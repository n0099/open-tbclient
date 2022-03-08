package com.badlogic.gdx.utils;

import c.b.b.q.j0;
import c.b.b.q.q;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
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

    public JsonWriter$OutputType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JsonWriter$OutputType) Enum.valueOf(JsonWriter$OutputType.class, str) : (JsonWriter$OutputType) invokeL.objValue;
    }

    public static JsonWriter$OutputType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JsonWriter$OutputType[]) $VALUES.clone() : (JsonWriter$OutputType[]) invokeV.objValue;
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
            j0 j0Var = new j0(str);
            j0Var.G(FileUtil.WINDOWS_SEPARATOR, "\\\\");
            j0Var.G(CharUtils.CR, "\\r");
            j0Var.G('\n', "\\n");
            j0Var.G('\t', "\\t");
            int i2 = q.a[ordinal()];
            if (i2 == 1) {
                if (!str.contains("//") && !str.contains("/*") && minimalNamePattern.matcher(j0Var).matches()) {
                    return j0Var.toString();
                }
            }
            if (javascriptPattern.matcher(j0Var).matches()) {
                return j0Var.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            j0Var.G('\"', "\\\"");
            sb.append(j0Var.toString());
            sb.append('\"');
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
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                return obj2;
            }
            j0 j0Var = new j0(obj2);
            j0Var.G(FileUtil.WINDOWS_SEPARATOR, "\\\\");
            j0Var.G(CharUtils.CR, "\\r");
            j0Var.G('\n', "\\n");
            j0Var.G('\t', "\\t");
            if (this == minimal && !obj2.equals("true") && !obj2.equals("false") && !obj2.equals(StringUtil.NULL_STRING) && !obj2.contains("//") && !obj2.contains("/*") && (length = j0Var.length()) > 0 && j0Var.charAt(length - 1) != ' ' && minimalValuePattern.matcher(j0Var).matches()) {
                return j0Var.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            j0Var.G('\"', "\\\"");
            sb.append(j0Var.toString());
            sb.append('\"');
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
