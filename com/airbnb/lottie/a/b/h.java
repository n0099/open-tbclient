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
    private Path lR;

    private h(com.airbnb.lottie.e eVar, @Nullable PointF pointF, @Nullable PointF pointF2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        super(eVar, pointF, pointF2, interpolator, f, f2);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static h a(JSONObject jSONObject, com.airbnb.lottie.e eVar, m.a<PointF> aVar) {
            PointF pointF;
            PointF pointF2;
            com.airbnb.lottie.a.a a = a.C0005a.a(jSONObject, eVar, eVar.bI(), aVar);
            JSONArray optJSONArray = jSONObject.optJSONArray(Config.FEED_LIST_PART);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("to");
            if (optJSONArray == null || optJSONArray2 == null) {
                pointF = null;
                pointF2 = null;
            } else {
                PointF a2 = com.airbnb.lottie.c.b.a(optJSONArray2, eVar.bI());
                pointF = com.airbnb.lottie.c.b.a(optJSONArray, eVar.bI());
                pointF2 = a2;
            }
            h hVar = new h(eVar, (PointF) a.lI, (PointF) a.lJ, a.lK, a.lL, a.lM);
            boolean z = (a.lJ == 0 || a.lI == 0 || !((PointF) a.lI).equals(((PointF) a.lJ).x, ((PointF) a.lJ).y)) ? false : true;
            if (hVar.lJ != 0 && !z) {
                hVar.lR = com.airbnb.lottie.c.f.b((PointF) a.lI, (PointF) a.lJ, pointF2, pointF);
            }
            return hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path cd() {
        return this.lR;
    }
}
