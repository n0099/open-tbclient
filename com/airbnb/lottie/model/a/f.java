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
    public com.airbnb.lottie.a.b.a<PointF, PointF> dG() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.pS) : new com.airbnb.lottie.a.b.j(this.pE);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static f i(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a ea = n.a(jSONObject, eVar.cL(), eVar, com.airbnb.lottie.model.j.qy).ea();
            return new f(ea.pE, (PointF) ea.pS);
        }
    }
}
