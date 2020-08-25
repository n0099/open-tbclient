package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
/* loaded from: classes11.dex */
public class PropertyProcessableDeserializer implements ObjectDeserializer {
    public final Class<PropertyProcessable> type;

    public PropertyProcessableDeserializer(Class<PropertyProcessable> cls) {
        this.type = cls;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            return (T) defaultJSONParser.parse(this.type.newInstance(), obj);
        } catch (Exception e) {
            throw new JSONException("craete instance error");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
