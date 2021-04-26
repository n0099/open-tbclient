package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class DoubleSerializer implements ObjectSerializer {
    public static final DoubleSerializer instance = new DoubleSerializer();
    public DecimalFormat decimalFormat;

    public DoubleSerializer() {
        this.decimalFormat = null;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue)) {
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat == null) {
                serializeWriter.writeDouble(doubleValue, true);
                return;
            } else {
                serializeWriter.write(decimalFormat.format(doubleValue));
                return;
            }
        }
        serializeWriter.writeNull();
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        this.decimalFormat = null;
        this.decimalFormat = decimalFormat;
    }

    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
    }
}
