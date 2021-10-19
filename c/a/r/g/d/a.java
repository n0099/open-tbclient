package c.a.r.g.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.r.g.b.b;
import c.a.r.g.c.a.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15470a;

    /* renamed from: b  reason: collision with root package name */
    public C0737a f15471b;

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
        this.f15470a = context;
        c().mkdirs();
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            file.mkdirs();
        }
    }

    public static String e(File file, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{file, str, str2, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        a(file);
        File file2 = new File(file, str);
        FileInputStream fileInputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (z) {
                        byteArray = new b().a(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    c.b(fileInputStream2);
                    c.b(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    c.b(fileInputStream);
                    c.b(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean f(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new b().b(str2.getBytes(str3)));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                c.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                c.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                c.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(this.f15470a.getApplicationInfo().dataDir) : (File) invokeV.objValue;
    }

    public final File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new File(b(), ".helios") : (File) invokeV.objValue;
    }

    public synchronized C0737a d() {
        InterceptResult invokeV;
        C0737a c0737a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f15471b == null) {
                    this.f15471b = new C0737a(this, ".helios", null);
                }
                c0737a = this.f15471b;
            }
            return c0737a;
        }
        return (C0737a) invokeV.objValue;
    }

    /* renamed from: c.a.r.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0737a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f15472a;

        /* renamed from: b  reason: collision with root package name */
        public String f15473b;

        /* renamed from: c  reason: collision with root package name */
        public C0737a f15474c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15475d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15476e;

        public C0737a(a aVar, String str, C0737a c0737a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, c0737a};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f15476e = aVar;
            this.f15475d = false;
            this.f15473b = str;
            this.f15474c = c0737a;
            this.f15475d = false;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b().mkdirs();
            }
        }

        public File b() {
            InterceptResult invokeV;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                File file2 = this.f15472a;
                if (file2 != null) {
                    return file2;
                }
                if (this.f15474c == null) {
                    file = new File(this.f15476e.b(), this.f15473b);
                } else {
                    file = new File(this.f15474c.b(), this.f15473b);
                }
                this.f15472a = file;
                return file;
            }
            return (File) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15473b : (String) invokeV.objValue;
        }

        public File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new File(this.f15472a, str) : (File) invokeL.objValue;
        }

        public C0737a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15474c : (C0737a) invokeV.objValue;
        }

        public C0737a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new C0737a(this.f15476e, str, this) : (C0737a) invokeL.objValue;
        }

        public String g(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? a.e(b(), str, "UTF-8", z) : (String) invokeLZ.objValue;
        }

        public C0737a h(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
                if (!this.f15475d) {
                    ArrayList arrayList = new ArrayList();
                    C0737a c0737a = this;
                    do {
                        arrayList.add(c0737a.c());
                        c0737a = c0737a.e();
                    } while (c0737a != null);
                    int size = arrayList.size() - 1;
                    while (size >= 0) {
                        size--;
                        file = new File(file, (String) arrayList.get(size));
                    }
                    return new C0737a(this.f15476e, file);
                }
                throw new IllegalStateException("isolate session is not support");
            }
            return (C0737a) invokeL.objValue;
        }

        public boolean i(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z)) == null) ? a.f(b(), str, str2, "UTF-8", z) : invokeLLZ.booleanValue;
        }

        public C0737a(a aVar, File file) {
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
            this.f15476e = aVar;
            this.f15475d = false;
            this.f15475d = true;
            this.f15472a = file;
            this.f15473b = file.getName();
        }
    }
}
