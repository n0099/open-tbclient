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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.bt;
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
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String c;
    public static volatile int d;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public final Handler b;

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

        private void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                ai.a(this.a, false);
            }
        }

        private void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                ai.a(this.a, true);
            }
        }

        public void a(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                this.a = activity;
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
                    View b = bj.b(activity);
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
                    bc.c().d("autotrace: createSnapshot didn't return a bitmap", e);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                        view2.setDrawingCacheEnabled(false);
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                } catch (IllegalAccessException e2) {
                    bc.c().d("autotrace: Can't access createSnapshot, using drawCache", e2);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                } catch (IllegalArgumentException e3) {
                    bc.c().b("autotrace: Can't call createSnapshot with arguments", e3);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                } catch (NoSuchMethodException e4) {
                    bc.c().a("autotrace: Can't call createSnapshot, will use drawCache", e4);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                } catch (InvocationTargetException e5) {
                    bc.c().d("autotrace: Exception when calling createSnapshot", e5);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                } catch (Exception e6) {
                    bc.c().d(" autotrace:createSnapshot encounter exception", e6);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.d = r3;
                    cVar.c = this.d;
                }
                if (bitmap == null) {
                    try {
                        bool = Boolean.valueOf(view2.isDrawingCacheEnabled());
                        view2.setDrawingCacheEnabled(true);
                        view2.buildDrawingCache(true);
                        bitmap = view2.getDrawingCache();
                    } catch (Exception e7) {
                        bc.c().a("autotrace: Can't take a bitmap snapshot of view " + view2 + ", skipping for now.", e7);
                    }
                }
                if (bitmap != null) {
                    int density = bitmap.getDensity();
                    r3 = density != 0 ? 160.0f / density : 1.0f;
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int width2 = (int) ((bitmap.getWidth() * r3) + 0.5d);
                    int height2 = (int) ((bitmap.getHeight() * r3) + 0.5d);
                    if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                        this.d.a(width2, height2, 160, bitmap);
                    }
                }
                if (bool != null && !bool.booleanValue()) {
                    view2.setDrawingCacheEnabled(false);
                }
                cVar.d = r3;
                cVar.c = this.d;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(581657253, "Lcom/baidu/mobstat/an;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(581657253, "Lcom/baidu/mobstat/an;");
        }
    }

    public an() {
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

    private JSONArray c(Activity activity) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, activity)) == null) {
            JSONArray jSONArray = new JSONArray();
            View a2 = bj.a(activity);
            a(activity, a2, jSONArray, "", a2);
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, activity)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        if (activity == null) {
            return null;
        }
        try {
            if (ak.a()) {
                int i = d + 1;
                d = i;
                if (i >= 3) {
                    ak.a(false);
                }
                Bitmap b2 = b(activity);
                if (b2 == null) {
                    return null;
                }
                JSONArray c2 = c(activity);
                String a2 = bt.a.a(c2.toString().getBytes());
                if (c == null || !c.equals(a2)) {
                    c = a2;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(StatisticConstants.SCREENSHOT, bj.a(b2));
                        jSONObject2.put(SapiOptions.KEY_CACHE_MODULE_HASH, bj.b(b2));
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("w", b2.getWidth());
                        jSONObject3.put("h", b2.getHeight());
                        jSONObject2.put("screen", jSONObject3);
                        jSONObject2.put("page", activity.getClass().getName());
                        jSONObject2.put("objects", c2);
                        return jSONObject2;
                    } catch (Throwable unused) {
                        jSONObject = jSONObject2;
                        return jSONObject;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable unused2) {
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
                bc.c().b("autotrace: Screenshot interrupted, no screenshot will be sent.", e);
            } catch (TimeoutException e2) {
                bc.c().c("autotrace: Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e2);
            } catch (Exception e3) {
                bc.c().d("autotrace: Exception thrown during screenshot attempt", e3);
            }
            if (emptyList.size() == 0) {
                return null;
            }
            return ((c) emptyList.get(0)).c.a;
        }
        return (Bitmap) invokeL.objValue;
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
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, this, activity, view2, jSONArray, str, view3) == null) || view2 == null || (e = bj.e(view2)) == null || ai.a(view2)) {
            return;
        }
        String l = bj.l(view2);
        if (TextUtils.isEmpty(l) || bj.c(activity, view2)) {
            return;
        }
        String c2 = bj.c(view2);
        if (TextUtils.isEmpty(c2)) {
            c2 = bj.a(view2, str);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view2, view3);
                if (TextUtils.isEmpty(c2)) {
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
                    jSONObject2.put("p", l);
                    jSONObject2.put("i", c2);
                    String b2 = bj.b(view2);
                    jSONObject2.put("t", b2);
                    jSONArray2.put(jSONObject2);
                    jSONObject.put("path", jSONArray2);
                    jSONObject.put("type", b2);
                    jSONObject.put("value", bj.a(view2));
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("x", ah.a(activity, e.left));
                    jSONObject3.put("y", ah.a(activity, e.top));
                    jSONObject3.put("w", ah.a(activity, e.width()));
                    jSONObject3.put("h", ah.a(activity, e.height()));
                    jSONObject.put("frame", jSONObject3);
                    jSONObject.put("alpha", bj.i(view2));
                    jSONObject.put("page", activity.getClass().getName());
                    jSONObject.put("z", bj.j(view2));
                    boolean z = view2 instanceof WebView;
                    if (z) {
                        Object obj = null;
                        String a2 = bl.a(activity, (WebView) view2, e);
                        if (TextUtils.isEmpty(a2)) {
                            str2 = "";
                        } else {
                            JSONObject jSONObject4 = new JSONObject(a2);
                            str2 = jSONObject4.optString("url");
                            obj = jSONObject4.optJSONArray("objects");
                        }
                        if (obj == null) {
                            obj = new JSONArray();
                        }
                        jSONObject.put("child", obj);
                        if (TextUtils.isEmpty(str2)) {
                            jSONObject.put("url", "/");
                        } else {
                            jSONObject.put("url", str2);
                        }
                    }
                    jSONObject.put("edit", bj.b(view2, str) ? 1 : 0);
                    jSONArray.put(jSONObject);
                    if (z) {
                        return;
                    }
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        JSONArray jSONArray3 = new JSONArray();
                        jSONObject.put("child", jSONArray3);
                        for (int i = 0; i < viewGroup.getChildCount(); i++) {
                            a(activity, viewGroup.getChildAt(i), jSONArray3, b2, view3);
                        }
                        return;
                    }
                    jSONObject.put("child", new JSONArray());
                    return;
                }
                return;
            }
        }
        if (TextUtils.isEmpty(c2)) {
        }
    }
}
