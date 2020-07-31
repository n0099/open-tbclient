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
/* loaded from: classes4.dex */
public abstract class b {
    public BdUniqueId aZB;
    protected q avf;
    private c bmg;
    private a bmh;
    public Context mContext;
    private long mChatId = 0;
    private boolean bmb = false;
    private long bmi = 2000;
    private long bmj = 3000;
    private HttpMessageListener bmk = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bml = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bmm = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bmn = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aZB);
            b.this.Kw();
            b.this.mHandler.postDelayed(this, b.this.bmj);
        }
    };
    private Runnable bmo = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aZB);
            b.this.Ky();
            b.this.mHandler.postDelayed(this, b.this.bmi);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aZB = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bmm);
        MessageManager.getInstance().registerListener(this.bmk);
        MessageManager.getInstance().registerListener(this.bml);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bmj = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bmg != null) {
                this.bmg.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Kp(), liveVideoChatSendCheckConnectResponseMessage.Kn(), liveVideoChatSendCheckConnectResponseMessage.Ko());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bmi = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Kt = liveVideoChatSendGetChatInfoResponseMessage.Kt();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Kq();
            }
            if (Kt != null) {
                if (Kt.Kb()) {
                    if (this.bmg != null) {
                        this.bmg.a(liveVideoChatSendGetChatInfoResponseMessage.Kt(), liveVideoChatSendGetChatInfoResponseMessage.Kr(), liveVideoChatSendGetChatInfoResponseMessage.Ks());
                    }
                } else if (Kt.Ka() && this.bmg != null) {
                    this.bmg.a(z, liveVideoChatSendGetChatInfoResponseMessage.Kt(), liveVideoChatSendGetChatInfoResponseMessage.Kr(), liveVideoChatSendGetChatInfoResponseMessage.Ks());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bmg != null) {
                    this.bmg.JM();
                }
            } else if (this.bmg != null) {
                this.bmg.E(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bmg = cVar;
    }

    public long Kc() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bmh = aVar;
    }

    public void aA(long j) {
        if (this.avf != null && this.avf.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.avf.mLiveInfo.live_id);
            httpMessage.setTag(this.aZB);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Kv() {
        Kx();
        Kw();
        this.mHandler.postDelayed(this.bmn, this.bmj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kw() {
        if (this.avf != null && this.avf.mLiveInfo != null && this.avf.ayC != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.avf.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.avf.ayC.userId);
            httpMessage.setTag(this.aZB);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Kx() {
        this.mHandler.removeCallbacks(this.bmn);
        MessageManager.getInstance().removeMessage(1021179, this.aZB);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.bmb = z;
        Kz();
        Ky();
        this.mHandler.postDelayed(this.bmo, this.bmi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky() {
        int i;
        int i2 = 0;
        if (this.avf != null && this.avf.mLiveInfo != null && this.avf.ayC != null) {
            if (this.bmh != null) {
                i2 = this.bmh.ww();
                i = this.bmh.JG();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bmb);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.avf.ayC.userId);
            bVar.addParam("live_id", this.avf.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.avf.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.aZB);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Kz() {
        this.mHandler.removeCallbacks(this.bmo);
        MessageManager.getInstance().removeMessage(1021180, this.aZB);
    }
}
