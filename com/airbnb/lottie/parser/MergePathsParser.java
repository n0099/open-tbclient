package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes7.dex */
public class MergePathsParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "mm", "hd");

    public static MergePaths parse(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (selectName != 2) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}
