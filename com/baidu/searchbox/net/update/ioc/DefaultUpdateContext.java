package com.baidu.searchbox.net.update.ioc;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DefaultUpdateContext implements IUpdateContext {
    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public void doStatistics(int i2, JSONObject jSONObject) {
    }

    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public List<String> getCustomUpdateBlackList() {
        return null;
    }
}
