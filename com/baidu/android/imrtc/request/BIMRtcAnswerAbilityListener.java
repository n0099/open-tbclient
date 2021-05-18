package com.baidu.android.imrtc.request;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface BIMRtcAnswerAbilityListener {

    /* loaded from: classes.dex */
    public static class BIMRtcAnswerAbilityResult {
        public int ability = -1;
        public String rtcToken = "";
        public String rtcAppId = "";
    }

    void onResult(int i2, String str, @NonNull BIMRtcAnswerAbilityResult bIMRtcAnswerAbilityResult);
}
