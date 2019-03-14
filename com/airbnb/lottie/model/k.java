package com.airbnb.lottie.model;

import com.airbnb.lottie.model.a.m;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k {
    private final float qv;
    private final float qw;

    public k(float f, float f2) {
        this.qv = f;
        this.qw = f2;
    }

    public k() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.qv;
    }

    public float getScaleY() {
        return this.qw;
    }

    public String toString() {
        return getScaleX() + Config.EVENT_HEAT_X + getScaleY();
    }

    /* loaded from: classes2.dex */
    public static class a implements m.a<k> {
        public static final a qx = new a();

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.model.a.m.a
        /* renamed from: d */
        public k b(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            return new k((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 100.0f) * f);
        }
    }
}
