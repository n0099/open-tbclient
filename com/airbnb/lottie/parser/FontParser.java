package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import java.io.IOException;
/* loaded from: classes.dex */
public class FontParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of("fFamily", AiBotChatDispatcher.AI_SINGLE_FORUM_NAME, "fStyle", "ascent");

    public static Font parse(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            f = (float) jsonReader.nextDouble();
                        }
                    } else {
                        str3 = jsonReader.nextString();
                    }
                } else {
                    str2 = jsonReader.nextString();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        return new Font(str, str2, str3, f);
    }
}
