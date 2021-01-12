package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.d.b;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;
/* loaded from: classes3.dex */
public class AwtCodec implements ObjectDeserializer, ObjectSerializer {
    public static final AwtCodec instance = new AwtCodec();

    public static boolean support(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), Config.EVENT_HEAT_X, point.x);
            serializeWriter.writeFieldValue(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", font.getName());
            serializeWriter.writeFieldValue(',', "style", font.getStyle());
            serializeWriter.writeFieldValue(',', TiebaInitialize.LogFields.SIZE, font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), Config.EVENT_HEAT_X, rectangle.x);
            serializeWriter.writeFieldValue(',', "y", rectangle.y);
            serializeWriter.writeFieldValue(',', "width", rectangle.width);
            serializeWriter.writeFieldValue(',', "height", rectangle.height);
        } else if (obj instanceof Color) {
            Color color = (Color) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), "r", color.getRed());
            serializeWriter.writeFieldValue(',', IXAdRequestInfo.GPS, color.getGreen());
            serializeWriter.writeFieldValue(',', b.f4043a, color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.writeFieldValue(',', "alpha", color.getAlpha());
            }
        } else {
            throw new JSONException("not support awt class : " + obj.getClass().getName());
        }
        serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN);
    }

    protected char writeClassName(SerializeWriter serializeWriter, Class<?> cls, char c) {
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            serializeWriter.write(Constants.METHOD_IM_FRIEND_GROUP_QUERY);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            serializeWriter.writeString(cls.getName());
            return ',';
        }
        return c;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
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

    protected Font parseFont(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        String str = null;
        int i = 0;
        int i2 = 0;
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
                        i = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (stringVal.equalsIgnoreCase(TiebaInitialize.LogFields.SIZE)) {
                    if (jSONLexer.token() == 2) {
                        i2 = jSONLexer.intValue();
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
        return new Font(str, i, i2);
    }

    protected Color parseColor(DefaultJSONParser defaultJSONParser) {
        int i;
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
                    if (stringVal.equalsIgnoreCase("r")) {
                        i = i3;
                        i5 = intValue;
                    } else if (stringVal.equalsIgnoreCase(IXAdRequestInfo.GPS)) {
                        i = i3;
                        i4 = intValue;
                    } else if (stringVal.equalsIgnoreCase(b.f4043a)) {
                        i = intValue;
                    } else if (!stringVal.equalsIgnoreCase("alpha")) {
                        throw new JSONException("syntax error, " + stringVal);
                    } else {
                        i2 = intValue;
                        i = i3;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i3 = i;
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Color(i5, i4, i3, i2);
    }

    protected Rectangle parseRectangle(DefaultJSONParser defaultJSONParser) {
        int floatValue;
        int i;
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
                    int intValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                    floatValue = intValue;
                } else if (i6 == 3) {
                    jSONLexer.nextToken();
                    floatValue = (int) jSONLexer.floatValue();
                } else {
                    throw new JSONException("syntax error");
                }
                if (stringVal.equalsIgnoreCase(Config.EVENT_HEAT_X)) {
                    i = i3;
                    i5 = floatValue;
                } else if (stringVal.equalsIgnoreCase("y")) {
                    i = i3;
                    i4 = floatValue;
                } else if (stringVal.equalsIgnoreCase("width")) {
                    i = floatValue;
                } else if (!stringVal.equalsIgnoreCase("height")) {
                    throw new JSONException("syntax error, " + stringVal);
                } else {
                    i2 = floatValue;
                    i = i3;
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
                i3 = i;
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Rectangle(i5, i4, i3, i2);
    }

    protected Point parsePoint(DefaultJSONParser defaultJSONParser, Object obj) {
        int floatValue;
        int i;
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
                        int intValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                        floatValue = intValue;
                    } else if (i4 == 3) {
                        jSONLexer.nextToken();
                        floatValue = (int) jSONLexer.floatValue();
                    } else {
                        throw new JSONException("syntax error : " + jSONLexer.tokenName());
                    }
                    if (stringVal.equalsIgnoreCase(Config.EVENT_HEAT_X)) {
                        i = floatValue;
                    } else if (!stringVal.equalsIgnoreCase("y")) {
                        throw new JSONException("syntax error, " + stringVal);
                    } else {
                        i2 = floatValue;
                        i = i3;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i3 = i;
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new Point(i3, i2);
    }

    private Object parseRef(DefaultJSONParser defaultJSONParser, Object obj) {
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

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
