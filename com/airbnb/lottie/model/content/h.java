package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private boolean closed;
    private PointF qB;

    /* renamed from: rx  reason: collision with root package name */
    private final List<com.airbnb.lottie.model.c> f3rx;

    private h(PointF pointF, boolean z, List<com.airbnb.lottie.model.c> list) {
        this.f3rx = new ArrayList();
        this.qB = pointF;
        this.closed = z;
        this.f3rx.addAll(list);
    }

    public h() {
        this.f3rx = new ArrayList();
    }

    private void i(float f, float f2) {
        if (this.qB == null) {
            this.qB = new PointF();
        }
        this.qB.set(f, f2);
    }

    public PointF ez() {
        return this.qB;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.c> eA() {
        return this.f3rx;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.qB == null) {
            this.qB = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (!this.f3rx.isEmpty() && this.f3rx.size() != hVar.eA().size() && this.f3rx.size() != hVar2.eA().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + eA().size() + "\tShape 1: " + hVar.eA().size() + "\tShape 2: " + hVar2.eA().size());
        }
        if (this.f3rx.isEmpty()) {
            for (int size = hVar.eA().size() - 1; size >= 0; size--) {
                this.f3rx.add(new com.airbnb.lottie.model.c());
            }
        }
        PointF ez = hVar.ez();
        PointF ez2 = hVar2.ez();
        i(com.airbnb.lottie.c.e.lerp(ez.x, ez2.x, f), com.airbnb.lottie.c.e.lerp(ez.y, ez2.y, f));
        for (int size2 = this.f3rx.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.model.c cVar = hVar.eA().get(size2);
            com.airbnb.lottie.model.c cVar2 = hVar2.eA().get(size2);
            PointF dA = cVar.dA();
            PointF dB = cVar.dB();
            PointF dC = cVar.dC();
            PointF dA2 = cVar2.dA();
            PointF dB2 = cVar2.dB();
            PointF dC2 = cVar2.dC();
            this.f3rx.get(size2).f(com.airbnb.lottie.c.e.lerp(dA.x, dA2.x, f), com.airbnb.lottie.c.e.lerp(dA.y, dA2.y, f));
            this.f3rx.get(size2).g(com.airbnb.lottie.c.e.lerp(dB.x, dB2.x, f), com.airbnb.lottie.c.e.lerp(dB.y, dB2.y, f));
            this.f3rx.get(size2).h(com.airbnb.lottie.c.e.lerp(dC.x, dC2.x, f), com.airbnb.lottie.c.e.lerp(dC.y, dC2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f3rx.size() + "closed=" + this.closed + '}';
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<h> {
        public static final a ry = new a();

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
                if (!(opt instanceof JSONObject) || !((JSONObject) opt).has("v")) {
                    jSONObject = null;
                } else {
                    jSONObject = (JSONObject) opt;
                }
                jSONObject2 = jSONObject;
            } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("v")) {
                jSONObject2 = (JSONObject) obj;
            }
            if (jSONObject2 == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray("v");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("i");
            JSONArray optJSONArray3 = jSONObject2.optJSONArray(Config.OS);
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
