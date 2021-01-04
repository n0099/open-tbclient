package com.baidu.live.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b {
    public static com.baidu.live.lottie.model.a.k c(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        jsonReader.beginObject();
        com.baidu.live.lottie.model.a.k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    kVar = d(jsonReader, eVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (kVar == null) {
            return new com.baidu.live.lottie.model.a.k(null, null, null, null);
        }
        return kVar;
    }

    private static com.baidu.live.lottie.model.a.k d(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        jsonReader.beginObject();
        com.baidu.live.lottie.model.a.b bVar = null;
        com.baidu.live.lottie.model.a.b bVar2 = null;
        com.baidu.live.lottie.model.a.a aVar = null;
        com.baidu.live.lottie.model.a.a aVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar2 = d.l(jsonReader, eVar);
                    break;
                case 1:
                    aVar = d.l(jsonReader, eVar);
                    break;
                case 2:
                    bVar2 = d.f(jsonReader, eVar);
                    break;
                case 3:
                    bVar = d.f(jsonReader, eVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.baidu.live.lottie.model.a.k(aVar2, aVar, bVar2, bVar);
    }
}
