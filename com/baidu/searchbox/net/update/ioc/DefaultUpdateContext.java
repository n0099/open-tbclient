package com.baidu.searchbox.net.update.ioc;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DefaultUpdateContext implements IUpdateContext {
    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public void doStatistics(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.searchbox.net.update.ioc.IUpdateContext
    public List<String> getCustomUpdateBlackList() {
        return null;
    }
}
