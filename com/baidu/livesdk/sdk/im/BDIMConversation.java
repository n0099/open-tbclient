package com.baidu.livesdk.sdk.im;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.MsgReceiveListener;
import com.baidu.livesdk.api.im.SendMessageListener;
import com.baidu.livesdk.api.im.SendMessageStatusListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.sdk.im.live.parser.LiveMessageParser;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class BDIMConversation implements IMConversation {
    public static final boolean DEBUG = false;
    public static final String TAG = "BDIMConversation";
    public Context mContext;
    public BIMConversation mConversation;

    public BDIMConversation(Context context, BIMConversation bIMConversation) {
        this.mContext = context;
        this.mConversation = bIMConversation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendMessageResponse(int i2, ChatMsg chatMsg, SendMessageListener sendMessageListener) {
        if (sendMessageListener != null) {
            ArrayList arrayList = null;
            if (i2 != 22 && i2 != 1024 && i2 != 1001) {
                arrayList = new ArrayList();
                arrayList.add(LiveMessageParser.parseChatMsg(chatMsg));
            }
            sendMessageListener.onSendMessageResult(i2, arrayList);
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void beginWithCompletion(final IMCastSetListener iMCastSetListener) {
        this.mConversation.beginWithCompletion(new IMcastSetListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.2
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i2, long j, long j2) {
                IMCastSetListener iMCastSetListener2 = iMCastSetListener;
                if (iMCastSetListener2 != null) {
                    iMCastSetListener2.onResult(i2, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void endWithCompletion(final IMCastSetListener iMCastSetListener) {
        this.mConversation.endWithCompletion(new IMcastSetListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.3
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i2, long j, long j2) {
                IMCastSetListener iMCastSetListener2 = iMCastSetListener;
                if (iMCastSetListener2 != null) {
                    iMCastSetListener2.onResult(i2, j, j2);
                }
            }
        });
    }

    public BIMConversation getBaseConversation() {
        return this.mConversation;
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void quitLiveShow() {
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void registerMsgReceiveListener(String str, final MsgReceiveListener msgReceiveListener) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        this.mConversation.registerLiveMsgReceiveListener(j, new ILiveMsgReceiveListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.1
            @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
            public void onReceiveMessage(int i2, JSONArray jSONArray) {
                MsgReceiveListener msgReceiveListener2 = msgReceiveListener;
                if (msgReceiveListener2 != null) {
                    msgReceiveListener2.onReceiveMessage(i2, LiveMessageParser.getMessageList(jSONArray));
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void sendMessage(Object obj, final SendMessageStatusListener sendMessageStatusListener, final SendMessageListener sendMessageListener) {
        this.mConversation.sendMessage(LiveMessageParser.trans2ChatMsg(this.mContext, (LiveSendMessage) obj), new ISendMessageStatusListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.4
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendProgress(int i2, ChatMsg chatMsg) {
                SendMessageStatusListener sendMessageStatusListener2 = sendMessageStatusListener;
                if (sendMessageStatusListener2 != null) {
                    sendMessageStatusListener2.onSendProgress(i2, chatMsg);
                }
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendStatus(int i2, ChatMsg chatMsg) {
                SendMessageStatusListener sendMessageStatusListener2 = sendMessageStatusListener;
                if (sendMessageStatusListener2 != null) {
                    sendMessageStatusListener2.onSendStatus(i2, chatMsg);
                }
            }
        }, new ISendMessageListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.5
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i2, ChatMsg chatMsg) {
                BDIMConversation.this.handleSendMessageResponse(i2, chatMsg, sendMessageListener);
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void setPullInterval(int i2) {
        this.mConversation.setPullInterval(i2);
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void unregisterMsgReceiveListener(String str) {
        try {
            this.mConversation.unregisterLiveMsgReceiveListener(Long.parseLong(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
