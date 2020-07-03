package com.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<com.airbnb.lottie.e.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.e eVar, float f, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            eVar.aX("Lottie doesn't support expressions.");
        } else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 107:
                        if (nextName.equals("k")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                            jsonReader.beginArray();
                            if (jsonReader.peek() == JsonToken.NUMBER) {
                                arrayList.add(q.a(jsonReader, eVar, f, ajVar, false));
                            } else {
                                while (jsonReader.hasNext()) {
                                    arrayList.add(q.a(jsonReader, eVar, f, ajVar, true));
                                }
                            }
                            jsonReader.endArray();
                            break;
                        } else {
                            arrayList.add(q.a(jsonReader, eVar, f, ajVar, false));
                            break;
                        }
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            l(arrayList);
        }
        return arrayList;
    }

    public static void l(List<? extends com.airbnb.lottie.e.a<?>> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            list.get(i2).Gs = Float.valueOf(list.get(i2 + 1).Ao);
            i = i2 + 1;
        }
        com.airbnb.lottie.e.a<?> aVar = list.get(size - 1);
        if (aVar.Gp == 0) {
            list.remove(aVar);
        }
    }
}
