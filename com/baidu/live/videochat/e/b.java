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
/* loaded from: classes10.dex */
public abstract class b {
    protected ab aED;
    public BdUniqueId aEw;
    private c bSb;
    private a bSc;
    public Context mContext;
    private long mChatId = 0;
    private boolean bRW = false;
    private long bSd = 2000;
    private long bSe = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bSf = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bSg = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bSh = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bSi = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aEw);
            b.this.WW();
            b.this.mHandler.postDelayed(this, b.this.bSe);
        }
    };
    private Runnable bSj = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aEw);
            b.this.WY();
            b.this.mHandler.postDelayed(this, b.this.bSd);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aEw = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bSh);
        MessageManager.getInstance().registerListener(this.bSf);
        MessageManager.getInstance().registerListener(this.bSg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bSe = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bSb != null) {
                this.bSb.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.WP(), liveVideoChatSendCheckConnectResponseMessage.WN(), liveVideoChatSendCheckConnectResponseMessage.WO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bSd = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b WT = liveVideoChatSendGetChatInfoResponseMessage.WT();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).WQ();
            }
            if (WT != null) {
                if (WT.Wu()) {
                    if (this.bSb != null) {
                        this.bSb.a(liveVideoChatSendGetChatInfoResponseMessage.WT(), liveVideoChatSendGetChatInfoResponseMessage.WR(), liveVideoChatSendGetChatInfoResponseMessage.WS());
                    }
                } else if (WT.SN() && this.bSb != null) {
                    this.bSb.a(z, liveVideoChatSendGetChatInfoResponseMessage.WT(), liveVideoChatSendGetChatInfoResponseMessage.WR(), liveVideoChatSendGetChatInfoResponseMessage.WS());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bSb != null) {
                    this.bSb.Wj();
                }
            } else if (this.bSb != null) {
                this.bSb.T(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bSb = cVar;
    }

    public long Wv() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bSc = aVar;
    }

    public void bD(long j) {
        if (this.aED != null && this.aED.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aED.mLiveInfo.live_id);
            httpMessage.setTag(this.aEw);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void WV() {
        WX();
        WW();
        this.mHandler.postDelayed(this.bSi, this.bSe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WW() {
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.aJD != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aED.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aED.aJD.userId);
            httpMessage.setTag(this.aEw);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void WX() {
        this.mHandler.removeCallbacks(this.bSi);
        MessageManager.getInstance().removeMessage(1021179, this.aEw);
    }

    public void f(long j, boolean z) {
        this.mChatId = j;
        this.bRW = z;
        WZ();
        WY();
        this.mHandler.postDelayed(this.bSj, this.bSd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        int i;
        int i2;
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.aJD != null) {
            if (this.bSc != null) {
                i = this.bSc.AO();
                i2 = this.bSc.Wd();
            } else {
                i = 0;
                i2 = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bRW);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aED.aJD.userId);
            bVar.addParam("live_id", this.aED.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aED.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i2);
            bVar.addParam("avts_fail", i);
            bVar.setTag(this.aEw);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void WZ() {
        this.mHandler.removeCallbacks(this.bSj);
        MessageManager.getInstance().removeMessage(1021180, this.aEw);
    }
}
