package com.baidu.searchbox.ng.ai.apps.framework;

import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.framework.apps.AiAppsFrame;
import com.baidu.searchbox.ng.ai.apps.framework.games.AiGamesFrame;
import com.baidu.searchbox.ng.ai.apps.util.AiAppIntentUtils;
/* loaded from: classes2.dex */
public class AiAppsFrameFactory {
    public static final String BUNDLE_AIAPPS_FRAME_TYPE = "aiapps_app_frame_type";
    public static final int FRAME_APPS = 0;
    public static final int FRAME_GAMES = 1;

    public static AiAppsBaseFrame buildFramework(AiAppsActivity aiAppsActivity, int i) {
        switch (i) {
            case 0:
                return new AiAppsFrame(aiAppsActivity);
            case 1:
                return new AiGamesFrame(aiAppsActivity);
            default:
                return new AiAppsFrame(aiAppsActivity);
        }
    }

    public static int parseFrameType(Intent intent) {
        return AiAppIntentUtils.safeGetIntExtra(intent, "aiapps_app_frame_type", 0);
    }
}
