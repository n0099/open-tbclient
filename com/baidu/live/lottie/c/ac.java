package com.baidu.live.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes9.dex */
public class ac implements aj<com.baidu.live.lottie.e.d> {
    public static final ac brb = new ac();

    private ac() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.lottie.c.aj
    /* renamed from: u */
    public com.baidu.live.lottie.e.d g(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.baidu.live.lottie.e.d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
