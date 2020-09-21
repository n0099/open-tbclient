package com.baidu.live.videochat.c;

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
    protected u aAP;
    public BdUniqueId bhK;
    private c bve;
    private a bvf;
    public Context mContext;
    private long mChatId = 0;
    private boolean buZ = false;
    private long bvg = 2000;
    private long bvh = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bvi = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bvj = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bvk = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bvl = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.bhK);
            b.this.QW();
            b.this.mHandler.postDelayed(this, b.this.bvh);
        }
    };
    private Runnable bvm = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.bhK);
            b.this.QY();
            b.this.mHandler.postDelayed(this, b.this.bvg);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bhK = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bvk);
        MessageManager.getInstance().registerListener(this.bvi);
        MessageManager.getInstance().registerListener(this.bvj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bvh = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bve != null) {
                this.bve.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.QP(), liveVideoChatSendCheckConnectResponseMessage.QN(), liveVideoChatSendCheckConnectResponseMessage.QO());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bvg = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b QT = liveVideoChatSendGetChatInfoResponseMessage.QT();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).QQ();
            }
            if (QT != null) {
                if (QT.QB()) {
                    if (this.bve != null) {
                        this.bve.a(liveVideoChatSendGetChatInfoResponseMessage.QT(), liveVideoChatSendGetChatInfoResponseMessage.QR(), liveVideoChatSendGetChatInfoResponseMessage.QS());
                    }
                } else if (QT.QA() && this.bve != null) {
                    this.bve.a(z, liveVideoChatSendGetChatInfoResponseMessage.QT(), liveVideoChatSendGetChatInfoResponseMessage.QR(), liveVideoChatSendGetChatInfoResponseMessage.QS());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bve != null) {
                    this.bve.Qm();
                }
            } else if (this.bve != null) {
                this.bve.E(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bve = cVar;
    }

    public long QC() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bvf = aVar;
    }

    public void aB(long j) {
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aAP.mLiveInfo.live_id);
            httpMessage.setTag(this.bhK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void QV() {
        QX();
        QW();
        this.mHandler.postDelayed(this.bvl, this.bvh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QW() {
        if (this.aAP != null && this.aAP.mLiveInfo != null && this.aAP.aEz != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aAP.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aAP.aEz.userId);
            httpMessage.setTag(this.bhK);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void QX() {
        this.mHandler.removeCallbacks(this.bvl);
        MessageManager.getInstance().removeMessage(1021179, this.bhK);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.buZ = z;
        QZ();
        QY();
        this.mHandler.postDelayed(this.bvm, this.bvg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QY() {
        int i;
        int i2 = 0;
        if (this.aAP != null && this.aAP.mLiveInfo != null && this.aAP.aEz != null) {
            if (this.bvf != null) {
                i2 = this.bvf.Cj();
                i = this.bvf.Qg();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.buZ);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aAP.aEz.userId);
            bVar.addParam("live_id", this.aAP.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aAP.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.bhK);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void QZ() {
        this.mHandler.removeCallbacks(this.bvm);
        MessageManager.getInstance().removeMessage(1021180, this.bhK);
    }
}
