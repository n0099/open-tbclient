package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.Utility;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.core.data.ConstantData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMGetUserProfileBaiduUidMsg extends Message {
    private static final String TAG = "IMGetUserProfileBaiduUidMsg";
    private long mBuid;
    private Context mContext;
    private int msgtype = 0;
    private int mReSendCount = 0;

    public int getMsgType() {
        return this.msgtype;
    }

    public void setMsgType(int i) {
        this.msgtype = i;
    }

    public IMGetUserProfileBaiduUidMsg(Context context, long j) {
        initCommonParameter(context);
        this.mContext = context;
        this.mBuid = j;
        setNeedReplay(true);
        setType(Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to_user", this.mBuid);
            jSONObject.put("is_https", true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rpc_retry_time", this.mReSendCount);
            jSONObject.put("rpc", jSONObject2.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMGetUserProfileBaiduUidMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("buid")) {
            long longExtra = intent.getLongExtra("buid", -1L);
            int intExtra = intent.getIntExtra(Constants.EXTRA_SAVE_TO_DB, 0);
            if (-1 != longExtra) {
                IMGetUserProfileBaiduUidMsg iMGetUserProfileBaiduUidMsg = new IMGetUserProfileBaiduUidMsg(context, longExtra);
                iMGetUserProfileBaiduUidMsg.setMsgType(intExtra);
                JSONObject jSONObject = new JSONObject();
                if (intExtra == 1) {
                    try {
                        jSONObject.put("type", intExtra);
                    } catch (JSONException e) {
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    }
                    saveCmdMessage(context, iMGetUserProfileBaiduUidMsg, jSONObject.toString(), iMGetUserProfileBaiduUidMsg.getPriority());
                    return iMGetUserProfileBaiduUidMsg;
                }
                return iMGetUserProfileBaiduUidMsg;
            }
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public static IMGetUserProfileBaiduUidMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        long j = new JSONObject(str2).getLong("to_user");
        int optInt = new JSONObject(str3).optInt("type");
        if (-1 != j) {
            IMGetUserProfileBaiduUidMsg iMGetUserProfileBaiduUidMsg = new IMGetUserProfileBaiduUidMsg(context, j);
            iMGetUserProfileBaiduUidMsg.setUUID(str);
            iMGetUserProfileBaiduUidMsg.setMsgType(optInt);
            return iMGetUserProfileBaiduUidMsg;
        }
        return null;
    }

    public long getBuid() {
        return this.mBuid;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        if (getMsgType() == 1) {
            if (i != 0) {
                if (this.mReSendCount >= 3) {
                    setNeedReSend(false);
                    DBManager.getInstance(context).deleteCmdMsg(getUUID());
                } else {
                    this.mReSendCount++;
                    setNeedReSend(true);
                    return;
                }
            } else {
                DBManager.getInstance(context).deleteCmdMsg(getUUID());
                setNeedReSend(false);
            }
        }
        if (i == 0) {
            if (jSONObject.has(ConstantData.VideoLocationType.PERSON_PROFILE)) {
                IMUserManager.getInstance(context).updateUser(Utility.contructChatUserFormUid(jSONObject.optJSONObject(ConstantData.VideoLocationType.PERSON_PROFILE)));
            }
            if (this.msgtype == 1) {
                DBManager.getInstance(this.mContext).deleteCmdMsg(getUUID());
            }
        }
        ChatUserManagerImpl.getInstance(context).onGetUserResultByBuid(context, getMsgType(), getListenerKey(), i, getBuid());
    }
}
