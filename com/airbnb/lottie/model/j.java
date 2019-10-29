package com.airbnb.lottie.model;

import android.graphics.PointF;
import com.airbnb.lottie.model.a.m;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j implements m.a<PointF> {
    public static final j gq = new j();

    private j() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.model.a.m.a
    /* renamed from: c */
    public PointF b(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return com.airbnb.lottie.c.b.a((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return com.airbnb.lottie.c.b.a((JSONObject) obj, f);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}
