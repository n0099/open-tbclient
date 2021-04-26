package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class PrimitiveArraySerializer implements ObjectSerializer {
    public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i3 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i3 < iArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i3]);
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i3 < sArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i3]);
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i3 < jArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i3]);
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i3 < zArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i3]);
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i3 < fArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                float f2 = fArr[i3];
                if (Float.isNaN(f2)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Float.toString(f2));
                }
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            while (i3 < dArr.length) {
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                double d2 = dArr[i3];
                if (Double.isNaN(d2)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((CharSequence) Double.toString(d2));
                }
                i3++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
        } else {
            serializeWriter.writeString((char[]) obj);
        }
    }
}
