package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class EnumDeserializer implements ObjectDeserializer {
    protected final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r4.length() > 0) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        String str;
        long j;
        long j2;
        int i;
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ordinalEnums.length) {
                break;
            }
            Enum r12 = this.ordinalEnums[i3];
            String name = r12.name();
            try {
                jSONField = (JSONField) cls.getField(name).getAnnotation(JSONField.class);
                if (jSONField != null) {
                    try {
                        str = jSONField.name();
                        if (str != null) {
                        }
                    } catch (Exception e) {
                        str = name;
                        j = -3750763034362895579L;
                        j2 = -3750763034362895579L;
                        while (i < str.length()) {
                        }
                        hashMap.put(Long.valueOf(j), r12);
                        if (j != j2) {
                        }
                        if (jSONField == null) {
                        }
                        i2 = i3 + 1;
                    }
                }
                str = name;
            } catch (Exception e2) {
                jSONField = null;
            }
            j = -3750763034362895579L;
            j2 = -3750763034362895579L;
            for (i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                j = 1099511628211L * (charAt ^ j);
                j2 = (j2 ^ ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' ')) * 1099511628211L;
            }
            hashMap.put(Long.valueOf(j), r12);
            if (j != j2) {
                hashMap.put(Long.valueOf(j2), r12);
            }
            if (jSONField == null) {
                for (String str2 : jSONField.alternateNames()) {
                    long j3 = -3750763034362895579L;
                    for (int i4 = 0; i4 < str2.length(); i4++) {
                        j3 = (j3 ^ str2.charAt(i4)) * 1099511628211L;
                    }
                    if (j3 != j && j3 != j2) {
                        hashMap.put(Long.valueOf(j3), r12);
                    }
                }
            }
            i2 = i3 + 1;
        }
        this.enumNameHashCodes = new long[hashMap.size()];
        int i5 = 0;
        for (Long l : hashMap.keySet()) {
            this.enumNameHashCodes[i5] = l.longValue();
            i5++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < this.enumNameHashCodes.length) {
                this.enums[i7] = (Enum) hashMap.get(Long.valueOf(this.enumNameHashCodes[i7]));
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    public Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    public Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue < 0 || intValue > this.ordinalEnums.length) {
                    throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
                }
                return (T) this.ordinalEnums[intValue];
            } else if (i == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() != 0) {
                    long j = -3750763034362895579L;
                    for (int i2 = 0; i2 < stringVal.length(); i2++) {
                        j = (j ^ stringVal.charAt(i2)) * 1099511628211L;
                    }
                    return (T) getEnumByHashCode(j);
                }
                return null;
            } else if (i == 8) {
                jSONLexer.nextToken(16);
                return null;
            } else {
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
        } catch (JSONException e) {
            throw e;
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
