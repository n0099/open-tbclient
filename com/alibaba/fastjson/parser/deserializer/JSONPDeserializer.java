package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class JSONPDeserializer implements ObjectDeserializer {
    public static final JSONPDeserializer instance = new JSONPDeserializer();

    /* JADX WARN: Type inference failed for: r1v1, types: [com.alibaba.fastjson.JSONPObject, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        int i2;
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        String scanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
        jSONLexerBase.nextToken();
        int i3 = jSONLexerBase.token();
        if (i3 == 25) {
            String str = scanSymbolUnQuoted + ".";
            scanSymbolUnQuoted = str + jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            jSONLexerBase.nextToken();
            i3 = jSONLexerBase.token();
        }
        ?? r1 = (T) new JSONPObject(scanSymbolUnQuoted);
        if (i3 == 10) {
            jSONLexerBase.nextToken();
            while (true) {
                r1.addParameter(defaultJSONParser.parse());
                i2 = jSONLexerBase.token();
                if (i2 != 16) {
                    break;
                }
                jSONLexerBase.nextToken();
            }
            if (i2 == 11) {
                jSONLexerBase.nextToken();
                if (jSONLexerBase.token() == 24) {
                    jSONLexerBase.nextToken();
                }
                return r1;
            }
            throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        throw new JSONException("illegal jsonp : " + jSONLexerBase.info());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }
}
