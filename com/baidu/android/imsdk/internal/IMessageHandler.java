package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.request.HeartbeatMessage;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.request.RcvMessage;
import com.baidu.android.imsdk.utils.BigEndianDataIutputStream;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class IMessageHandler {
    protected static final int MAX_BODY_LENGTH = 1048576;
    public static final int MSG_ID_HERATBEAT = 101;
    private static final String TAG = "IMessageHandler";
    protected Context mContext;
    public LinkedList<Message> mSendQueque = new LinkedList<>();
    public String mSocketIp = "";

    public abstract Message readMessage() throws EOFException, IOException;

    public abstract void setCurrentSocketState(SocketState socketState);

    public abstract boolean socketClose() throws IOException;

    public abstract SocketState socketConnect(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, SSLHandshakeException, AssertionError;

    public abstract void socketWrite(Message message) throws IOException;

    public IMessageHandler(Context context) {
        this.mContext = context;
    }

    public LinkedList<Message> getMessageQueue() {
        return this.mSendQueque;
    }

    public void sendMessage(Message message, boolean z) {
        IMConnection.getInstance(this.mContext).sendMessage(message, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message readMessage(BigEndianDataIutputStream bigEndianDataIutputStream) throws EOFException, IOException {
        bigEndianDataIutputStream.readByte();
        byte readByte = bigEndianDataIutputStream.readByte();
        if (readByte == 101) {
            LogUtils.i(TAG, "read cmdType:" + ((int) readByte));
            RcvMessage rcvMessage = new RcvMessage(null);
            rcvMessage.setHeartbeat(true);
            LogUtils.i(TAG, "readMessage nshead, heartbeat returned");
            return rcvMessage;
        }
        RcvMessage rcvMessage2 = new RcvMessage("{err_code:1024}");
        int readInt = bigEndianDataIutputStream.readInt();
        long readLong = bigEndianDataIutputStream.readLong();
        if (readInt > 0 && readInt <= 1048576) {
            try {
                byte[] bArr = new byte[readInt];
                bigEndianDataIutputStream.readFully(bArr);
                if (readByte == 11) {
                    LogUtils.d(TAG, "gzip receive message.");
                    rcvMessage2 = new RcvMessage(ungzip(bArr));
                } else {
                    rcvMessage2 = new RcvMessage(new String(bArr));
                }
                rcvMessage2.setMsgId(readLong);
            } catch (OutOfMemoryError e) {
                LogUtils.e(LogUtils.TAG, "out of Memory while read message msgId = " + readLong + " bodyLen = " + readInt);
            }
        } else {
            LogUtils.e(LogUtils.TAG, "message body length over 1024*1024 bodyLen = " + readInt + " msgId " + readLong);
            bigEndianDataIutputStream.skipBytes(readInt);
            rcvMessage2.setMsgId(readLong);
        }
        LogUtils.d(TAG, "RTN msg:" + rcvMessage2);
        return rcvMessage2;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String ungzip(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    str = byteArrayOutputStream.toString();
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e) {
                            LogUtils.e(TAG, "Exception ", e);
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    LogUtils.e(TAG, "unzip exception");
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e3) {
                            LogUtils.e(TAG, "Exception ", e3);
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    LogUtils.d(TAG, "after ungzip:" + str);
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e4) {
                        LogUtils.e(TAG, "Exception ", e4);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            gZIPInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
        LogUtils.d(TAG, "after ungzip:" + str);
        return str;
    }

    public void handleMessage(Message message, Message message2, boolean z) {
        try {
            if (!z) {
                handleFatalMessage(message);
            } else if (message != null && message2 != null) {
                String str = "";
                JSONObject jSONObject = new JSONObject();
                if (message.getBody().length() > 0) {
                    jSONObject = new JSONObject(message.getBody());
                }
                int optInt = jSONObject.optInt("err_code");
                if (jSONObject.has("msg")) {
                    str = jSONObject.getString("msg");
                }
                message2.handleMessageResult(this.mContext, jSONObject, optInt, str);
                if (50 == message2.getType() && optInt == 0) {
                    onLoginSuccess();
                }
                if (message2.isNeedReSend()) {
                    LogUtils.d(TAG, "reSending msg: method=" + message2.getType() + ";uuid=" + message2.getUUID());
                    sendMessage(message2, false);
                }
            } else if (message != null && !message.isHeartbeat() && message.getBody().length() > 0) {
                LogUtils.i(TAG, "handleMessage orginMsg is not null");
                JSONObject jSONObject2 = new JSONObject(message.getBody());
                if (jSONObject2.has("method")) {
                    int optInt2 = jSONObject2.optInt("method");
                    if (optInt2 == 96) {
                        NotifyMessageHandler.handleDeliverMessage(this.mContext, jSONObject2);
                    } else if (optInt2 == 196) {
                        NotifyMessageHandler.handleMcastMessage(this.mContext, jSONObject2);
                    } else if (optInt2 == 197) {
                        NotifyMessageHandler.handleConfigMessage(this.mContext, jSONObject2);
                    } else if (optInt2 == 226) {
                        NotifyMessageHandler.handleMediaNotifyMessage(this.mContext, jSONObject2);
                    } else if (optInt2 == 231) {
                        NotifyMessageHandler.handleRtcNotifyMessage(this.mContext, jSONObject2);
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "handleMessage exception.", e);
        }
    }

    public void onLoginSuccess() {
        synchronized (this.mSendQueque) {
            this.mSendQueque.notifyAll();
            IMSDK.getInstance(this.mContext).setAlarmTimeout();
        }
    }

    private void handleFatalMessage(Message message) {
        String str = Constants.ERROR_MSG_CONNECT_SERVER_ERROR;
        int i = 1004;
        LogUtils.d(TAG, "handleFatalMessage");
        if (message != null) {
            try {
                if (message.getBody().length() <= 0) {
                    message.handleMessageResult(this.mContext, null, 1004, Constants.ERROR_MSG_CONNECT_SERVER_ERROR);
                    return;
                }
                JSONObject jSONObject = new JSONObject(message.getBody());
                if (jSONObject.has("err_code")) {
                    i = jSONObject.getInt("err_code");
                }
                if (jSONObject.has("msg")) {
                    str = jSONObject.getString("msg");
                }
                message.handleMessageResult(this.mContext, jSONObject, i, str);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "handleFatalMessage:", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleDeliverMessage(JSONObject jSONObject) throws JSONException {
        long j;
        SyncStrategy generate;
        LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
        int i = jSONObject.getInt("category");
        if (i == 0 && jSONObject.has("msgid")) {
            try {
                j = jSONObject.getLong("msgid");
            } catch (JSONException e) {
                LogUtils.i(TAG, "JSONException:" + e.getMessage());
            }
            if (i != 0 || i == 2) {
                generate = Generator.generate(this.mContext, 5);
                if (generate == null) {
                    if (j != -1) {
                        generate.start(2, j);
                        return;
                    } else {
                        generate.start(2);
                        return;
                    }
                }
                return;
            } else if (i == 1) {
                long j2 = jSONObject.getLong("contacter");
                long j3 = jSONObject.getLong("msgid");
                LogUtils.i(TAG, "msgid : " + j3);
                SyncGroupMessageService.getInstance().execute(this.mContext, i, j2, j3, 2);
                return;
            } else {
                LogUtils.e(TAG, "handleDeliverMessage category error!!");
                return;
            }
        }
        j = -1;
        if (i != 0) {
        }
        generate = Generator.generate(this.mContext, 5);
        if (generate == null) {
        }
    }

    private void handleMcastMessage(JSONObject jSONObject) throws JSONException {
        LogUtils.i(TAG, "handleMessage mcast:" + jSONObject.toString());
        if (jSONObject.has("mcast_id")) {
            jSONObject.getLong("mcast_id");
        } else {
            LogUtils.e(TAG, "handleMcastMessage cast error!!");
        }
        ConversationStudioManImpl.getInstance(this.mContext).handleMessage(jSONObject);
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.Long] */
    private void handleConfigMessage(JSONObject jSONObject) throws JSONException {
        LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
        JSONArray jSONArray = new JSONArray();
        ArrayList<ChatMsg> arrayList = null;
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray("messages");
            for (int i = 0; i < jSONArray2.length(); i++) {
                jSONArray.put(jSONArray2.getJSONObject(i));
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        if (jSONArray.length() != 0) {
            Type type = new Type();
            type.t = 0L;
            arrayList = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
            ChatMsgManagerImpl.getInstance(this.mContext).persisConfigMsgIds(arrayList);
            ChatMsgManagerImpl.getInstance(this.mContext).deliverConfigMessage(arrayList);
        }
    }

    public void onSessionOpened() {
        String token = AccountManager.getToken(this.mContext);
        LogUtils.d(TAG, "Send handShake Message token is: " + token);
        if (!TextUtils.isEmpty(token)) {
            Utility.writeLoginFlag(this.mContext, "16Y_1", "send Logig msg");
            sendMessage(new IMUserLoginByTokenMsg(this.mContext, token, true, AccountManagerImpl.getInstance(this.mContext).getFrom(), AccountManagerImpl.getInstance(this.mContext).getcFrom()), true);
            LogUtils.d(TAG, "onSessionOpened, send IMUserLoginByTokenMsg...");
        }
    }

    public void onSessionClosed() {
        LoginManager.getInstance(this.mContext).logoutInternal(null);
    }

    public void sendHeartbeatMessage() {
        LogUtils.d(TAG, "onLoginSuccess sendHeartbeatMessage!");
        sendMessage(new HeartbeatMessage(), false);
    }
}
