package com.baidu.mobads.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
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
/* loaded from: classes20.dex */
public class b extends File {
    private static DexClassLoader f = null;
    private e a;
    private Class<?> b;
    private Context c;
    private PublicKey d;
    private IXAdLogger e;

    public b(String str, Context context) {
        this(str, context, null);
    }

    public b(String str, Context context, e eVar) {
        super(str);
        this.b = null;
        this.c = null;
        this.e = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.c = context;
        this.a = eVar;
        if (eVar != null) {
            try {
                this.d = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception e) {
                this.d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.a != null) {
            String a = a(new File(getAbsolutePath()));
            String b = b(this.a.d());
            if (!b.equalsIgnoreCase(a)) {
                throw new g.a("doCheckApkIntegrity failed, md5sum: " + a + ", checksum in json info: " + b);
            }
            return;
        }
        Log.i("XAdLocalApkFile", "built-in apk, no need to check");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> b() {
        if (this.b == null) {
            File file = new File(getAbsolutePath());
            try {
                this.b = b(file);
            } catch (Exception e) {
                file.delete();
            }
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        renameTo(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double c() {
        if (this.a == null) {
            return 0.0d;
        }
        return this.a.b();
    }

    private String b(String str) {
        if (this.d != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.d);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Exception e) {
                this.e.e("ErrorWhileVerifySigNature", e);
            }
        }
        return null;
    }

    private static PublicKey c(String str) {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(File file) {
        FileInputStream fileInputStream;
        IXAdLogger iXAdLogger;
        Object[] objArr;
        String str = "";
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    do {
                    } while (new DigestInputStream(fileInputStream, messageDigest).read(new byte[4096]) != -1);
                    byte[] digest = messageDigest.digest();
                    int i = 0;
                    while (i < digest.length) {
                        String str2 = str + Integer.toString((digest[i] & 255) + 256, 16).substring(1);
                        i++;
                        str = str2;
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                            iXAdLogger = this.e;
                            objArr = new Object[]{"XAdLocalApkFile", e.getMessage()};
                            iXAdLogger.e(objArr);
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    this.e.e("XAdLocalApkFile", e.getMessage());
                    str = "";
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            iXAdLogger = this.e;
                            objArr = new Object[]{"XAdLocalApkFile", e3.getMessage()};
                            iXAdLogger.e(objArr);
                            return str;
                        }
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                        this.e.e("XAdLocalApkFile", e4.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
        return str;
    }

    @TargetApi(14)
    private Class<?> b(File file) {
        Class<?> cls;
        this.e.d("XAdLocalApkFile", "Android version:" + Build.VERSION.RELEASE);
        try {
            synchronized (g.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.c.getFilesDir().getAbsolutePath();
                com.baidu.mobads.a.a.o = System.currentTimeMillis();
                DexClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                com.baidu.mobads.a.a.p = System.currentTimeMillis();
                f = dexClassLoader;
                this.e.i("XAdLocalApkFile", "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", loader=" + dexClassLoader + ", len=" + file.length() + ", list=" + file.list());
                cls = Class.forName("com.baidu.mobads.container.AllInOneXAdContainerFactory", true, dexClassLoader);
            }
        } catch (Exception e) {
            this.e.e("XAdLocalApkFile", e.getMessage());
            cls = null;
        }
        this.e.i("XAdLocalApkFile", "jar.path=" + file.getAbsolutePath() + ", clz=" + cls);
        return cls;
    }

    public static DexClassLoader d() {
        return f;
    }
}
