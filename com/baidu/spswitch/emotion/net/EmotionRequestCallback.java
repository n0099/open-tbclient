package com.baidu.spswitch.emotion.net;

import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public interface EmotionRequestCallback {
    void onFailure(@Nullable String str);

    void onSuccess(String str, int i);
}
