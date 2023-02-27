package com.baidu.searchbox.retrieve.core;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.upload.FetchResult;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Fetcher {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "Fetcher";
    public static final String UPLOAD_RESULT_VALID = "1";

    public static void statCheckData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordCheckRetrieveData(z, z2, str, str2, str3, str4);
        }
    }

    public static void dispatch(List<IFetchJob> list, JSONObject jSONObject, String str) {
        if (list != null && list.size() != 0) {
            if (DEBUG) {
                Log.d(TAG, "开始分发回捞命令 ");
            }
            boolean z = false;
            for (IFetchJob iFetchJob : list) {
                if (TextUtils.equals(str, iFetchJob.getFetchJobType())) {
                    iFetchJob.dispatch(jSONObject);
                    z = true;
                }
            }
            if (!z) {
                FetchReport.reportDispatch(str, "", "", jSONObject, "2");
                if (DEBUG) {
                    Log.e(TAG, "本地没有注册的type类型 ");
                }
                statDispatchDataFail(str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean process(final JSONObject jSONObject) {
        boolean z;
        synchronized (Fetcher.class) {
            if (jSONObject == null) {
                FetchReport.reportDataNull();
                statCheckData(true, false, "", "", "", "1");
                return false;
            }
            if (DEBUG) {
                Log.d(TAG, "收到回捞命令 " + jSONObject.toString());
            }
            final String optString = jSONObject.optString("type");
            final String optString2 = jSONObject.optString("jobId");
            final String optString3 = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                String optString4 = jSONObject.optString("expiredTime");
                if (!TextUtils.isEmpty(optString4)) {
                    if (System.currentTimeMillis() >= Long.parseLong(optString4) * 1000) {
                        FetchReport.reportDispatch(optString, optString2, optString3, jSONObject, "1");
                        if (DEBUG) {
                            Log.w(TAG, "回捞命令已过期 ");
                        }
                        z = false;
                        if (!z) {
                            statCheckData(true, false, optString2, optString, optString3, "3");
                            return false;
                        }
                    } else {
                        z = true;
                        if (!z) {
                        }
                    }
                }
                statCheckData(true, true, optString2, optString, optString3, "");
                FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(optString, "1", optString2, optString3, "0", "", ""), new IUploadListener() { // from class: com.baidu.searchbox.retrieve.core.Fetcher.1
                    @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                    public void onFailure() {
                        Fetcher.statCheckData(false, false, optString2, optString, optString3, "");
                    }

                    @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                    public void onSuccess(FetchResult fetchResult) {
                        if (fetchResult == null || !TextUtils.equals("1", fetchResult.getValid())) {
                            Fetcher.statCheckData(false, false, optString2, optString, optString3, "");
                            return;
                        }
                        Fetcher.statCheckData(false, true, optString2, optString, optString3, "");
                        Fetcher.dispatch(FetchActions.getInstance().getFetchCommandList(), jSONObject, optString);
                    }
                });
                return true;
            }
            FetchReport.reportDataError(optString, optString2, optString3, jSONObject);
            if (DEBUG) {
                Log.w(TAG, "回捞命令校验错误 " + jSONObject.toString());
            }
            statCheckData(true, false, optString2, optString, optString3, "2");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean processTimerJob(JSONObject jSONObject) {
        boolean z;
        synchronized (Fetcher.class) {
            if (DEBUG) {
                Log.d(TAG, "冷启后继续执行定时上传任务 ：" + jSONObject.toString());
            }
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("jobId");
            String optString3 = jSONObject.optString("version");
            String optString4 = jSONObject.optString("expiredTime");
            if (!TextUtils.isEmpty(optString4)) {
                if (System.currentTimeMillis() >= Long.parseLong(optString4) * 1000) {
                    FetchReport.reportDispatch(optString, optString2, optString3, jSONObject, "1");
                    if (DEBUG) {
                        Log.w(TAG, "定时上传任务命令已过期 : " + optString2);
                    }
                    z = false;
                    if (!z) {
                        statCheckData(true, false, optString2, optString, optString3, "3");
                        return false;
                    }
                } else {
                    z = true;
                    if (!z) {
                    }
                }
            }
            dispatch(FetchActions.getInstance().getFetchCommandList(), jSONObject, optString);
            return true;
        }
    }

    public static void statDispatchDataFail(String str) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordDispatchRetrieveData(false, "", str, "", "1");
        }
    }
}
