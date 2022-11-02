package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class ShapeStrokeParser {
    public static JsonReader.Options NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "c", Config.DEVICE_WIDTH, "o", "lc", "lj", "ml", "hd", "d");
    public static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");

    public static ShapeStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (true) {
            int i = 100;
            if (jsonReader.hasNext()) {
                int i2 = 1;
                switch (jsonReader.selectName(NAMES)) {
                    case 0:
                        str = jsonReader.nextString();
                        break;
                    case 1:
                        animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                        break;
                    case 2:
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        break;
                    case 3:
                        animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                        break;
                    case 4:
                        lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                        break;
                    case 5:
                        lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                        break;
                    case 6:
                        f = (float) jsonReader.nextDouble();
                        break;
                    case 7:
                        z = jsonReader.nextBoolean();
                        break;
                    case 8:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            AnimatableFloatValue animatableFloatValue3 = null;
                            String str2 = null;
                            while (jsonReader.hasNext()) {
                                int selectName = jsonReader.selectName(DASH_PATTERN_NAMES);
                                if (selectName != 0) {
                                    if (selectName != i2) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                    } else {
                                        animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                    }
                                } else {
                                    str2 = jsonReader.nextString();
                                }
                            }
                            jsonReader.endObject();
                            int hashCode = str2.hashCode();
                            if (hashCode != i) {
                                if (hashCode != 103) {
                                    if (hashCode == 111 && str2.equals("o")) {
                                        c = 0;
                                    }
                                    c = 65535;
                                } else {
                                    if (str2.equals("g")) {
                                        c = 2;
                                    }
                                    c = 65535;
                                }
                            } else {
                                if (str2.equals("d")) {
                                    c = 1;
                                }
                                c = 65535;
                            }
                            if (c != 0) {
                                if (c == 1 || c == 2) {
                                    lottieComposition.setHasDashPattern(true);
                                    arrayList.add(animatableFloatValue3);
                                }
                            } else {
                                animatableFloatValue = animatableFloatValue3;
                            }
                            i = 100;
                            i2 = 1;
                        }
                        jsonReader.endArray();
                        if (arrayList.size() != 1) {
                            break;
                        } else {
                            arrayList.add(arrayList.get(0));
                            break;
                        }
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                if (animatableIntegerValue == null) {
                    animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
                }
                return new ShapeStroke(str, animatableFloatValue, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue2, lineCapType, lineJoinType, f, z);
            }
        }
    }
}
