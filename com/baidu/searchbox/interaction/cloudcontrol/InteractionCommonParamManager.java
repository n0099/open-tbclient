package com.baidu.searchbox.interaction.cloudcontrol;

import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.interaction.cloudcontrol.ccs.InteractionPrivacySwitch;
/* loaded from: classes3.dex */
public class InteractionCommonParamManager {
    public static String processUrl(String str) {
        if (InteractionPrivacySwitch.getInteractionPrivacySwitch()) {
            return CommonUrlParamManager.getInstance().appendParam(str, 1);
        }
        return CommonUrlParamManager.getInstance().processUrl(str);
    }
}
