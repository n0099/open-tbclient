package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.nj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nj9 mPbPostData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, nj9 nj9Var) {
        super(context, shareItem, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), nj9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ShareItem) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPbPostData = nj9Var;
    }

    public nj9 getPbPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mPbPostData;
        }
        return (nj9) invokeV.objValue;
    }
}
