package com.baidu.live.videochat.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes4.dex */
public abstract class b {
    protected w aEc;
    private c bDG;
    private a bDH;
    public BdUniqueId bnb;
    public Context mContext;
    private long mChatId = 0;
    private boolean bDB = false;
    private long bDI = 2000;
    private long bDJ = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bDK = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bDL = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bDM = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bDN = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.bnb);
            b.this.TE();
            b.this.mHandler.postDelayed(this, b.this.bDJ);
        }
    };
    private Runnable bDO = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.bnb);
            b.this.TG();
            b.this.mHandler.postDelayed(this, b.this.bDI);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bnb = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bDM);
        MessageManager.getInstance().registerListener(this.bDK);
        MessageManager.getInstance().registerListener(this.bDL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bDJ = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bDG != null) {
                this.bDG.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Tx(), liveVideoChatSendCheckConnectResponseMessage.Tv(), liveVideoChatSendCheckConnectResponseMessage.Tw());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bDI = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b TB = liveVideoChatSendGetChatInfoResponseMessage.TB();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Ty();
            }
            if (TB != null) {
                if (TB.SY()) {
                    if (this.bDG != null) {
                        this.bDG.a(liveVideoChatSendGetChatInfoResponseMessage.TB(), liveVideoChatSendGetChatInfoResponseMessage.Tz(), liveVideoChatSendGetChatInfoResponseMessage.TA());
                    }
                } else if (TB.SX() && this.bDG != null) {
                    this.bDG.a(z, liveVideoChatSendGetChatInfoResponseMessage.TB(), liveVideoChatSendGetChatInfoResponseMessage.Tz(), liveVideoChatSendGetChatInfoResponseMessage.TA());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bDG != null) {
                    this.bDG.SJ();
                }
            } else if (this.bDG != null) {
                this.bDG.I(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bDG = cVar;
    }

    public long SZ() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bDH = aVar;
    }

    public void aF(long j) {
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aEc.mLiveInfo.live_id);
            httpMessage.setTag(this.bnb);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void TD() {
        TF();
        TE();
        this.mHandler.postDelayed(this.bDN, this.bDJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TE() {
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.aIe != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aEc.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aEc.aIe.userId);
            httpMessage.setTag(this.bnb);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void TF() {
        this.mHandler.removeCallbacks(this.bDN);
        MessageManager.getInstance().removeMessage(1021179, this.bnb);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.bDB = z;
        TH();
        TG();
        this.mHandler.postDelayed(this.bDO, this.bDI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TG() {
        int i;
        int i2 = 0;
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.aIe != null) {
            if (this.bDH != null) {
                i2 = this.bDH.Dn();
                i = this.bDH.SD();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bDB);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aEc.aIe.userId);
            bVar.addParam("live_id", this.aEc.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aEc.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.bnb);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void TH() {
        this.mHandler.removeCallbacks(this.bDO);
        MessageManager.getInstance().removeMessage(1021180, this.bnb);
    }
}
