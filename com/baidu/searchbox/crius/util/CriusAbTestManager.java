package com.baidu.searchbox.crius.util;

import android.util.Log;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes2.dex */
public class CriusAbTestManager {
    public static final String CRIUS_LAYOUT_FLATTEN_SWITCH = "crius_layout_enhance_switch";
    public static final String TAG = "CriusAbTestManager";
    public static boolean sCriusLayoutFlattenSwitch;
    public static boolean sHasGetCriusLayoutFlattenSwitch;
    public static final String PREFERENCE_VISITED_KEY = "is_visited_key";
    public static boolean sIsVisited = PreferenceUtil.getBoolean(PREFERENCE_VISITED_KEY, false);

    public static boolean isVisited() {
        return sIsVisited;
    }

    public static boolean isHitLayoutFlattenTest() {
        if (!sHasGetCriusLayoutFlattenSwitch) {
            sCriusLayoutFlattenSwitch = AbTestManager.getInstance().getSwitch(CRIUS_LAYOUT_FLATTEN_SWITCH, false);
            sHasGetCriusLayoutFlattenSwitch = true;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "isHitLayoutFlattenTest: " + sCriusLayoutFlattenSwitch);
        }
        return sCriusLayoutFlattenSwitch;
    }

    public static void updateVisitedState(boolean z) {
        PreferenceUtil.putBoolean(PREFERENCE_VISITED_KEY, z);
    }
}
