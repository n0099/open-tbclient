package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMDelMsg extends Message {
    public static final String TAG = "IMDelMsg";
    public int mCategory;
    public int mChatType;
    public long mClientMaxMsgid;
    public Context mContext;
    public boolean mIsZhida;
    public long[] mMsgIds;
    public long mPaid;
    public int mReSendCount = 0;
    public long mToId;

    public IMDelMsg(Context context, long j, int i2, long[] jArr, long j2, boolean z) {
        this.mClientMaxMsgid = -1L;
        initCommonParameter(context);
        this.mContext = context;
        this.mToId = j;
        setNeedReplay(true);
        this.mCategory = i2;
        setType(57);
        this.mMsgIds = jArr;
        this.mClientMaxMsgid = j2;
        this.mPriority = 14;
        this.mIsZhida = z;
    }

    public static IMDelMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
            long longExtra = intent.getLongExtra("contacter", -1L);
            int intExtra = intent.getIntExtra("category", -1);
            long[] longArrayExtra = intent.getLongArrayExtra(Constants.EXTRA_DEL_MSG_IDS);
            long longExtra2 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
            int intExtra2 = intent.getIntExtra("chat_type", 0);
            long longExtra3 = IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid() ? intent.getLongExtra(Constants.EXTRA_PA_ID, -1L) : -1L;
            if (-1 != longExtra && -1 != intExtra) {
                IMDelMsg iMDelMsg = new IMDelMsg(context, longExtra, intExtra, longArrayExtra, longExtra2, booleanExtra);
                iMDelMsg.setPaid(longExtra3);
                iMDelMsg.setChatType(intExtra2);
                Message.saveCmdMessage(context, iMDelMsg, null, iMDelMsg.getPriority());
                return iMDelMsg;
            }
        }
        return null;
    }

    private int updateDB(Context context) {
        long[] jArr = this.mMsgIds;
        if (jArr != null && jArr.length > 0) {
            return ChatMessageDBManager.getInstance(context).deleteMsgBatch(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mMsgIds);
        }
        return ChatMessageDBManager.getInstance(context).delMsgsOfCertainContacter(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mClientMaxMsgid);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 57);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to", this.mToId);
            jSONObject.put("category", this.mCategory);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            if (this.mMsgIds != null && this.mMsgIds.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (long j : this.mMsgIds) {
                    jSONArray.put(Long.valueOf(j));
                }
                jSONObject.put("msgid", jSONArray);
            }
            if (this.mClientMaxMsgid > 0) {
                jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgid);
            }
            if (this.mIsZhida) {
                jSONObject.put("tpl", Constants.getTplZhida(this.mContext));
            }
            if (IMConfigInternal.getInstance().getIMConfig(this.mContext).isNeedPaid()) {
                jSONObject.put("pa_uid", this.mPaid);
            }
            if (this.mChatType == 57) {
                jSONObject.put("group_type", 3);
            }
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            LogUtils.e(TAG, e2.getMessage(), e2);
        }
    }

    public int getCategory() {
        return this.mCategory;
    }

    public long getToUser() {
        return this.mToId;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        try {
            if (TextUtils.isEmpty(this.mListenerKey)) {
                if (i2 == 0) {
                    DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    setNeedReSend(false);
                } else {
                    if (i2 != 1004 && i2 != 1001) {
                        if (this.mReSendCount >= 3) {
                            setNeedReSend(false);
                            DBManager.getInstance(context).deleteCmdMsg(getUUID());
                        } else {
                            this.mReSendCount++;
                            setNeedReSend(true);
                        }
                        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                    }
                    setNeedReSend(false);
                    LoginManager.getInstance(this.mContext).triggleLogoutListener(i2, str);
                    DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                }
            } else if (i2 == 0) {
                updateDB(context);
            }
            super.handleMessageResult(context, jSONObject, i2, str);
        } catch (Exception e2) {
            LogUtils.e(TAG, "handle IMDelMsg exception :", e2);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public void setChatType(int i2) {
        this.mChatType = i2;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }
}
