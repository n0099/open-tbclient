package com.baidu.searchbox.cloudcommand.processor;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface ICloudCommandObserver {
    void dispatch(JSONObject jSONObject);

    String getCommandType();
}
