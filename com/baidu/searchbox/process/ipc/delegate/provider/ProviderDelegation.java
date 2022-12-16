package com.baidu.searchbox.process.ipc.delegate.provider;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.agent.provider.ProcessDelegateBaseProvider;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class ProviderDelegation extends Delegation<ProcessDelegateBaseProvider> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Bundle execCall(Bundle bundle);

    public ProviderDelegation() {
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
}
