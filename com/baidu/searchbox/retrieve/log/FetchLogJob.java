package com.baidu.searchbox.retrieve.log;

import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.retrieve.log.bean.FetchLogBean;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class FetchLogJob extends IFetchJob {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchLogJob";
    public static final String UPLOAD_WIFI_TYPE = "1";

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        return "flow";
    }

    private void statDispatchData(boolean z, FetchLogBean fetchLogBean, String str) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordDispatchRetrieveData(z, fetchLogBean.getJobId(), fetchLogBean.getType(), fetchLogBean.getVersion(), str);
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchLogBean parseJsonContent = FetchLog.parseJsonContent(jSONObject);
        if (parseJsonContent == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到命令 " + jSONObject);
        }
        if ("1".equals(parseJsonContent.getNetwork()) && !NetWorkUtils.NetType.WIFI.equals(NetWorkUtils.getNetworkType())) {
            statDispatchData(false, parseJsonContent, "2");
            return;
        }
        statDispatchData(true, parseJsonContent, "");
        ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).fetchUpload(parseJsonContent.getType(), parseJsonContent.getJobId(), parseJsonContent.getVersion(), parseJsonContent.getMaxSizeLimit(), parseJsonContent.getStartTime(), parseJsonContent.getEndTime(), parseJsonContent.getSpace());
    }
}
