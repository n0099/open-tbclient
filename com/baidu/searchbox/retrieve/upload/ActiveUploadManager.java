package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ActiveUploadManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int KEEP_ALIVE_TIME = 60000;
    public static final String TAG = "FetchLogActive";
    public static volatile ActiveUploadManager sSingleton;
    public ThreadPoolExecutor mActiveExecutor = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    public static ActiveUploadManager getInstance() {
        if (sSingleton == null) {
            synchronized (ActiveUploadManager.class) {
                if (sSingleton == null) {
                    sSingleton = new ActiveUploadManager();
                }
            }
        }
        return sSingleton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statActiveReportData(boolean z, ActiveUpObj activeUpObj) {
        IStatTask iStatTask;
        if (activeUpObj != null && (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) != null) {
            iStatTask.recordActiveUploadData(z, "report", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        }
    }

    public void activeUploadReportContent(@NonNull final ActiveUpObj activeUpObj, final IActiveUploadListener iActiveUploadListener) {
        this.mActiveExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.upload.ActiveUploadManager.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject createActiveReqContent = ContentUtils.createActiveReqContent(activeUpObj);
                if (createActiveReqContent != null) {
                    UploaderProvider.getContentUploader().uploadDataRequestASync("1", createActiveReqContent.toString(), null, new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.retrieve.upload.ActiveUploadManager.1.1
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onFail(Exception exc) {
                            if (ActiveUploadManager.DEBUG) {
                                Log.d(ActiveUploadManager.TAG, "onFail: " + exc.getMessage());
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ActiveUploadManager.this.statActiveReportData(false, activeUpObj);
                            IActiveUploadListener iActiveUploadListener2 = iActiveUploadListener;
                            if (iActiveUploadListener2 != null) {
                                iActiveUploadListener2.onFailure(exc.getMessage());
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public void onSuccess(JSONObject jSONObject, int i) {
                            if (jSONObject != null) {
                                if (TextUtils.equals("0", jSONObject.optString("errno"))) {
                                    if (ActiveUploadManager.DEBUG) {
                                        Log.d(ActiveUploadManager.TAG, "active upload success");
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    ActiveUploadManager.this.statActiveReportData(true, activeUpObj);
                                    IActiveUploadListener iActiveUploadListener2 = iActiveUploadListener;
                                    if (iActiveUploadListener2 != null) {
                                        iActiveUploadListener2.onSuccess();
                                        return;
                                    }
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                ActiveUploadManager.this.statActiveReportData(false, activeUpObj);
                                IActiveUploadListener iActiveUploadListener3 = iActiveUploadListener;
                                if (iActiveUploadListener3 != null) {
                                    iActiveUploadListener3.onFailure(jSONObject.toString());
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.searchbox.http.callback.ResponseCallback
                        public JSONObject parseResponse(Response response, int i) throws Exception {
                            if (response != null && response.body() != null) {
                                String string = response.body().string();
                                if (ActiveUploadManager.DEBUG) {
                                    Log.d(ActiveUploadManager.TAG, "statusCode:" + i + ", response=" + string);
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

    public void activeUploadReportContent(@NonNull ActiveUpObj activeUpObj) {
        activeUploadReportContent(activeUpObj, null);
    }
}
