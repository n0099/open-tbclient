package com.airbnb.lottie.parser;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;
/* loaded from: classes.dex */
public class ShapeFillParser {
    public static final JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "c", "o", "fillEnabled", "r", "hd");

    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue;
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue2 = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
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
                                    z2 = jsonReader.nextBoolean();
                                }
                            } else {
                                i = jsonReader.nextInt();
                            }
                        } else {
                            z = jsonReader.nextBoolean();
                        }
                    } else {
                        animatableIntegerValue2 = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    }
                } else {
                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        if (animatableIntegerValue2 == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        } else {
            animatableIntegerValue = animatableIntegerValue2;
        }
        if (i == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new ShapeFill(str, z, fillType, animatableColorValue, animatableIntegerValue, z2);
    }
}
