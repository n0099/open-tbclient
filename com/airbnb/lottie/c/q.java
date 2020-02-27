package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
class q {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static SparseArrayCompat<WeakReference<Interpolator>> jY;

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> dB() {
        if (jY == null) {
            jY = new SparseArrayCompat<>();
        }
        return jY;
    }

    @Nullable
    private static WeakReference<Interpolator> o(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = dB().get(i);
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            jY.put(i, weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.airbnb.lottie.e.a<T> a(JsonReader jsonReader, com.airbnb.lottie.e eVar, float f, aj<T> ajVar, boolean z) throws IOException {
        return z ? a(eVar, jsonReader, f, ajVar) : a(jsonReader, f, ajVar);
    }

    private static <T> com.airbnb.lottie.e.a<T> a(com.airbnb.lottie.e eVar, JsonReader jsonReader, float f, aj<T> ajVar) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        PointF g;
        PointF pointF;
        PointF pointF2;
        T t;
        boolean z;
        PointF pointF3;
        PointF pointF4 = null;
        PointF pointF5 = null;
        float f2 = 0.0f;
        T t2 = null;
        T t3 = null;
        boolean z2 = false;
        PointF pointF6 = null;
        PointF pointF7 = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 5;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
                        c = 4;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 1;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3701:
                    if (nextName.equals(Config.FEED_LIST_PART)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3707:
                    if (nextName.equals("to")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    g = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    break;
                case 1:
                    g = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = ajVar.b(jsonReader, f);
                    z = z2;
                    pointF3 = pointF6;
                    break;
                case 2:
                    t3 = ajVar.b(jsonReader, f);
                    g = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    break;
                case 3:
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    PointF pointF8 = pointF7;
                    pointF = p.g(jsonReader, f);
                    g = pointF8;
                    break;
                case 4:
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    PointF pointF9 = pointF7;
                    pointF = pointF4;
                    pointF2 = p.g(jsonReader, f);
                    g = pointF9;
                    break;
                case 5:
                    pointF3 = pointF6;
                    PointF pointF10 = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = jsonReader.nextInt() == 1;
                    g = pointF10;
                    break;
                case 6:
                    PointF pointF11 = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = p.g(jsonReader, f);
                    g = pointF11;
                    break;
                case 7:
                    g = p.g(jsonReader, f);
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    break;
                default:
                    jsonReader.skipValue();
                    g = pointF7;
                    pointF = pointF4;
                    pointF2 = pointF5;
                    t = t2;
                    z = z2;
                    pointF3 = pointF6;
                    break;
            }
            pointF6 = pointF3;
            z2 = z;
            t2 = t;
            pointF5 = pointF2;
            pointF4 = pointF;
            pointF7 = g;
        }
        jsonReader.endObject();
        if (z2) {
            interpolator = LINEAR_INTERPOLATOR;
            t3 = t2;
        } else if (pointF4 != null && pointF5 != null) {
            pointF4.x = com.airbnb.lottie.d.e.clamp(pointF4.x, -f, f);
            pointF4.y = com.airbnb.lottie.d.e.clamp(pointF4.y, -100.0f, 100.0f);
            pointF5.x = com.airbnb.lottie.d.e.clamp(pointF5.x, -f, f);
            pointF5.y = com.airbnb.lottie.d.e.clamp(pointF5.y, -100.0f, 100.0f);
            int c2 = com.airbnb.lottie.d.f.c(pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            WeakReference<Interpolator> o = o(c2);
            if (o == null) {
                interpolator2 = null;
            } else {
                interpolator2 = o.get();
            }
            if (o == null || interpolator2 == null) {
                interpolator2 = PathInterpolatorCompat.create(pointF4.x / f, pointF4.y / f, pointF5.x / f, pointF5.y / f);
                try {
                    a(c2, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            interpolator = interpolator2;
        } else {
            interpolator = LINEAR_INTERPOLATOR;
        }
        com.airbnb.lottie.e.a<T> aVar = new com.airbnb.lottie.e.a<>(eVar, t2, t3, interpolator, f2, null);
        aVar.kx = pointF6;
        aVar.ky = pointF7;
        return aVar;
    }

    private static <T> com.airbnb.lottie.e.a<T> a(JsonReader jsonReader, float f, aj<T> ajVar) throws IOException {
        return new com.airbnb.lottie.e.a<>(ajVar.b(jsonReader, f));
    }
}
