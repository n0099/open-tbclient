package com.baidu.searchbox.devicescore.dynamic;

import android.content.Context;
import com.baidu.searchbox.devicescore.ScoreMetaData;
/* loaded from: classes3.dex */
public interface IDynamicScoreManager {
    float getScore(Context context);

    void putMetaData(Context context, ScoreMetaData scoreMetaData);

    boolean validMetaData(Context context, ScoreMetaData scoreMetaData);
}
