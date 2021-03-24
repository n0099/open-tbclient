package com.baidu.sapi2.ecommerce.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
/* loaded from: classes2.dex */
public abstract class AddressManageCallback implements NoProguard {

    /* loaded from: classes2.dex */
    public static abstract class VoiceRecognitionResult {
        public static final int ERROR_CODE_VOICE_RECOGNITION_CANCEL = -500;
        public static final int ERROR_CODE_VOICE_RECOGNITION_INIT_FAIL = -502;
        public static final int ERROR_CODE_VOICE_RECOGNITION_INTERRUPT = -506;
        public static final int ERROR_CODE_VOICE_RECOGNITION_MICRO_OFF = -504;
        public static final int ERROR_CODE_VOICE_RECOGNITION_NET_OFF = -503;
        public static final int ERROR_CODE_VOICE_RECOGNITION_NET_TIME_OUT = -505;
        public static final int ERROR_CODE_VOICE_RECOGNITION_UNKOWN = -501;

        public abstract void onError(int i);

        public abstract void onVoiceEnd();

        public abstract void onVoiceResult(String str);

        public abstract void onVolumeResult(int i);

        public abstract void onWordResult(String str);
    }

    public void activityOnCreate() {
    }

    public void activityOnDestory() {
    }

    public void activityOnPause() {
    }

    public void activityOnResume() {
    }

    public void onCancelSpeech() {
    }

    public abstract void onFinish(AddressManageResult addressManageResult);

    public void onStartSpeech(VoiceRecognitionResult voiceRecognitionResult) {
    }

    public void onStopSpeech() {
    }
}
