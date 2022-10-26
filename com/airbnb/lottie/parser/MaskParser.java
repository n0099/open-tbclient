package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class MaskParser {
    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            char c2 = 65535;
            if (hashCode != 111) {
                if (hashCode != 3588) {
                    if (hashCode != 104433) {
                        if (hashCode == 3357091 && nextName.equals("mode")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (nextName.equals("inv")) {
                            c = 3;
                        }
                        c = 65535;
                    }
                } else {
                    if (nextName.equals(Config.PLATFORM_TYPE)) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (nextName.equals("o")) {
                    c = 2;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            jsonReader.skipValue();
                        } else {
                            z = jsonReader.nextBoolean();
                        }
                    } else {
                        animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    }
                } else {
                    animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                }
            } else {
                String nextString = jsonReader.nextString();
                int hashCode2 = nextString.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && nextString.equals("s")) {
                                c2 = 1;
                            }
                        } else if (nextString.equals("n")) {
                            c2 = 2;
                        }
                    } else if (nextString.equals("i")) {
                        c2 = 3;
                    }
                } else if (nextString.equals("a")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                Logger.warning("Unknown mask mode " + nextName + ". Defaulting to Add.");
                                maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            } else {
                                lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            }
                        } else {
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                        }
                    } else {
                        maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                    }
                } else {
                    maskMode = Mask.MaskMode.MASK_MODE_ADD;
                }
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z);
    }
}
