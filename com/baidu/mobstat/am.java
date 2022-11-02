package com.baidu.mobstat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.bs;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class am {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String c;
    public static volatile int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public final Handler b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(581657222, "Lcom/baidu/mobstat/am;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(581657222, "Lcom/baidu/mobstat/am;");
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap a;
        public final Paint b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new Paint(2);
            this.a = null;
        }

        public synchronized void a(int i, int i2, int i3, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitmap}) == null) {
                synchronized (this) {
                    if (this.a == null || this.a.getWidth() != i || this.a.getHeight() != i2) {
                        try {
                            this.a = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                        } catch (OutOfMemoryError unused) {
                            this.a = null;
                        }
                        if (this.a != null) {
                            this.a.setDensity(i3);
                        }
                    }
                    if (this.a != null) {
                        new Canvas(this.a).drawBitmap(bitmap, 0.0f, 0.0f, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Callable<List<c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public final List<c> b;
        public final DisplayMetrics c;
        public final a d;
        public final int e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = 160;
            this.c = new DisplayMetrics();
            this.b = new ArrayList();
            this.d = new a();
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(c cVar) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, cVar) == null) {
                View view2 = cVar.b;
                Boolean bool = null;
                try {
                    Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    bitmap = (Bitmap) declaredMethod.invoke(view2, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
                } catch (ClassCastException e) {
                    bb.c().d("autotrace: createSnapshot didn't return a bitmap", e);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                        view2.setDrawingCacheEnabled(false);
                    }
                    cVar.d = f;
                    cVar.c = this.d;
                } catch (IllegalAccessException e2) {
                    bb.c().d("autotrace: Can't access createSnapshot, using drawCache", e2);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f2 = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = f2;
                    cVar.c = this.d;
                } catch (IllegalArgumentException e3) {
                    bb.c().b("autotrace: Can't call createSnapshot with arguments", e3);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f22 = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = f22;
                    cVar.c = this.d;
                } catch (NoSuchMethodException e4) {
                    bb.c().a("autotrace: Can't call createSnapshot, will use drawCache", e4);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f222 = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = f222;
                    cVar.c = this.d;
                } catch (InvocationTargetException e5) {
                    bb.c().d("autotrace: Exception when calling createSnapshot", e5);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f2222 = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = f2222;
                    cVar.c = this.d;
                } catch (Exception e6) {
                    bb.c().d(" autotrace:createSnapshot encounter exception", e6);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    float f22222 = 1.0f;
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = f22222;
                    cVar.c = this.d;
                }
                if (bitmap == null) {
                    try {
                        bool = Boolean.valueOf(view2.isDrawingCacheEnabled());
                        view2.setDrawingCacheEnabled(true);
                        view2.buildDrawingCache(true);
                        bitmap = view2.getDrawingCache();
                    } catch (Exception e7) {
                        bb.c().a("autotrace: Can't take a bitmap snapshot of view " + view2 + ", skipping for now.", e7);
                    }
                }
                float f222222 = 1.0f;
                if (bitmap != null) {
                    int density = bitmap.getDensity();
                    if (density != 0) {
                        f222222 = 160.0f / density;
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int width2 = (int) ((bitmap.getWidth() * f222222) + 0.5d);
                    int height2 = (int) ((bitmap.getHeight() * f222222) + 0.5d);
                    if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                        this.d.a(width2, height2, 160, bitmap);
                    }
                }
                if (bool != null && !bool.booleanValue()) {
                    view2.setDrawingCacheEnabled(false);
                }
                cVar.d = f222222;
                cVar.c = this.d;
            }
        }

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                ah.a(this.a, false);
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                ah.a(this.a, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<c> call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.b.clear();
                HashSet<Activity> hashSet = new HashSet(1);
                hashSet.add(this.a);
                for (Activity activity : hashSet) {
                    String canonicalName = activity.getClass().getCanonicalName();
                    View b = bi.b(activity);
                    activity.getWindowManager().getDefaultDisplay().getMetrics(this.c);
                    this.b.add(new c(canonicalName, b));
                }
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    b();
                    a(this.b.get(i));
                    c();
                }
                return this.b;
            }
            return (List) invokeV.objValue;
        }

        public void a(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.a = activity;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final View b;
        public a c;
        public float d;

        public c(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = view2;
            this.c = null;
            this.d = 1.0f;
        }
    }

    public am() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new Handler(Looper.getMainLooper());
        this.a = new b();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            d = 0;
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Activity activity, View view2, JSONArray jSONArray, String str, View view3) throws Exception {
        Rect e;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65539, this, activity, view2, jSONArray, str, view3) != null) || view2 == null || (e = bi.e(view2)) == null || ah.a(view2)) {
            return;
        }
        String m = bi.m(view2);
        if (TextUtils.isEmpty(m) || bi.c(activity, view2)) {
            return;
        }
        String c2 = bi.c(view2);
        if (TextUtils.isEmpty(c2)) {
            c2 = bi.a(view2, str);
            if (TextUtils.isEmpty(c2)) {
                c2 = bi.a(view2, view3);
                if (!TextUtils.isEmpty(c2)) {
                    return;
                }
                long j = -1;
                try {
                    j = Long.valueOf(c2).longValue();
                } catch (Exception unused) {
                }
                if (j < 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("p", m);
                jSONObject2.put("i", c2);
                String b2 = bi.b(view2);
                jSONObject2.put("t", b2);
                jSONArray2.put(jSONObject2);
                jSONObject.put("path", jSONArray2);
                jSONObject.put("type", b2);
                jSONObject.put("value", bi.a(view2));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("x", ag.a(activity, e.left));
                jSONObject3.put("y", ag.a(activity, e.top));
                jSONObject3.put(Config.DEVICE_WIDTH, ag.a(activity, e.width()));
                jSONObject3.put("h", ag.a(activity, e.height()));
                jSONObject.put("frame", jSONObject3);
                jSONObject.put(Key.ALPHA, bi.i(view2));
                jSONObject.put("page", activity.getClass().getName());
                jSONObject.put("z", bi.j(view2));
                boolean z = view2 instanceof WebView;
                if (z) {
                    Object obj = null;
                    String a2 = bk.a(activity, (WebView) view2, e);
                    if (!TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject4 = new JSONObject(a2);
                        str2 = jSONObject4.optString("url");
                        obj = jSONObject4.optJSONArray("objects");
                    } else {
                        str2 = "";
                    }
                    if (obj == null) {
                        obj = new JSONArray();
                    }
                    jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CHILD, obj);
                    if (TextUtils.isEmpty(str2)) {
                        jSONObject.put("url", "/");
                    } else {
                        jSONObject.put("url", str2);
                    }
                }
                jSONObject.put("edit", bi.b(view2, str) ? 1 : 0);
                jSONArray.put(jSONObject);
                if (z) {
                    return;
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    JSONArray jSONArray3 = new JSONArray();
                    jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CHILD, jSONArray3);
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        a(activity, viewGroup.getChildAt(i), jSONArray3, b2, view3);
                    }
                    return;
                }
                jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CHILD, new JSONArray());
                return;
            }
        }
        if (!TextUtils.isEmpty(c2)) {
        }
    }

    private JSONArray c(Activity activity) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, activity)) == null) {
            JSONArray jSONArray = new JSONArray();
            View a2 = bi.a(activity);
            a(activity, a2, jSONArray, "", a2);
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            JSONObject jSONObject = null;
            if (activity == null) {
                return null;
            }
            try {
                if (!aj.a()) {
                    return null;
                }
                int i = d + 1;
                d = i;
                if (i >= 3) {
                    aj.a(false);
                }
                Bitmap b2 = b(activity);
                if (b2 == null) {
                    return null;
                }
                JSONArray c2 = c(activity);
                String a2 = bs.a.a(c2.toString().getBytes());
                if (c != null && c.equals(a2)) {
                    return null;
                }
                c = a2;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(StatisticConstants.SCREENSHOT, bi.a(b2));
                    jSONObject2.put(SapiOptions.KEY_CACHE_MODULE_HASH, bi.b(b2));
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.DEVICE_WIDTH, b2.getWidth());
                    jSONObject3.put("h", b2.getHeight());
                    jSONObject2.put("screen", jSONObject3);
                    jSONObject2.put("page", activity.getClass().getName());
                    jSONObject2.put("objects", c2);
                    return jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                    return jSONObject;
                }
            } catch (Throwable unused2) {
            }
        } else {
            return (JSONObject) invokeL.objValue;
        }
    }

    public Bitmap b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            this.a.a(activity);
            FutureTask futureTask = new FutureTask(this.a);
            this.b.post(futureTask);
            List emptyList = Collections.emptyList();
            try {
                emptyList = (List) futureTask.get(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                bb.c().b("autotrace: Screenshot interrupted, no screenshot will be sent.", e);
            } catch (TimeoutException e2) {
                bb.c().c("autotrace: Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e2);
            } catch (Exception e3) {
                bb.c().d("autotrace: Exception thrown during screenshot attempt", e3);
            }
            if (emptyList.size() != 0) {
                return ((c) emptyList.get(0)).c.a;
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }
}
