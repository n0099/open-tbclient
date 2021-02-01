package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.model.content.Mask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Mask r(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        boolean z;
        boolean z2;
        jsonReader.beginObject();
        com.airbnb.lottie.model.a.d dVar2 = null;
        com.airbnb.lottie.model.a.h hVar = null;
        Mask.MaskMode maskMode = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals(Config.OS)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3357091:
                    if (nextName.equals(UbcStatConstant.KEY_CONTENT_EXT_MODE)) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    String nextString = jsonReader.nextString();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        case 115:
                            if (nextString.equals("s")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                    switch (z2) {
                        case false:
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            continue;
                        case true:
                            maskMode = Mask.MaskMode.MaskModeSubtract;
                            continue;
                        case true:
                            dVar.bc("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MaskModeIntersect;
                            continue;
                        default:
                            Log.w("LOTTIE", "Unknown mask mode " + nextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            continue;
                    }
                case true:
                    hVar = d.j(jsonReader, dVar);
                    break;
                case true:
                    dVar2 = d.g(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, hVar, dVar2);
    }
}
