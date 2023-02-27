package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FetchUploadManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FetchUploadManager";
    public static volatile FetchUploadManager sSingleton;
    public ThreadPoolExecutor mContentExecutor = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    public static FetchUploadManager getInstance() {
        if (sSingleton == null) {
            synchronized (FetchUploadManager.class) {
                if (sSingleton == null) {
                    sSingleton = new FetchUploadManager();
                }
            }
        }
        return sSingleton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchReportData(boolean z, FetchTaskObj fetchTaskObj) {
        JSONObject jSONObject;
        if (fetchTaskObj == null || !TextUtils.equals("0", fetchTaskObj.getStatus()) || !TextUtils.equals("4", fetchTaskObj.getValue())) {
            return;
        }
        try {
            jSONObject = new JSONObject(fetchTaskObj.getFileMeta());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            jSONObject = null;
        }
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordUploadRetrieveData("report", z, fetchTaskObj.getJobID(), fetchTaskObj.getType(), fetchTaskObj.getVersion(), "", fetchTaskObj.getFileID(), jSONObject);
        }
    }

    public void uploadReportContent(@NonNull FetchTaskObj fetchTaskObj) {
        uploadReportContent(fetchTaskObj, null);
    }

    public void uploadReportContent(@NonNull final FetchTaskObj fetchTaskObj, final IUploadListener iUploadListener) {
        this.mContentExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.FetchUploadManager.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject createFetchReqContent = ContentUtils.createFetchReqContent(fetchTaskObj);
                if (createFetchReqContent != null) {
                    UploaderProvider.getContentUploader().uploadDataRequestASync("0", createFetchReqContent.toString(), null, new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.retrieve.upload.FetchUploadManager.1.1
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onFail(Exception exc) {
                            if (FetchUploadManager.DEBUG) {
                                Log.d(FetchUploadManager.TAG, "onFail: " + exc.getMessage());
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            FetchUploadManager.this.statFetchReportData(false, fetchTaskObj);
                            IUploadListener iUploadListener2 = iUploadListener;
                            if (iUploadListener2 != null) {
                                iUploadListener2.onFailure();
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onSuccess(JSONObject jSONObject, int i) {
                            IUploadListener iUploadListener2;
                            if (jSONObject != null) {
                                if (TextUtils.equals("0", jSONObject.optString("errno"))) {
                                    FetchResult createResult = ContentUtils.createResult(jSONObject.optJSONObject("data"));
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    FetchUploadManager.this.statFetchReportData(true, fetchTaskObj);
                                    if (createResult != null && (iUploadListener2 = iUploadListener) != null) {
                                        iUploadListener2.onSuccess(createResult);
                                        return;
                                    }
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                FetchUploadManager.this.statFetchReportData(false, fetchTaskObj);
                                IUploadListener iUploadListener3 = iUploadListener;
                                if (iUploadListener3 != null) {
                                    iUploadListener3.onFailure();
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public JSONObject parseResponse(Response response, int i) throws Exception {
                            if (response != null && response.body() != null) {
                                String string = response.body().string();
                                if (FetchUploadManager.DEBUG) {
                                    Log.d(FetchUploadManager.TAG, "statusCode:" + i + ", response=" + string);
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    return new JSONObject(string);
                                }
                                return null;
                            }
                            return null;
                        }
                    });
                }
            }
        });
    }
}
