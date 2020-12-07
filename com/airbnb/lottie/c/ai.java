package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes7.dex */
class ai {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath A(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        com.airbnb.lottie.model.a.b bVar = null;
        com.airbnb.lottie.model.a.b bVar2 = null;
        com.airbnb.lottie.model.a.b bVar3 = null;
        ShapeTrimPath.Type type = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109:
                    if (nextName.equals("m")) {
                        c = 4;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bVar3 = d.a(jsonReader, eVar, false);
                    break;
                case 1:
                    bVar2 = d.a(jsonReader, eVar, false);
                    break;
                case 2:
                    bVar = d.a(jsonReader, eVar, false);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeTrimPath(str, type, bVar3, bVar2, bVar);
    }
}
