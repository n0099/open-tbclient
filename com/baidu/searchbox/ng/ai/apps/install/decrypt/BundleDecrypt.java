package com.baidu.searchbox.ng.ai.apps.install.decrypt;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.searchbox.ng.ai.apps.install.decrypt.EncryptedBundle;
import com.baidu.searchbox.ng.ai.apps.install.decrypt.FileOutputThread;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.CountDownLatch;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class BundleDecrypt {
    private static final int BUFFER_SIZE = 4096;
    private static final int BYTE_SIZE = 8;
    private static final boolean DEBUG = false;
    private static final int FILE_HEADER = -1122498812;
    private static final int IV_SIZE = 16;
    private static final int KEY_SIZE = 16;
    private static final String PUB_KEY = "MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB";
    private static final String TAG = "BundleDecrypt";
    private static CharSequence TEMP_FILE_SUFFIX = "._";
    private static final int THREAD_NUMBER = 4;
    private static final String UTF8 = "utf-8";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [214=5] */
    @NonNull
    public static DecryptResult decrypt(File file, File file2, BufferedInputStream bufferedInputStream) {
        DataInputStream dataInputStream;
        DecryptResult decryptResult = new DecryptResult(false);
        if (file != null && file2 != null && file.exists()) {
            EncryptedBundle encryptedBundle = new EncryptedBundle();
            DataInputStream dataInputStream2 = null;
            try {
                if (bufferedInputStream == null) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        bufferedInputStream.skip(4L);
                    } catch (IOException e) {
                        e = e;
                        dataInputStream = dataInputStream2;
                        decryptResult.errInfo = e.getLocalizedMessage();
                        AiAppsFileUtils.closeSafely(dataInputStream);
                        return decryptResult;
                    } catch (InterruptedException e2) {
                        e = e2;
                        dataInputStream = null;
                        decryptResult.errInfo = e.getLocalizedMessage();
                        AiAppsFileUtils.closeSafely(dataInputStream);
                        return decryptResult;
                    } catch (Throwable th) {
                        th = th;
                        AiAppsFileUtils.closeSafely(null);
                        throw th;
                    }
                }
                dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    encryptedBundle.versionCode = getInt(dataInputStream);
                    encryptedBundle.fileNumber = getInt(dataInputStream);
                    encryptedBundle.indexLen = getInt(dataInputStream);
                    encryptedBundle.dataLen = getInt(dataInputStream);
                    encryptedBundle.appID = getLong(dataInputStream);
                    dataInputStream.readFully(encryptedBundle.cipher);
                    byte[] decryptCipher = decryptCipher(encryptedBundle.cipher);
                    if (decryptCipher == null || decryptCipher.length <= 0) {
                        decryptResult.errInfo = "cipher is null";
                        AiAppsFileUtils.closeSafely(dataInputStream);
                    } else {
                        byte[] bArr = new byte[encryptedBundle.indexLen];
                        dataInputStream.readFully(bArr);
                        byte[] bArr2 = new byte[16];
                        byte[] bArr3 = new byte[16];
                        System.arraycopy(decryptCipher, 0, bArr2, 0, 16);
                        System.arraycopy(decryptCipher, 16, bArr3, 0, 16);
                        byte[] decryptAES = decryptAES(bArr, bArr2, bArr3);
                        if (decryptAES == null || decryptAES.length <= 0) {
                            decryptResult.errInfo = "index array length <= 0";
                            AiAppsFileUtils.closeSafely(dataInputStream);
                        } else {
                            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream(decryptAES));
                            byte[] bArr4 = new byte[4096];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            for (int read = dataInputStream.read(bArr4); read > 0; read = dataInputStream.read(bArr4)) {
                                byteArrayOutputStream.write(bArr4, 0, read);
                            }
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                            for (int read2 = gZIPInputStream.read(bArr4); read2 > 0; read2 = gZIPInputStream.read(bArr4)) {
                                byteArrayOutputStream2.write(bArr4, 0, read2);
                            }
                            DataInputStream dataInputStream4 = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray())));
                            if (file2.exists() || file2.mkdirs()) {
                                CountDownLatch countDownLatch = new CountDownLatch(4);
                                Handler[] handlerArr = new Handler[4];
                                for (int i = 0; i < 4; i++) {
                                    FileOutputThread fileOutputThread = new FileOutputThread(TAG + i, file2, countDownLatch);
                                    fileOutputThread.start();
                                    handlerArr[i] = fileOutputThread.createHandler();
                                }
                                for (int i2 = 0; i2 < encryptedBundle.fileNumber; i2++) {
                                    EncryptedBundle.Index index = new EncryptedBundle.Index();
                                    index.offset = getInt(dataInputStream3);
                                    index.size = getInt(dataInputStream3);
                                    index.pathLen = getInt(dataInputStream3);
                                    byte[] bArr5 = new byte[index.pathLen];
                                    dataInputStream3.readFully(bArr5);
                                    index.path = new String(bArr5, "utf-8");
                                    if (index.size <= 0 || index.path.contains(TEMP_FILE_SUFFIX)) {
                                        dataInputStream4.skipBytes(index.size);
                                    } else {
                                        byte[] bArr6 = new byte[index.size];
                                        dataInputStream4.readFully(bArr6);
                                        Message obtain = Message.obtain();
                                        FileOutputThread.MessageObj messageObj = new FileOutputThread.MessageObj();
                                        messageObj.content = bArr6;
                                        messageObj.path = index.path;
                                        obtain.what = 100;
                                        obtain.obj = messageObj;
                                        handlerArr[i2 % 4].sendMessage(obtain);
                                    }
                                }
                                for (Handler handler : handlerArr) {
                                    handler.sendEmptyMessage(200);
                                }
                                AiAppsFileUtils.closeSafely(byteArrayOutputStream2);
                                AiAppsFileUtils.closeSafely(byteArrayOutputStream);
                                AiAppsFileUtils.closeSafely(dataInputStream3);
                                AiAppsFileUtils.closeSafely(gZIPInputStream);
                                AiAppsFileUtils.closeSafely(dataInputStream4);
                                countDownLatch.await();
                                decryptResult.isSuccess = true;
                                AiAppsFileUtils.closeSafely(dataInputStream);
                            } else {
                                Log.e(TAG, "create destination directory fail");
                                decryptResult.errInfo = "create destination directory failed";
                                AiAppsFileUtils.closeSafely(dataInputStream);
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    dataInputStream2 = dataInputStream;
                    dataInputStream = dataInputStream2;
                    decryptResult.errInfo = e.getLocalizedMessage();
                    AiAppsFileUtils.closeSafely(dataInputStream);
                    return decryptResult;
                } catch (InterruptedException e4) {
                    e = e4;
                    decryptResult.errInfo = e.getLocalizedMessage();
                    AiAppsFileUtils.closeSafely(dataInputStream);
                    return decryptResult;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return decryptResult;
    }

    private static int getInt(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    private static long getLong(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[8];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    private static PublicKey loadPubKey() {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(PUB_KEY.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }

    private static byte[] decryptAES(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, SapiEnv.SHARE_ALGORITHM), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }

    private static byte[] decryptCipher(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, loadPubKey());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }

    public static BufferedInputStream obtainEncryptedBundle(File file) {
        BufferedInputStream bufferedInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                if ((bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24)) == FILE_HEADER) {
                    return bufferedInputStream;
                }
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            bufferedInputStream = null;
        }
        AiAppsFileUtils.closeSafely(bufferedInputStream);
        return null;
    }

    public static void exportLogToCSV(int i) {
        File file = new File(Environment.getExternalStorageDirectory() + "/decryptLog.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(i));
            fileWriter.write(44);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    public static class DecryptResult {
        public String errInfo = "";
        public boolean isSuccess;

        public DecryptResult(boolean z) {
            this.isSuccess = z;
        }
    }
}
