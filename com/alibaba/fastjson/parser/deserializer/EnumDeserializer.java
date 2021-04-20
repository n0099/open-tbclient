package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    public final Class<?> enumClass;
    public long[] enumNameHashCodes;
    public final Enum[] enums;
    public final Enum[] ordinalEnums;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        int i;
        long j;
        long j2;
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            Enum[] enumArr = this.ordinalEnums;
            if (i2 >= enumArr.length) {
                break;
            }
            Enum r5 = enumArr[i2];
            String name = r5.name();
            JSONField jSONField2 = null;
            try {
                jSONField = (JSONField) TypeUtils.getAnnotation(cls.getField(name), JSONField.class);
                if (jSONField != null) {
                    try {
                        String name2 = jSONField.name();
                        if (name2 != null && name2.length() > 0) {
                            name = name2;
                        }
                    } catch (Exception unused) {
                        jSONField2 = jSONField;
                        jSONField = jSONField2;
                        i = 0;
                        j = -3750763034362895579L;
                        j2 = -3750763034362895579L;
                        while (i < name.length()) {
                        }
                        hashMap.put(Long.valueOf(j), r5);
                        if (j != j2) {
                        }
                        if (jSONField == null) {
                        }
                        i2++;
                    }
                }
            } catch (Exception unused2) {
            }
            i = 0;
            j = -3750763034362895579L;
            j2 = -3750763034362895579L;
            while (i < name.length()) {
                int charAt = name.charAt(i);
                long j3 = charAt ^ j;
                if (charAt >= 65 && charAt <= 90) {
                    charAt += 32;
                }
                j2 = (charAt ^ j2) * 1099511628211L;
                i++;
                j = j3 * 1099511628211L;
            }
            hashMap.put(Long.valueOf(j), r5);
            if (j != j2) {
                hashMap.put(Long.valueOf(j2), r5);
            }
            if (jSONField == null) {
                String[] alternateNames = jSONField.alternateNames();
                int length = alternateNames.length;
                int i3 = 0;
                while (i3 < length) {
                    String str = alternateNames[i3];
                    int i4 = 0;
                    long j4 = -3750763034362895579L;
                    while (i4 < str.length()) {
                        j4 = (j4 ^ str.charAt(i4)) * 1099511628211L;
                        i4++;
                        i2 = i2;
                    }
                    int i5 = i2;
                    if (j4 != j && j4 != j2) {
                        hashMap.put(Long.valueOf(j4), r5);
                    }
                    i3++;
                    i2 = i5;
                }
            }
            i2++;
        }
        this.enumNameHashCodes = new long[hashMap.size()];
        int i6 = 0;
        for (Long l : hashMap.keySet()) {
            this.enumNameHashCodes[i6] = l.longValue();
            i6++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int i7 = 0;
        while (true) {
            long[] jArr = this.enumNameHashCodes;
            if (i7 >= jArr.length) {
                return;
            }
            this.enums[i7] = (Enum) hashMap.get(Long.valueOf(jArr[i7]));
            i7++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0 && intValue < this.ordinalEnums.length) {
                    return (T) this.ordinalEnums[intValue];
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            } else if (i == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                long j = -3750763034362895579L;
                long j2 = -3750763034362895579L;
                for (int i2 = 0; i2 < stringVal.length(); i2++) {
                    int charAt = stringVal.charAt(i2);
                    long j3 = j ^ charAt;
                    if (charAt >= 65 && charAt <= 90) {
                        charAt += 32;
                    }
                    j = j3 * 1099511628211L;
                    j2 = (j2 ^ charAt) * 1099511628211L;
                }
                T t = (T) getEnumByHashCode(j);
                if (t == null && j2 != j) {
                    t = (T) getEnumByHashCode(j2);
                }
                if (t == null && jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                    throw new JSONException("not match enum value, " + this.enumClass.getName() + ZeusCrashHandler.NAME_SEPERATOR + stringVal);
                }
                return t;
            } else {
                if (i == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException(e3.getMessage(), e3);
        }
    }

    public Enum getEnumByHashCode(long j) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }
}
