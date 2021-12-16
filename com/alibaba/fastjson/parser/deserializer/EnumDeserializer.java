package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class EnumDeserializer implements ObjectDeserializer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> enumClass;
    public long[] enumNameHashCodes;
    public final Enum[] enums;
    public final Enum[] ordinalEnums;

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        int i2;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        HashMap hashMap = new HashMap();
        int i5 = 0;
        while (true) {
            Enum[] enumArr = this.ordinalEnums;
            if (i5 >= enumArr.length) {
                break;
            }
            Enum r6 = enumArr[i5];
            String name = r6.name();
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
                        i2 = 0;
                        j2 = -3750763034362895579L;
                        j3 = -3750763034362895579L;
                        while (i2 < name.length()) {
                        }
                        hashMap.put(Long.valueOf(j2), r6);
                        if (j2 != j3) {
                        }
                        if (jSONField == null) {
                        }
                        i5++;
                    }
                }
            } catch (Exception unused2) {
            }
            i2 = 0;
            j2 = -3750763034362895579L;
            j3 = -3750763034362895579L;
            while (i2 < name.length()) {
                int charAt = name.charAt(i2);
                long j4 = charAt ^ j2;
                if (charAt >= 65 && charAt <= 90) {
                    charAt += 32;
                }
                j3 = (charAt ^ j3) * 1099511628211L;
                i2++;
                j2 = j4 * 1099511628211L;
            }
            hashMap.put(Long.valueOf(j2), r6);
            if (j2 != j3) {
                hashMap.put(Long.valueOf(j3), r6);
            }
            if (jSONField == null) {
                String[] alternateNames = jSONField.alternateNames();
                int length = alternateNames.length;
                int i6 = 0;
                while (i6 < length) {
                    String str = alternateNames[i6];
                    int i7 = 0;
                    long j5 = -3750763034362895579L;
                    while (i7 < str.length()) {
                        j5 = (j5 ^ str.charAt(i7)) * 1099511628211L;
                        i7++;
                        i5 = i5;
                    }
                    int i8 = i5;
                    if (j5 != j2 && j5 != j3) {
                        hashMap.put(Long.valueOf(j5), r6);
                    }
                    i6++;
                    i5 = i8;
                }
            }
            i5++;
        }
        this.enumNameHashCodes = new long[hashMap.size()];
        int i9 = 0;
        for (Long l : hashMap.keySet()) {
            this.enumNameHashCodes[i9] = l.longValue();
            i9++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int i10 = 0;
        while (true) {
            long[] jArr = this.enumNameHashCodes;
            if (i10 >= jArr.length) {
                return;
            }
            this.enums[i10] = (Enum) hashMap.get(Long.valueOf(jArr[i10]));
            i10++;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, defaultJSONParser, type, obj)) == null) {
            try {
                JSONLexer jSONLexer = defaultJSONParser.lexer;
                int i2 = jSONLexer.token();
                if (i2 == 2) {
                    int intValue = jSONLexer.intValue();
                    jSONLexer.nextToken(16);
                    if (intValue >= 0 && intValue < this.ordinalEnums.length) {
                        return (T) this.ordinalEnums[intValue];
                    }
                    throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
                } else if (i2 == 4) {
                    String stringVal = jSONLexer.stringVal();
                    jSONLexer.nextToken(16);
                    if (stringVal.length() == 0) {
                        return null;
                    }
                    long j2 = -3750763034362895579L;
                    long j3 = -3750763034362895579L;
                    for (int i3 = 0; i3 < stringVal.length(); i3++) {
                        int charAt = stringVal.charAt(i3);
                        long j4 = j2 ^ charAt;
                        if (charAt >= 65 && charAt <= 90) {
                            charAt += 32;
                        }
                        j2 = j4 * 1099511628211L;
                        j3 = (j3 ^ charAt) * 1099511628211L;
                    }
                    T t = (T) getEnumByHashCode(j2);
                    if (t == null && j3 != j2) {
                        t = (T) getEnumByHashCode(j3);
                    }
                    if (t == null && jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                        throw new JSONException("not match enum value, " + this.enumClass.getName() + ZeusCrashHandler.NAME_SEPERATOR + stringVal);
                    }
                    return t;
                } else {
                    if (i2 == 8) {
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
        return (T) invokeLLL.objValue;
    }

    public Enum getEnumByHashCode(long j2) {
        InterceptResult invokeJ;
        int binarySearch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j2)) >= 0) {
                return this.enums[binarySearch];
            }
            return null;
        }
        return (Enum) invokeJ.objValue;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public Enum<?> valueOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.ordinalEnums[i2] : (Enum) invokeI.objValue;
    }
}
