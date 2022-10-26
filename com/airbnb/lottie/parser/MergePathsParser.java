package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
/* loaded from: classes.dex */
public class MergePathsParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, FunAdSdk.PLATFORM_MM, "hd");

    public static MergePaths parse(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        z = jsonReader.nextBoolean();
                    }
                } else {
                    mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
