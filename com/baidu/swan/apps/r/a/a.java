package com.baidu.swan.apps.r.a;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.utils.e;
import com.baidu.swan.apps.r.a.b;
import com.baidu.swan.apps.r.a.c;
import com.baidu.swan.c.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static CharSequence dhC = "._";

    /* loaded from: classes9.dex */
    public static class b {
        public BufferedInputStream dhD;
        public int type = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [222=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x01d9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @NonNull
    public static C0465a a(BufferedInputStream bufferedInputStream, File file, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        C0465a c0465a = new C0465a(false);
        if (file != null && bufferedInputStream != null && i != 0) {
            boolean z = DEBUG;
            ?? r2 = z;
            if (z) {
                Log.d("BundleDecrypt", "type :" + i);
                r2 = "BundleDecrypt";
            }
            com.baidu.swan.apps.r.a.b bVar = new com.baidu.swan.apps.r.a.b();
            try {
                try {
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    try {
                        bVar.versionCode = a(dataInputStream);
                        bVar.dhE = a(dataInputStream);
                        bVar.dhF = a(dataInputStream);
                        bVar.dhG = a(dataInputStream);
                        bVar.dhH = b(dataInputStream);
                        dataInputStream.readFully(bVar.dhI);
                        byte[] I = I(bVar.dhI);
                        if (I == null || I.length <= 0) {
                            c0465a.cYo = "cipher is null";
                            d.closeSafely(dataInputStream);
                        } else {
                            byte[] bArr = new byte[bVar.dhF];
                            dataInputStream.readFully(bArr);
                            byte[] bArr2 = new byte[16];
                            byte[] bArr3 = new byte[16];
                            System.arraycopy(I, 0, bArr2, 0, 16);
                            System.arraycopy(I, 16, bArr3, 0, 16);
                            byte[] d = d(bArr, bArr2, bArr3);
                            if (d == null || d.length <= 0) {
                                c0465a.cYo = "index array length <= 0";
                                d.closeSafely(dataInputStream);
                            } else {
                                if (i == 2) {
                                    if (DEBUG) {
                                        Log.d("BundleDecrypt", "create brotli stream");
                                    }
                                    dataInputStream2 = new DataInputStream(com.baidu.swan.apps.t.a.aBq().m(new ByteArrayInputStream(d)));
                                    dataInputStream3 = new DataInputStream(com.baidu.swan.apps.t.a.aBq().m(dataInputStream));
                                } else {
                                    dataInputStream2 = new DataInputStream(new ByteArrayInputStream(d));
                                    dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                                }
                                if (file.exists() || file.mkdirs()) {
                                    CountDownLatch countDownLatch = new CountDownLatch(4);
                                    Handler[] handlerArr = new Handler[4];
                                    for (int i2 = 0; i2 < 4; i2++) {
                                        c cVar = new c("BundleDecrypt" + i2, file, countDownLatch);
                                        cVar.start();
                                        handlerArr[i2] = cVar.aAr();
                                    }
                                    for (int i3 = 0; i3 < bVar.dhE; i3++) {
                                        b.a aVar = new b.a();
                                        aVar.offset = a(dataInputStream2);
                                        aVar.size = a(dataInputStream2);
                                        aVar.dhJ = a(dataInputStream2);
                                        byte[] bArr4 = new byte[aVar.dhJ];
                                        dataInputStream2.readFully(bArr4);
                                        aVar.path = new String(bArr4, "utf-8");
                                        if (aVar.path.contains(dhC)) {
                                            dataInputStream3.skipBytes(aVar.size);
                                        } else {
                                            byte[] bArr5 = new byte[aVar.size];
                                            dataInputStream3.readFully(bArr5);
                                            Message obtain = Message.obtain();
                                            c.a aVar2 = new c.a();
                                            aVar2.content = bArr5;
                                            aVar2.path = aVar.path;
                                            obtain.what = 100;
                                            obtain.obj = aVar2;
                                            handlerArr[i3 % 4].sendMessage(obtain);
                                        }
                                    }
                                    for (Handler handler : handlerArr) {
                                        handler.sendEmptyMessage(200);
                                    }
                                    countDownLatch.await();
                                    d.closeSafely(dataInputStream2);
                                    d.closeSafely(dataInputStream3);
                                    c0465a.isSuccess = true;
                                    d.closeSafely(dataInputStream);
                                } else {
                                    if (DEBUG) {
                                        Log.e("BundleDecrypt", "create destination directory fail");
                                    }
                                    c0465a.cYo = "create destination directory failed";
                                    d.closeSafely(dataInputStream);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        c0465a.cYo = e.getLocalizedMessage();
                        if (DEBUG) {
                            Log.e("BundleDecrypt", "decrypt bundle fail", e);
                        }
                        d.closeSafely(dataInputStream);
                        return c0465a;
                    }
                } catch (Throwable th) {
                    th = th;
                    d.closeSafely(r2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                dataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                d.closeSafely(r2);
                throw th;
            }
        }
        return c0465a;
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

    private static PublicKey aAq() {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", e.getMessage());
            }
            return null;
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, e.q), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
            }
            return null;
        }
    }

    private static byte[] I(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, aAq());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "decypt cipher fail", e);
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x005f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.swan.apps.r.a.a$b] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005a -> B:25:0x000e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b D(File file) {
        Closeable closeable;
        Closeable closeable2;
        int read;
        b bVar = new b();
        if (file == null || !file.exists()) {
            return bVar;
        }
        try {
            closeable = new BufferedInputStream(new FileInputStream(file));
            try {
                read = closeable.read() | (closeable.read() << 8) | (closeable.read() << 16) | (closeable.read() << 24);
            } catch (IOException e) {
                e = e;
                closeable2 = closeable;
                if (DEBUG) {
                    Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    closeable2 = closeable;
                }
                d.closeSafely(closeable2);
                closeable = bVar;
                return closeable;
            }
        } catch (IOException e2) {
            e = e2;
            closeable = null;
            closeable2 = closeable;
            if (DEBUG) {
            }
            d.closeSafely(closeable2);
            closeable = bVar;
            return closeable;
        }
        if (read == -1122498812) {
            bVar.dhD = closeable;
            bVar.type = 1;
            closeable = bVar;
        } else {
            closeable2 = closeable;
            if (read == -1122434039) {
                bVar.dhD = closeable;
                bVar.type = 2;
                closeable = bVar;
            }
            d.closeSafely(closeable2);
            closeable = bVar;
        }
        return closeable;
    }

    public static b a(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        b bVar = new b();
        bVar.dhD = bufferedInputStream;
        bufferedInputStream.mark(8);
        int read = bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
        if (read == -1122498812) {
            bVar.type = 1;
        } else if (read == -1122434039) {
            bVar.type = 2;
        } else {
            bufferedInputStream.reset();
        }
        return bVar;
    }

    public static void jo(int i) {
        File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/decryptLog.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(i));
            fileWriter.write(44);
            d.closeSafely(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.baidu.swan.apps.r.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0465a {
        public String cYo = "";
        public boolean isSuccess;

        C0465a(boolean z) {
            this.isSuccess = z;
        }
    }
}
