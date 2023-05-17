package com.baidu.searchbox.interaction.cloudcontrol;

import com.baidu.searchbox.interaction.cloudcontrol.ccs.InteractionPrivacySwitch;
import com.baidu.searchbox.util.BaiduIdentityManager;
/* loaded from: classes3.dex */
public class InteractionIdentityManager {
    public static String processUrl(String str) {
        if (InteractionPrivacySwitch.getInteractionPrivacySwitch()) {
            return BaiduIdentityManager.getInstance().appendParam(str, 1);
        }
        return BaiduIdentityManager.getInstance().processUrl(str);
    }
}
