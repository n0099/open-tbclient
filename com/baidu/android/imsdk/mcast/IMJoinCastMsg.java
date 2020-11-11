package com.baidu.android.imsdk.mcast;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Heartbeat;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.a;
import com.baidu.sapi2.SapiContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMJoinCastMsg extends Message {
    private static final String TAG = "IMJoinCastMsg";
    private Context mContext;
    private boolean mIsReliable;
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

    public IMJoinCastMsg(Context context, long j, String str, boolean z) {
        this(context, j, str);
        this.mIsReliable = z;
    }

    public static IMJoinCastMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMJoinCastMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getStringExtra(Constants.EXTRA_LISTENER_ID), intent.getBooleanExtra(Constants.EXTRA_OPT_EXT, false));
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
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("is_reliable", this.mIsReliable);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010a  */
    @Override // com.baidu.android.imsdk.request.Message
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Exception e;
        String str2;
        int i2;
        long j;
        long j2 = -1;
        if (i != 0) {
            j = -1;
            str2 = str;
            i2 = i;
        } else {
            try {
                if (jSONObject.has("msg")) {
                    jSONObject.getString("msg");
                }
                if (jSONObject.has("mcast_id")) {
                    long j3 = jSONObject.getLong("mcast_id");
                    try {
                        LogUtils.d("fxf", " cast id is" + j3);
                        j2 = j3;
                        str2 = str;
                        i2 = i;
                    } catch (Exception e2) {
                        e = e2;
                        j2 = j3;
                        str2 = str;
                        i2 = i;
                        LogUtils.e(TAG, "handle IMQuitCastMsg exception :", e);
                        j = j2;
                        LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
                        ConversationStudioManImpl conversationStudioManImpl = ConversationStudioManImpl.getInstance(this.mContext);
                        String listenerKey = getListenerKey();
                        if (j <= 0) {
                        }
                        conversationStudioManImpl.onJoinCastResult(listenerKey, i2, str2, j);
                    }
                } else {
                    str2 = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
                    i2 = 1015;
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str;
                i2 = i;
            }
            try {
                if (jSONObject.has("ping_interval")) {
                    int optInt = jSONObject.optInt("ping_interval", 60000);
                    if (optInt > 0) {
                        Heartbeat.ALARM_TIMEOUT = optInt * 1000;
                        if (a.azB) {
                            ConversationStudioManImpl.mCastHeartBeatTime = optInt;
                        }
                    } else {
                        Heartbeat.ALARM_TIMEOUT = 30000;
                    }
                } else {
                    Heartbeat.ALARM_TIMEOUT = 60000;
                }
                ConversationStudioManImpl.getInstance(this.mContext);
                ConversationStudioManImpl.resetHeartBeat(Heartbeat.ALARM_TIMEOUT);
                if (jSONObject.has("ack_enable")) {
                    if (jSONObject.optInt("ack_enable", 0) == 1) {
                        ConversationStudioManImpl.getInstance(this.mContext).addAckCastId(j2);
                    } else {
                        ConversationStudioManImpl.getInstance(this.mContext).removeAckCastId(j2);
                    }
                }
                LogUtils.d(TAG, " obj=" + jSONObject.toString());
                j = j2;
            } catch (Exception e4) {
                e = e4;
                LogUtils.e(TAG, "handle IMQuitCastMsg exception :", e);
                j = j2;
                LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
                ConversationStudioManImpl conversationStudioManImpl2 = ConversationStudioManImpl.getInstance(this.mContext);
                String listenerKey2 = getListenerKey();
                if (j <= 0) {
                }
                conversationStudioManImpl2.onJoinCastResult(listenerKey2, i2, str2, j);
            }
        }
        LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
        ConversationStudioManImpl conversationStudioManImpl22 = ConversationStudioManImpl.getInstance(this.mContext);
        String listenerKey22 = getListenerKey();
        if (j <= 0) {
            j = this.mToUser;
        }
        conversationStudioManImpl22.onJoinCastResult(listenerKey22, i2, str2, j);
    }
}
