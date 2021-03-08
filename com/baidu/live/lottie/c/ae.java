package com.baidu.live.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes9.dex */
class ae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.content.i w(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        int i = 1;
        String str = null;
        com.baidu.live.lottie.model.a.d dVar = null;
        boolean z = false;
        com.baidu.live.lottie.model.a.a aVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -396065730:
                    if (nextName.equals("fillEnabled")) {
                        c = 3;
                        break;
                    }
                    break;
                case 99:
                    if (nextName.equals("c")) {
                        c = 1;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    aVar = d.l(jsonReader, eVar);
                    break;
                case 2:
                    dVar = d.g(jsonReader, eVar);
                    break;
                case 3:
                    z = jsonReader.nextBoolean();
                    break;
                case 4:
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.baidu.live.lottie.model.content.i(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar);
    }
}
