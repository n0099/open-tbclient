package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes4.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.a.b.h s(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.a.b.h(dVar, q.a(jsonReader, dVar, com.airbnb.lottie.d.f.kz(), x.Hw, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
