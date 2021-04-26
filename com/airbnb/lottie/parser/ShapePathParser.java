package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
/* loaded from: classes.dex */
public class ShapePathParser {
    public static JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "ind", FunAdSdk.PLATFORM_KS, "hd");

    public static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int i2 = 0;
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                i2 = jsonReader.nextInt();
            } else if (selectName == 2) {
                animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new ShapePath(str, i2, animatableShapeValue, z);
    }
}
