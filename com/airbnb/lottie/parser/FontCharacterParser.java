package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FontCharacterParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("ch", "size", "w", "style", "fFamily", "data");
    public static final JsonReader.Options DATA_NAMES = JsonReader.Options.of("shapes");

    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                if (selectName != 5) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    jsonReader.beginObject();
                                    while (jsonReader.hasNext()) {
                                        if (jsonReader.selectName(DATA_NAMES) != 0) {
                                            jsonReader.skipName();
                                            jsonReader.skipValue();
                                        } else {
                                            jsonReader.beginArray();
                                            while (jsonReader.hasNext()) {
                                                arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                                            }
                                            jsonReader.endArray();
                                        }
                                    }
                                    jsonReader.endObject();
                                }
                            } else {
                                str2 = jsonReader.nextString();
                            }
                        } else {
                            str = jsonReader.nextString();
                        }
                    } else {
                        d2 = jsonReader.nextDouble();
                    }
                } else {
                    d = jsonReader.nextDouble();
                }
            } else {
                c = jsonReader.nextString().charAt(0);
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c, d, d2, str, str2);
    }
}
