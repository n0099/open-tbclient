package com.baidu.searchbox.aideviceperformanceboxproxy.stickiness;

import com.baidu.searchbox.aideviceperformance.stickiness.IUserStickinessBusinessDataProvider;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class DefaultUserStickinessBusinessDataProvider implements IUserStickinessBusinessDataProvider {
    @Override // com.baidu.searchbox.aideviceperformance.stickiness.IUserStickinessBusinessDataProvider
    public List<String> getRegisteredBusinessIdsList() {
        return Arrays.asList(new String[0]);
    }
}
