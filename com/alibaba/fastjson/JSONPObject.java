package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class JSONPObject implements JSONSerializable {
    public static String SECURITY_PREFIX = "/**/";
    public String function;
    public final List<Object> parameters = new ArrayList();

    public JSONPObject() {
    }

    public void addParameter(Object obj) {
        this.parameters.add(obj);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String toJSONString() {
        return toString();
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(JSONSerializer jSONSerializer, Object obj, Type type, int i2) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i3 = SerializerFeature.BrowserSecure.mask;
        if ((i2 & i3) != 0 || serializeWriter.isEnabled(i3)) {
            serializeWriter.write(SECURITY_PREFIX);
        }
        serializeWriter.write(this.function);
        serializeWriter.write(40);
        for (int i4 = 0; i4 < this.parameters.size(); i4++) {
            if (i4 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(this.parameters.get(i4));
        }
        serializeWriter.write(41);
    }

    public JSONPObject(String str) {
        this.function = str;
    }
}
