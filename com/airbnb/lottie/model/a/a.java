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
    public com.airbnb.lottie.a.b.a<Integer, Integer> cF() {
        return !hasAnimation() ? new com.airbnb.lottie.a.b.n(this.nl) : new com.airbnb.lottie.a.b.b(this.mV);
    }

    @Override // com.airbnb.lottie.model.a.o
    public String toString() {
        return "AnimatableColorValue{initialValue=" + this.nl + '}';
    }

    /* renamed from: com.airbnb.lottie.model.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0008a {
        public static a d(JSONObject jSONObject, com.airbnb.lottie.e eVar) {
            n.a cZ = n.a(jSONObject, 1.0f, eVar, com.airbnb.lottie.model.a.nE).cZ();
            return new a(cZ.mV, (Integer) cZ.nl);
        }
    }
}
