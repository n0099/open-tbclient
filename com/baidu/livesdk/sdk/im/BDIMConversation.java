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

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void quitLiveShow() {
    }

    public BDIMConversation(Context context, BIMConversation bIMConversation) {
        this.mContext = context;
        this.mConversation = bIMConversation;
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
            public void onReceiveMessage(int i, JSONArray jSONArray) {
                MsgReceiveListener msgReceiveListener2 = msgReceiveListener;
                if (msgReceiveListener2 != null) {
                    msgReceiveListener2.onReceiveMessage(i, LiveMessageParser.getMessageList(jSONArray));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendMessageResponse(int i, ChatMsg chatMsg, SendMessageListener sendMessageListener) {
        if (sendMessageListener != null) {
            ArrayList arrayList = null;
            if (i != 22 && i != 1024 && i != 1001) {
                arrayList = new ArrayList();
                arrayList.add(LiveMessageParser.parseChatMsg(chatMsg));
            }
            sendMessageListener.onSendMessageResult(i, arrayList);
        }
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void sendMessage(Object obj, final SendMessageStatusListener sendMessageStatusListener, final SendMessageListener sendMessageListener) {
        this.mConversation.sendMessage(LiveMessageParser.trans2ChatMsg(this.mContext, (LiveSendMessage) obj), new ISendMessageStatusListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.4
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendProgress(int i, ChatMsg chatMsg) {
                SendMessageStatusListener sendMessageStatusListener2 = sendMessageStatusListener;
                if (sendMessageStatusListener2 != null) {
                    sendMessageStatusListener2.onSendProgress(i, chatMsg);
                }
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendStatus(int i, ChatMsg chatMsg) {
                SendMessageStatusListener sendMessageStatusListener2 = sendMessageStatusListener;
                if (sendMessageStatusListener2 != null) {
                    sendMessageStatusListener2.onSendStatus(i, chatMsg);
                }
            }
        }, new ISendMessageListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.5
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                BDIMConversation.this.handleSendMessageResponse(i, chatMsg, sendMessageListener);
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void beginWithCompletion(final IMCastSetListener iMCastSetListener) {
        this.mConversation.beginWithCompletion(new IMcastSetListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.2
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                IMCastSetListener iMCastSetListener2 = iMCastSetListener;
                if (iMCastSetListener2 != null) {
                    iMCastSetListener2.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void endWithCompletion(final IMCastSetListener iMCastSetListener) {
        this.mConversation.endWithCompletion(new IMcastSetListener() { // from class: com.baidu.livesdk.sdk.im.BDIMConversation.3
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                IMCastSetListener iMCastSetListener2 = iMCastSetListener;
                if (iMCastSetListener2 != null) {
                    iMCastSetListener2.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void setPullInterval(int i) {
        this.mConversation.setPullInterval(i);
    }

    @Override // com.baidu.livesdk.api.im.IMConversation
    public void unregisterMsgReceiveListener(String str) {
        try {
            this.mConversation.unregisterLiveMsgReceiveListener(Long.parseLong(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BIMConversation getBaseConversation() {
        return this.mConversation;
    }
}
