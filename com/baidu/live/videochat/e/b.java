package com.baidu.live.videochat.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.u;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes4.dex */
public abstract class b {
    protected u aDU;
    private c bAK;
    private a bAL;
    public BdUniqueId blA;
    public Context mContext;
    private long mChatId = 0;
    private boolean bAF = false;
    private long bAM = 2000;
    private long bAN = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bAO = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bAP = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bAQ = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bAR = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.blA);
            b.this.SE();
            b.this.mHandler.postDelayed(this, b.this.bAN);
        }
    };
    private Runnable bAS = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.blA);
            b.this.SG();
            b.this.mHandler.postDelayed(this, b.this.bAM);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.blA = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bAQ);
        MessageManager.getInstance().registerListener(this.bAO);
        MessageManager.getInstance().registerListener(this.bAP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bAN = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bAK != null) {
                this.bAK.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Sx(), liveVideoChatSendCheckConnectResponseMessage.Sv(), liveVideoChatSendCheckConnectResponseMessage.Sw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bAM = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b SB = liveVideoChatSendGetChatInfoResponseMessage.SB();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Sy();
            }
            if (SB != null) {
                if (SB.RY()) {
                    if (this.bAK != null) {
                        this.bAK.a(liveVideoChatSendGetChatInfoResponseMessage.SB(), liveVideoChatSendGetChatInfoResponseMessage.Sz(), liveVideoChatSendGetChatInfoResponseMessage.SA());
                    }
                } else if (SB.RX() && this.bAK != null) {
                    this.bAK.a(z, liveVideoChatSendGetChatInfoResponseMessage.SB(), liveVideoChatSendGetChatInfoResponseMessage.Sz(), liveVideoChatSendGetChatInfoResponseMessage.SA());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bAK != null) {
                    this.bAK.RJ();
                }
            } else if (this.bAK != null) {
                this.bAK.G(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bAK = cVar;
    }

    public long RZ() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bAL = aVar;
    }

    public void aD(long j) {
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aDU.mLiveInfo.live_id);
            httpMessage.setTag(this.blA);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void SD() {
        SF();
        SE();
        this.mHandler.postDelayed(this.bAR, this.bAN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SE() {
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.aHD != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aDU.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aDU.aHD.userId);
            httpMessage.setTag(this.blA);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void SF() {
        this.mHandler.removeCallbacks(this.bAR);
        MessageManager.getInstance().removeMessage(1021179, this.blA);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.bAF = z;
        SH();
        SG();
        this.mHandler.postDelayed(this.bAS, this.bAM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SG() {
        int i;
        int i2 = 0;
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.aHD != null) {
            if (this.bAL != null) {
                i2 = this.bAL.Dg();
                i = this.bAL.RD();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bAF);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aDU.aHD.userId);
            bVar.addParam("live_id", this.aDU.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aDU.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.blA);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void SH() {
        this.mHandler.removeCallbacks(this.bAS);
        MessageManager.getInstance().removeMessage(1021180, this.blA);
    }
}
