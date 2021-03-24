package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import java.lang.reflect.Type;
import java.math.BigDecimal;
/* loaded from: classes.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.math.BigDecimal, T, java.lang.Object] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type != Double.TYPE && type != Double.class) {
                long longValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                if (type == Short.TYPE || type == Short.class) {
                    if (longValue <= 32767 && longValue >= -32768) {
                        return (T) Short.valueOf((short) longValue);
                    }
                    throw new JSONException("short overflow : " + longValue);
                } else if (type != Byte.TYPE && type != Byte.class) {
                    if (longValue >= -2147483648L && longValue <= 2147483647L) {
                        return (T) Integer.valueOf((int) longValue);
                    }
                    return (T) Long.valueOf(longValue);
                } else if (longValue <= 127 && longValue >= -128) {
                    return (T) Byte.valueOf((byte) longValue);
                } else {
                    throw new JSONException("short overflow : " + longValue);
                }
            }
            String numberString = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString));
        } else if (jSONLexer.token() == 3) {
            if (type != Double.TYPE && type != Double.class) {
                ?? r1 = (T) jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                if (type != Short.TYPE && type != Short.class) {
                    return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r1.byteValue()) : r1;
                } else if (r1.compareTo(BigDecimal.valueOf(32767L)) <= 0 && r1.compareTo(BigDecimal.valueOf(-32768L)) >= 0) {
                    return (T) Short.valueOf(r1.shortValue());
                } else {
                    throw new JSONException("short overflow : " + ((Object) r1));
                }
            }
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString2));
        } else if (jSONLexer.token() == 18 && WalletPayViewController.DEF_CHANNEL_TITLE.equals(jSONLexer.stringVal())) {
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
            if (parse == null) {
                return null;
            }
            if (type != Double.TYPE && type != Double.class) {
                if (type != Short.TYPE && type != Short.class) {
                    if (type != Byte.TYPE && type != Byte.class) {
                        return (T) TypeUtils.castToBigDecimal(parse);
                    }
                    try {
                        return (T) TypeUtils.castToByte(parse);
                    } catch (Exception e2) {
                        throw new JSONException("parseByte error, field : " + obj, e2);
                    }
                }
                try {
                    return (T) TypeUtils.castToShort(parse);
                } catch (Exception e3) {
                    throw new JSONException("parseShort error, field : " + obj, e3);
                }
            }
            try {
                return (T) TypeUtils.castToDouble(parse);
            } catch (Exception e4) {
                throw new JSONException("parseDouble error, field : " + obj, e4);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
