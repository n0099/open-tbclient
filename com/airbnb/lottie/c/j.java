package com.airbnb.lottie.c;

import android.util.JsonReader;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.d n(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3173:
                    if (nextName.equals("ch")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals(TiebaInitialize.LogFields.SIZE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 109780401:
                    if (nextName.equals("style")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c = jsonReader.nextString().charAt(0);
                    break;
                case 1:
                    d2 = jsonReader.nextDouble();
                    break;
                case 2:
                    d = jsonReader.nextDouble();
                    break;
                case 3:
                    str2 = jsonReader.nextString();
                    break;
                case 4:
                    str = jsonReader.nextString();
                    break;
                case 5:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.airbnb.lottie.model.content.j) g.m(jsonReader, dVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.airbnb.lottie.model.d(arrayList, c, d2, d, str2, str);
    }
}
