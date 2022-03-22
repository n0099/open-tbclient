package com.baidu.cyberplayer.sdk;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public abstract class MediaInstanceManagerProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public interface OnClientInstanceHandler {
        boolean onDestroyInstance();

        boolean onResumeInstance();
    }

    public MediaInstanceManagerProvider() {
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

    public abstract boolean activeInstance(int i);

    public abstract String getInstanceOptionByKey(int i, String str);

    public abstract Bundle getInstanceStatusByType(int i, int i2);

    public abstract int registerInstance(OnClientInstanceHandler onClientInstanceHandler);

    public abstract void unRegisterInstance(int i);

    public abstract void updateInstanceTimestamp(int i, long j);

    public abstract void updateStringOption(int i, String str, String str2);
}
