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
import com.baidu.mobstat.bt;
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

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f8516c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile int f8517d;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f8519b = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final b f8518a = new b();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public final Paint f8521b = new Paint(2);

        /* renamed from: a  reason: collision with root package name */
        public Bitmap f8520a = null;

        public synchronized void a(int i2, int i3, int i4, Bitmap bitmap) {
            if (this.f8520a == null || this.f8520a.getWidth() != i2 || this.f8520a.getHeight() != i3) {
                try {
                    this.f8520a = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError unused) {
                    this.f8520a = null;
                }
                if (this.f8520a != null) {
                    this.f8520a.setDensity(i4);
                }
            }
            if (this.f8520a != null) {
                new Canvas(this.f8520a).drawBitmap(bitmap, 0.0f, 0.0f, this.f8521b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Callable<List<c>> {

        /* renamed from: a  reason: collision with root package name */
        public Activity f8522a;

        /* renamed from: e  reason: collision with root package name */
        public final int f8526e = 160;

        /* renamed from: c  reason: collision with root package name */
        public final DisplayMetrics f8524c = new DisplayMetrics();

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f8523b = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public final a f8525d = new a();

        private void b() {
            ai.a(this.f8522a, false);
        }

        private void c() {
            ai.a(this.f8522a, true);
        }

        public void a(Activity activity) {
            this.f8522a = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<c> call() throws Exception {
            this.f8523b.clear();
            HashSet<Activity> hashSet = new HashSet(1);
            hashSet.add(this.f8522a);
            for (Activity activity : hashSet) {
                String canonicalName = activity.getClass().getCanonicalName();
                View b2 = bj.b(activity);
                activity.getWindowManager().getDefaultDisplay().getMetrics(this.f8524c);
                this.f8523b.add(new c(canonicalName, b2));
            }
            int size = this.f8523b.size();
            for (int i2 = 0; i2 < size; i2++) {
                b();
                a(this.f8523b.get(i2));
                c();
            }
            return this.f8523b;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(c cVar) {
            Bitmap bitmap;
            View view = cVar.f8528b;
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
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
            } catch (IllegalAccessException e3) {
                bc.c().d("autotrace: Can't access createSnapshot, using drawCache", e3);
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                }
                if (bool != null) {
                }
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
            } catch (IllegalArgumentException e4) {
                bc.c().b("autotrace: Can't call createSnapshot with arguments", e4);
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                }
                if (bool != null) {
                }
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
            } catch (NoSuchMethodException e5) {
                bc.c().a("autotrace: Can't call createSnapshot, will use drawCache", e5);
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                }
                if (bool != null) {
                }
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
            } catch (InvocationTargetException e6) {
                bc.c().d("autotrace: Exception when calling createSnapshot", e6);
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                }
                if (bool != null) {
                }
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
            } catch (Exception e7) {
                bc.c().d(" autotrace:createSnapshot encounter exception", e7);
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                }
                if (bool != null) {
                }
                cVar.f8530d = r3;
                cVar.f8529c = this.f8525d;
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
                    this.f8525d.a(width2, height2, 160, bitmap);
                }
            }
            if (bool != null && !bool.booleanValue()) {
                view.setDrawingCacheEnabled(false);
            }
            cVar.f8530d = r3;
            cVar.f8529c = this.f8525d;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f8527a;

        /* renamed from: b  reason: collision with root package name */
        public final View f8528b;

        /* renamed from: c  reason: collision with root package name */
        public a f8529c = null;

        /* renamed from: d  reason: collision with root package name */
        public float f8530d = 1.0f;

        public c(String str, View view) {
            this.f8527a = str;
            this.f8528b = view;
        }
    }

    public static void a() {
        f8517d = 0;
    }

    public static void b() {
        f8516c = "";
    }

    private JSONArray c(Activity activity) throws Exception {
        JSONArray jSONArray = new JSONArray();
        View a2 = bj.a(activity);
        a(activity, a2, jSONArray, "", a2);
        return jSONArray;
    }

    public JSONObject a(Activity activity) {
        JSONObject jSONObject = null;
        if (activity == null) {
            return null;
        }
        try {
            if (ak.a()) {
                int i2 = f8517d + 1;
                f8517d = i2;
                if (i2 >= 3) {
                    ak.a(false);
                }
                Bitmap b2 = b(activity);
                if (b2 == null) {
                    return null;
                }
                JSONArray c2 = c(activity);
                String a2 = bt.a.a(c2.toString().getBytes());
                if (f8516c == null || !f8516c.equals(a2)) {
                    f8516c = a2;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("screenshot", bj.a(b2));
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
        this.f8518a.a(activity);
        FutureTask futureTask = new FutureTask(this.f8518a);
        this.f8519b.post(futureTask);
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
        return ((c) emptyList.get(0)).f8529c.f8520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Activity activity, View view, JSONArray jSONArray, String str, View view2) throws Exception {
        Rect e2;
        String str2;
        if (view == null || (e2 = bj.e(view)) == null || ai.a(view)) {
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
                    jSONObject.put("frame", jSONObject3);
                    jSONObject.put("alpha", bj.i(view));
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
