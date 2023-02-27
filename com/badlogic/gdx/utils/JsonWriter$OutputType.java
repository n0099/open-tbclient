package com.badlogic.gdx.utils;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q8;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.apache.commons.codec.language.bm.ResourceConstants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class JsonWriter$OutputType {
    public static final /* synthetic */ JsonWriter$OutputType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JsonWriter$OutputType javascript;
    public static Pattern javascriptPattern;
    public static final JsonWriter$OutputType json;
    public static final JsonWriter$OutputType minimal;
    public static Pattern minimalNamePattern;
    public static Pattern minimalValuePattern;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(599981701, "Lcom/badlogic/gdx/utils/JsonWriter$OutputType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(599981701, "Lcom/badlogic/gdx/utils/JsonWriter$OutputType;");
                return;
            }
        }
        json = new JsonWriter$OutputType("json", 0);
        javascript = new JsonWriter$OutputType("javascript", 1);
        JsonWriter$OutputType jsonWriter$OutputType = new JsonWriter$OutputType("minimal", 2);
        minimal = jsonWriter$OutputType;
        $VALUES = new JsonWriter$OutputType[]{json, javascript, jsonWriter$OutputType};
        javascriptPattern = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
        minimalNamePattern = Pattern.compile("^[^\":,}/ ][^:]*$");
        minimalValuePattern = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");
    }

    public JsonWriter$OutputType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static JsonWriter$OutputType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (JsonWriter$OutputType) Enum.valueOf(JsonWriter$OutputType.class, str);
        }
        return (JsonWriter$OutputType) invokeL.objValue;
    }

    public static JsonWriter$OutputType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (JsonWriter$OutputType[]) $VALUES.clone();
        }
        return (JsonWriter$OutputType[]) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
        if (r1 != 2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String quoteName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q8 q8Var = new q8(str);
            q8Var.G('\\', "\\\\");
            q8Var.G('\r', "\\r");
            q8Var.G('\n', "\\n");
            q8Var.G('\t', "\\t");
            int i = x7.a[ordinal()];
            if (i == 1) {
                if (!str.contains(ResourceConstants.CMT) && !str.contains(ResourceConstants.EXT_CMT_START) && minimalNamePattern.matcher(q8Var).matches()) {
                    return q8Var.toString();
                }
            }
            if (javascriptPattern.matcher(q8Var).matches()) {
                return q8Var.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            q8Var.G(Typography.quote, "\\\"");
            sb.append(q8Var.toString());
            sb.append(Typography.quote);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String quoteValue(Object obj) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return StringUtil.NULL_STRING;
            }
            String obj2 = obj.toString();
            if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                q8 q8Var = new q8(obj2);
                q8Var.G('\\', "\\\\");
                q8Var.G('\r', "\\r");
                q8Var.G('\n', "\\n");
                q8Var.G('\t', "\\t");
                if (this == minimal && !obj2.equals("true") && !obj2.equals("false") && !obj2.equals(StringUtil.NULL_STRING) && !obj2.contains(ResourceConstants.CMT) && !obj2.contains(ResourceConstants.EXT_CMT_START) && (length = q8Var.length()) > 0 && q8Var.charAt(length - 1) != ' ' && minimalValuePattern.matcher(q8Var).matches()) {
                    return q8Var.toString();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(Typography.quote);
                q8Var.G(Typography.quote, "\\\"");
                sb.append(q8Var.toString());
                sb.append(Typography.quote);
                return sb.toString();
            }
            return obj2;
        }
        return (String) invokeL.objValue;
    }
}
