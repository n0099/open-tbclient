package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes.dex */
public class AtomicCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AtomicCodec instance = new AtomicCodec();

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(jSONArray);
        int i2 = 0;
        if (type == AtomicIntegerArray.class) {
            ?? r4 = (T) new AtomicIntegerArray(jSONArray.size());
            while (i2 < jSONArray.size()) {
                r4.set(i2, jSONArray.getInteger(i2).intValue());
                i2++;
            }
            return r4;
        }
        ?? r42 = (T) new AtomicLongArray(jSONArray.size());
        while (i2 < jSONArray.size()) {
            r42.set(i2, jSONArray.getLong(i2).longValue());
            i2++;
        }
        return r42;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof AtomicInteger) {
            serializeWriter.writeInt(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            serializeWriter.writeLong(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            serializeWriter.append((CharSequence) (((AtomicBoolean) obj).get() ? "true" : "false"));
        } else if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
        } else {
            int i3 = 0;
            if (obj instanceof AtomicIntegerArray) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                int length = atomicIntegerArray.length();
                serializeWriter.write(91);
                while (i3 < length) {
                    int i4 = atomicIntegerArray.get(i3);
                    if (i3 != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeInt(i4);
                    i3++;
                }
                serializeWriter.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            serializeWriter.write(91);
            while (i3 < length2) {
                long j = atomicLongArray.get(i3);
                if (i3 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(j);
                i3++;
            }
            serializeWriter.write(93);
        }
    }
}
