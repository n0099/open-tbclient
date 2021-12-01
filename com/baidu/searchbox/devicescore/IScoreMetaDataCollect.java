package com.baidu.searchbox.devicescore;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes9.dex */
public interface IScoreMetaDataCollect {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("device_score", "DEVICE_SCORE_COLLECT");

    void putScoreMetaData(Context context, ScoreMetaData scoreMetaData);
}
