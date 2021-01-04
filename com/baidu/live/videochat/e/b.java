package com.baidu.live.videochat.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.x;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes11.dex */
public abstract class b {
    protected x aGe;
    private c bRx;
    private a bRy;
    public BdUniqueId bwz;
    public Context mContext;
    private long mChatId = 0;
    private boolean bRs = false;
    private long bRz = 2000;
    private long bRA = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bRB = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bRC = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bRD = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bRE = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.bwz);
            b.this.Zc();
            b.this.mHandler.postDelayed(this, b.this.bRA);
        }
    };
    private Runnable bRF = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.bwz);
            b.this.Ze();
            b.this.mHandler.postDelayed(this, b.this.bRz);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bwz = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bRD);
        MessageManager.getInstance().registerListener(this.bRB);
        MessageManager.getInstance().registerListener(this.bRC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bRA = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bRx != null) {
                this.bRx.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.YV(), liveVideoChatSendCheckConnectResponseMessage.YT(), liveVideoChatSendCheckConnectResponseMessage.YU());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bRz = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b YZ = liveVideoChatSendGetChatInfoResponseMessage.YZ();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).YW();
            }
            if (YZ != null) {
                if (YZ.YA()) {
                    if (this.bRx != null) {
                        this.bRx.a(liveVideoChatSendGetChatInfoResponseMessage.YZ(), liveVideoChatSendGetChatInfoResponseMessage.YX(), liveVideoChatSendGetChatInfoResponseMessage.YY());
                    }
                } else if (YZ.UW() && this.bRx != null) {
                    this.bRx.a(z, liveVideoChatSendGetChatInfoResponseMessage.YZ(), liveVideoChatSendGetChatInfoResponseMessage.YX(), liveVideoChatSendGetChatInfoResponseMessage.YY());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bRx != null) {
                    this.bRx.Yp();
                }
            } else if (this.bRx != null) {
                this.bRx.O(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bRx = cVar;
    }

    public long YB() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bRy = aVar;
    }

    public void bz(long j) {
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aGe.mLiveInfo.live_id);
            httpMessage.setTag(this.bwz);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Zb() {
        Zd();
        Zc();
        this.mHandler.postDelayed(this.bRE, this.bRA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zc() {
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.aKu != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aGe.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aGe.aKu.userId);
            httpMessage.setTag(this.bwz);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Zd() {
        this.mHandler.removeCallbacks(this.bRE);
        MessageManager.getInstance().removeMessage(1021179, this.bwz);
    }

    public void d(long j, boolean z) {
        this.mChatId = j;
        this.bRs = z;
        Zf();
        Ze();
        this.mHandler.postDelayed(this.bRF, this.bRz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        int i;
        int i2;
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.aKu != null) {
            if (this.bRy != null) {
                i = this.bRy.DW();
                i2 = this.bRy.Yj();
            } else {
                i = 0;
                i2 = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bRs);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aGe.aKu.userId);
            bVar.addParam("live_id", this.aGe.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aGe.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i2);
            bVar.addParam("avts_fail", i);
            bVar.setTag(this.bwz);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Zf() {
        this.mHandler.removeCallbacks(this.bRF);
        MessageManager.getInstance().removeMessage(1021180, this.bwz);
    }
}
