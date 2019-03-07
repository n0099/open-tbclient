package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends o<PointF, PointF> {
    private f(List<com.airbnb.lottie.a.a<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<PointF, PointF> dF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.pN) : new com.airbnb.lottie.a.b.j(this.pz);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static f i(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a dZ = n.a(jSONObject, eVar.cK(), eVar, com.airbnb.lottie.model.j.qu).dZ();
            return new f(dZ.pz, (PointF) dZ.pN);
        }
    }
}
