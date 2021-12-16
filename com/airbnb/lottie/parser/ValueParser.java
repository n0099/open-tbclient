package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes9.dex */
public interface ValueParser<V> {
    V parse(JsonReader jsonReader, float f2) throws IOException;
}
