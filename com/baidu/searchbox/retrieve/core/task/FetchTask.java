package com.baidu.searchbox.retrieve.core.task;

import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FetchTask implements IFetchTask {
    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportDispatch(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        String jSONObject2;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "1", str2, str3, str4, jSONObject2, ""));
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportDispatchCheckFail(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "-1", str2, str3, str4, jSONObject2, ""));
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(str, "2", str2, str3, "", jSONObject2, ""));
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchTask
    public void reportTaskDone(String str, String str2, String str3, String str4, String str5, String str6) {
        FetchTaskObj fetchTaskObj = new FetchTaskObj(str, "4", str2, str3, str4, "", str6);
        fetchTaskObj.setFileID(str5);
        FetchUploadManager.getInstance().uploadReportContent(fetchTaskObj);
    }
}
