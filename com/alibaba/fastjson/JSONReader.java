package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public class JSONReader implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONStreamContext context;
    public final DefaultJSONParser parser;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReader(Reader reader) {
        this(reader, new Feature[0]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Reader) objArr2[0], (Feature[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void endStructure() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            JSONStreamContext jSONStreamContext = this.context.parent;
            this.context = jSONStreamContext;
            if (jSONStreamContext == null) {
                return;
            }
            switch (jSONStreamContext.state) {
                case 1001:
                case 1003:
                    i2 = 1002;
                    break;
                case 1002:
                    i2 = 1003;
                    break;
                case 1004:
                    i2 = 1005;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                this.context.state = i2;
            }
        }
    }

    private void readAfter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int i2 = this.context.state;
            int i3 = 1002;
            switch (i2) {
                case 1001:
                case 1003:
                    break;
                case 1002:
                    i3 = 1003;
                    break;
                case 1004:
                    i3 = 1005;
                    break;
                case 1005:
                    i3 = -1;
                    break;
                default:
                    throw new JSONException("illegal state : " + i2);
            }
            if (i3 != -1) {
                this.context.state = i3;
            }
        }
    }

    private void readBefore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int i2 = this.context.state;
            switch (i2) {
                case 1001:
                case 1004:
                    return;
                case 1002:
                    this.parser.accept(17);
                    return;
                case 1003:
                    this.parser.accept(16, 18);
                    return;
                case 1005:
                    this.parser.accept(16);
                    return;
                default:
                    throw new JSONException("illegal state : " + i2);
            }
        }
    }

    private void startStructure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            switch (this.context.state) {
                case 1001:
                case 1004:
                    return;
                case 1002:
                    this.parser.accept(17);
                    return;
                case 1003:
                case 1005:
                    this.parser.accept(16);
                    return;
                default:
                    throw new JSONException("illegal state : " + this.context.state);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.parser.close();
        }
    }

    public void config(Feature feature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, feature, z) == null) {
            this.parser.config(feature, z);
        }
    }

    public void endArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.parser.accept(15);
            endStructure();
        }
    }

    public void endObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.parser.accept(13);
            endStructure();
        }
    }

    public Locale getLocal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parser.lexer.getLocale() : (Locale) invokeV.objValue;
    }

    public TimeZone getTimzeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parser.lexer.getTimeZone() : (TimeZone) invokeV.objValue;
    }

    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.context != null) {
                int i2 = this.parser.lexer.token();
                int i3 = this.context.state;
                switch (i3) {
                    case 1001:
                    case 1003:
                        return i2 != 13;
                    case 1002:
                    default:
                        throw new JSONException("illegal state : " + i3);
                    case 1004:
                    case 1005:
                        return i2 != 15;
                }
            }
            throw new JSONException("context is null");
        }
        return invokeV.booleanValue;
    }

    public int peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.parser.lexer.token() : invokeV.intValue;
    }

    public Integer readInteger() {
        InterceptResult invokeV;
        Object parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.context == null) {
                parse = this.parser.parse();
            } else {
                readBefore();
                parse = this.parser.parse();
                readAfter();
            }
            return TypeUtils.castToInt(parse);
        }
        return (Integer) invokeV.objValue;
    }

    public Long readLong() {
        InterceptResult invokeV;
        Object parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.context == null) {
                parse = this.parser.parse();
            } else {
                readBefore();
                parse = this.parser.parse();
                readAfter();
            }
            return TypeUtils.castToLong(parse);
        }
        return (Long) invokeV.objValue;
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, typeReference)) == null) ? (T) readObject(typeReference.getType()) : (T) invokeL.objValue;
    }

    public String readString() {
        InterceptResult invokeV;
        Object parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.context == null) {
                parse = this.parser.parse();
            } else {
                readBefore();
                JSONLexer jSONLexer = this.parser.lexer;
                if (this.context.state == 1001 && jSONLexer.token() == 18) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextToken();
                    parse = stringVal;
                } else {
                    parse = this.parser.parse();
                }
                readAfter();
            }
            return TypeUtils.castToString(parse);
        }
        return (String) invokeV.objValue;
    }

    public void setLocale(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, locale) == null) {
            this.parser.lexer.setLocale(locale);
        }
    }

    public void setTimzeZone(TimeZone timeZone) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, timeZone) == null) {
            this.parser.lexer.setTimeZone(timeZone);
        }
    }

    public void startArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.context == null) {
                this.context = new JSONStreamContext(null, 1004);
            } else {
                startStructure();
                this.context = new JSONStreamContext(this.context, 1004);
            }
            this.parser.accept(14);
        }
    }

    public void startObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.context == null) {
                this.context = new JSONStreamContext(null, 1001);
            } else {
                startStructure();
                this.context = new JSONStreamContext(this.context, 1001);
            }
            this.parser.accept(12, 18);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReader(Reader reader, Feature... featureArr) {
        this(new JSONReaderScanner(reader));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader, featureArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((JSONLexer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        for (Feature feature : featureArr) {
            config(feature, true);
        }
    }

    public <T> T readObject(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, type)) == null) {
            if (this.context == null) {
                return (T) this.parser.parseObject(type);
            }
            readBefore();
            T t = (T) this.parser.parseObject(type);
            readAfter();
            return t;
        }
        return (T) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONLexer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((DefaultJSONParser) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultJSONParser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parser = defaultJSONParser;
    }

    public <T> T readObject(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cls)) == null) {
            if (this.context == null) {
                return (T) this.parser.parseObject((Class<Object>) cls);
            }
            readBefore();
            T t = (T) this.parser.parseObject((Class<Object>) cls);
            readAfter();
            return t;
        }
        return (T) invokeL.objValue;
    }

    public void readObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            if (this.context == null) {
                this.parser.parseObject(obj);
                return;
            }
            readBefore();
            this.parser.parseObject(obj);
            readAfter();
        }
    }

    public Object readObject() {
        InterceptResult invokeV;
        Object parseKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.context == null) {
                return this.parser.parse();
            }
            readBefore();
            int i2 = this.context.state;
            if (i2 != 1001 && i2 != 1003) {
                parseKey = this.parser.parse();
            } else {
                parseKey = this.parser.parseKey();
            }
            readAfter();
            return parseKey;
        }
        return invokeV.objValue;
    }

    public Object readObject(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, map)) == null) {
            if (this.context == null) {
                return this.parser.parseObject(map);
            }
            readBefore();
            Object parseObject = this.parser.parseObject(map);
            readAfter();
            return parseObject;
        }
        return invokeL.objValue;
    }
}
