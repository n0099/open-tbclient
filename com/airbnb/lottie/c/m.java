package com.airbnb.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.model.content.GradientType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.airbnb.lottie.model.content.d o(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c;
        boolean z;
        Path.FillType fillType = null;
        com.airbnb.lottie.model.a.f fVar = null;
        com.airbnb.lottie.model.a.f fVar2 = null;
        GradientType gradientType = null;
        com.airbnb.lottie.model.a.d dVar2 = null;
        com.airbnb.lottie.model.a.c cVar = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 103:
                    if (nextName.equals(IXAdRequestInfo.GPS)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginObject();
                    int i = -1;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        switch (nextName2.hashCode()) {
                            case 107:
                                if (nextName2.equals("k")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 112:
                                if (nextName2.equals("p")) {
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
                                i = jsonReader.nextInt();
                                break;
                            case true:
                                cVar = d.a(jsonReader, dVar, i);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    dVar2 = d.g(jsonReader, dVar);
                    break;
                case 3:
                    if (jsonReader.nextInt() != 1) {
                        gradientType = GradientType.Radial;
                        break;
                    } else {
                        gradientType = GradientType.Linear;
                        break;
                    }
                case 4:
                    fVar2 = d.h(jsonReader, dVar);
                    break;
                case 5:
                    fVar = d.h(jsonReader, dVar);
                    break;
                case 6:
                    if (jsonReader.nextInt() != 1) {
                        fillType = Path.FillType.EVEN_ODD;
                        break;
                    } else {
                        fillType = Path.FillType.WINDING;
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.d(str, gradientType, fillType, cVar, dVar2, fVar2, fVar, null, null);
    }
}
