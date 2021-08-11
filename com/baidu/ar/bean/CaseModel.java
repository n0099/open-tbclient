package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.ARType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCaseId;
    public String mCasePath;
    public ARType mCaseType;

    public CaseModel(ARType aRType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aRType, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCaseType = aRType;
        this.mCasePath = str;
        this.mCaseId = str2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof CaseModel) {
                return (!TextUtils.isEmpty(this.mCasePath) && this.mCasePath.equals(((CaseModel) obj).mCasePath)) || (TextUtils.isEmpty(this.mCasePath) && !TextUtils.isEmpty(this.mCaseId) && this.mCaseId.equals(((CaseModel) obj).mCaseId));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
