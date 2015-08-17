package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.VoiceCheckResult;
/* loaded from: classes.dex */
public abstract class VoiceCheckCallback implements IncompleteUserAware<VoiceCheckResult> {
    public abstract void onAccountTypeConflict(VoiceCheckResult voiceCheckResult);
}
