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
    private PointF pR;
    private final List<com.airbnb.lottie.model.c> qN;

    private h(PointF pointF, boolean z, List<com.airbnb.lottie.model.c> list) {
        this.qN = new ArrayList();
        this.pR = pointF;
        this.closed = z;
        this.qN.addAll(list);
    }

    public h() {
        this.qN = new ArrayList();
    }

    private void f(float f, float f2) {
        if (this.pR == null) {
            this.pR = new PointF();
        }
        this.pR.set(f, f2);
    }

    public PointF ej() {
        return this.pR;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.c> ek() {
        return this.qN;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.pR == null) {
            this.pR = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (!this.qN.isEmpty() && this.qN.size() != hVar.ek().size() && this.qN.size() != hVar2.ek().size()) {
            throw new IllegalStateException("Curves must have the same number of control points. This: " + ek().size() + "\tShape 1: " + hVar.ek().size() + "\tShape 2: " + hVar2.ek().size());
        }
        if (this.qN.isEmpty()) {
            for (int size = hVar.ek().size() - 1; size >= 0; size--) {
                this.qN.add(new com.airbnb.lottie.model.c());
            }
        }
        PointF ej = hVar.ej();
        PointF ej2 = hVar2.ej();
        f(com.airbnb.lottie.c.e.lerp(ej.x, ej2.x, f), com.airbnb.lottie.c.e.lerp(ej.y, ej2.y, f));
        for (int size2 = this.qN.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.model.c cVar = hVar.ek().get(size2);
            com.airbnb.lottie.model.c cVar2 = hVar2.ek().get(size2);
            PointF dk = cVar.dk();
            PointF dl = cVar.dl();
            PointF dm = cVar.dm();
            PointF dk2 = cVar2.dk();
            PointF dl2 = cVar2.dl();
            PointF dm2 = cVar2.dm();
            this.qN.get(size2).c(com.airbnb.lottie.c.e.lerp(dk.x, dk2.x, f), com.airbnb.lottie.c.e.lerp(dk.y, dk2.y, f));
            this.qN.get(size2).d(com.airbnb.lottie.c.e.lerp(dl.x, dl2.x, f), com.airbnb.lottie.c.e.lerp(dl.y, dl2.y, f));
            this.qN.get(size2).e(com.airbnb.lottie.c.e.lerp(dm.x, dm2.x, f), com.airbnb.lottie.c.e.lerp(dm.y, dm2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.qN.size() + "closed=" + this.closed + '}';
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<h> {
        public static final a qO = new a();

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
