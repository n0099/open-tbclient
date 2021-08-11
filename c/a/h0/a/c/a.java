package c.a.h0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.a.c.d;
import c.a.h0.a.k.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
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
    public static volatile a f3248g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f3249h = 30000000;

    /* renamed from: i  reason: collision with root package name */
    public static int f3250i = 50000000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, c.a.h0.a.c.c<?>> f3251a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.h0.a.c.d f3252b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.h0.a.c.d f3253c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, c.a.h0.a.c.d> f3254d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3255e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3256f;

    /* renamed from: c.a.h0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0068a implements d<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0068a(a aVar) {
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
        @Override // c.a.h0.a.c.a.d
        /* renamed from: a */
        public Bitmap parseFromBytes(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
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
                    c.a.h0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，OOM");
                    return null;
                } catch (Throwable unused2) {
                    c.a.h0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，解析异常");
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.h0.a.c.a.d
        /* renamed from: b */
        public <D> Bitmap rawGet(D d2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2)) == null) {
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f3258b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.a.c.d f3259c;

        public b(a aVar, String str, c cVar, c.a.h0.a.c.d dVar) {
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
            this.f3257a = str;
            this.f3258b = cVar;
            this.f3259c = dVar;
        }

        @Override // c.a.h0.a.c.d.e
        public void a(String str, c.a.h0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            }
        }

        @Override // c.a.h0.a.c.d.e
        public void b(String str, c.a.h0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) && this.f3257a.equals(str)) {
                this.f3258b.onCacheFailed();
                this.f3259c.q(this);
            }
        }

        @Override // c.a.h0.a.c.d.e
        public void c(String str, c.a.h0.a.c.c<File> cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) && this.f3257a.equals(str)) {
                this.f3258b.onCacheComplete();
                this.f3259c.q(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onCacheComplete();

        void onCacheFailed();
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        T parseFromBytes(byte[] bArr);

        <D> T rawGet(D d2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(215531669, "Lc/a/h0/a/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(215531669, "Lc/a/h0/a/c/a;");
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
        this.f3251a = new LruCache<>(6);
        String d2 = i.d(context);
        this.f3255e = d2 + MaterialLoader.IMAGE_CACHE_PATH;
        this.f3256f = d2 + MaterialLoader.VIDEO_CACHE_PATH;
        this.f3252b = c.a.h0.a.c.d.o(this.f3255e, f3249h);
        this.f3253c = c.a.h0.a.c.d.o(this.f3256f, f3250i);
        this.f3254d = new ConcurrentHashMap();
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
            if (f3248g == null) {
                synchronized (a.class) {
                    if (f3248g == null && context != null) {
                        f3248g = new a(context.getApplicationContext());
                    }
                }
            }
            return f3248g;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str, c.a.h0.a.c.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, dVar)) == null) {
            String a2 = a(str);
            return dVar.k() + a2;
        }
        return (String) invokeLL.objValue;
    }

    public final c.a.h0.a.c.d c(MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, materialCacheType)) == null) {
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                return this.f3253c;
            }
            return this.f3252b;
        }
        return (c.a.h0.a.c.d) invokeL.objValue;
    }

    public String d(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, materialCacheType)) == null) {
            String a2 = a(str);
            if (f(str, materialCacheType)) {
                return c(materialCacheType).k() + a2;
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
            c.a.h0.a.c.d c2 = c(materialCacheType);
            return (z || c2.f3266e) ? z : new File(b(str, c2)).exists();
        }
        return invokeLL.booleanValue;
    }

    public c.a.h0.a.c.c<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        c.a.h0.a.c.c<?> i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, materialCacheType)) == null) ? (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2 : (c.a.h0.a.c.c) invokeLL.objValue;
    }

    public final c.a.h0.a.c.c<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, materialCacheType)) == null) ? c(materialCacheType).j(str) : (c.a.h0.a.c.c) invokeLL.objValue;
    }

    public final c.a.h0.a.c.c<?> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f3251a.get(str) : (c.a.h0.a.c.c) invokeL.objValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new C0068a(this)) : (Bitmap) invokeL.objValue;
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, materialCacheType, dVar)) == null) {
            c.a.h0.a.c.c<?> g2 = g(a(str), materialCacheType);
            if (g2 != null) {
                if (File.class.equals(g2.c())) {
                    return dVar.parseFromBytes(g2.b());
                }
                if (Byte.TYPE.equals(g2.c())) {
                    return null;
                }
                return dVar.rawGet(g2.a());
            }
            if (!c(materialCacheType).f3266e) {
                File file = new File(b(str, c(materialCacheType)));
                if (file.exists()) {
                    return dVar.parseFromBytes(new c.a.h0.a.c.c(file).b());
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, bitmap, z) == null) {
            m(str, new c.a.h0.a.c.c<>(bitmap), this.f3252b, z, null);
        }
    }

    public final void m(String str, c.a.h0.a.c.c<?> cVar, c.a.h0.a.c.d dVar, boolean z, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, cVar, dVar, Boolean.valueOf(z), cVar2}) == null) {
            try {
                String a2 = a(str);
                if (z) {
                    this.f3251a.put(a2, cVar);
                }
                File file = new File(dVar.k() + a2);
                if (cVar2 != null) {
                    dVar.f(new b(this, a2, cVar2, dVar));
                }
                dVar.u(cVar.b(), new c.a.h0.a.c.c<>(file));
            } catch (Throwable th) {
                c.a.h0.a.k.b.i().c("Failed to cache resource.", th);
            }
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, bArr, materialCacheType, Boolean.valueOf(z), cVar}) == null) {
            c.a.h0.a.c.c<?> cVar2 = new c.a.h0.a.c.c<>(bArr);
            c.a.h0.a.c.d dVar = this.f3252b;
            if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
                dVar = this.f3253c;
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            c.a.h0.a.c.c<?> cVar2 = new c.a.h0.a.c.c<>(bArr);
            c.a.h0.a.c.d dVar = this.f3254d.get(str2);
            if (dVar == null) {
                dVar = c.a.h0.a.c.d.o(str2, i2);
                this.f3254d.put(str2, dVar);
            } else if (dVar.l() != i2) {
                dVar.trimToSize(i2);
            }
            m(str, cVar2, dVar, z, cVar);
        }
    }
}
