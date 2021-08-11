package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public abstract class IMessageHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_BODY_LENGTH = 1048576;
    public static final int MSG_ID_HERATBEAT = 101;
    public static final String TAG = "IMessageHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public LinkedList<Message> mSendQueque;
    public String mSocketIp;

    public IMessageHandler(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSendQueque = new LinkedList<>();
        this.mSocketIp = "";
        this.mContext = context;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Long] */
    private void handleConfigMessage(JSONObject jSONObject) throws JSONException {
        ArrayList<ChatMsg> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) {
            LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
            JSONArray jSONArray = new JSONArray();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                }
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                arrayList = null;
            }
            if (jSONArray.length() == 0) {
                return;
            }
            Type type = new Type();
            type.t = 0L;
            arrayList = MessageParser.parserMessage(this.mContext, jSONArray, type, true, false);
            ChatMsgManagerImpl.getInstance(this.mContext).persisConfigMsgIds(arrayList);
            ChatMsgManagerImpl.getInstance(this.mContext).deliverConfigMessage(arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleDeliverMessage(JSONObject jSONObject) throws JSONException {
        long j2;
        SyncStrategy generate;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, this, jSONObject) != null) {
            return;
        }
        LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
        int i2 = jSONObject.getInt("category");
        if (i2 == 0 && jSONObject.has("msgid")) {
            try {
                j2 = jSONObject.getLong("msgid");
            } catch (JSONException e2) {
                LogUtils.i(TAG, "JSONException:" + e2.getMessage());
            }
            if (i2 != 0 || i2 == 2) {
                generate = Generator.generate(this.mContext, 5);
                if (generate == null) {
                    if (j2 != -1) {
                        generate.start(2, j2);
                        return;
                    } else {
                        generate.start(2);
                        return;
                    }
                }
                return;
            } else if (i2 == 1) {
                long j3 = jSONObject.getLong("contacter");
                long j4 = jSONObject.getLong("msgid");
                LogUtils.i(TAG, "msgid : " + j4);
                SyncGroupMessageService.getInstance().execute(this.mContext, i2, j3, j4, 2);
                return;
            } else {
                LogUtils.e(TAG, "handleDeliverMessage category error!!");
                return;
            }
        }
        j2 = -1;
        if (i2 != 0) {
        }
        generate = Generator.generate(this.mContext, 5);
        if (generate == null) {
        }
    }

    private void handleFatalMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, message) == null) {
            LogUtils.d(TAG, "handleFatalMessage");
            if (message == null) {
                return;
            }
            try {
                int length = message.getBody().length();
                String str = Constants.ERROR_MSG_CONNECT_SERVER_ERROR;
                if (length <= 0) {
                    message.handleMessageResult(this.mContext, null, 1004, Constants.ERROR_MSG_CONNECT_SERVER_ERROR);
                    return;
                }
                JSONObject jSONObject = new JSONObject(message.getBody());
                int i2 = jSONObject.has(PmsConstant.Statistic.STATISTIC_ERRCODE) ? jSONObject.getInt(PmsConstant.Statistic.STATISTIC_ERRCODE) : 1004;
                if (jSONObject.has("msg")) {
                    str = jSONObject.getString("msg");
                }
                message.handleMessageResult(this.mContext, jSONObject, i2, str);
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "handleFatalMessage:", e2);
            }
        }
    }

    private void handleMcastMessage(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject) == null) {
            LogUtils.i(TAG, "handleMessage mcast:" + jSONObject.toString());
            if (jSONObject.has("mcast_id")) {
                jSONObject.getLong("mcast_id");
            } else {
                LogUtils.e(TAG, "handleMcastMessage cast error!!");
            }
            ConversationStudioManImpl.getInstance(this.mContext).handleMessage(jSONObject);
        }
    }

    private String ungzip(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream2 = null;
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                gZIPInputStream = gZIPInputStream2;
                th = th2;
            }
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
                try {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                    LogUtils.e(TAG, "Exception ", e2);
                }
            } catch (IOException unused2) {
                gZIPInputStream2 = gZIPInputStream;
                LogUtils.e(TAG, "unzip exception");
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e3) {
                        LogUtils.e(TAG, "Exception ", e3);
                        str = "";
                        LogUtils.d(TAG, "after ungzip:" + str);
                        return str;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                str = "";
                LogUtils.d(TAG, "after ungzip:" + str);
                return str;
            } catch (Throwable th3) {
                th = th3;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e4) {
                        LogUtils.e(TAG, "Exception ", e4);
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
            LogUtils.d(TAG, "after ungzip:" + str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public LinkedList<Message> getMessageQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSendQueque : (LinkedList) invokeV.objValue;
    }

    public void handleMessage(Message message, Message message2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message, message2, z) == null) {
            try {
                if (!z) {
                    handleFatalMessage(message);
                } else if (message != null && message2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    if (message.getBody().length() > 0) {
                        jSONObject = new JSONObject(message.getBody());
                    }
                    int optInt = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
                    message2.handleMessageResult(this.mContext, jSONObject, optInt, jSONObject.has("msg") ? jSONObject.getString("msg") : "");
                    if (50 == message2.getType() && optInt == 0) {
                        onLoginSuccess();
                    }
                    if (message2.isNeedReSend()) {
                        LogUtils.d(TAG, "reSending msg: method=" + message2.getType() + ";uuid=" + message2.getUUID());
                        sendMessage(message2, false);
                    }
                } else {
                    if (message != null && !message.isHeartbeat() && message.getBody().length() > 0) {
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
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "handleMessage exception.", e2);
            }
        }
    }

    public void onLoginSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.mSendQueque) {
                this.mSendQueque.notifyAll();
                IMSDK.getInstance(this.mContext).setAlarmTimeout();
            }
        }
    }

    public void onSessionClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LoginManager.getInstance(this.mContext).logoutInternal(null);
        }
    }

    public void onSessionOpened() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String token = AccountManager.getToken(this.mContext);
            LogUtils.d(TAG, "Send handShake Message token is: " + token);
            if (TextUtils.isEmpty(token)) {
                return;
            }
            Utility.writeLoginFlag(this.mContext, "16Y_1", "send Logig msg");
            Context context = this.mContext;
            sendMessage(new IMUserLoginByTokenMsg(context, token, true, AccountManagerImpl.getInstance(context).getFrom(), AccountManagerImpl.getInstance(this.mContext).getcFrom()), true);
            LogUtils.d(TAG, "onSessionOpened, send IMUserLoginByTokenMsg...");
        }
    }

    public abstract Message readMessage() throws EOFException, IOException;

    public Message readMessage(BigEndianDataIutputStream bigEndianDataIutputStream) throws EOFException, IOException {
        InterceptResult invokeL;
        RcvMessage rcvMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bigEndianDataIutputStream)) == null) {
            bigEndianDataIutputStream.readByte();
            byte readByte = bigEndianDataIutputStream.readByte();
            if (readByte == 101) {
                LogUtils.i(TAG, "read cmdType:" + ((int) readByte));
                RcvMessage rcvMessage2 = new RcvMessage(null);
                rcvMessage2.setHeartbeat(true);
                LogUtils.i(TAG, "readMessage nshead, heartbeat returned");
                return rcvMessage2;
            }
            RcvMessage rcvMessage3 = new RcvMessage("{err_code:1024}");
            int readInt = bigEndianDataIutputStream.readInt();
            long readLong = bigEndianDataIutputStream.readLong();
            if (readInt > 0 && readInt <= 1048576) {
                try {
                    byte[] bArr = new byte[readInt];
                    bigEndianDataIutputStream.readFully(bArr);
                    if (readByte == 11) {
                        LogUtils.d(TAG, "gzip receive message.");
                        rcvMessage = new RcvMessage(ungzip(bArr));
                    } else {
                        rcvMessage = new RcvMessage(new String(bArr));
                    }
                    rcvMessage3 = rcvMessage;
                    rcvMessage3.setMsgId(readLong);
                } catch (OutOfMemoryError unused) {
                    String str = LogUtils.TAG;
                    LogUtils.e(str, "out of Memory while read message msgId = " + readLong + " bodyLen = " + readInt);
                }
            } else {
                String str2 = LogUtils.TAG;
                LogUtils.e(str2, "message body length over 1024*1024 bodyLen = " + readInt + " msgId " + readLong);
                bigEndianDataIutputStream.skipBytes(readInt);
                rcvMessage3.setMsgId(readLong);
            }
            LogUtils.d(TAG, "RTN msg:" + rcvMessage3);
            return rcvMessage3;
        }
        return (Message) invokeL.objValue;
    }

    public void sendHeartbeatMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LogUtils.d(TAG, "onLoginSuccess sendHeartbeatMessage!");
            sendMessage(new HeartbeatMessage(), false);
        }
    }

    public void sendMessage(Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, message, z) == null) {
            IMConnection.getInstance(this.mContext).sendMessage(message, z);
        }
    }

    public abstract void setCurrentSocketState(SocketState socketState);

    public abstract boolean socketClose() throws IOException;

    public abstract SocketState socketConnect(String str, int i2) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, SSLHandshakeException, AssertionError;

    public abstract void socketWrite(Message message) throws IOException;
}
