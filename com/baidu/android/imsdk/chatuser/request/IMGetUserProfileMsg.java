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
/* loaded from: classes6.dex */
public class IMGetUserProfileMsg extends Message {
    private static final String TAG = "IMGetUserProfileMsg";
    private Context mContext;
    private long mToUser;
    private int msgtype = 0;
    private int mReSendCount = 0;

    public int getMsgType() {
        return this.msgtype;
    }

    public void setMsgType(int i) {
        this.msgtype = i;
    }

    public IMGetUserProfileMsg(Context context, long j) {
        initCommonParameter(context);
        this.mContext = context;
        this.mToUser = j;
        setNeedReplay(true);
        setType(70);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 70);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to_user", this.mToUser);
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

    public static IMGetUserProfileMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("uid")) {
            long longExtra = intent.getLongExtra("uid", -1L);
            int intExtra = intent.getIntExtra(Constants.EXTRA_SAVE_TO_DB, 0);
            if (-1 != longExtra) {
                IMGetUserProfileMsg iMGetUserProfileMsg = new IMGetUserProfileMsg(context, longExtra);
                iMGetUserProfileMsg.setMsgType(intExtra);
                JSONObject jSONObject = new JSONObject();
                if (intExtra == 1) {
                    try {
                        jSONObject.put("type", intExtra);
                    } catch (JSONException e) {
                        LogUtils.e(TAG, "Exception ", e);
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                    }
                    saveCmdMessage(context, iMGetUserProfileMsg, jSONObject.toString(), iMGetUserProfileMsg.getPriority());
                    return iMGetUserProfileMsg;
                }
                return iMGetUserProfileMsg;
            }
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public static IMGetUserProfileMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        long j = new JSONObject(str2).getLong("to_user");
        int optInt = new JSONObject(str3).optInt("type");
        if (-1 != j) {
            IMGetUserProfileMsg iMGetUserProfileMsg = new IMGetUserProfileMsg(context, j);
            iMGetUserProfileMsg.setUUID(str);
            iMGetUserProfileMsg.setMsgType(optInt);
            return iMGetUserProfileMsg;
        }
        return null;
    }

    public long getToUser() {
        return this.mToUser;
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
                IMUserManager.getInstance(context).updateUser(Utility.contructChatUser(jSONObject.optJSONObject(ConstantData.VideoLocationType.PERSON_PROFILE)));
            }
            if (this.msgtype == 1) {
                DBManager.getInstance(this.mContext).deleteCmdMsg(getUUID());
            }
        }
        ChatUserManagerImpl.getInstance(context).onGetUserResult(context, getMsgType(), getListenerKey(), i, getToUser());
    }
}
