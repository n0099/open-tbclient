package com.baidu.swan.apps.install.a;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.swan.apps.install.a.b;
import com.baidu.swan.apps.install.a.c;
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
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static CharSequence axa = "._";
    private static final String axb = com.baidu.swan.apps.u.a.CK().vF();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [214=6] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c3 A[Catch: all -> 0x01ff, TRY_LEAVE, TryCatch #5 {all -> 0x01ff, blocks: (B:12:0x0035, B:14:0x0060, B:18:0x006c, B:20:0x0090, B:24:0x009d, B:26:0x00b6, B:27:0x00bf, B:29:0x00d8, B:30:0x00e1, B:32:0x00fa, B:34:0x0100, B:36:0x0113, B:39:0x0120, B:41:0x0148, B:43:0x014c, B:45:0x017a, B:49:0x018c, B:48:0x0189, B:47:0x0184, B:58:0x01d1, B:60:0x01d5, B:61:0x01df, B:22:0x0093, B:16:0x0063, B:54:0x01b9, B:56:0x01c3), top: B:75:0x0017 }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0143a a(File file, File file2, BufferedInputStream bufferedInputStream) {
        DataInputStream dataInputStream;
        C0143a c0143a = new C0143a(false);
        if (file != null && file2 != null && file.exists()) {
            b bVar = new b();
            DataInputStream dataInputStream2 = null;
            try {
                if (bufferedInputStream == null) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        bufferedInputStream.skip(4L);
                    } catch (IOException e) {
                        e = e;
                        dataInputStream = dataInputStream2;
                        c0143a.axc = e.getLocalizedMessage();
                        if (DEBUG) {
                        }
                        com.baidu.swan.c.b.c(dataInputStream);
                        return c0143a;
                    } catch (InterruptedException e2) {
                        e = e2;
                        dataInputStream = null;
                        c0143a.axc = e.getLocalizedMessage();
                        if (DEBUG) {
                        }
                        com.baidu.swan.c.b.c(dataInputStream);
                        return c0143a;
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.c.b.c(null);
                        throw th;
                    }
                }
                dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    bVar.versionCode = a(dataInputStream);
                    bVar.axd = a(dataInputStream);
                    bVar.axe = a(dataInputStream);
                    bVar.axf = a(dataInputStream);
                    bVar.axg = b(dataInputStream);
                    dataInputStream.readFully(bVar.axh);
                    byte[] E = E(bVar.axh);
                    if (E == null || E.length <= 0) {
                        c0143a.axc = "cipher is null";
                        com.baidu.swan.c.b.c(dataInputStream);
                    } else {
                        byte[] bArr = new byte[bVar.axe];
                        dataInputStream.readFully(bArr);
                        byte[] bArr2 = new byte[16];
                        byte[] bArr3 = new byte[16];
                        System.arraycopy(E, 0, bArr2, 0, 16);
                        System.arraycopy(E, 16, bArr3, 0, 16);
                        byte[] c = c(bArr, bArr2, bArr3);
                        if (c == null || c.length <= 0) {
                            c0143a.axc = "index array length <= 0";
                            com.baidu.swan.c.b.c(dataInputStream);
                        } else {
                            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream(c));
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
                                    c cVar = new c("BundleDecrypt" + i, file2, countDownLatch);
                                    cVar.start();
                                    handlerArr[i] = cVar.Cx();
                                }
                                for (int i2 = 0; i2 < bVar.axd; i2++) {
                                    b.a aVar = new b.a();
                                    aVar.offset = a(dataInputStream3);
                                    aVar.size = a(dataInputStream3);
                                    aVar.axi = a(dataInputStream3);
                                    byte[] bArr5 = new byte[aVar.axi];
                                    dataInputStream3.readFully(bArr5);
                                    aVar.path = new String(bArr5, "utf-8");
                                    if (aVar.size <= 0 || aVar.path.contains(axa)) {
                                        dataInputStream4.skipBytes(aVar.size);
                                    } else {
                                        byte[] bArr6 = new byte[aVar.size];
                                        dataInputStream4.readFully(bArr6);
                                        Message obtain = Message.obtain();
                                        c.a aVar2 = new c.a();
                                        aVar2.content = bArr6;
                                        aVar2.path = aVar.path;
                                        obtain.what = 100;
                                        obtain.obj = aVar2;
                                        handlerArr[i2 % 4].sendMessage(obtain);
                                    }
                                }
                                for (Handler handler : handlerArr) {
                                    handler.sendEmptyMessage(200);
                                }
                                com.baidu.swan.c.b.c(byteArrayOutputStream2);
                                com.baidu.swan.c.b.c(byteArrayOutputStream);
                                com.baidu.swan.c.b.c(dataInputStream3);
                                com.baidu.swan.c.b.c(gZIPInputStream);
                                com.baidu.swan.c.b.c(dataInputStream4);
                                countDownLatch.await();
                                c0143a.isSuccess = true;
                                com.baidu.swan.c.b.c(dataInputStream);
                            } else {
                                Log.e("BundleDecrypt", "create destination directory fail");
                                c0143a.axc = "create destination directory failed";
                                com.baidu.swan.c.b.c(dataInputStream);
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    dataInputStream2 = dataInputStream;
                    dataInputStream = dataInputStream2;
                    c0143a.axc = e.getLocalizedMessage();
                    if (DEBUG) {
                        Log.e("BundleDecrypt", "decrypt bundle fail", e);
                    }
                    com.baidu.swan.c.b.c(dataInputStream);
                    return c0143a;
                } catch (InterruptedException e4) {
                    e = e4;
                    c0143a.axc = e.getLocalizedMessage();
                    if (DEBUG) {
                    }
                    com.baidu.swan.c.b.c(dataInputStream);
                    return c0143a;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return c0143a;
    }

    private static int a(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    private static long b(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[8];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    private static PublicKey Cw() {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(axb.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", e.getMessage());
            }
            return null;
        }
    }

    private static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, SapiEnv.SHARE_ALGORITHM), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
            }
            return null;
        }
    }

    private static byte[] E(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, Cw());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "decypt cipher fail", e);
            }
            return null;
        }
    }

    public static BufferedInputStream x(File file) {
        IOException e;
        BufferedInputStream bufferedInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                if ((bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24)) == -1122498812) {
                    return bufferedInputStream;
                }
            } catch (IOException e2) {
                e = e2;
                if (DEBUG) {
                    Log.e("BundleDecrypt", "bundle encryption check fail", e);
                }
                com.baidu.swan.c.b.c(bufferedInputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        }
        com.baidu.swan.c.b.c(bufferedInputStream);
        return null;
    }

    public static void cA(int i) {
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

    /* renamed from: com.baidu.swan.apps.install.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0143a {
        public String axc = "";
        public boolean isSuccess;

        public C0143a(boolean z) {
            this.isSuccess = z;
        }
    }
}
