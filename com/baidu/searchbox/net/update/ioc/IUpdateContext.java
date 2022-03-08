package com.baidu.searchbox.net.update.ioc;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface IUpdateContext {
    void doStatistics(int i2, JSONObject jSONObject);

    List<String> getCustomUpdateBlackList();
}
