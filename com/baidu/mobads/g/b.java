package com.baidu.mobads.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class b extends File {

    /* renamed from: f  reason: collision with root package name */
    public static DexClassLoader f8255f;

    /* renamed from: a  reason: collision with root package name */
    public e f8256a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f8257b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8258c;

    /* renamed from: d  reason: collision with root package name */
    public PublicKey f8259d;

    /* renamed from: e  reason: collision with root package name */
    public IXAdLogger f8260e;

    public b(String str, Context context) {
        this(str, context, null);
    }

    public static DexClassLoader d() {
        return f8255f;
    }

    public void a() {
        if (this.f8256a != null) {
            String a2 = a(new File(getAbsolutePath()));
            String b2 = b(this.f8256a.d());
            if (b2.equalsIgnoreCase(a2)) {
                return;
            }
            throw new g.a("doCheckApkIntegrity failed, md5sum: " + a2 + ", checksum in json info: " + b2);
        }
        this.f8260e.d("XAdLocalApkFile", "built-in apk, no need to check");
    }

    public Class<?> b() {
        if (this.f8257b == null) {
            File file = new File(getAbsolutePath());
            try {
                this.f8257b = b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.f8257b;
    }

    public double c() {
        e eVar = this.f8256a;
        if (eVar == null) {
            return 0.0d;
        }
        return eVar.b();
    }

    public b(String str, Context context, e eVar) {
        super(str);
        this.f8257b = null;
        this.f8258c = null;
        this.f8260e = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.f8258c = context;
        this.f8256a = eVar;
        if (eVar != null) {
            try {
                this.f8259d = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f8259d = null;
            }
        }
    }

    public static PublicKey c(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    private String b(String str) {
        if (this.f8259d != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f8259d);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Exception e2) {
                this.f8260e.e("ErrorWhileVerifySigNature", e2);
                return null;
            }
        }
        return null;
    }

    public void a(String str) {
        renameTo(new File(str));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.baidu.mobads.interfaces.utils.IXAdLogger] */
    private String a(File file) {
        FileInputStream fileInputStream;
        byte[] digest;
        FileInputStream fileInputStream2 = 0;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (new DigestInputStream(fileInputStream, messageDigest).read(new byte[4096]) != -1) {
            }
            String str = "";
            for (int i = 0; i < messageDigest.digest().length; i++) {
                str = str + Integer.toString((digest[i] & 255) + 256, 16).substring(1);
            }
            try {
                fileInputStream.close();
            } catch (Exception e3) {
                this.f8260e.d("XAdLocalApkFile", e3.getMessage());
            }
            return str;
        } catch (Exception e4) {
            e = e4;
            fileInputStream3 = fileInputStream;
            this.f8260e.d("XAdLocalApkFile", e.getMessage());
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                    return "";
                } catch (Exception e5) {
                    fileInputStream2 = this.f8260e;
                    fileInputStream2.d("XAdLocalApkFile", e5.getMessage());
                    return "";
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != 0) {
                try {
                    fileInputStream2.close();
                } catch (Exception e6) {
                    this.f8260e.d("XAdLocalApkFile", e6.getMessage());
                }
            }
            throw th;
        }
    }

    @TargetApi(14)
    private Class<?> b(File file) {
        Class<?> cls;
        IXAdLogger iXAdLogger = this.f8260e;
        iXAdLogger.d("XAdLocalApkFile", "Android version:" + Build.VERSION.RELEASE);
        Class<?> cls2 = null;
        try {
            synchronized (g.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.f8258c.getFilesDir().getAbsolutePath();
                com.baidu.mobads.constants.a.o = System.currentTimeMillis();
                DexClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                com.baidu.mobads.constants.a.p = System.currentTimeMillis();
                f8255f = dexClassLoader;
                IXAdLogger iXAdLogger2 = this.f8260e;
                iXAdLogger2.d("XAdLocalApkFile", "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", loader=" + dexClassLoader + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName("com.baidu.mobads.container.AllInOneXAdContainerFactory", true, dexClassLoader);
            }
            cls2 = cls;
        } catch (Exception e2) {
            this.f8260e.d("XAdLocalApkFile", e2.getMessage());
        }
        IXAdLogger iXAdLogger3 = this.f8260e;
        iXAdLogger3.d("XAdLocalApkFile", "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }
}
