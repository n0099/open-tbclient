package com.baidu.searchbox.retrieve.stats;

import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.stats.service.StatTaskManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class StatTask implements IStatTask {
    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordActiveUploadData(boolean z, String str, String str2, String str3, String str4) {
        StatTaskManager.getInstance().recordActiveUploadData(z, str, str2, str3, str4);
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordDispatchRetrieveData(boolean z, String str, String str2, String str3, String str4) {
        StatTaskManager.getInstance().recordDispatchRetrieveData(z, str, str2, str3, str4);
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordCheckRetrieveData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        StatTaskManager.getInstance().recordCheckRetrieveData(z, z2, str, str2, str3, str4);
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordReceiveRetrieveData(boolean z) {
        StatTaskManager.getInstance().recordReceiveRetrieveData(z);
    }

    @Override // com.baidu.searchbox.retrieve.inter.statistics.IStatTask
    public void recordUploadRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        StatTaskManager.getInstance().recordUploadRetrieveData(str, z, str2, str3, str4, str5, str6, jSONObject);
    }
}
