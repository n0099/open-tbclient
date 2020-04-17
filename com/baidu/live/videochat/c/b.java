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
    protected n aDE;
    public BdUniqueId aQF;
    private c aZe;
    private a aZf;
    public Context mContext;
    private long mChatId = 0;
    private boolean aYZ = false;
    private long aZg = 2000;
    private long aZh = 3000;
    private HttpMessageListener aZi = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aZj = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener aZk = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable aZl = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aQF);
            b.this.Hk();
            b.this.mHandler.postDelayed(this, b.this.aZh);
        }
    };
    private Runnable aZm = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aQF);
            b.this.Hm();
            b.this.mHandler.postDelayed(this, b.this.aZg);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aQF = bdUniqueId;
        xC();
        registerListener();
    }

    private void xC() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aZk);
        MessageManager.getInstance().registerListener(this.aZi);
        MessageManager.getInstance().registerListener(this.aZj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.aZh = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.aZe != null) {
                this.aZe.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Hd(), liveVideoChatSendCheckConnectResponseMessage.Hb(), liveVideoChatSendCheckConnectResponseMessage.Hc());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.aZg = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Hh = liveVideoChatSendGetChatInfoResponseMessage.Hh();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).He();
            }
            if (Hh != null) {
                if (Hh.GP()) {
                    if (this.aZe != null) {
                        this.aZe.a(liveVideoChatSendGetChatInfoResponseMessage.Hh(), liveVideoChatSendGetChatInfoResponseMessage.Hf(), liveVideoChatSendGetChatInfoResponseMessage.Hg());
                    }
                } else if (Hh.GO() && this.aZe != null) {
                    this.aZe.a(z, liveVideoChatSendGetChatInfoResponseMessage.Hh(), liveVideoChatSendGetChatInfoResponseMessage.Hf(), liveVideoChatSendGetChatInfoResponseMessage.Hg());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.aZe != null) {
                    this.aZe.GA();
                }
            } else if (this.aZe != null) {
                this.aZe.C(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.aZe = cVar;
    }

    public long GQ() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.aZf = aVar;
    }

    public void av(long j) {
        if (this.aDE != null && this.aDE.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aDE.mLiveInfo.live_id);
            httpMessage.setTag(this.aQF);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Hj() {
        Hl();
        Hk();
        this.mHandler.postDelayed(this.aZl, this.aZh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hk() {
        if (this.aDE != null && this.aDE.mLiveInfo != null && this.aDE.aqe != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aDE.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aDE.aqe.userId);
            httpMessage.setTag(this.aQF);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Hl() {
        this.mHandler.removeCallbacks(this.aZl);
        MessageManager.getInstance().removeMessage(1021179, this.aQF);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.aYZ = z;
        Hn();
        Hm();
        this.mHandler.postDelayed(this.aZm, this.aZg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
        int i;
        int i2 = 0;
        if (this.aDE != null && this.aDE.mLiveInfo != null && this.aDE.aqe != null) {
            if (this.aZf != null) {
                i2 = this.aZf.uA();
                i = this.aZf.Gu();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.aYZ);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aDE.aqe.userId);
            bVar.addParam("live_id", this.aDE.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aDE.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.aQF);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacks(this.aZm);
        MessageManager.getInstance().removeMessage(1021180, this.aQF);
    }
}
