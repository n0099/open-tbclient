package com.baidu.searchbox.aideviceperformance.stickiness;

import android.content.Context;
/* loaded from: classes2.dex */
public interface IStickinessScoreManager {
    float getStickinessScore(String str);

    boolean updateStickinessScore(Context context);
}
