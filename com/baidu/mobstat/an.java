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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.ExecutionState;
import com.tachikoma.core.component.anim.AnimationProperty;
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
/* loaded from: classes10.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f37476c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile int f37477d;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f37478b;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final Paint f37479b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37479b = new Paint(2);
            this.a = null;
        }

        public synchronized void a(int i2, int i3, int i4, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bitmap}) == null) {
                synchronized (this) {
                    if (this.a == null || this.a.getWidth() != i2 || this.a.getHeight() != i3) {
                        try {
                            this.a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                        } catch (OutOfMemoryError unused) {
                            this.a = null;
                        }
                        if (this.a != null) {
                            this.a.setDensity(i4);
                        }
                    }
                    if (this.a != null) {
                        new Canvas(this.a).drawBitmap(bitmap, 0.0f, 0.0f, this.f37479b);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Callable<List<c>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f37480b;

        /* renamed from: c  reason: collision with root package name */
        public final DisplayMetrics f37481c;

        /* renamed from: d  reason: collision with root package name */
        public final a f37482d;

        /* renamed from: e  reason: collision with root package name */
        public final int f37483e;

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
                    return;
                }
            }
            this.f37483e = 160;
            this.f37481c = new DisplayMetrics();
            this.f37480b = new ArrayList();
            this.f37482d = new a();
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
                this.f37480b.clear();
                HashSet<Activity> hashSet = new HashSet(1);
                hashSet.add(this.a);
                for (Activity activity : hashSet) {
                    String canonicalName = activity.getClass().getCanonicalName();
                    View b2 = bj.b(activity);
                    activity.getWindowManager().getDefaultDisplay().getMetrics(this.f37481c);
                    this.f37480b.add(new c(canonicalName, b2));
                }
                int size = this.f37480b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    b();
                    a(this.f37480b.get(i2));
                    c();
                }
                return this.f37480b;
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
                View view = cVar.f37484b;
                Boolean bool = null;
                try {
                    Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    bitmap = (Bitmap) declaredMethod.invoke(view, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
                } catch (ClassCastException e2) {
                    bc.c().d("autotrace: createSnapshot didn't return a bitmap", e2);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                        view.setDrawingCacheEnabled(false);
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                } catch (IllegalAccessException e3) {
                    bc.c().d("autotrace: Can't access createSnapshot, using drawCache", e3);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                } catch (IllegalArgumentException e4) {
                    bc.c().b("autotrace: Can't call createSnapshot with arguments", e4);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                } catch (NoSuchMethodException e5) {
                    bc.c().a("autotrace: Can't call createSnapshot, will use drawCache", e5);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                } catch (InvocationTargetException e6) {
                    bc.c().d("autotrace: Exception when calling createSnapshot", e6);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                } catch (Exception e7) {
                    bc.c().d(" autotrace:createSnapshot encounter exception", e7);
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    if (bitmap != null) {
                    }
                    if (bool != null) {
                    }
                    cVar.f37486d = r3;
                    cVar.f37485c = this.f37482d;
                }
                if (bitmap == null) {
                    try {
                        bool = Boolean.valueOf(view.isDrawingCacheEnabled());
                        view.setDrawingCacheEnabled(true);
                        view.buildDrawingCache(true);
                        bitmap = view.getDrawingCache();
                    } catch (Exception e8) {
                        bc.c().a("autotrace: Can't take a bitmap snapshot of view " + view + ", skipping for now.", e8);
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
                        this.f37482d.a(width2, height2, 160, bitmap);
                    }
                }
                if (bool != null && !bool.booleanValue()) {
                    view.setDrawingCacheEnabled(false);
                }
                cVar.f37486d = r3;
                cVar.f37485c = this.f37482d;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final View f37484b;

        /* renamed from: c  reason: collision with root package name */
        public a f37485c;

        /* renamed from: d  reason: collision with root package name */
        public float f37486d;

        public c(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, view};
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
            this.f37484b = view;
            this.f37485c = null;
            this.f37486d = 1.0f;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37478b = new Handler(Looper.getMainLooper());
        this.a = new b();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f37477d = 0;
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f37476c = "";
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
                int i2 = f37477d + 1;
                f37477d = i2;
                if (i2 >= 3) {
                    ak.a(false);
                }
                Bitmap b2 = b(activity);
                if (b2 == null) {
                    return null;
                }
                JSONArray c2 = c(activity);
                String a2 = bt.a.a(c2.toString().getBytes());
                if (f37476c == null || !f37476c.equals(a2)) {
                    f37476c = a2;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(StatisticConstants.SCREENSHOT, bj.a(b2));
                        jSONObject2.put("hash", bj.b(b2));
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
            this.f37478b.post(futureTask);
            List emptyList = Collections.emptyList();
            try {
                emptyList = (List) futureTask.get(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                bc.c().b("autotrace: Screenshot interrupted, no screenshot will be sent.", e2);
            } catch (TimeoutException e3) {
                bc.c().c("autotrace: Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e3);
            } catch (Exception e4) {
                bc.c().d("autotrace: Exception thrown during screenshot attempt", e4);
            }
            if (emptyList.size() == 0) {
                return null;
            }
            return ((c) emptyList.get(0)).f37485c.a;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Activity activity, View view, JSONArray jSONArray, String str, View view2) throws Exception {
        Rect e2;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, this, activity, view, jSONArray, str, view2) == null) || view == null || (e2 = bj.e(view)) == null || ai.a(view)) {
            return;
        }
        String l = bj.l(view);
        if (TextUtils.isEmpty(l) || bj.c(activity, view)) {
            return;
        }
        String c2 = bj.c(view);
        if (TextUtils.isEmpty(c2)) {
            c2 = bj.a(view, str);
            if (TextUtils.isEmpty(c2)) {
                c2 = bj.a(view, view2);
                if (TextUtils.isEmpty(c2)) {
                    long j2 = -1;
                    try {
                        j2 = Long.valueOf(c2).longValue();
                    } catch (Exception unused) {
                    }
                    if (j2 < 0) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("p", l);
                    jSONObject2.put("i", c2);
                    String b2 = bj.b(view);
                    jSONObject2.put("t", b2);
                    jSONArray2.put(jSONObject2);
                    jSONObject.put("path", jSONArray2);
                    jSONObject.put("type", b2);
                    jSONObject.put("value", bj.a(view));
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("x", ah.a(activity, e2.left));
                    jSONObject3.put("y", ah.a(activity, e2.top));
                    jSONObject3.put("w", ah.a(activity, e2.width()));
                    jSONObject3.put("h", ah.a(activity, e2.height()));
                    jSONObject.put(ExecutionState.FRAME, jSONObject3);
                    jSONObject.put(AnimationProperty.OPACITY, bj.i(view));
                    jSONObject.put("page", activity.getClass().getName());
                    jSONObject.put("z", bj.j(view));
                    boolean z = view instanceof WebView;
                    if (z) {
                        Object obj = null;
                        String a2 = bl.a(activity, (WebView) view, e2);
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
                    jSONObject.put("edit", bj.b(view, str) ? 1 : 0);
                    jSONArray.put(jSONObject);
                    if (z) {
                        return;
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        JSONArray jSONArray3 = new JSONArray();
                        jSONObject.put("child", jSONArray3);
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            a(activity, viewGroup.getChildAt(i2), jSONArray3, b2, view2);
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
