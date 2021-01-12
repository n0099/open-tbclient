package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
class q {
    private static SparseArrayCompat<WeakReference<Interpolator>> Hv;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> kq() {
        if (Hv == null) {
            Hv = new SparseArrayCompat<>();
        }
        return Hv;
    }

    @Nullable
    private static WeakReference<Interpolator> Y(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = kq().get(i);
        }
        return weakReference;
    }

    private static void b(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            Hv.put(i, weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.airbnb.lottie.e.a<T> a(JsonReader jsonReader, com.airbnb.lottie.d dVar, float f, aj<T> ajVar, boolean z) throws IOException {
        return z ? a(dVar, jsonReader, f, ajVar) : a(jsonReader, f, ajVar);
    }

    private static <T> com.airbnb.lottie.e.a<T> a(com.airbnb.lottie.d dVar, JsonReader jsonReader, float f, aj<T> ajVar) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator interpolator2;
        PointF l;
        PointF pointF;
        T t2;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f2 = 0.0f;
        T t3 = null;
        T t4 = null;
        boolean z = false;
        PointF pointF4 = null;
        PointF pointF5 = null;
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
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 1:
                    t3 = ajVar.g(jsonReader, f);
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 2:
                    t2 = ajVar.g(jsonReader, f);
                    l = pointF5;
                    pointF = pointF4;
                    break;
                case 3:
                    pointF2 = p.l(jsonReader, f);
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 4:
                    pointF3 = p.l(jsonReader, f);
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 5:
                    z = jsonReader.nextInt() == 1;
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
                case 6:
                    pointF = p.l(jsonReader, f);
                    l = pointF5;
                    t2 = t4;
                    break;
                case 7:
                    l = p.l(jsonReader, f);
                    pointF = pointF4;
                    t2 = t4;
                    break;
                default:
                    jsonReader.skipValue();
                    l = pointF5;
                    pointF = pointF4;
                    t2 = t4;
                    break;
            }
            pointF5 = l;
            pointF4 = pointF;
            t4 = t2;
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            t = t3;
        } else if (pointF2 != null && pointF3 != null) {
            pointF2.x = com.airbnb.lottie.d.e.clamp(pointF2.x, -f, f);
            pointF2.y = com.airbnb.lottie.d.e.clamp(pointF2.y, -100.0f, 100.0f);
            pointF3.x = com.airbnb.lottie.d.e.clamp(pointF3.x, -f, f);
            pointF3.y = com.airbnb.lottie.d.e.clamp(pointF3.y, -100.0f, 100.0f);
            int d = com.airbnb.lottie.d.f.d(pointF2.x, pointF2.y, pointF3.x, pointF3.y);
            WeakReference<Interpolator> Y = Y(d);
            if (Y == null) {
                interpolator2 = null;
            } else {
                interpolator2 = Y.get();
            }
            if (Y == null || interpolator2 == null) {
                interpolator2 = PathInterpolatorCompat.create(pointF2.x / f, pointF2.y / f, pointF3.x / f, pointF3.y / f);
                try {
                    b(d, new WeakReference(interpolator2));
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            interpolator = interpolator2;
            t = t4;
        } else {
            interpolator = LINEAR_INTERPOLATOR;
            t = t4;
        }
        com.airbnb.lottie.e.a<T> aVar = new com.airbnb.lottie.e.a<>(dVar, t3, t, interpolator, f2, null);
        aVar.HR = pointF4;
        aVar.HS = pointF5;
        return aVar;
    }

    private static <T> com.airbnb.lottie.e.a<T> a(JsonReader jsonReader, float f, aj<T> ajVar) throws IOException {
        return new com.airbnb.lottie.e.a<>(ajVar.g(jsonReader, f));
    }
}
