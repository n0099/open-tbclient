package com.baidu.swan.apps.install.a;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.install.a.b;
import com.baidu.swan.apps.install.a.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
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
    private static CharSequence ayz = "._";
    private static final String ayA = com.baidu.swan.apps.u.a.Ew().wU();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [188=5] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0158 A[Catch: all -> 0x018a, TRY_LEAVE, TryCatch #3 {all -> 0x018a, blocks: (B:8:0x0017, B:10:0x0042, B:14:0x004e, B:16:0x0072, B:20:0x007e, B:22:0x0098, B:24:0x009e, B:26:0x00a2, B:27:0x00ab, B:29:0x00b5, B:31:0x00c1, B:33:0x00e7, B:35:0x00eb, B:37:0x0117, B:41:0x0129, B:40:0x0126, B:39:0x0121, B:48:0x0166, B:50:0x0169, B:51:0x0173, B:18:0x0075, B:12:0x0045, B:44:0x014e, B:46:0x0158), top: B:65:0x0012 }] */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0145a a(BufferedInputStream bufferedInputStream, File file) {
        DataInputStream dataInputStream;
        C0145a c0145a = new C0145a(false);
        if (file != null && bufferedInputStream != null) {
            b bVar = new b();
            try {
                try {
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    try {
                        bVar.versionCode = a(dataInputStream);
                        bVar.ayB = a(dataInputStream);
                        bVar.ayC = a(dataInputStream);
                        bVar.ayD = a(dataInputStream);
                        bVar.ayE = b(dataInputStream);
                        dataInputStream.readFully(bVar.ayF);
                        byte[] z = z(bVar.ayF);
                        if (z == null || z.length <= 0) {
                            c0145a.att = "cipher is null";
                            com.baidu.swan.c.a.c(dataInputStream);
                        } else {
                            byte[] bArr = new byte[bVar.ayC];
                            dataInputStream.readFully(bArr);
                            byte[] bArr2 = new byte[16];
                            byte[] bArr3 = new byte[16];
                            System.arraycopy(z, 0, bArr2, 0, 16);
                            System.arraycopy(z, 16, bArr3, 0, 16);
                            byte[] c = c(bArr, bArr2, bArr3);
                            if (c == null || c.length <= 0) {
                                c0145a.att = "index array length <= 0";
                                com.baidu.swan.c.a.c(dataInputStream);
                            } else {
                                DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(c));
                                DataInputStream dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                                if (file.exists() || file.mkdirs()) {
                                    CountDownLatch countDownLatch = new CountDownLatch(4);
                                    Handler[] handlerArr = new Handler[4];
                                    for (int i = 0; i < 4; i++) {
                                        c cVar = new c("BundleDecrypt" + i, file, countDownLatch);
                                        cVar.start();
                                        handlerArr[i] = cVar.Ej();
                                    }
                                    for (int i2 = 0; i2 < bVar.ayB; i2++) {
                                        b.a aVar = new b.a();
                                        aVar.offset = a(dataInputStream2);
                                        aVar.size = a(dataInputStream2);
                                        aVar.ayG = a(dataInputStream2);
                                        byte[] bArr4 = new byte[aVar.ayG];
                                        dataInputStream2.readFully(bArr4);
                                        aVar.path = new String(bArr4, "utf-8");
                                        if (aVar.size <= 0 || aVar.path.contains(ayz)) {
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
                                            handlerArr[i2 % 4].sendMessage(obtain);
                                        }
                                    }
                                    for (Handler handler : handlerArr) {
                                        handler.sendEmptyMessage(200);
                                    }
                                    countDownLatch.await();
                                    com.baidu.swan.c.a.c(dataInputStream2);
                                    com.baidu.swan.c.a.c(dataInputStream3);
                                    c0145a.isSuccess = true;
                                    com.baidu.swan.c.a.c(dataInputStream);
                                } else {
                                    if (DEBUG) {
                                        Log.e("BundleDecrypt", "create destination directory fail");
                                    }
                                    c0145a.att = "create destination directory failed";
                                    com.baidu.swan.c.a.c(dataInputStream);
                                }
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        c0145a.att = e.getLocalizedMessage();
                        if (DEBUG) {
                            Log.e("BundleDecrypt", "decrypt bundle fail", e);
                        }
                        com.baidu.swan.c.a.c(dataInputStream);
                        return c0145a;
                    } catch (InterruptedException e2) {
                        e = e2;
                        c0145a.att = e.getLocalizedMessage();
                        if (DEBUG) {
                        }
                        com.baidu.swan.c.a.c(dataInputStream);
                        return c0145a;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(null);
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
                com.baidu.swan.c.a.c(null);
                throw th;
            }
        }
        return c0145a;
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

    private static PublicKey Ei() {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(ayA.getBytes("utf-8"), 0)));
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
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e);
            }
            return null;
        }
    }

    private static byte[] z(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, Ei());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (DEBUG) {
                Log.e("BundleDecrypt", "decypt cipher fail", e);
            }
            return null;
        }
    }

    public static BufferedInputStream r(File file) {
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
                com.baidu.swan.c.a.c(bufferedInputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        }
        com.baidu.swan.c.a.c(bufferedInputStream);
        return null;
    }

    public static boolean a(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(8);
        if ((bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24)) == -1122498812) {
            return true;
        }
        bufferedInputStream.reset();
        return false;
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
    public static class C0145a {
        public String att = "";
        public boolean isSuccess;

        public C0145a(boolean z) {
            this.isSuccess = z;
        }
    }
}
