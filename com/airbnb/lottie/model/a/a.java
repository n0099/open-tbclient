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
    public com.airbnb.lottie.a.b.a<Integer, Integer> dF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.pN) : new com.airbnb.lottie.a.b.b(this.pz);
    }

    @Override // com.airbnb.lottie.model.a.o
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.pN + '}';
    }

    /* renamed from: com.airbnb.lottie.model.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0008a {
        public static a d(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a dZ = n.a(jSONObject, 1.0f, eVar, com.airbnb.lottie.model.a.qf).dZ();
            return new a(dZ.pz, (Integer) dZ.pN);
        }
    }
}
