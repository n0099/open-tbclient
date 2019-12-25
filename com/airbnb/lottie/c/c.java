package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes4.dex */
public class c {
    public static com.airbnb.lottie.model.a.l e(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        com.airbnb.lottie.model.a.e eVar2;
        com.airbnb.lottie.model.a.g gVar;
        com.airbnb.lottie.model.a.e eVar3;
        com.airbnb.lottie.model.a.e eVar4 = null;
        com.airbnb.lottie.model.a.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.a.g gVar2 = null;
        com.airbnb.lottie.model.a.b bVar = null;
        com.airbnb.lottie.model.a.d dVar = null;
        com.airbnb.lottie.model.a.b bVar2 = null;
        com.airbnb.lottie.model.a.b bVar3 = null;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals(Config.APP_VERSION_CODE)) {
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
                    com.airbnb.lottie.model.a.e eVar5 = eVar4;
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar5 = a.a(jsonReader, eVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    com.airbnb.lottie.model.a.g gVar3 = gVar2;
                    eVar3 = eVar5;
                    gVar = gVar3;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                case 1:
                    mVar = a.b(jsonReader, eVar);
                    gVar = gVar2;
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                case 2:
                    gVar = d.i(jsonReader, eVar);
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                case 3:
                    eVar.G("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.g(jsonReader, eVar);
                    gVar = gVar2;
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                case 6:
                    bVar2 = d.a(jsonReader, eVar, false);
                    gVar = gVar2;
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                case 7:
                    bVar3 = d.a(jsonReader, eVar, false);
                    gVar = gVar2;
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
                default:
                    jsonReader.skipValue();
                    gVar = gVar2;
                    eVar3 = eVar4;
                    continue;
                    eVar4 = eVar3;
                    gVar2 = gVar;
            }
            bVar = d.a(jsonReader, eVar, false);
            gVar = gVar2;
            eVar3 = eVar4;
            eVar4 = eVar3;
            gVar2 = gVar;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar4 == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar2 = new com.airbnb.lottie.model.a.e();
        } else {
            eVar2 = eVar4;
        }
        if (gVar2 == null) {
            gVar2 = new com.airbnb.lottie.model.a.g(new com.airbnb.lottie.e.d(1.0f, 1.0f));
        }
        return new com.airbnb.lottie.model.a.l(eVar2, mVar, gVar2, bVar, dVar == null ? new com.airbnb.lottie.model.a.d() : dVar, bVar2, bVar3);
    }
}
