package com.baidu.searchbox.retrieve.stats.service;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class StatTaskManager {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "FetchStatManager";
    public static volatile StatTaskManager mInstance;
    public UBCManager mUBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    public static StatTaskManager getInstance() {
        if (mInstance == null) {
            synchronized (StatTaskManager.class) {
                if (mInstance == null) {
                    mInstance = new StatTaskManager();
                }
            }
        }
        return mInstance;
    }

    private JSONObject generateActiveExtData(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("dataId", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(StatConstants.KEY_EXT_TASK_TYPE, str2);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    private JSONObject generateRetrieveExtData(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("jobId", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put(StatConstants.KEY_EXT_TASK_TYPE, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("version", str3);
            }
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject3.put(StatConstants.KEY_EXT_ERR_CODE, str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject3.put(StatConstants.KEY_EXT_ERR_MSG, str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject3.put(StatConstants.KEY_EXT_FILE_ID, str6);
            }
            if (jSONObject != null) {
                jSONObject3.put("fileMeta", jSONObject);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("detail", jSONObject3);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (jSONObject2.length() > 0) {
            return jSONObject2;
        }
        return null;
    }

    private void recordRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, JSONObject jSONObject) {
        if (this.mUBCManager == null) {
            return;
        }
        recordUBCData(StatConstants.STAT_RETRIEVE_ID, StatConstants.VALUE_FROM_RETRIEVE, str, null, z, generateRetrieveExtData(str2, str3, str4, str5, str6, str7, jSONObject));
    }

    private void recordUBCData(String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str2);
            jSONObject2.put("type", str3);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("page", str4);
            }
            if (z) {
                jSONObject2.put("value", "1");
            } else {
                jSONObject2.put("value", "0");
            }
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (DEBUG) {
            Log.d(TAG, "id: " + str + ", content: " + jSONObject2.toString());
        }
        this.mUBCManager.onEvent(str, jSONObject2);
    }

    public void recordCheckRetrieveData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        if (this.mUBCManager == null) {
            return;
        }
        String str5 = StatConstants.VALUE_TYPE_CLIENT_CHECK;
        String str6 = "";
        if (!z) {
            str5 = StatConstants.VALUE_TYPE_SERVER_CHECK;
        } else if (!z2) {
            char c = 65535;
            switch (str4.hashCode()) {
                case 49:
                    if (str4.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str4.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str4.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        str6 = StatConstants.ERR_MSG_CLIENT_CHECK_EXPIRED;
                    }
                } else {
                    str6 = StatConstants.ERR_MSG_CLIENT_CHECK_WRONG;
                }
            } else {
                str6 = StatConstants.ERR_MSG_CLIENT_CHECK_EMPTY;
            }
        }
        recordRetrieveData(str5, z2, str, str2, str3, str4, str6, "", null);
    }

    public void recordActiveUploadData(boolean z, String str, String str2, String str3, String str4) {
        if (this.mUBCManager == null) {
            return;
        }
        recordUBCData(StatConstants.STAT_ACTIVE_ID, StatConstants.VALUE_FROM_AC_UPLOAD, str, str4, z, generateActiveExtData(str2, str3));
    }

    public void recordDispatchRetrieveData(boolean z, String str, String str2, String str3, String str4) {
        String str5;
        if (this.mUBCManager == null) {
            return;
        }
        if (!z) {
            char c = 65535;
            int hashCode = str4.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str4.equals("2")) {
                    c = 1;
                }
            } else if (str4.equals("1")) {
                c = 0;
            }
            if (c != 0) {
                if (c == 1) {
                    str5 = StatConstants.ERR_MSG_DISPATCH_NET_WRONG;
                }
            } else {
                str5 = StatConstants.ERR_MSG_DISPATCH_NOT_REGISTER;
            }
            recordRetrieveData(StatConstants.VALUE_TYPE_DISPATCH, z, str, str2, str3, str4, str5, "", null);
        }
        str5 = "";
        recordRetrieveData(StatConstants.VALUE_TYPE_DISPATCH, z, str, str2, str3, str4, str5, "", null);
    }

    public void recordReceiveRetrieveData(boolean z) {
        if (this.mUBCManager == null) {
            return;
        }
        recordRetrieveData(StatConstants.VALUE_TYPE_RECEIVE, z, "", "", "", "", "", "", null);
    }

    public void recordUploadRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        if (this.mUBCManager == null) {
            return;
        }
        recordRetrieveData(str, z, str2, str3, str4, "", str5, str6, jSONObject);
    }
}
