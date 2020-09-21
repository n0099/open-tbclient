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
/* loaded from: classes10.dex */
public class AtomicCodec implements ObjectDeserializer, ObjectSerializer {
    public static final AtomicCodec instance = new AtomicCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2 = 0;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof AtomicInteger) {
            serializeWriter.writeInt(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            serializeWriter.writeLong(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            serializeWriter.append((CharSequence) (((AtomicBoolean) obj).get() ? "true" : "false"));
        } else if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
        } else if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            serializeWriter.write(91);
            while (i2 < length) {
                int i3 = atomicIntegerArray.get(i2);
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(i3);
                i2++;
            }
            serializeWriter.write(93);
        } else {
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            serializeWriter.write(91);
            while (i2 < length2) {
                long j = atomicLongArray.get(i2);
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(j);
                i2++;
            }
            serializeWriter.write(93);
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        int i = 0;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(jSONArray);
        if (type == AtomicIntegerArray.class) {
            ?? r1 = (T) new AtomicIntegerArray(jSONArray.size());
            while (i < jSONArray.size()) {
                r1.set(i, jSONArray.getInteger(i).intValue());
                i++;
            }
            return r1;
        }
        ?? r12 = (T) new AtomicLongArray(jSONArray.size());
        while (i < jSONArray.size()) {
            r12.set(i, jSONArray.getLong(i).longValue());
            i++;
        }
        return r12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }
}
