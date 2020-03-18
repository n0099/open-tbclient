package com.baidu.swan.apps.t.a;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.swan.apps.as.ac;
import com.baidu.swan.apps.t.a.b;
import com.baidu.swan.apps.t.a.c;
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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static CharSequence bxV = "._";

    /* loaded from: classes11.dex */
    public static class b {
        public BufferedInputStream bxW;
        public int type = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [220=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x01d5 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a3 A[Catch: all -> 0x01d5, TRY_LEAVE, TryCatch #1 {all -> 0x01d5, blocks: (B:12:0x0037, B:14:0x0062, B:18:0x006e, B:20:0x0092, B:26:0x00a2, B:28:0x00a6, B:29:0x00af, B:30:0x00ca, B:32:0x00d0, B:34:0x00d6, B:36:0x00da, B:37:0x00e3, B:40:0x0104, B:42:0x0110, B:44:0x0136, B:46:0x013a, B:48:0x016c, B:49:0x0171, B:50:0x0174, B:57:0x01b1, B:59:0x01b4, B:60:0x01be, B:39:0x00ed, B:22:0x0095, B:16:0x0065, B:53:0x0199, B:55:0x01a3), top: B:74:0x0032 }] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0301a a(BufferedInputStream bufferedInputStream, File file, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        C0301a c0301a = new C0301a(false);
        if (file != null && bufferedInputStream != null && i != 0) {
            boolean z = DEBUG;
            ?? r2 = z;
            if (z) {
                Log.d("BundleDecrypt", "type :" + i);
                r2 = "BundleDecrypt";
            }
            com.baidu.swan.apps.t.a.b bVar = new com.baidu.swan.apps.t.a.b();
            try {
                try {
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    try {
                        bVar.versionCode = a(dataInputStream);
                        bVar.bxX = a(dataInputStream);
                        bVar.bxY = a(dataInputStream);
                        bVar.bxZ = a(dataInputStream);
                        bVar.bya = b(dataInputStream);
                        dataInputStream.readFully(bVar.byb);
                        byte[] x = x(bVar.byb);
                        if (x == null || x.length <= 0) {
                            c0301a.bqT = "cipher is null";
                            com.baidu.swan.d.c.closeSafely(dataInputStream);
                        } else {
                            byte[] bArr = new byte[bVar.bxY];
                            dataInputStream.readFully(bArr);
                            byte[] bArr2 = new byte[16];
                            byte[] bArr3 = new byte[16];
                            System.arraycopy(x, 0, bArr2, 0, 16);
                            System.arraycopy(x, 16, bArr3, 0, 16);
                            byte[] d = d(bArr, bArr2, bArr3);
                            if (d == null || d.length <= 0) {
                                c0301a.bqT = "index array length <= 0";
                                com.baidu.swan.d.c.closeSafely(dataInputStream);
                            } else {
                                if (i == 2) {
                                    if (DEBUG) {
                                        Log.d("BundleDecrypt", "create brotli stream");
                                    }
                                    dataInputStream2 = new DataInputStream(new org.brotli.dec.b(new ByteArrayInputStream(d)));
                                    dataInputStream3 = new DataInputStream(new org.brotli.dec.b(dataInputStream));
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
                                        handlerArr[i2] = cVar.TY();
                                    }
                                    for (int i3 = 0; i3 < bVar.bxX; i3++) {
                                        b.a aVar = new b.a();
                                        aVar.offset = a(dataInputStream2);
                                        aVar.size = a(dataInputStream2);
                                        aVar.byc = a(dataInputStream2);
                                        byte[] bArr4 = new byte[aVar.byc];
                                        dataInputStream2.readFully(bArr4);
                                        aVar.path = new String(bArr4, "utf-8");
                                        if (aVar.path.contains(bxV)) {
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
                                    com.baidu.swan.d.c.closeSafely(dataInputStream2);
                                    com.baidu.swan.d.c.closeSafely(dataInputStream3);
                                    c0301a.isSuccess = true;
                                    com.baidu.swan.d.c.closeSafely(dataInputStream);
                                } else {
                                    if (DEBUG) {
                                        Log.e("BundleDecrypt", "create destination directory fail");
                                    }
                                    c0301a.bqT = "create destination directory failed";
                                    com.baidu.swan.d.c.closeSafely(dataInputStream);
                                }
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        c0301a.bqT = e.getLocalizedMessage();
                        if (DEBUG) {
                            Log.e("BundleDecrypt", "decrypt bundle fail", e);
                        }
                        com.baidu.swan.d.c.closeSafely(dataInputStream);
                        return c0301a;
                    } catch (InterruptedException e2) {
                        e = e2;
                        c0301a.bqT = e.getLocalizedMessage();
                        if (DEBUG) {
                        }
                        com.baidu.swan.d.c.closeSafely(dataInputStream);
                        return c0301a;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.d.c.closeSafely(r2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                dataInputStream = null;
            } catch (InterruptedException e4) {
                e = e4;
                dataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                com.baidu.swan.d.c.closeSafely(r2);
                throw th;
            }
        }
        return c0301a;
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

    private static PublicKey TX() {
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
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
            }
            return null;
        }
    }

    private static byte[] x(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, TX());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "decypt cipher fail", e);
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0061 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.swan.apps.t.a.a$b] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:25:0x000e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b r(File file) {
        Closeable closeable;
        IOException e;
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
            } catch (IOException e2) {
                e = e2;
                closeable2 = closeable;
                if (DEBUG) {
                    Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    closeable2 = closeable;
                }
                com.baidu.swan.d.c.closeSafely(closeable2);
                closeable = bVar;
                return closeable;
            }
        } catch (IOException e3) {
            closeable = null;
            e = e3;
            closeable2 = closeable;
            if (DEBUG) {
            }
            com.baidu.swan.d.c.closeSafely(closeable2);
            closeable = bVar;
            return closeable;
        }
        if (read == -1122498812) {
            bVar.bxW = closeable;
            bVar.type = 1;
            closeable = bVar;
        } else {
            closeable2 = closeable;
            if (read == -1122434039) {
                bVar.bxW = closeable;
                bVar.type = 2;
                closeable = bVar;
            }
            com.baidu.swan.d.c.closeSafely(closeable2);
            closeable = bVar;
        }
        return closeable;
    }

    public static b a(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        b bVar = new b();
        bVar.bxW = bufferedInputStream;
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

    public static void fe(int i) {
        File file = new File(ac.getStorageList().get(0).mPath, "/decryptLog.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(i));
            fileWriter.write(44);
            com.baidu.swan.d.c.closeSafely(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.baidu.swan.apps.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0301a {
        public String bqT = "";
        public boolean isSuccess;

        C0301a(boolean z) {
            this.isSuccess = z;
        }
    }
}
