package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baidu.android.imsdk.internal.Constants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class ByteBufferCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ByteBufferCodec instance = new ByteBufferCodec();

    /* loaded from: classes.dex */
    public static class ByteBufferBean {
        public byte[] array;
        public int limit;
        public int position;

        public ByteBuffer byteBuffer() {
            ByteBuffer wrap = ByteBuffer.wrap(this.array);
            wrap.limit(this.limit);
            wrap.position(this.position);
            return wrap;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) ((ByteBufferBean) defaultJSONParser.parseObject((Class<Object>) ByteBufferBean.class)).byteBuffer();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] array = byteBuffer.array();
        SerializeWriter serializeWriter = jSONSerializer.out;
        serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
        serializeWriter.writeFieldName("array");
        serializeWriter.writeByteArray(array);
        serializeWriter.writeFieldValue(',', Constants.EXTRA_CONFIG_LIMIT, byteBuffer.limit());
        serializeWriter.writeFieldValue(',', "position", byteBuffer.position());
        serializeWriter.write(125);
    }
}
