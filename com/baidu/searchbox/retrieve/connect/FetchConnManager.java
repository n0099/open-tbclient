package com.baidu.searchbox.retrieve.connect;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.core.Fetcher;
import com.baidu.searchbox.retrieve.file.util.Constants;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.log.FetchLogJob;
import com.baidu.searchbox.retrieve.timer.FetchTimerJob;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FetchConnManager {
    public static final String ACTION_FETCH_LOG_NOTICE = "fetch_log_notice";
    public static final String DATA = "data";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY = "api";
    public static final int RETRY_COUNT = 3;
    public static final long RETRY_DELAY = 30000;
    public static volatile FetchConnManager sSingleton;
    public Context mContext;
    public Handler mMainHandler;

    @Deprecated
    public void registerFetchReceiveListener() {
    }

    public static FetchConnManager getInstance() {
        if (sSingleton == null) {
            synchronized (FetchConnManager.class) {
                if (sSingleton == null) {
                    sSingleton = new FetchConnManager(AppRuntime.getAppContext());
                }
            }
        }
        return sSingleton;
    }

    public synchronized void init() {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.searchbox.retrieve.connect.FetchConnManager.1
            @Override // java.lang.Runnable
            public void run() {
                FetchConnManager.this.checkRetryFetch();
            }
        }, 30000L);
    }

    public synchronized void release() {
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.mMainHandler = null;
        sSingleton = null;
    }

    public FetchConnManager(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private void statReceiveData(boolean z) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordReceiveRetrieveData(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRetryFetch() {
        String originData = FetchTaskManager.getInstance().getOriginData();
        int retryCount = FetchTaskManager.getInstance().getRetryCount();
        if (DEBUG) {
            Log.i(FetchLogJob.TAG, "FetchLogJob retry originData " + originData);
            Log.i(FetchLogJob.TAG, "FetchLogJob retry retryCount " + retryCount);
        }
        if (!TextUtils.isEmpty(originData) && retryCount <= 3) {
            FetchTaskManager.getInstance().saveRetryCount(retryCount + 1);
            try {
                Fetcher.process(new JSONObject(originData));
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        List<JSONObject> allOriginTimerData = FetchTaskManager.getInstance().getAllOriginTimerData();
        if (allOriginTimerData != null && allOriginTimerData.size() > 0) {
            for (JSONObject jSONObject : allOriginTimerData) {
                if (DEBUG) {
                    Log.i(FetchTimerJob.TAG, "FetchTimerJob continue originData " + jSONObject);
                }
                if (!Fetcher.processTimerJob(jSONObject)) {
                    FetchTaskManager.getInstance().removeOriginTimerData(jSONObject.optString("jobId"));
                }
            }
        }
    }

    public void dispatch(JSONObject jSONObject) {
        if (jSONObject == null) {
            statReceiveData(false);
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("jobId");
        if (Constants.FetchType.isTimerType(optString)) {
            FetchTaskManager.getInstance().saveOriginTimerData(optString2, jSONObject);
        } else if (!Constants.FetchType.isCancelType(optString)) {
            FetchTaskManager.getInstance().saveOriginData(jSONObject.toString());
            FetchTaskManager.getInstance().saveRetryCount(0);
        }
        statReceiveData(true);
        if (!Fetcher.process(jSONObject) && Constants.FetchType.isTimerType(optString)) {
            FetchTaskManager.getInstance().removeOriginTimerData(optString2);
        }
    }
}
