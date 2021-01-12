package com.baidu.live.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes9.dex */
public class i implements aj<Float> {
    public static final i bqX = new i();

    private i() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.c.aj
    /* renamed from: i */
    public Float g(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(p.e(jsonReader) * f);
    }
}
