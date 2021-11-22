package b.a.m.l;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.m.j.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3552a;

    /* renamed from: b  reason: collision with root package name */
    public C0097a f3553b;

    /* renamed from: b.a.m.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0097a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f3554a;

        /* renamed from: b  reason: collision with root package name */
        public String f3555b;

        /* renamed from: c  reason: collision with root package name */
        public C0097a f3556c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3557d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3558e;

        public C0097a(a aVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3558e = aVar;
            this.f3557d = false;
            this.f3557d = true;
            this.f3554a = file;
            this.f3555b = file.getName();
        }

        public C0097a(a aVar, String str, C0097a c0097a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, c0097a};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f3558e = aVar;
            this.f3557d = false;
            this.f3555b = str;
            this.f3556c = c0097a;
            this.f3557d = false;
        }

        public C0097a a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                if (this.f3557d) {
                    throw new IllegalStateException("isolate session is not support");
                }
                ArrayList arrayList = new ArrayList();
                C0097a c0097a = this;
                do {
                    arrayList.add(c0097a.h());
                    c0097a = c0097a.i();
                } while (c0097a != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C0097a(this.f3558e, file);
            }
            return (C0097a) invokeL.objValue;
        }

        public File b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new File(this.f3554a, str) : (File) invokeL.objValue;
        }

        public String c(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) ? a.b(g(), str, "UTF-8", z) : (String) invokeLZ.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                g().mkdirs();
            }
        }

        public boolean e(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) ? a.d(g(), str, str2, "UTF-8", z) : invokeLLZ.booleanValue;
        }

        public C0097a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new C0097a(this.f3558e, str, this) : (C0097a) invokeL.objValue;
        }

        public File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                File file = this.f3554a;
                if (file != null) {
                    return file;
                }
                File file2 = this.f3556c == null ? new File(this.f3558e.a(), this.f3555b) : new File(this.f3556c.g(), this.f3555b);
                this.f3554a = file2;
                return file2;
            }
            return (File) invokeV.objValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3555b : (String) invokeV.objValue;
        }

        public C0097a i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3556c : (C0097a) invokeV.objValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3552a = context;
        e().mkdirs();
    }

    public static String b(File file, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, str, str2, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        c(file);
        File file2 = new File(file, str);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (z) {
                        byteArray = new c().a(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    b.a.m.m.c.b(fileInputStream);
                    b.a.m.m.c.b(byteArrayOutputStream2);
                    return str3;
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    b.a.m.m.c.b(fileInputStream);
                    b.a.m.m.c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    b.a.m.m.c.b(fileInputStream);
                    b.a.m.m.c.b(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                fileInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static void c(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            file.mkdirs();
        }
    }

    public static boolean d(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        c(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream2.write(new c().b(str2.getBytes()));
                } else {
                    fileOutputStream2.write(str2.getBytes(str3));
                }
                b.a.m.m.c.b(fileOutputStream2);
                return true;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                b.a.m.m.c.b(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                b.a.m.m.c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(this.f3552a.getApplicationInfo().dataDir) : (File) invokeV.objValue;
    }

    public final File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new File(a(), ".cesium") : (File) invokeV.objValue;
    }

    public synchronized C0097a f() {
        InterceptResult invokeV;
        C0097a c0097a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f3553b == null) {
                    this.f3553b = new C0097a(this, ".cesium", null);
                }
                c0097a = this.f3553b;
            }
            return c0097a;
        }
        return (C0097a) invokeV.objValue;
    }
}
