package c.a.q.l.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q.h.c.a.c;
import c.a.q.h.c.a.d;
import c.a.q.h.c.a.f;
import c.a.q.h.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f11557f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f11558b;

    /* renamed from: c  reason: collision with root package name */
    public a.C0742a f11559c;

    /* renamed from: d  reason: collision with root package name */
    public ZipFile f11560d;

    /* renamed from: e  reason: collision with root package name */
    public PackageManager f11561e;

    /* renamed from: c.a.q.l.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0751a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0751a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(".cfgtmp") : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                try {
                    String b2 = aVar.b("info");
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    b bVar = new b();
                    bVar.a = jSONObject.getLong("version");
                    return bVar;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1321991292, "Lc/a/q/l/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1321991292, "Lc/a/q/l/a/b/a;");
                return;
            }
        }
        f11557f = new String[]{"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a() {
        Throwable th;
        File file;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.intValue;
        }
        try {
            AssetManager assets = this.f11558b.createPackageContext(this.a, 0).getAssets();
            this.f11559c.a();
            File h2 = h();
            InputStream inputStream5 = null;
            try {
                h2.delete();
                file = File.createTempFile("cfg", ".cfgtmp", h2.getParentFile());
                try {
                    ?? fileOutputStream = new FileOutputStream(file);
                    try {
                        InputStream open = assets.open("com.baidu.helios/c.dat");
                        try {
                            try {
                                d.a(open, fileOutputStream, 16384);
                                try {
                                    X509Certificate[][] s = com.baidu.helios.trusts.zone.verifier.b.s(file);
                                    if (s.length == 0) {
                                        c.b(open);
                                        c.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        return 3;
                                    }
                                    HashSet hashSet = new HashSet();
                                    for (X509Certificate[] x509CertificateArr : s) {
                                        if (x509CertificateArr != null) {
                                            for (X509Certificate x509Certificate : x509CertificateArr) {
                                                if (x509Certificate != null) {
                                                    hashSet.add(f.c(x509Certificate.getSignature()));
                                                }
                                            }
                                        }
                                    }
                                    HashSet hashSet2 = new HashSet();
                                    Collections.addAll(hashSet2, f11557f);
                                    if (!hashSet2.equals(hashSet)) {
                                        c.b(open);
                                        c.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        return 3;
                                    }
                                    file.renameTo(h2);
                                    c.b(open);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    return 0;
                                } catch (Exception unused4) {
                                    c.b(open);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused5) {
                                        }
                                    }
                                    return 3;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream5 = open;
                                inputStream = inputStream5;
                                inputStream5 = fileOutputStream;
                                c.b(inputStream);
                                c.b(inputStream5);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused6) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException unused7) {
                            inputStream5 = open;
                            inputStream4 = inputStream5;
                            inputStream5 = fileOutputStream;
                            c.b(inputStream4);
                            c.b(inputStream5);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused8) {
                                }
                            }
                            return 5;
                        } catch (IOException unused9) {
                            inputStream5 = open;
                            inputStream3 = inputStream5;
                            inputStream5 = fileOutputStream;
                            c.b(inputStream3);
                            c.b(inputStream5);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused10) {
                                }
                            }
                            return 2;
                        } catch (Exception unused11) {
                            inputStream5 = open;
                            inputStream2 = inputStream5;
                            inputStream5 = fileOutputStream;
                            c.b(inputStream2);
                            c.b(inputStream5);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused12) {
                                }
                            }
                            return 4;
                        }
                    } catch (FileNotFoundException unused13) {
                    } catch (IOException unused14) {
                    } catch (Exception unused15) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (FileNotFoundException unused16) {
                    inputStream4 = null;
                    c.b(inputStream4);
                    c.b(inputStream5);
                    if (file != null) {
                    }
                    return 5;
                } catch (IOException unused17) {
                    inputStream3 = null;
                    c.b(inputStream3);
                    c.b(inputStream5);
                    if (file != null) {
                    }
                    return 2;
                } catch (Exception unused18) {
                    inputStream2 = null;
                    c.b(inputStream2);
                    c.b(inputStream5);
                    if (file != null) {
                    }
                    return 4;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    c.b(inputStream);
                    c.b(inputStream5);
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused19) {
                file = null;
            } catch (IOException unused20) {
                file = null;
            } catch (Exception unused21) {
                file = null;
            } catch (Throwable th5) {
                th = th5;
                file = null;
            }
        } catch (Exception unused22) {
            return 1;
        }
    }

    public String b(String str) throws TrustSubject.ConfigNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = d(str);
                    return d.b(inputStream, "UTF-8");
                } catch (IOException e2) {
                    throw new TrustSubject.ConfigNotFoundException(e2);
                }
            } finally {
                c.b(inputStream);
            }
        }
        return (String) invokeL.objValue;
    }

    public void c(String str, Context context, a.C0742a c0742a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, context, c0742a) == null) {
            this.a = str;
            this.f11558b = context;
            this.f11559c = c0742a;
            this.f11561e = context.getPackageManager();
        }
    }

    public final InputStream d(String str) throws TrustSubject.ConfigNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return this.f11560d.getInputStream(new ZipEntry(str));
            } catch (Exception e2) {
                throw new TrustSubject.ConfigNotFoundException(e2);
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File[] listFiles = this.f11559c.b().listFiles(new C0751a(this));
            int i2 = 0;
            if (listFiles != null) {
                int length = listFiles.length;
                boolean z = false;
                while (i2 < length) {
                    listFiles[i2].delete();
                    i2++;
                    z = true;
                }
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ZipFile zipFile = this.f11560d;
            if (zipFile != null) {
                c.d(zipFile);
                this.f11560d = null;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h().delete() : invokeV.booleanValue;
    }

    public final File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f11559c.d("c.dat") : (File) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b a = b.a(this);
            if (a != null) {
                return a.a;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Bundle bundle = this.f11561e.getPackageInfo(this.a, 128).applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString("com.baidu.helios.tc.qver");
                    if (TextUtils.isEmpty(string) || !string.startsWith("v")) {
                        return -1L;
                    }
                    return Long.valueOf(string.substring(1)).longValue();
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f11560d != null) {
                return true;
            }
            File h2 = h();
            if (h2.exists()) {
                try {
                    this.f11560d = new ZipFile(h2);
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
