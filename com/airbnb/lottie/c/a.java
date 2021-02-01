package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static com.airbnb.lottie.model.a.e a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.m(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.e.a(p.l(jsonReader, com.airbnb.lottie.d.f.kz())));
        }
        return new com.airbnb.lottie.model.a.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        jsonReader.beginObject();
        boolean z = false;
        com.airbnb.lottie.model.a.b bVar = null;
        com.airbnb.lottie.model.a.b bVar2 = null;
        com.airbnb.lottie.model.a.e eVar = null;
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
                case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                    if (nextName.equals("y")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar = a(jsonReader, dVar);
                    break;
                case 1:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar2 = d.f(jsonReader, dVar);
                        break;
                    }
                case 2:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar = d.f(jsonReader, dVar);
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.bc("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.airbnb.lottie.model.a.i(bVar2, bVar);
    }
}
