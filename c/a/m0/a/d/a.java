package c.a.m0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import c.a.m0.a.d.d;
import c.a.m0.a.l.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f4514g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f4515h = 30000000;

    /* renamed from: i  reason: collision with root package name */
    public static int f4516i = 50000000;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, c.a.m0.a.d.c<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.m0.a.d.d f4517b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.m0.a.d.d f4518c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, c.a.m0.a.d.d> f4519d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4520e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4521f;

    /* renamed from: c.a.m0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0210a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0210a(a aVar) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.m0.a.d.a.d
        /* renamed from: c */
        public Bitmap b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                if (bArr == null) {
                    return null;
                }
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                } catch (OutOfMemoryError unused) {
                    c.a.m0.a.l.b.i().h("CacheEngine", "图片请求失败，OOM");
                    return null;
                } catch (Throwable unused2) {
                    c.a.m0.a.l.b.i().h("CacheEngine", "图片请求失败，解析异常");
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.m0.a.d.a.d
        /* renamed from: d */
        public <D> Bitmap a(D d2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d2)) == null) {
                if (d2 instanceof Bitmap) {
                    return (Bitmap) d2;
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f4522b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.m0.a.d.d f4523c;

        public b(a aVar, String str, c cVar, c.a.m0.a.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4522b = cVar;
            this.f4523c = dVar;
        }

        @Override // c.a.m0.a.d.d.e
        public void a(String str, c.a.m0.a.d.c<File> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            }
        }

        @Override // c.a.m0.a.d.d.e
        public void b(String str, c.a.m0.a.d.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) && this.a.equals(str)) {
                this.f4522b.a();
                this.f4523c.q(this);
            }
        }

        @Override // c.a.m0.a.d.d.e
        public void c(String str, c.a.m0.a.d.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) && this.a.equals(str)) {
                this.f4522b.b();
                this.f4523c.q(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        <D> T a(D d2);

        T b(byte[] bArr);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-231776263, "Lc/a/m0/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-231776263, "Lc/a/m0/a/d/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(6);
        String d2 = i.d(context);
        this.f4520e = d2 + "img_download/";
        this.f4521f = d2 + "video_download/";
        this.f4517b = c.a.m0.a.d.d.o(this.f4520e, f4515h);
        this.f4518c = c.a.m0.a.d.d.o(this.f4521f, f4516i);
        this.f4519d = new ConcurrentHashMap();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim() : (String) invokeL.objValue;
    }

    public static a e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f4514g == null) {
                synchronized (a.class) {
                    if (f4514g == null && context != null) {
                        f4514g = new a(context.getApplicationContext());
                    }
                }
            }
            return f4514g;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str, c.a.m0.a.d.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
            String a = a(str);
            return dVar.k() + a;
        }
        return (String) invokeLL.objValue;
    }

    public final c.a.m0.a.d.d c(MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialCacheType)) == null) {
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                return this.f4518c;
            }
            return this.f4517b;
        }
        return (c.a.m0.a.d.d) invokeL.objValue;
    }

    public String d(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) {
            String a = a(str);
            if (f(str, materialCacheType)) {
                return c(materialCacheType).k() + a;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public boolean f(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, materialCacheType)) == null) {
            boolean z = g(a(str), materialCacheType) != null;
            c.a.m0.a.d.d c2 = c(materialCacheType);
            return (z || c2.f4527e) ? z : new File(b(str, c2)).exists();
        }
        return invokeLL.booleanValue;
    }

    public c.a.m0.a.d.c<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        c.a.m0.a.d.c<?> i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, materialCacheType)) == null) ? (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2 : (c.a.m0.a.d.c) invokeLL.objValue;
    }

    public final c.a.m0.a.d.c<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, materialCacheType)) == null) ? c(materialCacheType).j(str) : (c.a.m0.a.d.c) invokeLL.objValue;
    }

    public final c.a.m0.a.d.c<?> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.a.get(str) : (c.a.m0.a.d.c) invokeL.objValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new C0210a(this)) : (Bitmap) invokeL.objValue;
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType, dVar)) == null) {
            c.a.m0.a.d.c<?> g2 = g(a(str), materialCacheType);
            if (g2 != null) {
                if (File.class.equals(g2.c())) {
                    return dVar.b(g2.b());
                }
                if (Byte.TYPE.equals(g2.c())) {
                    return null;
                }
                return dVar.a(g2.a());
            }
            if (!c(materialCacheType).f4527e) {
                File file = new File(b(str, c(materialCacheType)));
                if (file.exists()) {
                    return dVar.b(new c.a.m0.a.d.c(file).b());
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, bitmap, z) == null) {
            m(str, new c.a.m0.a.d.c<>(bitmap), this.f4517b, z, null);
        }
    }

    public final void m(String str, c.a.m0.a.d.c<?> cVar, c.a.m0.a.d.d dVar, boolean z, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, cVar, dVar, Boolean.valueOf(z), cVar2}) == null) {
            try {
                String a = a(str);
                if (z) {
                    this.a.put(a, cVar);
                }
                File file = new File(dVar.k() + a);
                if (cVar2 != null) {
                    dVar.f(new b(this, a, cVar2, dVar));
                }
                dVar.u(cVar.b(), new c.a.m0.a.d.c<>(file));
            } catch (Throwable th) {
                c.a.m0.a.l.b.i().c("Failed to cache resource.", th);
            }
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, bArr, materialCacheType, Boolean.valueOf(z), cVar}) == null) {
            c.a.m0.a.d.c<?> cVar2 = new c.a.m0.a.d.c<>(bArr);
            c.a.m0.a.d.d dVar = this.f4517b;
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                dVar = this.f4518c;
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            c.a.m0.a.d.c<?> cVar2 = new c.a.m0.a.d.c<>(bArr);
            c.a.m0.a.d.d dVar = this.f4519d.get(str2);
            if (dVar == null) {
                dVar = c.a.m0.a.d.d.o(str2, i2);
                this.f4519d.put(str2, dVar);
            } else if (dVar.l() != i2) {
                dVar.trimToSize(i2);
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }
}
