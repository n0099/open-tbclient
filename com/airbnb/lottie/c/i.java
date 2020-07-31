package com.airbnb.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes20.dex */
public class i implements aj<Float> {
    public static final i FU = new i();

    private i() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.c.aj
    /* renamed from: d */
    public Float b(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(p.c(jsonReader) * f);
    }
}
