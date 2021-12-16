package c.a.q0.a.o2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.e;
import c.a.q0.a.d2.f;
import c.a.q0.a.k;
import c.a.q0.a.o2.g.g;
import c.a.q0.a.u2.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7500e;

    /* renamed from: f  reason: collision with root package name */
    public static int f7501f;

    /* renamed from: g  reason: collision with root package name */
    public static int f7502g;

    /* renamed from: h  reason: collision with root package name */
    public static int f7503h;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7504b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7505c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a<Long> f7506d;

    /* loaded from: classes.dex */
    public class a implements c.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.q0.a.u2.c.a
        public Long update() throws IllegalStateException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(this.a.e()) : (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(629017772, "Lc/a/q0/a/o2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(629017772, "Lc/a/q0/a/o2/c;");
                return;
            }
        }
        f7500e = k.a;
        f7501f = 1024;
        f7502g = -1;
        f7503h = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7506d = new a(this);
        this.f7504b = b.t(eVar);
        this.f7505c = "aiapp_" + this.f7504b;
        c.a.q0.a.u2.d.f8933h.b(this.f7506d);
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.getBytes(StandardCharsets.UTF_8).length > 512 : invokeL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.getBytes(StandardCharsets.UTF_8).length > 3145728 : invokeL.booleanValue;
    }

    public int a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return file.length() > 10485760 ? 2002 : 2000;
            }
            return 2001;
        }
        return invokeL.intValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                g().edit().clear().commit();
            } else {
                g().edit().clear().apply();
            }
            c.a.q0.w.d.k(b.x(e.f0()));
            c.a.q0.w.d.k(b.v(e.f0()));
            c.a.q0.a.u2.d.f8933h.update();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f7500e) {
                File file = g().getFile();
                String str = this.f7504b + " exists = " + file.exists() + " isFile = " + file.isFile() + " path = " + file.getPath() + " size = " + file.length();
            }
            return g().c();
        }
        return invokeV.longValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
                int lastIndexOf = str.lastIndexOf(File.separator);
                int length = str.length();
                if (lastIndexOf != f7502g && length > lastIndexOf) {
                    return str.substring(lastIndexOf + f7503h, length);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = new g(this.f7505c, false);
            }
            return this.a;
        }
        return (g) invokeV.objValue;
    }

    public c.a.q0.a.o2.a h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            File file = new File(str);
            if (file.isFile()) {
                c.a.q0.a.o2.a aVar = new c.a.q0.a.o2.a();
                aVar.f(file.length());
                aVar.d(file.lastModified());
                return aVar;
            }
            return null;
        }
        return (c.a.q0.a.o2.a) invokeL.objValue;
    }

    public List<c.a.q0.a.o2.a> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String v = b.v(e.f0());
            if (TextUtils.isEmpty(v)) {
                return null;
            }
            return k(v);
        }
        return (List) invokeV.objValue;
    }

    public List<c.a.q0.a.o2.a> j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            if (f7500e) {
                String str = "——> getSavedFileList: " + file.getAbsolutePath();
            }
            c.a.q0.a.o2.a aVar = new c.a.q0.a.o2.a();
            ArrayList arrayList = new ArrayList();
            if (file.isFile()) {
                aVar.e(file.getAbsolutePath());
                aVar.f(file.length());
                aVar.d(file.lastModified());
                arrayList.add(aVar);
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return null;
                }
                for (File file2 : listFiles) {
                    List<c.a.q0.a.o2.a> j2 = j(file2);
                    if (j2 != null) {
                        arrayList.addAll(arrayList.size(), j2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<c.a.q0.a.o2.a> k(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (f7500e) {
                String str2 = "——> getSavedFileList:  dir " + str;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return j(file);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final File l(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(str, str2);
        }
        return (File) invokeLL.objValue;
    }

    public boolean m(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) ? (e() - ((long) g().getString(str, "").length())) + ((long) str2.length()) > n() : invokeLL.booleanValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 10485760L;
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x004a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x004c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public String o(String str) {
        InterceptResult invokeL;
        Object obj;
        Object obj2;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String v = b.v(e.f0());
            String str2 = "";
            if (TextUtils.isEmpty(v)) {
                return "";
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    File l = l(v, f(str));
                    FileInputStream fileInputStream2 = new FileInputStream(new File((String) str));
                    try {
                        str = new FileOutputStream(l);
                        try {
                            byte[] bArr = new byte[f7501f];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                str.write(bArr, 0, read);
                                str.flush();
                            }
                            str2 = l.getAbsolutePath();
                            c.a.q0.w.d.d(fileInputStream2);
                            closeable = str;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            obj2 = str;
                            str = obj2;
                            if (f7500e) {
                                e.printStackTrace();
                                str = obj2;
                            }
                            c.a.q0.w.d.d(fileInputStream);
                            closeable = str;
                            c.a.q0.w.d.d(closeable);
                            return str2;
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            obj = str;
                            str = obj;
                            if (f7500e) {
                                e.printStackTrace();
                                str = obj;
                            }
                            c.a.q0.w.d.d(fileInputStream);
                            closeable = str;
                            c.a.q0.w.d.d(closeable);
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            c.a.q0.w.d.d(fileInputStream);
                            c.a.q0.w.d.d(str);
                            throw th;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        str = 0;
                    } catch (IOException e5) {
                        e = e5;
                        str = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        str = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                obj2 = null;
            } catch (IOException e7) {
                e = e7;
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
            }
            c.a.q0.w.d.d(closeable);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
