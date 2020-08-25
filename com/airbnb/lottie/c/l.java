package com.airbnb.lottie.c;

import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class l implements aj<com.airbnb.lottie.model.content.c> {
    private int Gz;

    public l(int i) {
        this.Gz = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.c.aj
    /* renamed from: e */
    public com.airbnb.lottie.model.content.c b(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.Gz == -1) {
            this.Gz = arrayList.size() / 4;
        }
        float[] fArr = new float[this.Gz];
        int[] iArr = new int[this.Gz];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.Gz * 4; i3++) {
            int i4 = i3 / 4;
            double floatValue = arrayList.get(i3).floatValue();
            switch (i3 % 4) {
                case 0:
                    fArr[i4] = (float) floatValue;
                    break;
                case 1:
                    i2 = (int) (floatValue * 255.0d);
                    break;
                case 2:
                    i = (int) (floatValue * 255.0d);
                    break;
                case 3:
                    iArr[i4] = Color.argb(255, i2, i, (int) (floatValue * 255.0d));
                    break;
            }
        }
        com.airbnb.lottie.model.content.c cVar = new com.airbnb.lottie.model.content.c(fArr, iArr);
        a(cVar, arrayList);
        return cVar;
    }

    private void a(com.airbnb.lottie.model.content.c cVar, List<Float> list) {
        int i;
        int i2 = this.Gz * 4;
        if (list.size() > i2) {
            int size = (list.size() - i2) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i3 = 0;
            int i4 = i2;
            while (i4 < list.size()) {
                if (i4 % 2 == 0) {
                    dArr[i3] = list.get(i4).floatValue();
                    i = i3;
                } else {
                    dArr2[i3] = list.get(i4).floatValue();
                    i = i3 + 1;
                }
                i4++;
                i3 = i;
            }
            for (int i5 = 0; i5 < cVar.getSize(); i5++) {
                int i6 = cVar.getColors()[i5];
                cVar.getColors()[i5] = Color.argb(a(cVar.jM()[i5], dArr, dArr2), Color.red(i6), Color.green(i6), Color.blue(i6));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int a(double d, double[] dArr, double[] dArr2) {
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < dArr.length) {
                double d2 = dArr[i2 - 1];
                double d3 = dArr[i2];
                if (dArr[i2] < d) {
                    i = i2 + 1;
                } else {
                    return (int) (com.airbnb.lottie.d.e.b(dArr2[i2 - 1], dArr2[i2], (d - d2) / (d3 - d2)) * 255.0d);
                }
            } else {
                return (int) (dArr2[dArr2.length - 1] * 255.0d);
            }
        }
    }
}
