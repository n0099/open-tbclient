package com.baidu.live.lottie.c;

import android.util.JsonReader;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
/* loaded from: classes10.dex */
class ag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.content.k y(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        com.baidu.live.lottie.model.a.h hVar = null;
        int i = 0;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3432:
                    if (nextName.equals(FunAdSdk.PLATFORM_KS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    i = jsonReader.nextInt();
                    break;
                case 2:
                    hVar = d.j(jsonReader, eVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.baidu.live.lottie.model.content.k(str, i, hVar);
    }
}
