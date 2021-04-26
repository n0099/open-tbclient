package com.alibaba.fastjson.parser;
@Deprecated
/* loaded from: classes.dex */
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig) {
        super(str, parserConfig);
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig, int i2) {
        super(str, parserConfig, i2);
    }

    public DefaultExtJSONParser(char[] cArr, int i2, ParserConfig parserConfig, int i3) {
        super(cArr, i2, parserConfig, i3);
    }
}
