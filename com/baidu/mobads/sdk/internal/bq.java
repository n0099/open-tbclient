package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.security.DigestInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class bq extends File {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "LocalApkFile";
    public static final long b = 6916965592955692235L;
    public static ClassLoader h;
    public transient /* synthetic */ FieldHolder $fh;
    public bv c;
    public Class<?> d;
    public Context e;
    public PublicKey f;
    public br g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833693920, "Lcom/baidu/mobads/sdk/internal/bq;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833693920, "Lcom/baidu/mobads/sdk/internal/bq;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq a;

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public a(bq bqVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bqVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bqVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bq(String str, Context context) {
        this(str, context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Context) objArr2[1], (bv) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(String str, Context context, bv bvVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context, bvVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.g = br.a();
        this.e = context;
        this.c = bvVar;
        if (bvVar != null) {
            try {
                this.f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f = null;
            }
        }
    }

    public static ClassLoader a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            ClassLoader classLoader = h;
            if (classLoader != null) {
                return classLoader;
            }
            return ar.a(context.getApplicationContext());
        }
        return (ClassLoader) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1 A[Catch: Exception -> 0x009d, TRY_LEAVE, TryCatch #1 {Exception -> 0x009d, blocks: (B:48:0x0099, B:52:0x00a1), top: B:60:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(File file) {
        InterceptResult invokeL;
        DigestInputStream digestInputStream;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, file)) == null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    digestInputStream = new DigestInputStream(fileInputStream2, messageDigest);
                    try {
                        while (digestInputStream.read(new byte[4096]) != -1) {
                        }
                        String str = "";
                        for (int i = 0; i < messageDigest.digest().length; i++) {
                            str = str + Integer.toString((digest[i] & 255) + 256, 16).substring(1);
                        }
                        try {
                            fileInputStream2.close();
                            digestInputStream.close();
                        } catch (Exception e) {
                            this.g.a(a, e.getMessage());
                        }
                        return str;
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            this.g.a(a, e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e3) {
                                    this.g.a(a, e3.getMessage());
                                    return "";
                                }
                            }
                            if (digestInputStream == null) {
                                return "";
                            }
                            digestInputStream.close();
                            return "";
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    this.g.a(a, e4.getMessage());
                                    throw th;
                                }
                            }
                            if (digestInputStream != null) {
                                digestInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (digestInputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    digestInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    digestInputStream = null;
                }
            } catch (Exception e6) {
                e = e6;
                digestInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                digestInputStream = null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    @TargetApi(14)
    private Class<?> b(File file) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, file)) == null) {
            br brVar = this.g;
            brVar.a(a, "Android version:" + bj.a(this.e).c());
            Class<?> cls2 = null;
            try {
                synchronized (bx.class) {
                    String absolutePath = file.getAbsolutePath();
                    ClassLoader classLoader = getClass().getClassLoader();
                    String absolutePath2 = this.e.getFilesDir().getAbsolutePath();
                    String str = w.aK;
                    h = an.a(absolutePath, absolutePath2, (String) null, classLoader);
                    br brVar2 = this.g;
                    brVar2.a(a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list());
                    cls = Class.forName(str, true, h);
                }
                cls2 = cls;
            } catch (Exception e) {
                this.g.a(a, e.getMessage());
            }
            br brVar3 = this.g;
            brVar3.a(a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
            return cls2;
        }
        return (Class) invokeL.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (this.f != null) {
                byte[] decode = Base64.decode(str, 0);
                try {
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(2, this.f);
                    return new String(cipher.doFinal(decode), "UTF-8").trim();
                } catch (Exception e) {
                    this.g.c("ErrorWhileVerifySigNature", e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static PublicKey c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
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
        return (PublicKey) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            File[] listFiles = this.e.getFilesDir().listFiles(new a(this));
            for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                if (listFiles[i].getAbsolutePath().contains(bx.e)) {
                    br brVar = this.g;
                    brVar.a(a, "clearDexCacheFiles-->" + i + "--" + listFiles[i].getAbsolutePath());
                    listFiles[i].delete();
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.c != null) {
                String a2 = a(new File(getAbsolutePath()));
                String b2 = b(this.c.d());
                if (!a2.equalsIgnoreCase(b2)) {
                    throw new bx.a("doCheckApkIntegrity failed, md5sum: " + a2 + ", checksum in json info: " + b2);
                }
                return;
            }
            this.g.a(a, "built-in apk, no need to check");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            renameTo(new File(str));
        }
    }

    public Class<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d == null) {
                File file = new File(getAbsolutePath());
                try {
                    this.d = b(file);
                } catch (Exception unused) {
                    file.delete();
                }
            }
            return this.d;
        }
        return (Class) invokeV.objValue;
    }

    public double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            bv bvVar = this.c;
            if (bvVar == null) {
                return 0.0d;
            }
            return bvVar.b();
        }
        return invokeV.doubleValue;
    }
}
