package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes10.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.a.b.h s(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.a.b.h(eVar, q.a(jsonReader, eVar, com.airbnb.lottie.d.f.lb(), x.GY, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
