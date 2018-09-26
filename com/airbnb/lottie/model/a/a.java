package com.airbnb.lottie.model.a;

import com.airbnb.lottie.model.a.n;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends o<Integer, Integer> {
    private a(List<com.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    @Override // com.airbnb.lottie.model.a.m
    public com.airbnb.lottie.a.b.a<Integer, Integer> dp() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.oZ) : new com.airbnb.lottie.a.b.b(this.oL);
    }

    @Override // com.airbnb.lottie.model.a.o
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.oZ + '}';
    }

    /* renamed from: com.airbnb.lottie.model.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0007a {
        public static a d(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a dJ = n.a(jSONObject, 1.0f, eVar, com.airbnb.lottie.model.a.px).dJ();
            return new a(dJ.oL, (Integer) dJ.oZ);
        }
    }
}
