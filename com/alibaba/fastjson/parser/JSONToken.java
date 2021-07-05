package com.alibaba.fastjson.parser;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes.dex */
public class JSONToken {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLON = 17;
    public static final int COMMA = 16;
    public static final int DOT = 25;
    public static final int EOF = 20;
    public static final int ERROR = 1;
    public static final int FALSE = 7;
    public static final int FIELD_NAME = 19;
    public static final int HEX = 26;
    public static final int IDENTIFIER = 18;
    public static final int LBRACE = 12;
    public static final int LBRACKET = 14;
    public static final int LITERAL_FLOAT = 3;
    public static final int LITERAL_INT = 2;
    public static final int LITERAL_ISO8601_DATE = 5;
    public static final int LITERAL_STRING = 4;
    public static final int LPAREN = 10;
    public static final int NEW = 9;
    public static final int NULL = 8;
    public static final int RBRACE = 13;
    public static final int RBRACKET = 15;
    public static final int RPAREN = 11;
    public static final int SEMI = 24;
    public static final int SET = 21;
    public static final int TREE_SET = 22;
    public static final int TRUE = 6;
    public static final int UNDEFINED = 23;
    public transient /* synthetic */ FieldHolder $fh;

    public JSONToken() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String name(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "error";
                case 2:
                    return "int";
                case 3:
                    return ShaderParams.VALUE_TYPE_FLOAT;
                case 4:
                    return "string";
                case 5:
                    return "iso8601";
                case 6:
                    return "true";
                case 7:
                    return "false";
                case 8:
                    return StringUtil.NULL_STRING;
                case 9:
                    return "new";
                case 10:
                    return "(";
                case 11:
                    return SmallTailInfo.EMOTION_SUFFIX;
                case 12:
                    return StringUtil.ARRAY_START;
                case 13:
                    return "}";
                case 14:
                    return PreferencesUtil.LEFT_MOUNT;
                case 15:
                    return PreferencesUtil.RIGHT_MOUNT;
                case 16:
                    return ",";
                case 17:
                    return ":";
                case 18:
                    return "ident";
                case 19:
                    return "fieldName";
                case 20:
                    return "EOF";
                case 21:
                    return "Set";
                case 22:
                    return "TreeSet";
                case 23:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
                case 24:
                    return ";";
                case 25:
                    return ".";
                case 26:
                    return "hex";
                default:
                    return "Unknown";
            }
        }
        return (String) invokeI.objValue;
    }
}
