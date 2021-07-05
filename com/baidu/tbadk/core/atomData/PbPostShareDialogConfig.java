package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h2.h.m;
/* loaded from: classes4.dex */
public class PbPostShareDialogConfig extends ShareDialogConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m mPbPostData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPostShareDialogConfig(Context context, ShareItem shareItem, boolean z, m mVar) {
        super(context, shareItem, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ShareItem) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPbPostData = mVar;
    }

    public m getPbPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPbPostData : (m) invokeV.objValue;
    }
}
