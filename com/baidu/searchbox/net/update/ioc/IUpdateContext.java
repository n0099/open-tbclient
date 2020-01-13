package com.baidu.searchbox.net.update.ioc;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public interface IUpdateContext {
    void doStatistics(int i, JSONObject jSONObject);

    List<String> getCustomUpdateBlackList();
}
