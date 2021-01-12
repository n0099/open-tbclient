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
import com.baidu.sapi2.SapiContext;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMSendQuizOptMsg extends Message {
    private static final String TAG = "IMSendQuizOptMsg";
    private int mAnsWer;
    private long mCastId;
    private Context mContext;
    private int mGroup;
    private int mOpCode;
    private String mOptExt;
    private int mQuizId;
    private long mRoomId;
    private long mUid;

    public IMSendQuizOptMsg(Context context, long j, long j2, int i, String str, String str2) {
        this.mContext = context;
        initCommonParameter(context);
        this.mListenerKey = str2;
        this.mCastId = j;
        this.mRoomId = j2;
        this.mOpCode = i;
        this.mOptExt = str;
        setListenerKey(this.mListenerKey);
        setNeedReplay(true);
        setType(210);
    }

    public static IMSendQuizOptMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("mcast_id")) {
            return new IMSendQuizOptMsg(context, intent.getLongExtra("mcast_id", -1L), intent.getLongExtra("room_id", -1L), intent.getIntExtra(Constants.EXTRA_OPT_CODE, -1), intent.getStringExtra(Constants.EXTRA_OPT_EXT), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        long j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 210);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            try {
                j = Long.parseLong(Utility.readUid(this.mContext));
            } catch (Exception e) {
                LogUtils.e(TAG, "bd uid is null");
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                j = 0;
            }
            jSONObject.put("bd_uid", j);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("mcast_id", this.mCastId);
            jSONObject.put("room_id", this.mRoomId);
            jSONObject.put("op_code", this.mOpCode);
            jSONObject.put("op_ext", this.mOptExt);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        long j;
        String str2;
        int i2;
        long j2 = -1;
        if (i == 0) {
            try {
                if (jSONObject.has("msg")) {
                    jSONObject.getString("msg");
                }
                if (jSONObject.has("mcast_id")) {
                    j2 = jSONObject.getLong("mcast_id");
                } else {
                    i = 1015;
                    str = Constants.ERROR_MSG_SERVER_INTERNAL_ERROR;
                }
                j = j2;
                str2 = str;
                i2 = i;
            } catch (Exception e) {
                LogUtils.e(TAG, "handle sendQuizOptMsg exception :", e);
            }
            super.handleMessageResult(context, jSONObject, i2, str2);
            LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
            ConversationStudioManImpl.getInstance(this.mContext).onSendQuizOptsResult(getListenerKey(), i2, str2, j, this.mRoomId);
        }
        j = -1;
        str2 = str;
        i2 = i;
        super.handleMessageResult(context, jSONObject, i2, str2);
        LogUtils.d(TAG, "errorCode:" + i2 + "  strMsg" + str2);
        ConversationStudioManImpl.getInstance(this.mContext).onSendQuizOptsResult(getListenerKey(), i2, str2, j, this.mRoomId);
    }
}
