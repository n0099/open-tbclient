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
/* loaded from: classes4.dex */
public class IMDelMsg extends Message {
    public static final String TAG = IMDelMsg.class.getSimpleName();
    private int mCategory;
    private long mClientMaxMsgid;
    private Context mContext;
    private boolean mIsZhida;
    private long[] mMsgIds;
    private long mPaid;
    private int mReSendCount = 0;
    private long mToId;

    public IMDelMsg(Context context, long j, int i, long[] jArr, long j2, boolean z) {
        this.mClientMaxMsgid = -1L;
        initCommonParameter(context);
        this.mContext = context;
        this.mToId = j;
        setNeedReplay(true);
        this.mCategory = i;
        setType(57);
        this.mMsgIds = jArr;
        this.mClientMaxMsgid = j2;
        this.mPriority = 14;
        this.mIsZhida = z;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public static IMDelMsg newInstance(Context context, Intent intent) {
        long j;
        if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
            long longExtra = intent.getLongExtra("contacter", -1L);
            int intExtra = intent.getIntExtra("category", -1);
            long[] longArrayExtra = intent.getLongArrayExtra(Constants.EXTRA_DEL_MSG_IDS);
            long longExtra2 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
            if (!IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                j = -1;
            } else {
                j = intent.getLongExtra(Constants.EXTRA_PA_ID, -1L);
            }
            if (-1 != longExtra && -1 != intExtra) {
                IMDelMsg iMDelMsg = new IMDelMsg(context, longExtra, intExtra, longArrayExtra, longExtra2, booleanExtra);
                iMDelMsg.setPaid(j);
                saveCmdMessage(context, iMDelMsg, null, iMDelMsg.getPriority());
                return iMDelMsg;
            }
        }
        return null;
    }

    public static IMDelMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        long j;
        JSONObject jSONObject = new JSONObject(str2);
        int optInt = jSONObject.optInt("category");
        long optLong = jSONObject.optLong("to");
        JSONArray optJSONArray = jSONObject.optJSONArray("msgid");
        long optLong2 = jSONObject.optLong(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
        long[] jArr = null;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            jArr = new long[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                jArr[i] = optJSONArray.getLong(i);
            }
        }
        boolean z = jSONObject.optInt("tpl") == Constants.getTplZhida(context);
        if (!IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
            j = -1;
        } else {
            j = jSONObject.getInt("pa_uid");
        }
        IMDelMsg iMDelMsg = new IMDelMsg(context, optLong, optInt, jArr, optLong2, z);
        iMDelMsg.setPaid(j);
        iMDelMsg.setUUID(str);
        return iMDelMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
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
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            LogUtils.e(TAG, e.getMessage(), e);
        }
    }

    public long getToUser() {
        return this.mToId;
    }

    public int getCategory() {
        return this.mCategory;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        try {
            if (TextUtils.isEmpty(this.mListenerKey)) {
                if (i == 0) {
                    DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    setNeedReSend(false);
                } else {
                    if (i == 1004 || i == 1001) {
                        setNeedReSend(false);
                        LoginManager.getInstance(this.mContext).triggleLogoutListener(i, str);
                    } else if (this.mReSendCount >= 3) {
                        setNeedReSend(false);
                        DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    } else {
                        this.mReSendCount++;
                        setNeedReSend(true);
                    }
                    DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                }
            } else if (i == 0) {
                updateDB(context);
            }
            super.handleMessageResult(context, jSONObject, i, str);
        } catch (Exception e) {
            LogUtils.e(TAG, "handle IMDelMsg exception :", e);
        }
    }

    private int updateDB(Context context) {
        return (this.mMsgIds == null || this.mMsgIds.length <= 0) ? ChatMessageDBManager.getInstance(context).delMsgsOfCertainContacter(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mClientMaxMsgid) : ChatMessageDBManager.getInstance(context).deleteMsgBatch(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mMsgIds);
    }
}
