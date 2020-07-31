package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes20.dex */
public class ac implements aj<com.airbnb.lottie.e.d> {
    public static final ac Gb = new ac();

    private ac() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.c.aj
    /* renamed from: l */
    public com.airbnb.lottie.e.d b(JsonReader jsonReader, float f) throws IOException {
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
        return new com.airbnb.lottie.e.d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
