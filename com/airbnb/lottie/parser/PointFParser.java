package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes7.dex */
public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = new PointFParser();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public PointF parse(JsonReader jsonReader, float f2) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        if (peek == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(jsonReader, f2);
        }
        if (peek == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(jsonReader, f2);
        }
        if (peek == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
