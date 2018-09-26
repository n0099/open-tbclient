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
import com.baidu.mobstat.bz;
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
/* loaded from: classes3.dex */
public class au {
    private static volatile String c;
    private static volatile int d = 0;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final b a = new b();

    public static void a() {
        d = 0;
    }

    public static void b() {
        c = "";
    }

    public JSONObject a(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            if (!ar.a()) {
                return null;
            }
            int i = d + 1;
            d = i;
            if (i >= 3) {
                ar.a(false);
            }
            Bitmap b2 = b(activity);
            if (b2 == null) {
                return null;
            }
            JSONArray c2 = c(activity);
            String a2 = bz.a.a(c2.toString().getBytes());
            if (c != null && c.equals(a2)) {
                return null;
            }
            c = a2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("screenshot", bq.a(b2));
                jSONObject.put("hash", bq.b(b2));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Config.DEVICE_WIDTH, b2.getWidth());
                jSONObject2.put("h", b2.getHeight());
                jSONObject.put("screen", jSONObject2);
                jSONObject.put("page", activity.getClass().getName());
                jSONObject.put("objects", c2);
                return jSONObject;
            } catch (Throwable th) {
                return jSONObject;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private JSONArray c(Activity activity) throws Exception {
        JSONArray jSONArray = new JSONArray();
        View a2 = bq.a(activity);
        a(activity, a2, jSONArray, "", a2);
        return jSONArray;
    }

    private void a(Activity activity, View view, JSONArray jSONArray, String str, View view2) throws Exception {
        Rect e;
        Object obj;
        String str2;
        int i = 0;
        if (view != null && (e = bq.e(view)) != null && !ap.a(view)) {
            String l = bq.l(view);
            if (!TextUtils.isEmpty(l) && !bq.c(activity, view)) {
                String c2 = bq.c(view);
                if (TextUtils.isEmpty(c2)) {
                    c2 = bq.a(view, str);
                    if (TextUtils.isEmpty(c2)) {
                        c2 = bq.a(view, view2);
                    }
                }
                if (!TextUtils.isEmpty(c2)) {
                    long j = -1;
                    try {
                        j = Long.valueOf(c2).longValue();
                    } catch (Exception e2) {
                    }
                    if (j >= 0) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("p", l);
                        jSONObject2.put("i", c2);
                        String b2 = bq.b(view);
                        jSONObject2.put("t", b2);
                        jSONArray2.put(jSONObject2);
                        jSONObject.put("path", jSONArray2);
                        jSONObject.put("type", b2);
                        jSONObject.put("value", bq.a(view));
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(Config.EVENT_HEAT_X, ao.a(activity, e.left));
                        jSONObject3.put("y", ao.a(activity, e.top));
                        jSONObject3.put(Config.DEVICE_WIDTH, ao.a(activity, e.width()));
                        jSONObject3.put("h", ao.a(activity, e.height()));
                        jSONObject.put("frame", jSONObject3);
                        jSONObject.put("alpha", bq.i(view));
                        jSONObject.put("page", activity.getClass().getName());
                        jSONObject.put("z", bq.j(view));
                        if (view instanceof WebView) {
                            String a2 = bs.a(activity, (WebView) view, e);
                            if (TextUtils.isEmpty(a2)) {
                                obj = null;
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
                        jSONObject.put("edit", bq.b(view, str) ? 1 : 0);
                        jSONArray.put(jSONObject);
                        if (!(view instanceof WebView)) {
                            if (view instanceof ViewGroup) {
                                ViewGroup viewGroup = (ViewGroup) view;
                                JSONArray jSONArray3 = new JSONArray();
                                jSONObject.put("child", jSONArray3);
                                while (true) {
                                    int i2 = i;
                                    if (i2 < viewGroup.getChildCount()) {
                                        a(activity, viewGroup.getChildAt(i2), jSONArray3, b2, view2);
                                        i = i2 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            } else {
                                jSONObject.put("child", new JSONArray());
                            }
                        }
                    }
                }
            }
        }
    }

    public Bitmap b(Activity activity) {
        List list;
        this.a.a(activity);
        FutureTask futureTask = new FutureTask(this.a);
        this.b.post(futureTask);
        List emptyList = Collections.emptyList();
        if (futureTask != null) {
            try {
                list = (List) futureTask.get(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                bj.c().b("autotrace: Screenshot interrupted, no screenshot will be sent.", e);
            } catch (TimeoutException e2) {
                bj.c().c("autotrace: Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent.", e2);
            } catch (Exception e3) {
                bj.c().d("autotrace: Exception thrown during screenshot attempt", e3);
            }
        } else {
            list = emptyList;
        }
        emptyList = list;
        if (emptyList.size() == 0) {
            return null;
        }
        return ((c) emptyList.get(0)).c.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements Callable<List<c>> {
        private Activity a;
        private final int e = 160;
        private final DisplayMetrics c = new DisplayMetrics();
        private final List<c> b = new ArrayList();
        private final a d = new a();

        public void a(Activity activity) {
            this.a = activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<c> call() throws Exception {
            this.b.clear();
            HashSet<Activity> hashSet = new HashSet(1);
            hashSet.add(this.a);
            for (Activity activity : hashSet) {
                String canonicalName = activity.getClass().getCanonicalName();
                View b = bq.b(activity);
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

        private void b() {
            ap.a(this.a, false);
        }

        private void c() {
            ap.a(this.a, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [359=5] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(c cVar) {
            Bitmap bitmap;
            Boolean bool;
            Exception exc;
            Bitmap bitmap2;
            Boolean valueOf;
            Boolean bool2;
            View view = cVar.b;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                bitmap = (Bitmap) declaredMethod.invoke(view, Bitmap.Config.RGB_565, -1, false);
            } catch (ClassCastException e) {
                bj.c().d("autotrace: createSnapshot didn't return a bitmap", e);
                bitmap = null;
            } catch (IllegalAccessException e2) {
                bj.c().d("autotrace: Can't access createSnapshot, using drawCache", e2);
                bitmap = null;
            } catch (IllegalArgumentException e3) {
                bj.c().b("autotrace: Can't call createSnapshot with arguments", e3);
                bitmap = null;
            } catch (NoSuchMethodException e4) {
                bj.c().a("autotrace: Can't call createSnapshot, will use drawCache", e4);
                bitmap = null;
            } catch (InvocationTargetException e5) {
                bj.c().d("autotrace: Exception when calling createSnapshot", e5);
                bitmap = null;
            } catch (Exception e6) {
                bj.c().d(" autotrace:createSnapshot encounter exception", e6);
                bitmap = null;
            }
            if (bitmap == null) {
                try {
                    valueOf = Boolean.valueOf(view.isDrawingCacheEnabled());
                } catch (Exception e7) {
                    bool = null;
                    exc = e7;
                }
                try {
                    view.setDrawingCacheEnabled(true);
                    view.buildDrawingCache(true);
                    bitmap2 = view.getDrawingCache();
                    bool2 = valueOf;
                } catch (Exception e8) {
                    bool = valueOf;
                    exc = e8;
                    bj.c().a("autotrace: Can't take a bitmap snapshot of view " + view + ", skipping for now.", exc);
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    if (bool != null) {
                        view.setDrawingCacheEnabled(false);
                    }
                    cVar.d = r0;
                    cVar.c = this.d;
                }
            } else {
                bitmap2 = bitmap;
                bool2 = null;
            }
            bool = bool2;
            if (bitmap2 != null) {
                int density = bitmap2.getDensity();
                r0 = density != 0 ? 160.0f / density : 1.0f;
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                int width2 = (int) ((bitmap2.getWidth() * r0) + 0.5d);
                int height2 = (int) ((bitmap2.getHeight() * r0) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.d.a(width2, height2, 160, bitmap2);
                }
            }
            if (bool != null && !bool.booleanValue()) {
                view.setDrawingCacheEnabled(false);
            }
            cVar.d = r0;
            cVar.c = this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        private final Paint b = new Paint(2);
        private Bitmap a = null;

        public synchronized void a(int i, int i2, int i3, Bitmap bitmap) {
            if (this.a == null || this.a.getWidth() != i || this.a.getHeight() != i2) {
                try {
                    this.a = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError e) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c {
        public final String a;
        public final View b;
        public a c = null;
        public float d = 1.0f;

        public c(String str, View view) {
            this.a = str;
            this.b = view;
        }
    }
}
