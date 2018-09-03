package com.airbnb.lottie.a;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.e;
import com.airbnb.lottie.model.a.m;
import com.baidu.appsearchlib.Info;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a<T> {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private final e jY;
    @Nullable
    public final T kY;
    @Nullable
    public final T kZ;
    @Nullable
    public final Interpolator la;
    public final float lb;
    @Nullable
    public Float lc;
    private float ld = Float.MIN_VALUE;
    private float le = Float.MIN_VALUE;

    public static void f(List<? extends a<?>> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            list.get(i2).lc = Float.valueOf(list.get(i2 + 1).lb);
            i = i2 + 1;
        }
        a<?> aVar = list.get(size - 1);
        if (aVar.kY == null) {
            list.remove(aVar);
        }
    }

    public a(e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.jY = eVar;
        this.kY = t;
        this.kZ = t2;
        this.la = interpolator;
        this.lb = f;
        this.lc = f2;
    }

    public float bA() {
        if (this.ld == Float.MIN_VALUE) {
            this.ld = (this.lb - ((float) this.jY.bg())) / this.jY.bm();
        }
        return this.ld;
    }

    public float bB() {
        if (this.le == Float.MIN_VALUE) {
            if (this.lc == null) {
                this.le = 1.0f;
            } else {
                this.le = bA() + ((this.lc.floatValue() - this.lb) / this.jY.bm());
            }
        }
        return this.le;
    }

    public boolean bC() {
        return this.la == null;
    }

    public boolean g(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= bA() && f < bB();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.kY + ", endValue=" + this.kZ + ", startFrame=" + this.lb + ", endFrame=" + this.lc + ", interpolator=" + this.la + '}';
    }

    /* renamed from: com.airbnb.lottie.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0004a {
        private static SparseArrayCompat<WeakReference<Interpolator>> lf;

        private static SparseArrayCompat<WeakReference<Interpolator>> bE() {
            if (lf == null) {
                lf = new SparseArrayCompat<>();
            }
            return lf;
        }

        @Nullable
        private static WeakReference<Interpolator> k(int i) {
            WeakReference<Interpolator> weakReference;
            synchronized (C0004a.class) {
                weakReference = bE().get(i);
            }
            return weakReference;
        }

        private static void a(int i, WeakReference<Interpolator> weakReference) {
            synchronized (C0004a.class) {
                lf.put(i, weakReference);
            }
        }

        private C0004a() {
        }

        public static <T> a<T> a(JSONObject jSONObject, e eVar, float f, m.a<T> aVar) {
            T b;
            Interpolator interpolator;
            T t;
            PointF pointF;
            PointF pointF2;
            Interpolator interpolator2;
            float f2 = 0.0f;
            if (jSONObject.has(Info.kBaiduTimeKey)) {
                f2 = (float) jSONObject.optDouble(Info.kBaiduTimeKey, 0.0d);
                Object opt = jSONObject.opt(NotifyType.SOUND);
                T b2 = opt != null ? aVar.b(opt, f) : null;
                Object opt2 = jSONObject.opt("e");
                T b3 = opt2 != null ? aVar.b(opt2, f) : null;
                JSONObject optJSONObject = jSONObject.optJSONObject("o");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("i");
                if (optJSONObject == null || optJSONObject2 == null) {
                    pointF = null;
                    pointF2 = null;
                } else {
                    PointF a = b.a(optJSONObject, f);
                    PointF a2 = b.a(optJSONObject2, f);
                    pointF2 = a;
                    pointF = a2;
                }
                if (jSONObject.optInt("h", 0) == 1) {
                    interpolator2 = a.LINEAR_INTERPOLATOR;
                    b3 = b2;
                } else if (pointF2 == null) {
                    interpolator2 = a.LINEAR_INTERPOLATOR;
                } else {
                    pointF2.x = com.airbnb.lottie.c.e.clamp(pointF2.x, -f, f);
                    pointF2.y = com.airbnb.lottie.c.e.clamp(pointF2.y, -100.0f, 100.0f);
                    pointF.x = com.airbnb.lottie.c.e.clamp(pointF.x, -f, f);
                    pointF.y = com.airbnb.lottie.c.e.clamp(pointF.y, -100.0f, 100.0f);
                    int b4 = f.b(pointF2.x, pointF2.y, pointF.x, pointF.y);
                    WeakReference<Interpolator> k = k(b4);
                    interpolator2 = k != null ? k.get() : null;
                    if (k == null || interpolator2 == null) {
                        interpolator2 = PathInterpolatorCompat.create(pointF2.x / f, pointF2.y / f, pointF.x / f, pointF.y / f);
                        try {
                            a(b4, new WeakReference(interpolator2));
                        } catch (ArrayIndexOutOfBoundsException e) {
                        }
                    }
                }
                interpolator = interpolator2;
                b = b3;
                t = b2;
            } else {
                b = aVar.b(jSONObject, f);
                interpolator = null;
                t = b;
            }
            return new a<>(eVar, t, b, interpolator, f2, null);
        }

        public static <T> List<a<T>> a(JSONArray jSONArray, e eVar, float f, m.a<T> aVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i), eVar, f, aVar));
            }
            a.f(arrayList);
            return arrayList;
        }
    }
}
