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
    protected w aDh;
    private c bHC;
    private a bHD;
    public BdUniqueId bmJ;
    public Context mContext;
    private long mChatId = 0;
    private boolean bHx = false;
    private long bHE = 2000;
    private long bHF = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bHG = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bHH = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bHI = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bHJ = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.bmJ);
            b.this.Vv();
            b.this.mHandler.postDelayed(this, b.this.bHF);
        }
    };
    private Runnable bHK = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.bmJ);
            b.this.Vx();
            b.this.mHandler.postDelayed(this, b.this.bHE);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bmJ = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bHI);
        MessageManager.getInstance().registerListener(this.bHG);
        MessageManager.getInstance().registerListener(this.bHH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bHF = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bHC != null) {
                this.bHC.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Vo(), liveVideoChatSendCheckConnectResponseMessage.Vm(), liveVideoChatSendCheckConnectResponseMessage.Vn());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bHE = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Vs = liveVideoChatSendGetChatInfoResponseMessage.Vs();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Vp();
            }
            if (Vs != null) {
                if (Vs.UU()) {
                    if (this.bHC != null) {
                        this.bHC.a(liveVideoChatSendGetChatInfoResponseMessage.Vs(), liveVideoChatSendGetChatInfoResponseMessage.Vq(), liveVideoChatSendGetChatInfoResponseMessage.Vr());
                    }
                } else if (Vs.Rt() && this.bHC != null) {
                    this.bHC.a(z, liveVideoChatSendGetChatInfoResponseMessage.Vs(), liveVideoChatSendGetChatInfoResponseMessage.Vq(), liveVideoChatSendGetChatInfoResponseMessage.Vr());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bHC != null) {
                    this.bHC.UH();
                }
            } else if (this.bHC != null) {
                this.bHC.M(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bHC = cVar;
    }

    public long UV() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bHD = aVar;
    }

    public void bb(long j) {
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aDh.mLiveInfo.live_id);
            httpMessage.setTag(this.bmJ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Vu() {
        Vw();
        Vv();
        this.mHandler.postDelayed(this.bHJ, this.bHF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vv() {
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.aHk != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aDh.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aDh.aHk.userId);
            httpMessage.setTag(this.bmJ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Vw() {
        this.mHandler.removeCallbacks(this.bHJ);
        MessageManager.getInstance().removeMessage(1021179, this.bmJ);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.bHx = z;
        Vy();
        Vx();
        this.mHandler.postDelayed(this.bHK, this.bHE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vx() {
        int i;
        int i2 = 0;
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.aHk != null) {
            if (this.bHD != null) {
                i2 = this.bHD.CX();
                i = this.bHD.UB();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bHx);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aDh.aHk.userId);
            bVar.addParam("live_id", this.aDh.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aDh.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.bmJ);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Vy() {
        this.mHandler.removeCallbacks(this.bHK);
        MessageManager.getInstance().removeMessage(1021180, this.bmJ);
    }
}
