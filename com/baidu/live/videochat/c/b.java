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
    protected q aJj;
    public BdUniqueId aWV;
    private c bgG;
    private a bgH;
    public Context mContext;
    private long mChatId = 0;
    private boolean bgB = false;
    private long bgI = 2000;
    private long bgJ = 3000;
    private HttpMessageListener bgK = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bgL = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bgM = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bgN = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.aWV);
            b.this.Jc();
            b.this.mHandler.postDelayed(this, b.this.bgJ);
        }
    };
    private Runnable bgO = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.aWV);
            b.this.Je();
            b.this.mHandler.postDelayed(this, b.this.bgI);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.aWV = bdUniqueId;
        Fv();
        registerListener();
    }

    private void Fv() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bgM);
        MessageManager.getInstance().registerListener(this.bgK);
        MessageManager.getInstance().registerListener(this.bgL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bgJ = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bgG != null) {
                this.bgG.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.IV(), liveVideoChatSendCheckConnectResponseMessage.IT(), liveVideoChatSendCheckConnectResponseMessage.IU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bgI = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b IZ = liveVideoChatSendGetChatInfoResponseMessage.IZ();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).IW();
            }
            if (IZ != null) {
                if (IZ.IH()) {
                    if (this.bgG != null) {
                        this.bgG.a(liveVideoChatSendGetChatInfoResponseMessage.IZ(), liveVideoChatSendGetChatInfoResponseMessage.IX(), liveVideoChatSendGetChatInfoResponseMessage.IY());
                    }
                } else if (IZ.IG() && this.bgG != null) {
                    this.bgG.a(z, liveVideoChatSendGetChatInfoResponseMessage.IZ(), liveVideoChatSendGetChatInfoResponseMessage.IX(), liveVideoChatSendGetChatInfoResponseMessage.IY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bgG != null) {
                    this.bgG.Is();
                }
            } else if (this.bgG != null) {
                this.bgG.C(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bgG = cVar;
    }

    public long II() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bgH = aVar;
    }

    public void aA(long j) {
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aJj.mLiveInfo.live_id);
            httpMessage.setTag(this.aWV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Jb() {
        Jd();
        Jc();
        this.mHandler.postDelayed(this.bgN, this.bgJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.avj != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aJj.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aJj.avj.userId);
            httpMessage.setTag(this.aWV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Jd() {
        this.mHandler.removeCallbacks(this.bgN);
        MessageManager.getInstance().removeMessage(1021179, this.aWV);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.bgB = z;
        Jf();
        Je();
        this.mHandler.postDelayed(this.bgO, this.bgI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Je() {
        int i;
        int i2 = 0;
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.avj != null) {
            if (this.bgH != null) {
                i2 = this.bgH.vG();
                i = this.bgH.Im();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bgB);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aJj.avj.userId);
            bVar.addParam("live_id", this.aJj.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aJj.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.aWV);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Jf() {
        this.mHandler.removeCallbacks(this.bgO);
        MessageManager.getInstance().removeMessage(1021180, this.aWV);
    }
}
