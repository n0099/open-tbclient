package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
/* loaded from: classes6.dex */
public class MaskParser {
    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c2;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            char c3 = 65535;
            if (hashCode == 111) {
                if (nextName.equals("o")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3588) {
                if (nextName.equals("pt")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && nextName.equals("mode")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (nextName.equals("inv")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                String nextString = jsonReader.nextString();
                int hashCode2 = nextString.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && nextString.equals("s")) {
                                c3 = 1;
                            }
                        } else if (nextString.equals("n")) {
                            c3 = 2;
                        }
                    } else if (nextString.equals("i")) {
                        c3 = 3;
                    }
                } else if (nextString.equals("a")) {
                    c3 = 0;
                }
                if (c3 == 0) {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else if (c3 == 1) {
                    maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                } else if (c3 == 2) {
                    maskMode = Mask.MaskMode.MASK_MODE_NONE;
                } else if (c3 != 3) {
                    Logger.warning("Unknown mask mode " + nextName + ". Defaulting to Add.");
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                } else {
                    lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                }
            } else if (c2 == 1) {
                animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
            } else if (c2 == 2) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z);
    }
}
