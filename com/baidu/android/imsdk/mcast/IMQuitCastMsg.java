package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMQuitCastMsg extends Message {
    public static final String TAG = "IMQuitCastMsg";
    public Context mContext;
    public String mMsgKey;
    public long mRowId;
    public long mToUser;

    public IMQuitCastMsg(Context context, long j, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mMsgKey = str;
        this.mToUser = j;
        setNeedReplay(true);
        setType(202);
    }

    public static IMQuitCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMQuitCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 202);
            jSONObject.put("mcast_id", this.mToUser);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("msg_key", this.mMsgKey);
            jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(IMQuitCastMsg.class.getSimpleName(), "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        long j = -1;
        if (i == 0) {
            try {
                if (jSONObject.has("msg")) {
                    jSONObject.getString("msg");
                }
                if (jSONObject.has("mcast_id")) {
                    j = jSONObject.getLong("mcast_id");
                } else {
                    i = 1015;
                    str = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
                }
                if (j > 0) {
                    LogUtils.d(TAG, "quit 直播间，castid信息：" + j);
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "handle IMQuitCastMsg exception :", e2);
            }
        }
        int i2 = i;
        String str2 = str;
        super.handleMessageResult(context, jSONObject, i2, str2);
        LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
        ConversationStudioManImpl.getInstance(this.mContext).onQuitCastResult(getListenerKey(), i2, str2, j);
    }
}
