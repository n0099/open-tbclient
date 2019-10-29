package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMMarkMsgReadedMsg extends Message {
    public static final String TAG = IMMarkMsgReadedMsg.class.getSimpleName();
    private long mCategory;
    private long mClientMaxMsgid;
    private Context mContext;
    private boolean mIsZHida;
    private long mMsgId;
    private long mPaid;
    private int mReSendCount = 0;
    private long mTo;

    public IMMarkMsgReadedMsg(Context context, long j, long j2, long j3, long j4, boolean z) {
        this.mClientMaxMsgid = -1L;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(67);
        this.mCategory = j;
        this.mTo = j2;
        this.mMsgId = j3;
        this.mContext = context;
        this.mClientMaxMsgid = j4;
        this.mPriority = 14;
        this.mIsZHida = z;
    }

    public void setPaid(long j) {
        this.mPaid = j;
    }

    public static IMMarkMsgReadedMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        IMMarkMsgReadedMsg iMMarkMsgReadedMsg = new IMMarkMsgReadedMsg(context, jSONObject.optLong("category"), jSONObject.optLong("to"), jSONObject.optLong("msgid"), jSONObject.optLong(Constants.EXTRA_CLIENT_MAX_MSGID, -1L), jSONObject.optInt(TableDefine.PaSubscribeColumns.COLUMN_TPL) == Constants.getTplZhida(context));
        iMMarkMsgReadedMsg.setUUID(str);
        if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
            iMMarkMsgReadedMsg.setPaid(jSONObject.getLong("pa_uid"));
        }
        return iMMarkMsgReadedMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public static IMMarkMsgReadedMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
            long longExtra = intent.getLongExtra("contacter", -1L);
            long intExtra = intent.getIntExtra("category", -1);
            long longExtra2 = intent.getLongExtra("msgid", -1L);
            long longExtra3 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
            if (-1 != longExtra && -1 != intExtra) {
                IMMarkMsgReadedMsg iMMarkMsgReadedMsg = new IMMarkMsgReadedMsg(context, intExtra, longExtra, longExtra2, longExtra3, booleanExtra);
                if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                    iMMarkMsgReadedMsg.setPaid(intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
                }
                saveCmdMessage(context, iMMarkMsgReadedMsg, null, iMMarkMsgReadedMsg.getPriority());
                return iMMarkMsgReadedMsg;
            }
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 67);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to", this.mTo);
            jSONObject.put("category", this.mCategory);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            if (this.mMsgId > 0) {
                jSONObject.put("msgid", this.mMsgId);
            }
            if (this.mClientMaxMsgid > 0) {
                jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgid);
            }
            if (this.mIsZHida) {
                jSONObject.put(TableDefine.PaSubscribeColumns.COLUMN_TPL, Constants.getTplZhida(this.mContext));
            }
            if (IMConfigInternal.getInstance().getIMConfig(this.mContext).isNeedPaid()) {
                jSONObject.put("pa_uid", this.mPaid);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rpc_retry_time", this.mReSendCount);
            jSONObject.put("rpc", jSONObject2.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        if (i == 0) {
            DBManager.getInstance(context).deleteCmdMsg(getUUID());
            setNeedReSend(false);
            return;
        }
        if (i == 1004 || i == 1001) {
            setNeedReSend(false);
        } else if (this.mReSendCount >= 3) {
            setNeedReSend(false);
            DBManager.getInstance(context).deleteCmdMsg(getUUID());
        } else {
            this.mReSendCount++;
            setNeedReSend(true);
        }
        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
    }
}
