package com.baidu.livesdk.sdk.im.live;

import com.baidu.livesdk.api.im.IMCastSetListener;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.MsgReceiveListener;
import com.baidu.livesdk.api.im.SendMessageListener;
import com.baidu.livesdk.api.im.live.LiveIM;
import com.baidu.livesdk.api.im.live.LiveMessageBean;
import com.baidu.livesdk.api.im.live.LiveMsgReceiverListener;
import com.baidu.livesdk.api.im.live.LiveSendMessage;
import com.baidu.livesdk.api.im.live.LiveSendMessageListener;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveIMController implements LiveIM {
    public static final boolean DEBUG = false;
    public static final String TAG = "LiveIMController";
    public String mCastId;
    public IMCastSetListener mCastSetListener;
    public IMConversation mConversation;
    public boolean mIsConnect;
    public boolean mNecessary;
    public int mPullInterval;
    public String mUrl;

    public LiveIMController(IMConversation iMConversation) {
        this.mConversation = iMConversation;
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void exitRoom(String str) {
        IMConversation iMConversation = this.mConversation;
        if (iMConversation == null) {
            return;
        }
        iMConversation.unregisterMsgReceiveListener(str);
        this.mConversation.endWithCompletion(new IMCastSetListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.3
            @Override // com.baidu.livesdk.api.im.IMCastSetListener
            public void onResult(int i, long j, long j2) {
                LiveIMController.this.mIsConnect = false;
            }
        });
        this.mConversation.quitLiveShow();
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void registerMsgReceiveListener(String str, final LiveMsgReceiverListener liveMsgReceiverListener) {
        this.mConversation.registerMsgReceiveListener(str, new MsgReceiveListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.5
            @Override // com.baidu.livesdk.api.im.MsgReceiveListener
            public void onReceiveMessage(int i, Object obj) {
                LiveMsgReceiverListener liveMsgReceiverListener2 = liveMsgReceiverListener;
                if (liveMsgReceiverListener2 != null) {
                    try {
                        liveMsgReceiverListener2.onReceiveMessage(i, (List) obj);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public void enterRoom() {
        this.mConversation.beginWithCompletion(new IMCastSetListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.2
            @Override // com.baidu.livesdk.api.im.IMCastSetListener
            public void onResult(int i, long j, long j2) {
                if (LiveIMController.this.mCastSetListener != null) {
                    LiveIMController.this.mCastSetListener.onResult(i, j, j2);
                }
                LiveIMController.this.mIsConnect = true;
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void exitRoom() {
        exitRoom(this.mCastId);
    }

    public IMConversation getConversation() {
        return this.mConversation;
    }

    public boolean isConnect() {
        return this.mIsConnect;
    }

    public void quitLiveShow() {
        this.mConversation.quitLiveShow();
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void enterRoom(String str, String str2, int i, final IMCastSetListener iMCastSetListener, boolean z) {
        this.mCastId = str;
        this.mUrl = str2;
        this.mPullInterval = i;
        this.mCastSetListener = iMCastSetListener;
        this.mNecessary = z;
        this.mConversation.setPullInterval(i);
        this.mConversation.beginWithCompletion(new IMCastSetListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.1
            @Override // com.baidu.livesdk.api.im.IMCastSetListener
            public void onResult(int i2, long j, long j2) {
                IMCastSetListener iMCastSetListener2 = iMCastSetListener;
                if (iMCastSetListener2 != null) {
                    iMCastSetListener2.onResult(i2, j, j2);
                }
                LiveIMController.this.mIsConnect = true;
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.live.LiveIM
    public void sendMessage(final String str, LiveSendMessage liveSendMessage, final LiveSendMessageListener liveSendMessageListener) {
        IMConversation iMConversation = this.mConversation;
        if (iMConversation != null && liveSendMessage != null) {
            iMConversation.sendMessage(liveSendMessage, null, new SendMessageListener() { // from class: com.baidu.livesdk.sdk.im.live.LiveIMController.4
                @Override // com.baidu.livesdk.api.im.SendMessageListener
                public void onSendMessageResult(int i, Object obj) {
                    List<LiveMessageBean> list;
                    LiveSendMessageListener liveSendMessageListener2 = liveSendMessageListener;
                    if (liveSendMessageListener2 != null) {
                        try {
                            String str2 = str;
                            if (obj != null) {
                                list = (List) obj;
                            } else {
                                list = null;
                            }
                            liveSendMessageListener2.onSendSuccess(str2, i, list);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        } else if (liveSendMessageListener != null) {
            liveSendMessageListener.onSendSuccess(str, -1, null);
        }
    }
}
