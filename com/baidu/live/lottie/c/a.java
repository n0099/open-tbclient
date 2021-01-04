package com.baidu.live.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    public static com.baidu.live.lottie.model.a.e a(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, eVar));
            }
            jsonReader.endArray();
            r.m(arrayList);
        } else {
            arrayList.add(new com.baidu.live.lottie.e.a(p.l(jsonReader, com.baidu.live.lottie.d.f.kA())));
        }
        return new com.baidu.live.lottie.model.a.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        jsonReader.beginObject();
        boolean z = false;
        com.baidu.live.lottie.model.a.b bVar = null;
        com.baidu.live.lottie.model.a.b bVar2 = null;
        com.baidu.live.lottie.model.a.e eVar2 = null;
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
                    if (nextName.equals("x")) {
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
            eVar.bc("Lottie doesn't support expressions.");
        }
        return eVar2 != null ? eVar2 : new com.baidu.live.lottie.model.a.i(bVar2, bVar);
    }
}
