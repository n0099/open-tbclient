package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Heartbeat;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMJoinCastMsg extends Message {
    private Context mContext;
    private String mMsgKey;
    protected long mRowId;
    private long mToUser;

    public IMJoinCastMsg(Context context, long j, String str) {
        this.mContext = context;
        initCommonParameter(context);
        this.mMsgKey = str;
        this.mToUser = j;
        setNeedReplay(true);
        setType(201);
    }

    public static IMJoinCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 201);
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
        long j = -1;
        if (i == 0) {
            McastConfig.mLiveShowing = true;
            if (jSONObject.has("msg")) {
                jSONObject.getString("msg");
            }
            if (jSONObject.has("mcast_id")) {
                j = jSONObject.getLong("mcast_id");
                LogUtils.d("fxf", " cast id is" + j);
            } else {
                i = 1015;
                str = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
            }
            if (jSONObject.has("ping_interval")) {
                int optInt = jSONObject.optInt("ping_interval", 120000);
                if (optInt > 0) {
                    Heartbeat.ALARM_TIMEOUT = optInt * 1000;
                } else {
                    Heartbeat.ALARM_TIMEOUT = 30000;
                }
            } else {
                Heartbeat.ALARM_TIMEOUT = 120000;
            }
            McastManagerImpl.getInstance(this.mContext);
            McastManagerImpl.resetHeartBeat(Heartbeat.ALARM_TIMEOUT);
        }
        String str2 = str;
        int i2 = i;
        LogUtils.d("IMJoinCastMsg", " obj=" + jSONObject.toString());
        LogUtils.d("IMJoinCastMsg", "errorCode:" + i2 + "  strMsg" + str2);
        McastManagerImpl.getInstance(this.mContext).onJoinCastResult(getListenerKey(), i2, str2, j);
    }
}
