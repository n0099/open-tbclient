package com.baidu.searchbox.retrieve.timer;

import android.os.Handler;
import android.util.Log;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IUploadTask;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimer;
import com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class FetchTimerJob extends IFetchJob {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchTimerJob";
    public Handler mHandler;

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        return Constants.FetchType.FETCH_TIMER_TYPE;
    }

    /* loaded from: classes2.dex */
    public static class TimerJobRunnable implements Runnable {
        public final Handler mHandler;
        public final FetchTimerBean mTimerBean;

        public TimerJobRunnable(FetchTimerBean fetchTimerBean, Handler handler) {
            this.mTimerBean = fetchTimerBean;
            this.mHandler = handler;
        }

        private void statDispatchData(boolean z, FetchTimerBean fetchTimerBean, String str) {
            IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
            if (iStatTask != null) {
                iStatTask.recordDispatchRetrieveData(z, fetchTimerBean.getJobId(), fetchTimerBean.getType(), fetchTimerBean.getVersion(), str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if ("1".equals(this.mTimerBean.getNetwork()) && !NetWorkUtils.NetType.WIFI.equals(NetWorkUtils.getNetworkType())) {
                statDispatchData(false, this.mTimerBean, "2");
                this.mHandler.postDelayed(this, TimeUnit.MINUTES.toMillis(this.mTimerBean.getFrequency()));
                return;
            }
            String jobId = this.mTimerBean.getJobId();
            if (!FetchTimerList.getInstance().hasJob(jobId)) {
                this.mHandler.removeCallbacks(this);
                FetchTaskManager.getInstance().removeOriginTimerData(jobId);
            }
            if (System.currentTimeMillis() > this.mTimerBean.getExpiredTime()) {
                this.mHandler.removeCallbacks(this);
                FetchTaskManager.getInstance().removeOriginTimerData(jobId);
            }
            statDispatchData(true, this.mTimerBean, "");
            ((IUploadTask) ServiceManager.getService(IUploadTask.SERVICE_REFERENCE)).activeUploadSnapShot(this.mTimerBean.getType(), this.mTimerBean.getJobId(), this.mTimerBean.getSpace(), this.mTimerBean.getMaxTotalFileSize(), this.mTimerBean.getStartTime(), this.mTimerBean.getEndTime(), true, new IActiveUploadListener() { // from class: com.baidu.searchbox.retrieve.timer.FetchTimerJob.TimerJobRunnable.1
                @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                public void onFailure(String str) {
                    if (FetchTimerJob.DEBUG) {
                        Log.i(FetchTimerJob.TAG, "周期性定时任务上传失败 jobId ：" + TimerJobRunnable.this.mTimerBean.getJobId() + " ;error :" + str);
                    }
                }

                @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                public void onSuccess() {
                    if (FetchTimerJob.DEBUG) {
                        Log.i(FetchTimerJob.TAG, "周期性定时任务上传成功 jobId ：" + TimerJobRunnable.this.mTimerBean.getJobId());
                    }
                }
            });
            this.mHandler.postDelayed(this, TimeUnit.MINUTES.toMillis(this.mTimerBean.getFrequency()));
        }
    }

    private void startJob(FetchTimerBean fetchTimerBean) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(AppRuntime.getAppContext().getMainLooper());
        }
        this.mHandler.post(new TimerJobRunnable(fetchTimerBean, this.mHandler));
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskDone(fetchTimerBean.getType(), fetchTimerBean.getJobId(), fetchTimerBean.getVersion(), "0", "", "");
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(JSONObject jSONObject) {
        FetchTimerBean parseJsonContent = FetchTimer.parseJsonContent(jSONObject);
        if (parseJsonContent == null) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "日志回捞收到命令 " + jSONObject);
        }
        String jobId = parseJsonContent.getJobId();
        if (FetchTimerList.getInstance().hasJob(jobId)) {
            if (DEBUG) {
                Log.i(TAG, "周期性定时回捞任务已存在 ：" + jobId);
                return;
            }
            return;
        }
        FetchTimerList.getInstance().addJob(jobId);
        startJob(parseJsonContent);
    }
}
