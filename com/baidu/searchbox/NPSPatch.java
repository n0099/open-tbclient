package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class NPSPatch {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NPSPatch";
    public transient /* synthetic */ FieldHolder $fh;
    public String newMD5;
    public String oldFileName;
    public String patchFileName;

    public NPSPatch(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.oldFileName = null;
        this.newMD5 = null;
        this.patchFileName = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.oldFileName = str;
            this.patchFileName = str2;
            this.newMD5 = str3;
            return;
        }
        throw new IllegalArgumentException("old file name or patch file name is null.");
    }

    public int bsPatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int patch = NPSPatchUtils.patch(this.oldFileName, str, this.patchFileName);
            if (patch == 0 && !checkMD5(str)) {
                return 2;
            }
            return patch;
        }
        return invokeL.intValue;
    }

    public boolean checkMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(this.newMD5, NPSPatchUtils.toMd5(new File(str), false));
        }
        return invokeL.booleanValue;
    }
}
