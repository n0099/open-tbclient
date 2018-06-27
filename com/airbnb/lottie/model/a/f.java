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
    public com.airbnb.lottie.a.b.a<PointF, PointF> ck() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.mJ) : new com.airbnb.lottie.a.b.j(this.mr);
    }

    /* loaded from: classes2.dex */
    public static final class a {
        public static f i(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cE = n.a(jSONObject, eVar.bp(), eVar, com.airbnb.lottie.model.j.ns).cE();
            return new f(cE.mr, (PointF) cE.mJ);
        }
    }
}
