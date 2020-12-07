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
    protected w aFN;
    private c bMK;
    private a bML;
    public BdUniqueId brR;
    public Context mContext;
    private long mChatId = 0;
    private boolean bMF = false;
    private long bMM = 2000;
    private long bMN = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bMO = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bMP = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bMQ = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bMR = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.brR);
            b.this.XV();
            b.this.mHandler.postDelayed(this, b.this.bMN);
        }
    };
    private Runnable bMS = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.brR);
            b.this.XX();
            b.this.mHandler.postDelayed(this, b.this.bMM);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.brR = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bMQ);
        MessageManager.getInstance().registerListener(this.bMO);
        MessageManager.getInstance().registerListener(this.bMP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bMN = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bMK != null) {
                this.bMK.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.XO(), liveVideoChatSendCheckConnectResponseMessage.XM(), liveVideoChatSendCheckConnectResponseMessage.XN());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bMM = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b XS = liveVideoChatSendGetChatInfoResponseMessage.XS();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).XP();
            }
            if (XS != null) {
                if (XS.Xu()) {
                    if (this.bMK != null) {
                        this.bMK.a(liveVideoChatSendGetChatInfoResponseMessage.XS(), liveVideoChatSendGetChatInfoResponseMessage.XQ(), liveVideoChatSendGetChatInfoResponseMessage.XR());
                    }
                } else if (XS.TR() && this.bMK != null) {
                    this.bMK.a(z, liveVideoChatSendGetChatInfoResponseMessage.XS(), liveVideoChatSendGetChatInfoResponseMessage.XQ(), liveVideoChatSendGetChatInfoResponseMessage.XR());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bMK != null) {
                    this.bMK.Xj();
                }
            } else if (this.bMK != null) {
                this.bMK.M(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bMK = cVar;
    }

    public long Xv() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bML = aVar;
    }

    public void bz(long j) {
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aFN.mLiveInfo.live_id);
            httpMessage.setTag(this.brR);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void XU() {
        XW();
        XV();
        this.mHandler.postDelayed(this.bMR, this.bMN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XV() {
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.aJV != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aFN.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aFN.aJV.userId);
            httpMessage.setTag(this.brR);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void XW() {
        this.mHandler.removeCallbacks(this.bMR);
        MessageManager.getInstance().removeMessage(1021179, this.brR);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.bMF = z;
        XY();
        XX();
        this.mHandler.postDelayed(this.bMS, this.bMM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        int i;
        int i2 = 0;
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.aJV != null) {
            if (this.bML != null) {
                i2 = this.bML.EH();
                i = this.bML.Xd();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bMF);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aFN.aJV.userId);
            bVar.addParam("live_id", this.aFN.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aFN.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.brR);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void XY() {
        this.mHandler.removeCallbacks(this.bMS);
        MessageManager.getInstance().removeMessage(1021180, this.brR);
    }
}
