package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes4.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f2));
    }
}
