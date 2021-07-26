package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class AwtCodec implements ObjectSerializer, ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public static final AwtCodec instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1373574340, "Lcom/alibaba/fastjson/serializer/AwtCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1373574340, "Lcom/alibaba/fastjson/serializer/AwtCodec;");
                return;
            }
        }
        instance = new AwtCodec();
    }

    public AwtCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private Object parseRef(DefaultJSONParser defaultJSONParser, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, defaultJSONParser, obj)) == null) {
            JSONLexer lexer = defaultJSONParser.getLexer();
            lexer.nextTokenWithColon(4);
            String stringVal = lexer.stringVal();
            defaultJSONParser.setContext(defaultJSONParser.getContext(), obj);
            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(defaultJSONParser.getContext(), stringVal));
            defaultJSONParser.popContext();
            defaultJSONParser.setResolveStatus(1);
            lexer.nextToken(13);
            defaultJSONParser.accept(13);
            return null;
        }
        return invokeLL.objValue;
    }

    public static boolean support(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class : invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            if (jSONLexer.token() == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
                throw new JSONException("syntax error");
            } else {
                jSONLexer.nextToken();
                if (type == Point.class) {
                    t = (T) parsePoint(defaultJSONParser, obj);
                } else if (type == Rectangle.class) {
                    t = (T) parseRectangle(defaultJSONParser);
                } else if (type == Color.class) {
                    t = (T) parseColor(defaultJSONParser);
                } else if (type == Font.class) {
                    t = (T) parseFont(defaultJSONParser);
                } else {
                    throw new JSONException("not support awt class : " + type);
                }
                ParseContext context = defaultJSONParser.getContext();
                defaultJSONParser.setContext(t, obj);
                defaultJSONParser.setContext(context);
                return t;
            }
        }
        return (T) invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    public Color parseColor(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (jSONLexer.token() != 13) {
                if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextTokenWithColon(2);
                    if (jSONLexer.token() == 2) {
                        int intValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                        if (stringVal.equalsIgnoreCase(r.f7788a)) {
                            i2 = intValue;
                        } else if (stringVal.equalsIgnoreCase("g")) {
                            i3 = intValue;
                        } else if (stringVal.equalsIgnoreCase("b")) {
                            i4 = intValue;
                        } else if (!stringVal.equalsIgnoreCase("alpha")) {
                            throw new JSONException("syntax error, " + stringVal);
                        } else {
                            i5 = intValue;
                        }
                        if (jSONLexer.token() == 16) {
                            jSONLexer.nextToken(4);
                        }
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            jSONLexer.nextToken();
            return new Color(i2, i3, i4, i5);
        }
        return (Color) invokeL.objValue;
    }

    public Font parseFont(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = 0;
            String str = null;
            int i3 = 0;
            while (jSONLexer.token() != 13) {
                if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextTokenWithColon(2);
                    if (stringVal.equalsIgnoreCase("name")) {
                        if (jSONLexer.token() == 4) {
                            str = jSONLexer.stringVal();
                            jSONLexer.nextToken();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (stringVal.equalsIgnoreCase("style")) {
                        if (jSONLexer.token() == 2) {
                            i2 = jSONLexer.intValue();
                            jSONLexer.nextToken();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else if (stringVal.equalsIgnoreCase("size")) {
                        if (jSONLexer.token() == 2) {
                            i3 = jSONLexer.intValue();
                            jSONLexer.nextToken();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    } else {
                        throw new JSONException("syntax error, " + stringVal);
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            jSONLexer.nextToken();
            return new Font(str, i2, i3);
        }
        return (Font) invokeL.objValue;
    }

    public Point parsePoint(DefaultJSONParser defaultJSONParser, Object obj) {
        InterceptResult invokeLL;
        int floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, defaultJSONParser, obj)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = 0;
            int i3 = 0;
            while (jSONLexer.token() != 13) {
                if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    if (JSON.DEFAULT_TYPE_KEY.equals(stringVal)) {
                        defaultJSONParser.acceptType("java.awt.Point");
                    } else if ("$ref".equals(stringVal)) {
                        return (Point) parseRef(defaultJSONParser, obj);
                    } else {
                        jSONLexer.nextTokenWithColon(2);
                        int i4 = jSONLexer.token();
                        if (i4 == 2) {
                            floatValue = jSONLexer.intValue();
                            jSONLexer.nextToken();
                        } else if (i4 == 3) {
                            floatValue = (int) jSONLexer.floatValue();
                            jSONLexer.nextToken();
                        } else {
                            throw new JSONException("syntax error : " + jSONLexer.tokenName());
                        }
                        if (stringVal.equalsIgnoreCase("x")) {
                            i2 = floatValue;
                        } else if (!stringVal.equalsIgnoreCase("y")) {
                            throw new JSONException("syntax error, " + stringVal);
                        } else {
                            i3 = floatValue;
                        }
                        if (jSONLexer.token() == 16) {
                            jSONLexer.nextToken(4);
                        }
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            jSONLexer.nextToken();
            return new Point(i2, i3);
        }
        return (Point) invokeLL.objValue;
    }

    public Rectangle parseRectangle(DefaultJSONParser defaultJSONParser) {
        InterceptResult invokeL;
        int floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, defaultJSONParser)) == null) {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (jSONLexer.token() != 13) {
                if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextTokenWithColon(2);
                    int i6 = jSONLexer.token();
                    if (i6 == 2) {
                        floatValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else if (i6 == 3) {
                        floatValue = (int) jSONLexer.floatValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                    if (stringVal.equalsIgnoreCase("x")) {
                        i2 = floatValue;
                    } else if (stringVal.equalsIgnoreCase("y")) {
                        i3 = floatValue;
                    } else if (stringVal.equalsIgnoreCase("width")) {
                        i4 = floatValue;
                    } else if (!stringVal.equalsIgnoreCase("height")) {
                        throw new JSONException("syntax error, " + stringVal);
                    } else {
                        i5 = floatValue;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            jSONLexer.nextToken();
            return new Rectangle(i2, i3, i4, i5);
        }
        return (Rectangle) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{jSONSerializer, obj, obj2, type, Integer.valueOf(i2)}) == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (obj == null) {
                serializeWriter.writeNull();
                return;
            }
            if (obj instanceof Point) {
                Point point = (Point) obj;
                serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", point.x);
                serializeWriter.writeFieldValue(',', "y", point.y);
            } else if (obj instanceof Font) {
                Font font = (Font) obj;
                serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", font.getName());
                serializeWriter.writeFieldValue(',', "style", font.getStyle());
                serializeWriter.writeFieldValue(',', "size", font.getSize());
            } else if (obj instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) obj;
                serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", rectangle.x);
                serializeWriter.writeFieldValue(',', "y", rectangle.y);
                serializeWriter.writeFieldValue(',', "width", rectangle.width);
                serializeWriter.writeFieldValue(',', "height", rectangle.height);
            } else if (obj instanceof Color) {
                Color color = (Color) obj;
                serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), r.f7788a, color.getRed());
                serializeWriter.writeFieldValue(',', "g", color.getGreen());
                serializeWriter.writeFieldValue(',', "b", color.getBlue());
                if (color.getAlpha() > 0) {
                    serializeWriter.writeFieldValue(',', "alpha", color.getAlpha());
                }
            } else {
                throw new JSONException("not support awt class : " + obj.getClass().getName());
            }
            serializeWriter.write(125);
        }
    }

    public char writeClassName(SerializeWriter serializeWriter, Class<?> cls, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{serializeWriter, cls, Character.valueOf(c2)})) == null) {
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                serializeWriter.writeString(cls.getName());
                return ',';
            }
            return c2;
        }
        return invokeCommon.charValue;
    }
}
