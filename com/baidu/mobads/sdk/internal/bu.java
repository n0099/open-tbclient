package com.baidu.mobads.sdk.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.cg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bu implements cg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bt a;

    public bu(bt btVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {btVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = btVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cg.a
    public void a(bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, bvVar) != null) {
            return;
        }
        this.a.a(bx.k, bvVar, "download apk successfully, downloader exit");
        bt unused = bt.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.cg.a
    public void b(bv bvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bvVar) != null) {
            return;
        }
        this.a.a(bx.l, bvVar, "downloadApk failed");
    }
}
