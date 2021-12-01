package com.baidu.cyberplayer.sdk;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public abstract class MediaInstanceManagerProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes8.dex */
    public interface OnClientInstanceHandler {
        boolean onDestroyInstance();

        boolean onResumeInstance();
    }

    public MediaInstanceManagerProvider() {
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

    public abstract void activeInstance(int i2);

    public abstract String getInstanceOptionByKey(int i2, String str);

    public abstract Bundle getInstanceStatusByType(int i2, int i3);

    public abstract int registerInstance(OnClientInstanceHandler onClientInstanceHandler);

    public abstract void unRegisterInstance(int i2);

    public abstract void updateInstanceTimestamp(int i2, long j2);

    public abstract void updateStringOption(int i2, String str, String str2);
}
