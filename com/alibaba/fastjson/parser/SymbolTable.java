package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SymbolTable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int indexMask;
    public final String[] symbols;

    public SymbolTable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.indexMask = i2 - 1;
        this.symbols = new String[i2];
        addSymbol("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        addSymbol(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static int hash(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, cArr, i2, i3)) == null) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                i5 = (i5 * 31) + cArr[i2];
                i4++;
                i2++;
            }
            return i5;
        }
        return invokeLII.intValue;
    }

    public static String subString(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
            char[] cArr = new char[i3];
            str.getChars(i2, i3 + i2, cArr, 0);
            return new String(cArr);
        }
        return (String) invokeLII.objValue;
    }

    public String addSymbol(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i2, i3)) == null) ? addSymbol(cArr, i2, i3, hash(cArr, i2, i3)) : (String) invokeLII.objValue;
    }

    public String addSymbol(char[] cArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048579, this, cArr, i2, i3, i4)) == null) {
            int i5 = this.indexMask & i4;
            String str = this.symbols[i5];
            if (str != null) {
                boolean z = false;
                if (i4 == str.hashCode() && i3 == str.length()) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i3) {
                            z = true;
                            break;
                        } else if (cArr[i2 + i6] != str.charAt(i6)) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                return z ? str : new String(cArr, i2, i3);
            }
            String intern = new String(cArr, i2, i3).intern();
            this.symbols[i5] = intern;
            return intern;
        }
        return (String) invokeLIII.objValue;
    }

    public String addSymbol(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, str, i2, i3, i4)) == null) ? addSymbol(str, i2, i3, i4, false) : (String) invokeLIII.objValue;
    }

    public String addSymbol(String str, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            int i5 = this.indexMask & i4;
            String str2 = this.symbols[i5];
            if (str2 != null) {
                if (i4 == str2.hashCode() && i3 == str2.length() && str.startsWith(str2, i2)) {
                    return str2;
                }
                String subString = subString(str, i2, i3);
                if (z) {
                    this.symbols[i5] = subString;
                }
                return subString;
            }
            if (i3 != str.length()) {
                str = subString(str, i2, i3);
            }
            String intern = str.intern();
            this.symbols[i5] = intern;
            return intern;
        }
        return (String) invokeCommon.objValue;
    }
}
