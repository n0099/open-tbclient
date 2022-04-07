package com.baidu.tbadk.core.util;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.CharArrayWriter;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class BuildPackageInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BuildPackageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getBranchNameFromFile(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(context.getResources().getIdentifier("branch", "raw", context.getPackageName())));
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            char[] cArr = new char[2048];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read > 0) {
                    charArrayWriter.write(cArr, 0, read);
                } else {
                    String charArrayWriter2 = charArrayWriter.toString();
                    inputStreamReader.close();
                    return charArrayWriter2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "get branch error";
        }
    }

    public static String getCommitIdFromFile(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(context.getResources().getIdentifier("commitid", "raw", context.getPackageName())));
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            char[] cArr = new char[2048];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read > 0) {
                    charArrayWriter.write(cArr, 0, read);
                } else {
                    String charArrayWriter2 = charArrayWriter.toString();
                    inputStreamReader.close();
                    return charArrayWriter2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "get commitid error";
        }
    }
}
