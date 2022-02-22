package com.baidu.searchbox.devicescore;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes11.dex */
public interface IDeviceScore {
    public static final int SCORE_LEVEL_HIGH = 3;
    public static final int SCORE_LEVEL_LOW = 1;
    public static final int SCORE_LEVEL_MID = 2;
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("device_score", "DEVICE_SCORE");
    public static final String TYPE_LAUNCH_SPEED = "LAUNCH_SPEED";

    float getDynamicScore(Context context);

    float getDynamicScoreByType(Context context, String str);

    float getFinalScore(Context context);

    int getScoreLevel(Context context);

    float getStaticScore(Context context);

    void updateScore(Context context);
}
