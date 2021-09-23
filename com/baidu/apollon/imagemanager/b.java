package com.baidu.apollon.imagemanager;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38013a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f38014b = "ImageMemoryCache";

    /* renamed from: c  reason: collision with root package name */
    public static final int f38015c = 15;

    /* renamed from: d  reason: collision with root package name */
    public static final int f38016d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static final float f38017e = 0.75f;

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> f38018f;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Bitmap> f38019g;

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f38020h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f38021i;

    /* renamed from: j  reason: collision with root package name */
    public static Runnable f38022j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334523803, "Lcom/baidu/apollon/imagemanager/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(334523803, "Lcom/baidu/apollon/imagemanager/b$a;");
                    return;
                }
            }
            HandlerThread unused = b.f38020h = new HandlerThread("sb_imagecache_loop", 10);
            b.f38020h.start();
            Handler unused2 = b.f38021i = new Handler(b.f38020h.getLooper());
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-433170952, "Lcom/baidu/apollon/imagemanager/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-433170952, "Lcom/baidu/apollon/imagemanager/b;");
                return;
            }
        }
        f38018f = new ConcurrentHashMap<>(7);
        f38019g = new LinkedHashMap<String, Bitmap>(7, 0.75f, true) { // from class: com.baidu.apollon.imagemanager.ImageMemoryCache$1
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 1;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10, r11);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r9), Float.valueOf(r10), Boolean.valueOf(r11)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue(), ((Boolean) objArr2[2]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
                InterceptResult invokeL;
                ConcurrentHashMap concurrentHashMap;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, entry)) == null) {
                    if (size() > 15) {
                        concurrentHashMap = b.f38018f;
                        concurrentHashMap.put(entry.getKey(), new SoftReference(entry.getValue()));
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
        f38022j = new Runnable() { // from class: com.baidu.apollon.imagemanager.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b.e();
                }
            }
        };
    }

    public b() {
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

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (f38019g) {
                for (Map.Entry<String, Bitmap> entry : f38019g.entrySet()) {
                    f38018f.put(entry.getKey(), new SoftReference<>(entry.getValue()));
                }
                f38019g.clear();
            }
            LinkedList linkedList = new LinkedList();
            for (Map.Entry<String, SoftReference<Bitmap>> entry2 : f38018f.entrySet()) {
                if (entry2.getValue().get() == null) {
                    linkedList.add(entry2.getKey());
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                f38018f.remove((String) it.next());
            }
        }
    }

    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) || bitmap == null) {
            return;
        }
        synchronized (f38019g) {
            f38019g.put(str, bitmap);
        }
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (f38019g) {
                Bitmap bitmap = f38019g.get(str);
                if (bitmap != null) {
                    return bitmap;
                }
                SoftReference<Bitmap> softReference = f38018f.get(str);
                if (softReference != null) {
                    Bitmap bitmap2 = softReference.get();
                    if (bitmap2 != null) {
                        a(str, bitmap2);
                        return bitmap2;
                    }
                    f38018f.remove(str);
                    return null;
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f38021i == null) {
                new a();
            }
            Handler handler = f38021i;
            if (handler != null) {
                handler.removeCallbacks(f38022j);
                f38021i.postDelayed(f38022j, 10000L);
            }
        }
    }
}
