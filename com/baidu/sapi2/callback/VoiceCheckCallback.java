package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.VoiceCheckResult;
/* loaded from: classes.dex */
public abstract class VoiceCheckCallback implements CheckUserStatusCallback<VoiceCheckResult> {
    public abstract void onAccountTypeConflict(VoiceCheckResult voiceCheckResult);

    public abstract void onUserNotNormalized(VoiceCheckResult voiceCheckResult);
}
