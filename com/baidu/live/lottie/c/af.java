package com.baidu.live.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class af {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.live.lottie.model.content.j x(JsonReader jsonReader, com.baidu.live.lottie.e eVar) throws IOException {
        String str = null;
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3371:
                    if (nextName.equals("it")) {
                        c = 1;
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
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.baidu.live.lottie.model.content.b m = g.m(jsonReader, eVar);
                        if (m != null) {
                            arrayList.add(m);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.baidu.live.lottie.model.content.j(str, arrayList);
    }
}
