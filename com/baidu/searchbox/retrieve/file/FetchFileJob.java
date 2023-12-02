package com.baidu.searchbox.retrieve.file;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.bean.FetchFileData;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.searchbox.retrieve.inter.IFetchJob;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.upload.FetchResult;
import com.baidu.searchbox.retrieve.upload.FetchTaskObj;
import com.baidu.searchbox.retrieve.upload.FetchUploadManager;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import com.baidu.tieba.gzb;
import com.baidu.tieba.hzb;
import com.baidu.tieba.jzb;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class FetchFileJob extends IFetchJob {
    public static final String BIZ_TYPE = "fetchlog";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchFileJob";
    public static final String UPLOAD_RESULT_VALID = "1";

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public String getFetchJobType() {
        return "file";
    }

    public static void statDispatchData(FetchFileData.FetchBean fetchBean) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordDispatchRetrieveData(true, fetchBean.mJobId, fetchBean.mType, fetchBean.mVersion, "");
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.IFetchJob
    public void dispatch(final JSONObject jSONObject) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.1
            @Override // java.lang.Runnable
            public void run() {
                final FetchFileData.FetchBean parseJsonContent = FetchFileData.parseJsonContent(jSONObject);
                if (parseJsonContent == null) {
                    return;
                }
                if (FetchFileJob.DEBUG) {
                    Log.i(FetchFileJob.TAG, "文件回捞收到命令 " + jSONObject);
                }
                FetchFileJob.statDispatchData(parseJsonContent);
                FetchUploadManager.getInstance().uploadReportContent(new FetchTaskObj(parseJsonContent.mType, "3", parseJsonContent.mJobId, parseJsonContent.mVersion, "", "", ""), new IUploadListener() { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.1.1
                    @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                    public void onFailure() {
                        FetchFileJob.this.statFetchData("start", false, parseJsonContent, StatConstants.ERR_MSG_START_FAIL, "", null);
                    }

                    @Override // com.baidu.searchbox.retrieve.upload.IUploadListener
                    public void onSuccess(FetchResult fetchResult) {
                        if (fetchResult == null || !TextUtils.equals("1", fetchResult.getValid())) {
                            FetchFileJob.this.statFetchData("start", false, parseJsonContent, StatConstants.ERR_MSG_START_FAIL, "", null);
                            return;
                        }
                        FetchFileJob.this.statFetchData("start", true, parseJsonContent, "", "", null);
                        FetchFileJob.this.startFetchFile(parseJsonContent);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchData(String str, boolean z, FetchFileData.FetchBean fetchBean, String str2, String str3, JSONObject jSONObject) {
        IStatTask iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE);
        if (iStatTask != null) {
            iStatTask.recordUploadRetrieveData(str, z, fetchBean.mJobId, fetchBean.mType, fetchBean.mVersion, str2, str3, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTaskDone(FetchFileData.FetchBean fetchBean, String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        if (fetchBean == null) {
            return;
        }
        if ("0".equals(str2)) {
            FetchTaskManager.getInstance().clearOriginData();
            FetchTaskManager.getInstance().saveRetryCount(0);
        }
        IFetchTask iFetchTask = (IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE);
        String str3 = fetchBean.mType;
        String str4 = fetchBean.mJobId;
        String str5 = fetchBean.mVersion;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        iFetchTask.reportTaskDone(str3, str4, str5, str2, str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFetchFile(final FetchFileData.FetchBean fetchBean) {
        List<String> list = fetchBean.mPathList;
        if (list != null && list.size() != 0) {
            statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, true, fetchBean, "", "", null);
            hzb hzbVar = (hzb) ServiceManager.getService(hzb.a);
            if (hzbVar == null) {
                if (DEBUG) {
                    Log.d(TAG, "loss voyager impl component");
                    return;
                }
                return;
            }
            hzbVar.g(list, "fetchlog", fetchBean.mMaxFileSize * 1024, new gzb() { // from class: com.baidu.searchbox.retrieve.file.FetchFileJob.2
                @Override // com.baidu.tieba.gzb
                public void onFailure(String str, JSONObject jSONObject) {
                    FetchFileJob.this.statFetchFileData(false, fetchBean, str, "", jSONObject);
                    if (!TextUtils.equals("dir not found", str)) {
                        FetchFileJob fetchFileJob = FetchFileJob.this;
                        FetchFileData.FetchBean fetchBean2 = fetchBean;
                        jzb.a(jSONObject, str);
                        fetchFileJob.reportTaskDone(fetchBean2, "", "2", jSONObject);
                        return;
                    }
                    FetchFileJob.this.reportTaskDone(fetchBean, "", "1", jSONObject);
                }

                @Override // com.baidu.tieba.gzb
                public void onSuccess(String str, JSONObject jSONObject) {
                    FetchFileJob.this.statFetchFileData(true, fetchBean, "", str, jSONObject);
                    FetchFileJob.this.reportTaskDone(fetchBean, str, "0", jSONObject);
                }
            });
            return;
        }
        statFetchData(StatConstants.VALUE_TYPE_CHECK_PARAM, false, fetchBean, StatConstants.ERR_MSG_CHECK_PARAM_FAIL, "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statFetchFileData(boolean z, FetchFileData.FetchBean fetchBean, String str, String str2, JSONObject jSONObject) {
        if (z) {
            statFetchData("query", true, fetchBean, "", "", jSONObject);
            statFetchData("zip", true, fetchBean, "", "", jSONObject);
            statFetchData("upload", true, fetchBean, "", str2, jSONObject);
        } else if (TextUtils.equals("dir not found", str)) {
            statFetchData("query", false, fetchBean, str, "", jSONObject);
        } else if (TextUtils.equals("zip failed", str)) {
            statFetchData("query", true, fetchBean, "", "", jSONObject);
            statFetchData("zip", false, fetchBean, str, "", jSONObject);
        } else {
            statFetchData("query", true, fetchBean, "", "", jSONObject);
            statFetchData("zip", true, fetchBean, "", "", jSONObject);
            statFetchData("upload", false, fetchBean, str, "", jSONObject);
        }
    }
}
