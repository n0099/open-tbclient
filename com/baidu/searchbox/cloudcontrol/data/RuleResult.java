package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
/* loaded from: classes23.dex */
public class RuleResult {
    public ICloudControlProcessor mProcessor;
    public String mServiceName;

    private RuleResult() {
    }

    public static RuleResult make(String str, ICloudControlProcessor iCloudControlProcessor) {
        RuleResult ruleResult = new RuleResult();
        ruleResult.mServiceName = str;
        ruleResult.mProcessor = iCloudControlProcessor;
        return ruleResult;
    }
}
