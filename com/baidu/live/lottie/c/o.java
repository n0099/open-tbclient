package com.baidu.live.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes9.dex */
public class o implements aj<Integer> {
    public static final o bwb = new o();

    private o() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.c.aj
    /* renamed from: f */
    public Integer g(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(p.e(jsonReader) * f));
    }
}
