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
    private PointF qE;
    private final List<com.airbnb.lottie.model.c> rA;

    private h(PointF pointF, boolean z, List<com.airbnb.lottie.model.c> list) {
        this.rA = new ArrayList();
        this.qE = pointF;
        this.closed = z;
        this.rA.addAll(list);
    }

    public h() {
        this.rA = new ArrayList();
    }

    private void f(float f, float f2) {
        if (this.qE == null) {
            this.qE = new PointF();
        }
        this.qE.set(f, f2);
    }

    public PointF eB() {
        return this.qE;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.c> eC() {
        return this.rA;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.qE == null) {
            this.qE = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (!this.rA.isEmpty() && this.rA.size() != hVar.eC().size() && this.rA.size() != hVar2.eC().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + eC().size() + "\tShape 1: " + hVar.eC().size() + "\tShape 2: " + hVar2.eC().size());
        }
        if (this.rA.isEmpty()) {
            for (int size = hVar.eC().size() - 1; size >= 0; size--) {
                this.rA.add(new com.airbnb.lottie.model.c());
            }
        }
        PointF eB = hVar.eB();
        PointF eB2 = hVar2.eB();
        f(com.airbnb.lottie.c.e.lerp(eB.x, eB2.x, f), com.airbnb.lottie.c.e.lerp(eB.y, eB2.y, f));
        for (int size2 = this.rA.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.model.c cVar = hVar.eC().get(size2);
            com.airbnb.lottie.model.c cVar2 = hVar2.eC().get(size2);
            PointF dC = cVar.dC();
            PointF dD = cVar.dD();
            PointF dE = cVar.dE();
            PointF dC2 = cVar2.dC();
            PointF dD2 = cVar2.dD();
            PointF dE2 = cVar2.dE();
            this.rA.get(size2).c(com.airbnb.lottie.c.e.lerp(dC.x, dC2.x, f), com.airbnb.lottie.c.e.lerp(dC.y, dC2.y, f));
            this.rA.get(size2).d(com.airbnb.lottie.c.e.lerp(dD.x, dD2.x, f), com.airbnb.lottie.c.e.lerp(dD.y, dD2.y, f));
            this.rA.get(size2).e(com.airbnb.lottie.c.e.lerp(dE.x, dE2.x, f), com.airbnb.lottie.c.e.lerp(dE.y, dE2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.rA.size() + "closed=" + this.closed + '}';
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<h> {
        public static final a rB = new a();

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
