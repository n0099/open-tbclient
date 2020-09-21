package com.baidu.searchbox.cloudcontrol.router;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.data.RuleResult;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
/* loaded from: classes23.dex */
public class RouterRule {
    public RuleResult apply(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RuleResult.make(str, getProcessor(str));
    }

    private ICloudControlProcessor getProcessor(String str) {
        return CloudControlManager.getInstance().getProcessor(str);
    }
}
