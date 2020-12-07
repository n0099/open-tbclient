package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Type;
/* loaded from: classes15.dex */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();

    /* JADX WARN: Code restructure failed: missing block: B:139:?, code lost:
        return (T) new java.lang.StackTraceElement(r3, r2, r1, r0);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error: " + JSONToken.name(jSONLexer.token()));
        } else {
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            while (true) {
                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable());
                if (scanSymbol == null) {
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        break;
                    } else if (jSONLexer.token() == 16 && jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    }
                }
                jSONLexer.nextTokenWithColon(4);
                if (PushClientConstants.TAG_CLASS_NAME.equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str = null;
                    } else if (jSONLexer.token() == 4) {
                        str = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("methodName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str2 = null;
                    } else if (jSONLexer.token() == 4) {
                        str2 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("fileName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str3 = null;
                    } else if (jSONLexer.token() == 4) {
                        str3 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("lineNumber".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        i = 0;
                    } else if (jSONLexer.token() == 2) {
                        i = jSONLexer.intValue();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("nativeMethod".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 6) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 7) {
                        jSONLexer.nextToken(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (scanSymbol == JSON.DEFAULT_TYPE_KEY) {
                    if (jSONLexer.token() == 4) {
                        String stringVal = jSONLexer.stringVal();
                        if (!stringVal.equals("java.lang.StackTraceElement")) {
                            throw new JSONException("syntax error : " + stringVal);
                        }
                    } else if (jSONLexer.token() != 8) {
                        throw new JSONException("syntax error");
                    }
                } else if ("moduleName".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else if ("moduleVersion".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else if ("classLoaderName".equals(scanSymbol)) {
                    if (jSONLexer.token() != 8) {
                        if (jSONLexer.token() == 4) {
                            jSONLexer.stringVal();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else {
                    throw new JSONException("syntax error : " + scanSymbol);
                }
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
