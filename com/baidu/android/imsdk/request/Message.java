package com.baidu.android.imsdk.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.utils.BigEndianDataOutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class Message {
    public Context context;
    public long mAppid;
    public String mListenerKey;
    public int mType;
    public long mUk;
    public long msgId;
    public boolean isHeartbeat = false;
    public boolean mIsSending = false;
    public boolean needReplay = false;
    public String mBody = "";
    public int mPriority = 15;
    public boolean needReSend = false;
    public String mUUId = UUID.randomUUID().toString();

    private void addRetryTime() {
        if (TextUtils.isEmpty(this.mBody)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mBody);
            if (this.context != null) {
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.context));
            }
            if (TextUtils.isEmpty(jSONObject.optString("rpc"))) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", 0);
                jSONObject.put("rpc", jSONObject2.toString());
                this.mBody = jSONObject.toString();
            }
        } catch (JSONException e2) {
            LogUtils.e("Message", "getBody :", e2);
        }
    }

    public static Message parseBody(Context context, String str, String str2, String str3) throws Exception {
        return null;
    }

    public static void saveCmdMessage(Context context, Message message, String str, int i2) {
        DBManager.getInstance(context).saveCmdMsg(message.getUUID(), message.getType(), message.getBody(), str, i2, 0);
    }

    public abstract void buildBody();

    public long getAppid() {
        return this.mAppid;
    }

    public String getBody() {
        buildBody();
        if (this.mIsSending) {
            addRetryTime();
        }
        return this.mBody;
    }

    public String getListenerKey() {
        return this.mListenerKey;
    }

    public byte[] getMessageBytes() {
        ByteArrayOutputStream byteArrayOutputStream;
        buildBody();
        addRetryTime();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BigEndianDataOutputStream bigEndianDataOutputStream = new BigEndianDataOutputStream(byteArrayOutputStream);
                if (!this.isHeartbeat) {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte((byte) 1);
                    bigEndianDataOutputStream.writeInt(this.mBody.getBytes().length);
                    bigEndianDataOutputStream.writeLong(this.msgId);
                    if (this.mBody.length() != 0) {
                        bigEndianDataOutputStream.write(this.mBody.getBytes());
                    }
                } else {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte(Constants.SHORT_PING_CMD_TYPE);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    LogUtils.e("Message", "baos.close", e2);
                }
                return byteArray;
            } catch (IOException unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e("Message", "baos.close", e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        LogUtils.e("Message", "baos.close", e4);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public long getMsgId() {
        return this.msgId;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getType() {
        return this.mType;
    }

    public String getUUID() {
        return this.mUUId;
    }

    public long getUk() {
        return this.mUk;
    }

    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        if (i2 == 4001 || i2 == 4003 || i2 == 4004 || i2 == 4005) {
            LoginManager.getInstance(context).triggleLogoutListener(i2, str);
        }
    }

    public void initCommonParameter(Context context) {
        this.context = context;
        setUk(IMSDK.getInstance(context).getUk());
        setAppid(AccountManager.getAppid(context));
    }

    public boolean isHeartbeat() {
        return this.isHeartbeat;
    }

    public boolean isNeedReSend() {
        return this.needReSend;
    }

    public boolean isNeedReplay() {
        return this.needReplay;
    }

    public void isSending(boolean z) {
        this.mIsSending = z;
    }

    public void onMsgSending(Context context) {
    }

    public void setAppid(long j) {
        this.mAppid = j;
    }

    public void setHeartbeat(boolean z) {
        this.isHeartbeat = z;
    }

    public void setListenerKey(String str) {
        this.mListenerKey = str;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public void setNeedReSend(boolean z) {
        this.needReSend = z;
    }

    public void setNeedReplay(boolean z) {
        this.needReplay = z;
    }

    public void setSendingState(Context context) {
        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 2);
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public void setUUID(String str) {
        this.mUUId = str;
    }

    public void setUk(long j) {
        this.mUk = j;
    }

    public String toString() {
        buildBody();
        if (this.mIsSending) {
            addRetryTime();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MsgId: ");
        sb.append(this.msgId);
        sb.append(" body: ");
        sb.append(this.isHeartbeat ? "heartbeat" : this.mBody);
        return sb.toString();
    }
}
