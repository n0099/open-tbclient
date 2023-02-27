package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.retrieve.inter.statistics.IStatTask;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.tieba.p3a;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes2.dex */
public class AcUploadResultObserver implements p3a {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchAcUploadResult";
    public static final String TYPE_ACTIVE_UPLOAD = "acupload";
    public ActiveUploadObserver mActiveUploadObserver;

    @Override // com.baidu.tieba.p3a
    public String getBizType() {
        return "acupload";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchActiveResult(boolean z, String str, String str2, JSONObject jSONObject) {
        if (this.mActiveUploadObserver == null) {
            this.mActiveUploadObserver = new ActiveUploadObserver();
        }
        List<IActiveUploadResult> list = this.mActiveUploadObserver.mActiveObserverList.getList();
        if (list != null && list.size() != 0) {
            for (IActiveUploadResult iActiveUploadResult : list) {
                if (TextUtils.equals(iActiveUploadResult.getSource(), str)) {
                    if (z) {
                        iActiveUploadResult.onSuccess(str2, jSONObject);
                    } else {
                        iActiveUploadResult.onFailure(str2, jSONObject);
                    }
                }
            }
        }
    }

    private void statActiveUploadData(boolean z, ActiveUpObj activeUpObj, String str) {
        IStatTask iStatTask;
        if (activeUpObj == null || (iStatTask = (IStatTask) ServiceManager.getService(IStatTask.SERVICE_REFERENCE)) == null) {
            return;
        }
        String fileType = activeUpObj.getFileType();
        if (TextUtils.isEmpty(fileType)) {
            return;
        }
        if (TextUtils.equals(fileType, "1")) {
            iStatTask.recordActiveUploadData(z, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else if (z) {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), fileType);
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), fileType);
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), fileType);
        } else if (TextUtils.equals("dir not found", str)) {
            iStatTask.recordActiveUploadData(false, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else if (TextUtils.equals("zip failed", str)) {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(false, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        } else {
            iStatTask.recordActiveUploadData(true, "query", activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(true, StatConstants.VALUE_TYPE_ZIP, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
            iStatTask.recordActiveUploadData(false, StatConstants.VALUE_TYPE_UPLOAD, activeUpObj.getDataId(), activeUpObj.getType(), activeUpObj.getFileType());
        }
    }

    @Override // com.baidu.tieba.p3a
    public void onReceiveResult(boolean z, String str, final String str2, JSONObject jSONObject, final JSONObject jSONObject2) {
        String jSONObject3;
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            String optString = jSONObject2.optString("type");
            final String optString2 = jSONObject2.optString("source");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = optString;
            }
            String optString3 = jSONObject2.optString("dataId");
            List asList = Arrays.asList(jSONObject2.optString("space"));
            String optString4 = jSONObject2.optString(UploadConstant.KEY_FILE_TYPE);
            if (jSONObject == null) {
                jSONObject3 = "";
            } else {
                jSONObject3 = jSONObject.toString();
            }
            ActiveUpObj activeUpObj = new ActiveUpObj(optString, optString3, asList, jSONObject3);
            activeUpObj.setFileType(optString4);
            if (z) {
                if (DEBUG) {
                    Log.d(TAG, str + " has received active upload success");
                }
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(str2)) {
                    activeUpObj.setFileID(str2);
                    statActiveUploadData(true, activeUpObj, "");
                    ActiveUploadManager.getInstance().activeUploadReportContent(activeUpObj, new IActiveUploadListener() { // from class: com.baidu.searchbox.retrieve.upload.AcUploadResultObserver.1
                        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                        public void onFailure(String str3) {
                            if (AcUploadResultObserver.DEBUG) {
                                Log.d(AcUploadResultObserver.TAG, "active upload file, success: but failed to report to performance platform. errMsg is :" + str3);
                            }
                            AcUploadResultObserver.this.dispatchActiveResult(false, optString2, str2, jSONObject2);
                        }

                        @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener
                        public void onSuccess() {
                            if (AcUploadResultObserver.DEBUG) {
                                Log.d(AcUploadResultObserver.TAG, "active upload success: has reported to performance platform. ");
                            }
                            AcUploadResultObserver.this.dispatchActiveResult(true, optString2, str2, jSONObject2);
                        }
                    });
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "Active upload failed");
            }
            statActiveUploadData(false, activeUpObj, str2);
            dispatchActiveResult(false, optString2, str2, jSONObject2);
        } else if (DEBUG) {
            Log.d(TAG, "Active upload result: " + z + ", bizType: " + str);
        }
    }
}
