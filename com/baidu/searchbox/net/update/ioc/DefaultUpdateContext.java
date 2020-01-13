package com.baidu.searchbox.net.update.ioc;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class DefaultUpdateContext implements IUpdateContext {
    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public List<String> getCustomUpdateBlackList() {
        return null;
    }

    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public void doStatistics(int i, JSONObject jSONObject) {
    }
}
