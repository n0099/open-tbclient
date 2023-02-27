package com.baidu.searchbox.retrieve.connect.cloudcommand;

import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.cloudcommand.processor.ICloudCommandObserver;
import com.baidu.searchbox.retrieve.connect.FetchConnManager;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class FetchCloudCommandReceiver implements ICloudCommandObserver {
    public static final String COMMAND_TYPE = "fetch_log_notice";

    @Override // com.baidu.searchbox.cloudcommand.processor.ICloudCommandObserver
    public String getCommandType() {
        return "fetch_log_notice";
    }

    @Override // com.baidu.searchbox.cloudcommand.processor.ICloudCommandObserver
    public void dispatch(JSONObject jSONObject) {
        if (jSONObject != null) {
            FetchConnManager.getInstance().dispatch(jSONObject);
        }
    }
}
