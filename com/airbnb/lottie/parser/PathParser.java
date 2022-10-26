package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class PathParser implements ValueParser {
    public static final PathParser INSTANCE = new PathParser();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.parser.ValueParser
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.jsonToPoint(jsonReader, f);
    }
}
