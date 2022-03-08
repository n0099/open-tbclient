package com.baidu.sapi2.ecommerce.callback;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class AddressManageCallback implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static abstract class VoiceRecognitionResult {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ERROR_CODE_VOICE_RECOGNITION_CANCEL = -500;
        public static final int ERROR_CODE_VOICE_RECOGNITION_INIT_FAIL = -502;
        public static final int ERROR_CODE_VOICE_RECOGNITION_INTERRUPT = -506;
        public static final int ERROR_CODE_VOICE_RECOGNITION_MICRO_OFF = -504;
        public static final int ERROR_CODE_VOICE_RECOGNITION_NET_OFF = -503;
        public static final int ERROR_CODE_VOICE_RECOGNITION_NET_TIME_OUT = -505;
        public static final int ERROR_CODE_VOICE_RECOGNITION_UNKOWN = -501;
        public transient /* synthetic */ FieldHolder $fh;

        public VoiceRecognitionResult() {
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

        public abstract void onError(int i2);

        public abstract void onVoiceEnd();

        public abstract void onVoiceResult(String str);

        public abstract void onVolumeResult(int i2);

        public abstract void onWordResult(String str);
    }

    public AddressManageCallback() {
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

    public void activityOnCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void activityOnDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void activityOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void activityOnResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void onCancelSpeech() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void onFinish(AddressManageResult addressManageResult);

    public void onStartSpeech(VoiceRecognitionResult voiceRecognitionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, voiceRecognitionResult) == null) {
        }
    }

    public void onStopSpeech() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
