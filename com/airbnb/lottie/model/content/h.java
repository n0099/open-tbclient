package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.model.a.m;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private boolean closed;
    private PointF nz;
    private final List<com.airbnb.lottie.model.c> ox;

    private h(PointF pointF, boolean z, List<com.airbnb.lottie.model.c> list) {
        this.ox = new ArrayList();
        this.nz = pointF;
        this.closed = z;
        this.ox.addAll(list);
    }

    public h() {
        this.ox = new ArrayList();
    }

    private void f(float f, float f2) {
        if (this.nz == null) {
            this.nz = new PointF();
        }
        this.nz.set(f, f2);
    }

    public PointF de() {
        return this.nz;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.c> df() {
        return this.ox;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.nz == null) {
            this.nz = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (!this.ox.isEmpty() && this.ox.size() != hVar.df().size() && this.ox.size() != hVar2.df().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + df().size() + "\tShape 1: " + hVar.df().size() + "\tShape 2: " + hVar2.df().size());
        }
        if (this.ox.isEmpty()) {
            for (int size = hVar.df().size() - 1; size >= 0; size--) {
                this.ox.add(new com.airbnb.lottie.model.c());
            }
        }
        PointF de = hVar.de();
        PointF de2 = hVar2.de();
        f(com.airbnb.lottie.c.e.lerp(de.x, de2.x, f), com.airbnb.lottie.c.e.lerp(de.y, de2.y, f));
        for (int size2 = this.ox.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.model.c cVar = hVar.df().get(size2);
            com.airbnb.lottie.model.c cVar2 = hVar2.df().get(size2);
            PointF cf = cVar.cf();
            PointF cg = cVar.cg();
            PointF ch = cVar.ch();
            PointF cf2 = cVar2.cf();
            PointF cg2 = cVar2.cg();
            PointF ch2 = cVar2.ch();
            this.ox.get(size2).c(com.airbnb.lottie.c.e.lerp(cf.x, cf2.x, f), com.airbnb.lottie.c.e.lerp(cf.y, cf2.y, f));
            this.ox.get(size2).d(com.airbnb.lottie.c.e.lerp(cg.x, cg2.x, f), com.airbnb.lottie.c.e.lerp(cg.y, cg2.y, f));
            this.ox.get(size2).e(com.airbnb.lottie.c.e.lerp(ch.x, ch2.x, f), com.airbnb.lottie.c.e.lerp(ch.y, ch2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.ox.size() + "closed=" + this.closed + '}';
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<h> {
        public static final a oy = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: h */
        public h b(Object obj, float f) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            if (obj instanceof JSONArray) {
                Object opt = ((JSONArray) obj).opt(0);
                if (!(opt instanceof JSONObject) || !((JSONObject) opt).has(NotifyType.VIBRATE)) {
                    jSONObject = null;
                } else {
                    jSONObject = (JSONObject) opt;
                }
                jSONObject2 = jSONObject;
            } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has(NotifyType.VIBRATE)) {
                jSONObject2 = (JSONObject) obj;
            }
            if (jSONObject2 == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray(NotifyType.VIBRATE);
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("i");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray("o");
            boolean optBoolean = jSONObject2.optBoolean("c", false);
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length() || optJSONArray.length() != optJSONArray3.length()) {
                throw new IllegalStateException("Unable to process points array or tangents. " + jSONObject2);
            }
            if (optJSONArray.length() == 0) {
                return new h(new PointF(), false, Collections.emptyList());
            }
            int length = optJSONArray.length();
            PointF a = a(0, optJSONArray);
            a.x *= f;
            a.y *= f;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 1; i < length; i++) {
                PointF a2 = a(i, optJSONArray);
                PointF a3 = a(i - 1, optJSONArray);
                PointF a4 = a(i - 1, optJSONArray3);
                PointF a5 = a(i, optJSONArray2);
                PointF b = com.airbnb.lottie.c.e.b(a3, a4);
                PointF b2 = com.airbnb.lottie.c.e.b(a2, a5);
                b.x *= f;
                b.y *= f;
                b2.x *= f;
                b2.y *= f;
                a2.x *= f;
                a2.y *= f;
                arrayList.add(new com.airbnb.lottie.model.c(b, b2, a2));
            }
            if (optBoolean) {
                PointF a6 = a(0, optJSONArray);
                PointF a7 = a(length - 1, optJSONArray);
                PointF a8 = a(length - 1, optJSONArray3);
                PointF a9 = a(0, optJSONArray2);
                PointF b3 = com.airbnb.lottie.c.e.b(a7, a8);
                PointF b4 = com.airbnb.lottie.c.e.b(a6, a9);
                if (f != 1.0f) {
                    b3.x *= f;
                    b3.y *= f;
                    b4.x *= f;
                    b4.y *= f;
                    a6.x *= f;
                    a6.y *= f;
                }
                arrayList.add(new com.airbnb.lottie.model.c(b3, b4, a6));
            }
            return new h(a, optBoolean, arrayList);
        }

        private static PointF a(int i, JSONArray jSONArray) {
            if (i >= jSONArray.length()) {
                throw new IllegalArgumentException("Invalid index " + i + ". There are only " + jSONArray.length() + " points.");
            }
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            Object opt = optJSONArray.opt(0);
            Object opt2 = optJSONArray.opt(1);
            return new PointF(opt instanceof Double ? ((Double) opt).floatValue() : ((Integer) opt).intValue(), opt2 instanceof Double ? ((Double) opt2).floatValue() : ((Integer) opt2).intValue());
        }
    }
}
