package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMQuitCastMsg extends Message {
    private Context mContext;
    private String mMsgKey;
    protected long mRowId;
    private long mToUser;

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
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 202);
            jSONObject.put("mcast_id", this.mToUser);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("msg_key", this.mMsgKey);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        String str2;
        int i2;
        long j = -1;
        if (i == 0) {
            McastConfig.mLiveShowing = false;
            if (jSONObject.has("msg")) {
                jSONObject.getString("msg");
            }
            if (jSONObject.has("mcast_id")) {
                j = jSONObject.getLong("mcast_id");
                str2 = str;
                i2 = i;
            } else {
                str2 = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
                i2 = 1015;
            }
        } else {
            str2 = str;
            i2 = i;
        }
        LogUtils.d("IMQuitCastMsg", "errorCode:" + i2 + "  strMsg" + str2);
        McastManagerImpl.getInstance(this.mContext).onQuitCastResult(getListenerKey(), i2, str2, j);
    }
}
