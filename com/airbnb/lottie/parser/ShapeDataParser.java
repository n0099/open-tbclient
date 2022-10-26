package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class ShapeDataParser implements ValueParser {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    public static final JsonReader.Options NAMES = JsonReader.Options.of("c", "v", "i", "o");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            list3 = JsonUtils.jsonToPoints(jsonReader, f);
                        }
                    } else {
                        list2 = JsonUtils.jsonToPoints(jsonReader, f);
                    }
                } else {
                    list = JsonUtils.jsonToPoints(jsonReader, f);
                }
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new ShapeData(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = (PointF) list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = (PointF) list.get(i);
                int i2 = i - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints((PointF) list.get(i2), (PointF) list3.get(i2)), MiscUtils.addPoints(pointF2, (PointF) list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = (PointF) list.get(0);
                int i3 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints((PointF) list.get(i3), (PointF) list3.get(i3)), MiscUtils.addPoints(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
