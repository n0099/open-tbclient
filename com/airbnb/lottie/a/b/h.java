package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.a.m;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends com.airbnb.lottie.a.a<PointF> {
    @Nullable
    private Path lo;

    private h(com.airbnb.lottie.e eVar, @Nullable PointF pointF, @Nullable PointF pointF2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        super(eVar, pointF, pointF2, interpolator, f, f2);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static h a(JSONObject jSONObject, com.airbnb.lottie.e eVar, m.a<PointF> aVar) {
            PointF pointF;
            PointF pointF2;
            com.airbnb.lottie.a.a a = a.C0004a.a(jSONObject, eVar, eVar.bp(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("ti");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                PointF a2 = com.airbnb.lottie.c.b.a(optJSONArray2, eVar.bp());
                pointF = com.airbnb.lottie.c.b.a(optJSONArray, eVar.bp());
                pointF2 = a2;
            }
            h hVar = new h(eVar, (PointF) a.lf, (PointF) a.lg, a.lh, a.li, a.lj);
            boolean z = (a.lg == 0 || a.lf == 0 || !((PointF) a.lf).equals(((PointF) a.lg).x, ((PointF) a.lg).y)) ? false : true;
            if (hVar.lg != 0 && !z) {
                hVar.lo = com.airbnb.lottie.c.f.b((PointF) a.lf, (PointF) a.lg, pointF2, pointF);
            }
            return hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path getPath() {
        return this.lo;
    }
}
