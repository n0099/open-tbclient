package com.baidu.searchbox.retrieve.timer;

import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerCancel;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerCancelBean;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class FetchTimerCancelJob extends IFetchJob {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchTimerCancelJob";

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        return Constants.FetchType.FETCH_TIMER_CANCEL_TYPE;
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchTimerCancelBean parseJsonContent = FetchTimerCancel.parseJsonContent(jSONObject);
        if (parseJsonContent == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到取消命令 " + jSONObject);
        }
        String cancelJobId = parseJsonContent.getCancelJobId();
        if (FetchTimerList.getInstance().hasJob(cancelJobId)) {
            if (DEBUG) {
                Log.i(TAG, "周期性定时回捞任务取消 ：" + cancelJobId);
            }
            FetchTimerList.getInstance().removeJob(cancelJobId);
            FetchTaskManager.getInstance().removeOriginTimerData(cancelJobId);
        }
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskDone(parseJsonContent.getType(), parseJsonContent.getJobId(), parseJsonContent.getVersion(), "0", "", "");
    }
}
