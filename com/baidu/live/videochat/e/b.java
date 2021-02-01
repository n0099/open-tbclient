package com.baidu.live.videochat.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes11.dex */
public abstract class b {
    public BdUniqueId aCW;
    protected ab aDd;
    private c bQB;
    private a bQC;
    public Context mContext;
    private long mChatId = 0;
    private boolean bQw = false;
    private long bQD = 2000;
    private long bQE = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bQF = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bQG = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bQH = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bQI = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aCW);
            b.this.WT();
            b.this.mHandler.postDelayed(this, b.this.bQE);
        }
    };
    private Runnable bQJ = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aCW);
            b.this.WV();
            b.this.mHandler.postDelayed(this, b.this.bQD);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aCW = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bQH);
        MessageManager.getInstance().registerListener(this.bQF);
        MessageManager.getInstance().registerListener(this.bQG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bQE = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bQB != null) {
                this.bQB.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.WM(), liveVideoChatSendCheckConnectResponseMessage.WK(), liveVideoChatSendCheckConnectResponseMessage.WL());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bQD = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b WQ = liveVideoChatSendGetChatInfoResponseMessage.WQ();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).WN();
            }
            if (WQ != null) {
                if (WQ.Wr()) {
                    if (this.bQB != null) {
                        this.bQB.a(liveVideoChatSendGetChatInfoResponseMessage.WQ(), liveVideoChatSendGetChatInfoResponseMessage.WO(), liveVideoChatSendGetChatInfoResponseMessage.WP());
                    }
                } else if (WQ.SK() && this.bQB != null) {
                    this.bQB.a(z, liveVideoChatSendGetChatInfoResponseMessage.WQ(), liveVideoChatSendGetChatInfoResponseMessage.WO(), liveVideoChatSendGetChatInfoResponseMessage.WP());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bQB != null) {
                    this.bQB.Wg();
                }
            } else if (this.bQB != null) {
                this.bQB.T(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bQB = cVar;
    }

    public long Ws() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bQC = aVar;
    }

    public void bD(long j) {
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aDd.mLiveInfo.live_id);
            httpMessage.setTag(this.aCW);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void WS() {
        WU();
        WT();
        this.mHandler.postDelayed(this.bQI, this.bQE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.aId != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aDd.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aDd.aId.userId);
            httpMessage.setTag(this.aCW);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void WU() {
        this.mHandler.removeCallbacks(this.bQI);
        MessageManager.getInstance().removeMessage(1021179, this.aCW);
    }

    public void f(long j, boolean z) {
        this.mChatId = j;
        this.bQw = z;
        WW();
        WV();
        this.mHandler.postDelayed(this.bQJ, this.bQD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        int i;
        int i2;
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.aId != null) {
            if (this.bQC != null) {
                i = this.bQC.AL();
                i2 = this.bQC.Wa();
            } else {
                i = 0;
                i2 = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bQw);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aDd.aId.userId);
            bVar.addParam("live_id", this.aDd.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aDd.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i2);
            bVar.addParam("avts_fail", i);
            bVar.setTag(this.aCW);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void WW() {
        this.mHandler.removeCallbacks(this.bQJ);
        MessageManager.getInstance().removeMessage(1021180, this.aCW);
    }
}
