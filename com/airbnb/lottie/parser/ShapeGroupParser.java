package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ShapeGroupParser {
    public static JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, ClarityUrlList.ClarityUrl.KEY_HD, AdvanceSetting.NETWORK_TYPE);

    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                            if (parse != null) {
                                arrayList.add(parse);
                            }
                        }
                        jsonReader.endArray();
                    }
                } else {
                    z = jsonReader.nextBoolean();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new ShapeGroup(str, arrayList, z);
    }
}
