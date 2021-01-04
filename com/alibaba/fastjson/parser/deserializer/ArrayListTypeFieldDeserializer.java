package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final Type itemType;

    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        if (fieldInfo.fieldType instanceof ParameterizedType) {
            Type type = ((ParameterizedType) fieldInfo.fieldType).getActualTypeArguments()[0];
            if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length == 1) {
                    type = upperBounds[0];
                }
            }
            this.itemType = type;
            return;
        }
        this.itemType = Object.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (String) null);
            return;
        }
        Collection arrayList = new ArrayList();
        ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(context);
        if (obj == null) {
            map.put(this.fieldInfo.name, arrayList);
        } else {
            setValue(obj, arrayList);
        }
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i;
        Class cls2;
        int i2;
        ObjectDeserializer objectDeserializer;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer2 = this.deserializer;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (!(parameterizedType.getRawType() instanceof Class)) {
                    cls2 = null;
                } else {
                    cls2 = (Class) parameterizedType.getRawType();
                }
                if (cls2 != null) {
                    int length = cls2.getTypeParameters().length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (cls2.getTypeParameters()[i3].getName().equals(typeVariable.getName())) {
                            i2 = i3;
                            break;
                        }
                    }
                }
                i2 = -1;
                if (i2 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i2];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                        objectDeserializer2 = objectDeserializer;
                    }
                }
                objectDeserializer = objectDeserializer2;
                objectDeserializer2 = objectDeserializer;
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    if (!(parameterizedType3.getRawType() instanceof Class)) {
                        cls = null;
                    } else {
                        cls = (Class) parameterizedType3.getRawType();
                    }
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        for (int i4 = 0; i4 < length2; i4++) {
                            if (cls.getTypeParameters()[i4].getName().equals(typeVariable2.getName())) {
                                i = i4;
                                break;
                            }
                        }
                    }
                    i = -1;
                    if (i != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                        type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    }
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            if (objectDeserializer2 == null) {
                objectDeserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer2;
                this.itemFastMatchToken = this.deserializer.getFastMatchToken();
            }
            jSONLexer.nextToken(this.itemFastMatchToken);
            int i5 = 0;
            while (true) {
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                if (jSONLexer.token() != 15) {
                    collection.add(objectDeserializer2.deserialze(defaultJSONParser, type2, Integer.valueOf(i5)));
                    defaultJSONParser.checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(this.itemFastMatchToken);
                    }
                    i5++;
                } else {
                    jSONLexer.nextToken(16);
                    return;
                }
            }
        } else {
            if (objectDeserializer2 == null) {
                objectDeserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer2;
            }
            collection.add(objectDeserializer2.deserialze(defaultJSONParser, type2, 0));
            defaultJSONParser.checkListResolve(collection);
        }
    }
}
