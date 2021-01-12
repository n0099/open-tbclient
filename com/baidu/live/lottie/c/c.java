package com.baidu.live.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes9.dex */
public class c {
    public static com.baidu.live.lottie.model.a.l e(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        com.baidu.live.lottie.model.a.e eVar2;
        com.baidu.live.lottie.model.a.g gVar;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.baidu.live.lottie.model.a.b bVar = null;
        com.baidu.live.lottie.model.a.b bVar2 = null;
        com.baidu.live.lottie.model.a.d dVar = null;
        com.baidu.live.lottie.model.a.b bVar3 = null;
        com.baidu.live.lottie.model.a.g gVar2 = null;
        com.baidu.live.lottie.model.a.m<PointF, PointF> mVar = null;
        com.baidu.live.lottie.model.a.e eVar3 = null;
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
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 5;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c = 1;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 4;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3242:
                    if (nextName.equals("eo")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3656:
                    if (nextName.equals("rz")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3676:
                    if (nextName.equals("so")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar3 = a.a(jsonReader, eVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 1:
                    mVar = a.b(jsonReader, eVar);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 2:
                    gVar = d.i(jsonReader, eVar);
                    continue;
                    gVar2 = gVar;
                case 3:
                    eVar.bc("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.g(jsonReader, eVar);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 6:
                    bVar2 = d.a(jsonReader, eVar, false);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 7:
                    bVar = d.a(jsonReader, eVar, false);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                default:
                    jsonReader.skipValue();
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
            }
            bVar3 = d.a(jsonReader, eVar, false);
            gVar = gVar2;
            gVar2 = gVar;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar3 == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar2 = new com.baidu.live.lottie.model.a.e();
        } else {
            eVar2 = eVar3;
        }
        if (gVar2 == null) {
            gVar2 = new com.baidu.live.lottie.model.a.g(new com.baidu.live.lottie.e.d(1.0f, 1.0f));
        }
        return new com.baidu.live.lottie.model.a.l(eVar2, mVar, gVar2, bVar3, dVar == null ? new com.baidu.live.lottie.model.a.d() : dVar, bVar2, bVar);
    }
}
