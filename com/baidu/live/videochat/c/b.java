package com.baidu.live.videochat.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.n;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes3.dex */
public abstract class b {
    protected n aDK;
    public BdUniqueId aQK;
    private c aZj;
    private a aZk;
    public Context mContext;
    private long mChatId = 0;
    private boolean aZe = false;
    private long aZl = 2000;
    private long aZm = 3000;
    private HttpMessageListener aZn = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aZo = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aZp = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable aZq = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aQK);
            b.this.Hj();
            b.this.mHandler.postDelayed(this, b.this.aZm);
        }
    };
    private Runnable aZr = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aQK);
            b.this.Hl();
            b.this.mHandler.postDelayed(this, b.this.aZl);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aQK = bdUniqueId;
        xB();
        registerListener();
    }

    private void xB() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aZp);
        MessageManager.getInstance().registerListener(this.aZn);
        MessageManager.getInstance().registerListener(this.aZo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.aZm = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.aZj != null) {
                this.aZj.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Hc(), liveVideoChatSendCheckConnectResponseMessage.Ha(), liveVideoChatSendCheckConnectResponseMessage.Hb());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.aZl = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Hg = liveVideoChatSendGetChatInfoResponseMessage.Hg();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Hd();
            }
            if (Hg != null) {
                if (Hg.GO()) {
                    if (this.aZj != null) {
                        this.aZj.a(liveVideoChatSendGetChatInfoResponseMessage.Hg(), liveVideoChatSendGetChatInfoResponseMessage.He(), liveVideoChatSendGetChatInfoResponseMessage.Hf());
                    }
                } else if (Hg.GN() && this.aZj != null) {
                    this.aZj.a(z, liveVideoChatSendGetChatInfoResponseMessage.Hg(), liveVideoChatSendGetChatInfoResponseMessage.He(), liveVideoChatSendGetChatInfoResponseMessage.Hf());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.aZj != null) {
                    this.aZj.Gz();
                }
            } else if (this.aZj != null) {
                this.aZj.C(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.aZj = cVar;
    }

    public long GP() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.aZk = aVar;
    }

    public void av(long j) {
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aDK.mLiveInfo.live_id);
            httpMessage.setTag(this.aQK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Hi() {
        Hk();
        Hj();
        this.mHandler.postDelayed(this.aZq, this.aZm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hj() {
        if (this.aDK != null && this.aDK.mLiveInfo != null && this.aDK.aqk != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aDK.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aDK.aqk.userId);
            httpMessage.setTag(this.aQK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Hk() {
        this.mHandler.removeCallbacks(this.aZq);
        MessageManager.getInstance().removeMessage(1021179, this.aQK);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.aZe = z;
        Hm();
        Hl();
        this.mHandler.postDelayed(this.aZr, this.aZl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        int i;
        int i2 = 0;
        if (this.aDK != null && this.aDK.mLiveInfo != null && this.aDK.aqk != null) {
            if (this.aZk != null) {
                i2 = this.aZk.uz();
                i = this.aZk.Gt();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.aZe);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aDK.aqk.userId);
            bVar.addParam("live_id", this.aDK.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aDK.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.aQK);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Hm() {
        this.mHandler.removeCallbacks(this.aZr);
        MessageManager.getInstance().removeMessage(1021180, this.aQK);
    }
}
