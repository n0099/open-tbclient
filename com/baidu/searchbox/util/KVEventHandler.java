package com.baidu.searchbox.util;

import android.text.TextUtils;
import com.baidu.android.util.KVStorageRuntime;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.lr1;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class KVEventHandler extends lr1 {
    public static final String KV_ERROR_UPLOAD_TASK_NAME = "uploadKVFailEvent";
    public static final String TAG = "KVEventHandler";
    public static final String UBC_FILE_NAME_KEY = "file_name";
    public static final String UBC_FILE_SIZE_KEY = "file_size";
    public static final String UBC_ID_KV_ERROR_EVENT = "3837";
    public static final String UBC_KEY_KEY = "key";
    public static final String UBC_LEFT_SPACE_KEY = "left_space";
    public static UBCManager sUbcManager;
    public int mCheckCrcFailUploadTime = 9;
    public int mWriteFailUploadTime = 9;
    public int mExpansionFailUploadTime = 9;

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticEvent(int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 4) {
                    int i2 = this.mExpansionFailUploadTime;
                    if (i2 < 0) {
                        return;
                    }
                    this.mExpansionFailUploadTime = i2 - 1;
                }
            } else {
                int i3 = this.mWriteFailUploadTime;
                if (i3 < 0) {
                    return;
                }
                this.mWriteFailUploadTime = i3 - 1;
            }
        } else {
            int i4 = this.mCheckCrcFailUploadTime;
            if (i4 < 0) {
                return;
            }
            this.mCheckCrcFailUploadTime = i4 - 1;
        }
        if (sUbcManager == null) {
            sUbcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", String.valueOf(i));
            jSONObject.put("file_name", str);
            if (i == 2) {
                jSONObject.put("key", str2);
            }
            if (i == 4) {
                JSONObject jSONObject2 = new JSONObject();
                int length = (int) (SwanKV.getSwanKVFileByName(AppRuntime.getAppContext(), str, KVStorageRuntime.getKVStorageControl().getKVStoragePath()).length() / 1024);
                jSONObject2.put(UBC_LEFT_SPACE_KEY, String.valueOf((int) ((StorageUtils.getAvailableExternalMemorySize() / 1024) / 1024)));
                jSONObject2.put("file_size", String.valueOf(length));
                jSONObject.put("ext", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        sUbcManager.onEvent(UBC_ID_KV_ERROR_EVENT, jSONObject);
    }

    @Override // com.baidu.tieba.lr1
    public void onKVCatchError(final int i, final String str, final String str2) {
        super.onKVCatchError(i, str, str2);
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.util.KVEventHandler.1
            @Override // java.lang.Runnable
            public void run() {
                KVEventHandler.this.statisticEvent(i, str, str2);
            }
        }, KV_ERROR_UPLOAD_TASK_NAME, 3);
    }
}
