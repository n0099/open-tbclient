package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ObjectDeserializer deserializer;
    public int itemFastMatchToken;
    public final Type itemType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parserConfig, cls, fieldInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Class) objArr2[0], (FieldInfo) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Type type = fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
            this.itemType = type2;
            return;
        }
        this.itemType = Object.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 14;
        }
        return invokeV.intValue;
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i2;
        Type intern;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, defaultJSONParser, type, collection) != null) {
            return;
        }
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        int i4 = 0;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i3 = 0;
                    while (i3 < length) {
                        if (cls.getTypeParameters()[i3].getName().equals(typeVariable.getName())) {
                            break;
                        }
                        i3++;
                    }
                }
                i3 = -1;
                if (i3 != -1) {
                    intern = parameterizedType.getActualTypeArguments()[i3];
                    if (!intern.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.getConfig().getDeserializer(intern);
                    }
                    type2 = intern;
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1 && (actualTypeArguments[0] instanceof TypeVariable)) {
                    TypeVariable typeVariable2 = (TypeVariable) actualTypeArguments[0];
                    ParameterizedType parameterizedType3 = (ParameterizedType) type;
                    cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                    if (cls != null) {
                        int length2 = cls.getTypeParameters().length;
                        i2 = 0;
                        while (i2 < length2) {
                            if (cls.getTypeParameters()[i2].getName().equals(typeVariable2.getName())) {
                                break;
                            }
                            i2++;
                        }
                    }
                    i2 = -1;
                    if (i2 != -1) {
                        actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i2];
                        intern = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                        type2 = intern;
                    }
                }
            }
        } else if ((type2 instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            int i5 = 0;
            while (true) {
                if (i5 >= length3) {
                    break;
                }
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i5];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length == 1) {
                        type2 = bounds[0];
                    }
                } else {
                    i5++;
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            if (objectDeserializer == null) {
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer;
                this.itemFastMatchToken = objectDeserializer.getFastMatchToken();
            }
            ObjectDeserializer objectDeserializer2 = objectDeserializer;
            jSONLexer.nextToken(this.itemFastMatchToken);
            while (true) {
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                if (jSONLexer.token() == 15) {
                    jSONLexer.nextToken(16);
                    return;
                }
                collection.add(objectDeserializer2.deserialze(defaultJSONParser, type2, Integer.valueOf(i4)));
                defaultJSONParser.checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(this.itemFastMatchToken);
                }
                i4++;
            }
        } else {
            if (objectDeserializer == null) {
                objectDeserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = objectDeserializer;
            }
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
            defaultJSONParser.checkListResolve(collection);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, defaultJSONParser, obj, type, map) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = jSONLexer.token();
            if (i2 == 8 || (i2 == 4 && jSONLexer.stringVal().length() == 0)) {
                if (obj == null) {
                    map.put(this.fieldInfo.name, null);
                    return;
                } else {
                    setValue(obj, (String) null);
                    return;
                }
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
    }
}
