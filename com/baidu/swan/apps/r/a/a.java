package com.baidu.swan.apps.r.a;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.utils.h;
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.r.a.b;
import com.baidu.swan.apps.r.a.c;
import com.baidu.swan.e.d;
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
    private static CharSequence cgC = "._";

    /* loaded from: classes11.dex */
    public static class b {
        public BufferedInputStream cgD;
        public int type = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [221=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x01db */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @NonNull
    public static C0370a a(BufferedInputStream bufferedInputStream, File file, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        C0370a c0370a = new C0370a(false);
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
                        bVar.cgE = a(dataInputStream);
                        bVar.cgF = a(dataInputStream);
                        bVar.cgG = a(dataInputStream);
                        bVar.cgH = b(dataInputStream);
                        dataInputStream.readFully(bVar.cgI);
                        byte[] G = G(bVar.cgI);
                        if (G == null || G.length <= 0) {
                            c0370a.bYH = "cipher is null";
                            d.closeSafely(dataInputStream);
                        } else {
                            byte[] bArr = new byte[bVar.cgF];
                            dataInputStream.readFully(bArr);
                            byte[] bArr2 = new byte[16];
                            byte[] bArr3 = new byte[16];
                            System.arraycopy(G, 0, bArr2, 0, 16);
                            System.arraycopy(G, 16, bArr3, 0, 16);
                            byte[] d = d(bArr, bArr2, bArr3);
                            if (d == null || d.length <= 0) {
                                c0370a.bYH = "index array length <= 0";
                                d.closeSafely(dataInputStream);
                            } else {
                                if (i == 2) {
                                    if (DEBUG) {
                                        Log.d("BundleDecrypt", "create brotli stream");
                                    }
                                    dataInputStream2 = new DataInputStream(com.baidu.swan.apps.u.a.afN().j(new ByteArrayInputStream(d)));
                                    dataInputStream3 = new DataInputStream(com.baidu.swan.apps.u.a.afN().j(dataInputStream));
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
                                        handlerArr[i2] = cVar.aeQ();
                                    }
                                    for (int i3 = 0; i3 < bVar.cgE; i3++) {
                                        b.a aVar = new b.a();
                                        aVar.offset = a(dataInputStream2);
                                        aVar.size = a(dataInputStream2);
                                        aVar.cgJ = a(dataInputStream2);
                                        byte[] bArr4 = new byte[aVar.cgJ];
                                        dataInputStream2.readFully(bArr4);
                                        aVar.path = new String(bArr4, "utf-8");
                                        if (aVar.path.contains(cgC)) {
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
                                    c0370a.isSuccess = true;
                                    d.closeSafely(dataInputStream);
                                } else {
                                    if (DEBUG) {
                                        Log.e("BundleDecrypt", "create destination directory fail");
                                    }
                                    c0370a.bYH = "create destination directory failed";
                                    d.closeSafely(dataInputStream);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        c0370a.bYH = e.getLocalizedMessage();
                        if (DEBUG) {
                            Log.e("BundleDecrypt", "decrypt bundle fail", e);
                        }
                        d.closeSafely(dataInputStream);
                        return c0370a;
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
        return c0370a;
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

    private static PublicKey aeP() {
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
            cipher.init(2, new SecretKeySpec(bArr2, h.q), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
            }
            return null;
        }
    }

    private static byte[] G(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, aeP());
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
    /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.swan.apps.r.a.a$b] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:25:0x000e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b w(File file) {
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
                d.closeSafely(closeable2);
                closeable = bVar;
                return closeable;
            }
        } catch (IOException e3) {
            closeable = null;
            e = e3;
            closeable2 = closeable;
            if (DEBUG) {
            }
            d.closeSafely(closeable2);
            closeable = bVar;
            return closeable;
        }
        if (read == -1122498812) {
            bVar.cgD = closeable;
            bVar.type = 1;
            closeable = bVar;
        } else {
            closeable2 = closeable;
            if (read == -1122434039) {
                bVar.cgD = closeable;
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
        bVar.cgD = bufferedInputStream;
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

    public static void fw(int i) {
        File file = new File(ad.getStorageList().get(0).mPath, "/decryptLog.csv");
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
    /* loaded from: classes11.dex */
    public static class C0370a {
        public String bYH = "";
        public boolean isSuccess;

        C0370a(boolean z) {
            this.isSuccess = z;
        }
    }
}
