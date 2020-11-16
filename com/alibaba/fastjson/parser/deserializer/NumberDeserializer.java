package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
/* loaded from: classes19.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX WARN: Type inference failed for: r0v23, types: [java.math.BigDecimal, T, java.lang.Object] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                if (longValue > 32767 || longValue < -32768) {
                    throw new JSONException("short overflow : " + longValue);
                }
                return (T) Short.valueOf((short) longValue);
            } else if (type == Byte.TYPE || type == Byte.class) {
                if (longValue > 127 || longValue < -128) {
                    throw new JSONException("short overflow : " + longValue);
                }
                return (T) Byte.valueOf((byte) longValue);
            } else if (longValue >= -2147483648L && longValue <= 2147483647L) {
                return (T) Integer.valueOf((int) longValue);
            } else {
                return (T) Long.valueOf(longValue);
            }
        } else if (jSONLexer.token() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString2));
            }
            ?? r0 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                if (r0.compareTo(BigDecimal.valueOf(32767L)) > 0 || r0.compareTo(BigDecimal.valueOf(-32768L)) < 0) {
                    throw new JSONException("short overflow : " + ((Object) r0));
                }
                return (T) Short.valueOf(r0.shortValue());
            } else if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf(r0.byteValue());
            } else {
                return r0;
            }
        } else if (jSONLexer.token() == 18 && "NaN".equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse != null) {
                if (type == Double.TYPE || type == Double.class) {
                    try {
                        return (T) TypeUtils.castToDouble(parse);
                    } catch (Exception e) {
                        throw new JSONException("parseDouble error, field : " + obj, e);
                    }
                } else if (type == Short.TYPE || type == Short.class) {
                    try {
                        return (T) TypeUtils.castToShort(parse);
                    } catch (Exception e2) {
                        throw new JSONException("parseShort error, field : " + obj, e2);
                    }
                } else if (type == Byte.TYPE || type == Byte.class) {
                    try {
                        return (T) TypeUtils.castToByte(parse);
                    } catch (Exception e3) {
                        throw new JSONException("parseByte error, field : " + obj, e3);
                    }
                } else {
                    return (T) TypeUtils.castToBigDecimal(parse);
                }
            }
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
