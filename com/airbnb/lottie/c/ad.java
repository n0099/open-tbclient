package com.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes20.dex */
public class ad implements aj<com.airbnb.lottie.model.content.h> {
    public static final ad Gc = new ad();

    private ad() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.c.aj
    /* renamed from: m */
    public com.airbnb.lottie.model.content.h b(JsonReader jsonReader, float f) throws IOException {
        List<PointF> f2;
        List<PointF> list;
        List<PointF> list2;
        boolean z;
        List<PointF> list3 = null;
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list4 = null;
        List<PointF> list5 = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c = 0;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
                        c = 2;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 118:
                    if (nextName.equals("v")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    list = list4;
                    list2 = list5;
                    z = jsonReader.nextBoolean();
                    f2 = list3;
                    break;
                case 1:
                    list = list4;
                    list2 = p.f(jsonReader, f);
                    z = z2;
                    f2 = list3;
                    break;
                case 2:
                    list = p.f(jsonReader, f);
                    list2 = list5;
                    z = z2;
                    f2 = list3;
                    break;
                case 3:
                    f2 = p.f(jsonReader, f);
                    list = list4;
                    list2 = list5;
                    z = z2;
                    break;
                default:
                    f2 = list3;
                    list = list4;
                    list2 = list5;
                    z = z2;
                    break;
            }
            list3 = f2;
            list4 = list;
            list5 = list2;
            z2 = z;
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list5 == null || list4 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list5.isEmpty()) {
            return new com.airbnb.lottie.model.content.h(new PointF(), false, Collections.emptyList());
        }
        int size = list5.size();
        PointF pointF = list5.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = list5.get(i);
            arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.d.e.a(list5.get(i - 1), list3.get(i - 1)), com.airbnb.lottie.d.e.a(pointF2, list4.get(i)), pointF2));
        }
        if (z2) {
            PointF pointF3 = list5.get(0);
            arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.d.e.a(list5.get(size - 1), list3.get(size - 1)), com.airbnb.lottie.d.e.a(pointF3, list4.get(0)), pointF3));
        }
        return new com.airbnb.lottie.model.content.h(pointF, z2, arrayList);
    }
}
