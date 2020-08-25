package com.baidu.android.imsdk.request;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.utils.BigEndianDataOutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.sapi2.SapiContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class Message {
    private Context context;
    protected long mAppid;
    protected String mListenerKey;
    private int mType;
    protected long mUk;
    private long msgId;
    private boolean isHeartbeat = false;
    private boolean mIsSending = false;
    private boolean needReplay = false;
    protected String mBody = "";
    protected int mPriority = 15;
    private boolean needReSend = false;
    private String mUUId = UUID.randomUUID().toString();

    protected abstract void buildBody();

    public String getUUID() {
        return this.mUUId;
    }

    public void setUUID(String str) {
        this.mUUId = str;
    }

    public boolean isNeedReSend() {
        return this.needReSend;
    }

    public void setNeedReSend(boolean z) {
        this.needReSend = z;
    }

    public static void saveCmdMessage(Context context, Message message, String str, int i) {
        DBManager.getInstance(context).saveCmdMsg(message.getUUID(), message.getType(), message.getBody(), str, i, 0);
    }

    public static Message parseBody(Context context, String str, String str2, String str3) throws Exception {
        return null;
    }

    public int getPriority() {
        return this.mPriority;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
    public byte[] getMessageBytes() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr = null;
        buildBody();
        addRetryTime();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BigEndianDataOutputStream bigEndianDataOutputStream = new BigEndianDataOutputStream(byteArrayOutputStream);
                if (this.isHeartbeat) {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte(Constants.SHORT_PING_CMD_TYPE);
                } else {
                    bigEndianDataOutputStream.writeByte((byte) 2);
                    bigEndianDataOutputStream.writeByte((byte) 1);
                    bigEndianDataOutputStream.writeInt(this.mBody.getBytes().length);
                    bigEndianDataOutputStream.writeLong(this.msgId);
                    if (this.mBody.length() != 0) {
                        bigEndianDataOutputStream.write(this.mBody.getBytes());
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        LogUtils.e("Message", "baos.close", e);
                    }
                }
            } catch (IOException e2) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e("Message", "baos.close", e3);
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        LogUtils.e("Message", "baos.close", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
        }
        return bArr;
    }

    private void addRetryTime() {
        if (!TextUtils.isEmpty(this.mBody)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mBody);
                if (this.context != null) {
                    jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.context));
                }
                if (TextUtils.isEmpty(jSONObject.optString("rpc"))) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("rpc_retry_time", 0);
                    jSONObject.put("rpc", jSONObject2.toString());
                    this.mBody = jSONObject.toString();
                }
            } catch (JSONException e) {
                LogUtils.e("Message", "getBody :", e);
            }
        }
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public boolean isNeedReplay() {
        return this.needReplay;
    }

    public void setNeedReplay(boolean z) {
        this.needReplay = z;
    }

    public boolean isHeartbeat() {
        return this.isHeartbeat;
    }

    public void setHeartbeat(boolean z) {
        this.isHeartbeat = z;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void onMsgSending(Context context) {
    }

    public void isSending(boolean z) {
        this.mIsSending = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSendingState(Context context) {
        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 2);
    }

    public String toString() {
        buildBody();
        if (this.mIsSending) {
            addRetryTime();
        }
        return "MsgId: " + this.msgId + " body: " + (this.isHeartbeat ? "heartbeat" : this.mBody);
    }

    public String getBody() {
        buildBody();
        if (this.mIsSending) {
            addRetryTime();
        }
        return this.mBody;
    }

    public long getUk() {
        return this.mUk;
    }

    public void setUk(long j) {
        this.mUk = j;
    }

    public long getAppid() {
        return this.mAppid;
    }

    public void setAppid(long j) {
        this.mAppid = j;
    }

    public void initCommonParameter(Context context) {
        this.context = context;
        setUk(IMSDK.getInstance(context).getUk());
        setAppid(AccountManager.getAppid(context));
    }

    public void setListenerKey(String str) {
        this.mListenerKey = str;
    }

    public String getListenerKey() {
        return this.mListenerKey;
    }

    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
    }
}
