package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a {
    public static com.airbnb.lottie.model.a.e a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, eVar));
            }
            jsonReader.endArray();
            r.g(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.e.a(p.g(jsonReader, com.airbnb.lottie.d.f.dK())));
        }
        return new com.airbnb.lottie.model.a.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        com.airbnb.lottie.model.a.b bVar = null;
        jsonReader.beginObject();
        boolean z = false;
        com.airbnb.lottie.model.a.b bVar2 = null;
        com.airbnb.lottie.model.a.e eVar2 = null;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals("k")) {
                        c = 0;
                        break;
                    }
                    break;
                case 120:
                    if (nextName.equals(Config.EVENT_HEAT_X)) {
                        c = 1;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar2 = a(jsonReader, eVar);
                    break;
                case 1:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar2 = d.f(jsonReader, eVar);
                        break;
                    }
                case 2:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar = d.f(jsonReader, eVar);
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            eVar.G("Lottie doesn't support expressions.");
        }
        return eVar2 != null ? eVar2 : new com.airbnb.lottie.model.a.i(bVar2, bVar);
    }
}
