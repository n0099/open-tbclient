package com.baidu.ar.speech;
/* loaded from: classes3.dex */
public class SpeechStatus {
    public static final int BEGINNINGOFSPEECH = 1;
    public static final int CANCLE = 7;
    public static final int ENDOFSPEECH = 2;
    public static final int ERROR = 3;
    public static final int PARTIALRESULT = 6;
    public static final int READYFORSPEECH = 0;
    public static final int RESULT = 4;
    public static final int RESULT_NO_MATCH = 5;

    /* loaded from: classes3.dex */
    public class SpeechErrorStatus {
        public static final int ERROR_INSUFFICIENT_PERMISSIONS = 3;
        public static final int ERROR_NETWORK = 2;
        public static final int ERROR_NULL = 0;
        public static final int ERROR_SPEECH_TIMEOUT = 1;

        public SpeechErrorStatus() {
        }
    }
}
