package com.baidu.android.imsdk.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MessageUbc {
    public static final String EVENT_TYPE = "0";
    public static final String ID_TYPE = "1";
    public static String TAG = "MessageUbc";
    public static final String TYPE = "sendmessage";
    public Context mContext;
    public long mEndTime;
    public ChatMsg mSendMsg;
    public long mStartTime = System.currentTimeMillis();
    public String mUbcId;

    public MessageUbc(Context context, ChatMsg chatMsg, String str) {
        this.mContext = context;
        this.mSendMsg = chatMsg;
        this.mUbcId = str;
    }

    private JSONObject generateContent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (this.mSendMsg != null && this.mStartTime > 0) {
            try {
                jSONObject.put("type", TYPE);
                jSONObject.put("value", str);
                JSONObject generateExt = generateExt(str, str2);
                if (generateExt != null) {
                    jSONObject.put("ext", generateExt);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    private JSONObject generateDebugInfo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        ChatMsg chatMsg = this.mSendMsg;
        if (chatMsg != null) {
            try {
                jSONObject.put("sendmsg", chatMsg.toJsonString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    private JSONObject generateExt(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (this.mSendMsg != null) {
            try {
                jSONObject.put("role", AccountManager.getMediaRole(this.mContext) ? "2" : "1");
                jSONObject.put("package_name", RetrieveReportRequest.APP_NAME);
                jSONObject.put("appid", String.valueOf(AccountManager.getAppid(this.mContext)));
                jSONObject.put("starttime", String.valueOf(this.mStartTime));
                jSONObject.put("endtime", String.valueOf(this.mEndTime));
                jSONObject.put("cost_time", String.valueOf(this.mEndTime - this.mStartTime));
                jSONObject.put("error_code", str);
                jSONObject.put("error_msg", str2);
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext)));
                jSONObject.put("res_type", String.valueOf(this.mSendMsg.getMsgType()));
                jSONObject.put("isgroup", String.valueOf(this.mSendMsg.getCategory()));
                if (!"0".equals(str)) {
                    jSONObject.put("debug_info", generateDebugInfo(str, str2));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONArray generateUBCData(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        this.mEndTime = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (this.mSendMsg != null && !TextUtils.isEmpty(this.mUbcId)) {
            try {
                jSONObject.put("id", this.mUbcId);
                jSONObject.put("timestamp", String.valueOf(this.mStartTime));
                jSONObject.put(Constant.ID_TYPE, "1");
                jSONObject.put("type", "0");
                JSONObject generateContent = generateContent(str, str2);
                if (generateContent == null) {
                    return null;
                }
                jSONObject.put("content", generateContent);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String str3 = TAG;
        LogUtils.d(str3, "generateUBCData:" + jSONObject.toString());
        if (jSONObject.length() > 0) {
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
