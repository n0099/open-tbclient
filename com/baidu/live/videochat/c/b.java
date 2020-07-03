package com.baidu.live.videochat.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.q;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes3.dex */
public abstract class b {
    protected q aLQ;
    public BdUniqueId aZD;
    private c blM;
    private a blN;
    public Context mContext;
    private long mChatId = 0;
    private boolean blH = false;
    private long blO = 2000;
    private long blP = 3000;
    private HttpMessageListener blQ = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener blR = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener blS = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable blT = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aZD);
            b.this.Kp();
            b.this.mHandler.postDelayed(this, b.this.blP);
        }
    };
    private Runnable blU = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aZD);
            b.this.Kr();
            b.this.mHandler.postDelayed(this, b.this.blO);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aZD = bdUniqueId;
        xp();
        registerListener();
    }

    private void xp() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.blS);
        MessageManager.getInstance().registerListener(this.blQ);
        MessageManager.getInstance().registerListener(this.blR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.blP = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.blM != null) {
                this.blM.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Ki(), liveVideoChatSendCheckConnectResponseMessage.Kg(), liveVideoChatSendCheckConnectResponseMessage.Kh());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.blO = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Km = liveVideoChatSendGetChatInfoResponseMessage.Km();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Kj();
            }
            if (Km != null) {
                if (Km.JU()) {
                    if (this.blM != null) {
                        this.blM.a(liveVideoChatSendGetChatInfoResponseMessage.Km(), liveVideoChatSendGetChatInfoResponseMessage.Kk(), liveVideoChatSendGetChatInfoResponseMessage.Kl());
                    }
                } else if (Km.JT() && this.blM != null) {
                    this.blM.a(z, liveVideoChatSendGetChatInfoResponseMessage.Km(), liveVideoChatSendGetChatInfoResponseMessage.Kk(), liveVideoChatSendGetChatInfoResponseMessage.Kl());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.blM != null) {
                    this.blM.JF();
                }
            } else if (this.blM != null) {
                this.blM.E(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.blM = cVar;
    }

    public long JV() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.blN = aVar;
    }

    public void aA(long j) {
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aLQ.mLiveInfo.live_id);
            httpMessage.setTag(this.aZD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Ko() {
        Kq();
        Kp();
        this.mHandler.postDelayed(this.blT, this.blP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp() {
        if (this.aLQ != null && this.aLQ.mLiveInfo != null && this.aLQ.axp != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aLQ.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aLQ.axp.userId);
            httpMessage.setTag(this.aZD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Kq() {
        this.mHandler.removeCallbacks(this.blT);
        MessageManager.getInstance().removeMessage(1021179, this.aZD);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.blH = z;
        Ks();
        Kr();
        this.mHandler.postDelayed(this.blU, this.blO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kr() {
        int i;
        int i2 = 0;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null && this.aLQ.axp != null) {
            if (this.blN != null) {
                i2 = this.blN.wa();
                i = this.blN.Jz();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.blH);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aLQ.axp.userId);
            bVar.addParam("live_id", this.aLQ.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aLQ.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.aZD);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Ks() {
        this.mHandler.removeCallbacks(this.blU);
        MessageManager.getInstance().removeMessage(1021180, this.aZD);
    }
}
