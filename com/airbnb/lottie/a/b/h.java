package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
import com.airbnb.lottie.a.a;
import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends com.airbnb.lottie.a.a<PointF> {
    @Nullable
    private Path oy;

    private h(com.airbnb.lottie.e eVar, @Nullable PointF pointF, @Nullable PointF pointF2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        super(eVar, pointF, pointF2, interpolator, f, f2);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static h a(JSONObject jSONObject, com.airbnb.lottie.e eVar, m.a<PointF> aVar) {
            PointF pointF;
            PointF pointF2;
            com.airbnb.lottie.a.a a = a.C0007a.a(jSONObject, eVar, eVar.cM(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                PointF a2 = com.airbnb.lottie.c.b.a(optJSONArray2, eVar.cM());
                pointF = com.airbnb.lottie.c.b.a(optJSONArray, eVar.cM());
                pointF2 = a2;
            }
            h hVar = new h(eVar, (PointF) a.on, (PointF) a.oo, a.oq, a.or, a.ot);
            boolean z = (a.oo == 0 || a.on == 0 || !((PointF) a.on).equals(((PointF) a.oo).x, ((PointF) a.oo).y)) ? false : true;
            if (hVar.oo != 0 && !z) {
                hVar.oy = com.airbnb.lottie.c.f.b((PointF) a.on, (PointF) a.oo, pointF2, pointF);
            }
            return hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path getPath() {
        return this.oy;
    }
}
