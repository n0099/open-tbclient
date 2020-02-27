package com.baidu.browser.sailor.lightapp;

import android.text.TextUtils;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BdLightappKernelJsCallback implements INoProGuard {
    public static final String ERROR_INFO_KEY = "error_info";
    public static final String ERROR_RESULT_KEY = "error_code";
    public static final int FAIL = 1;
    public static final int FOBIDDEN_PATH = 4;
    public static final int PARAM_ERROR = 2;
    private static final String RESULT_KEY = "result";
    public static final int SUCCESS = 0;
    private static final String TAG = "BdLightappKernalCallback";
    public static final int USER_CANCEL = 3;
    private HashMap<String, String> mAbililtyConfigs;
    private a mCallbackListener;
    private JSONObject mCallbackParam = new JSONObject();
    private String mErrorCallback;
    private String mParam;
    private String mSuccessCallback;

    /* loaded from: classes11.dex */
    public interface a {
        void onCallBack(String str, String str2);
    }

    public BdLightappKernelJsCallback(String str, String str2) {
        this.mSuccessCallback = str;
        this.mErrorCallback = str2;
    }

    public BdLightappKernelJsCallback(String str, String str2, a aVar) {
        this.mSuccessCallback = str;
        this.mErrorCallback = str2;
        this.mCallbackListener = aVar;
    }

    public void addField(String str) {
        if (this.mParam != null) {
            addField(this.mParam, str);
        }
    }

    public void addField(String str, String str2) {
        try {
            this.mCallbackParam.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addField(String str, JSONObject jSONObject) {
        try {
            this.mCallbackParam.put(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getConfigsMap() {
        if (this.mAbililtyConfigs == null) {
            this.mAbililtyConfigs = new HashMap<>();
        }
        return this.mAbililtyConfigs;
    }

    public void handleResult(String str, boolean z) {
        setResult(z);
        if (z) {
            if (str == null) {
                str = "";
            }
            addField(str);
        }
        notifyResult();
    }

    public void notifyCallback(String str, String str2) {
        if (this.mCallbackListener != null) {
            this.mCallbackListener.onCallBack(str, str2);
        }
    }

    public void notifyResult() {
        int i = 0;
        try {
            i = this.mCallbackParam.getInt("result");
        } catch (JSONException e) {
            Log.e(TAG, "result must be set befor notify!!!");
        }
        notifyCallback(i == 0 ? this.mSuccessCallback : this.mErrorCallback, this.mCallbackParam.toString());
    }

    public void sendCallBack(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            addField(str2);
        } else {
            addField(str, str2);
        }
        setResult(z);
        notifyResult();
    }

    public void sendCallBack(String str, JSONObject jSONObject, boolean z) {
        addField(str, jSONObject);
        setResult(z);
        notifyResult();
    }

    public void sendCallBackWithRetCode(int i) {
        try {
            this.mCallbackParam.put("error_code", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setResult(i == 0 ? 0 : 1);
        notifyResult();
    }

    public void sendFailCallBack(String str) {
        sendCallBack(ERROR_INFO_KEY, str, false);
    }

    public void sendSuccCallBack() {
        setResult(true);
        notifyResult();
    }

    public void setCallbackListener(a aVar) {
        this.mCallbackListener = aVar;
    }

    public void setParam(String str) {
        this.mParam = str;
    }

    public void setResult(int i) {
        try {
            this.mCallbackParam.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setResult(boolean z) {
        setResult(z ? 0 : 1);
    }
}
