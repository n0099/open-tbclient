package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public interface BIMRtcAnswerAbilityListener {

    /* loaded from: classes8.dex */
    public static class BIMRtcAnswerAbilityResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int ability;
        public String rtcAppId;
        public String rtcToken;

        public BIMRtcAnswerAbilityResult() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ability = -1;
            this.rtcToken = "";
            this.rtcAppId = "";
        }
    }

    void onResult(int i2, String str, @NonNull BIMRtcAnswerAbilityResult bIMRtcAnswerAbilityResult);
}
