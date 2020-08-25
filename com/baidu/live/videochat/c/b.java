package com.baidu.live.videochat.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.r;
import com.baidu.live.videochat.message.LiveVideoChatSendCheckConnectResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendFinishResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendGetChatInfoResponseMessage;
/* loaded from: classes7.dex */
public abstract class b {
    protected r aAh;
    public BdUniqueId beV;
    private c brM;
    private a brN;
    public Context mContext;
    private long mChatId = 0;
    private boolean brH = false;
    private long brO = 2000;
    private long brP = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener brQ = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener brR = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener brS = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable brT = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.beV);
            b.this.Qo();
            b.this.mHandler.postDelayed(this, b.this.brP);
        }
    };
    private Runnable brU = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.beV);
            b.this.Qq();
            b.this.mHandler.postDelayed(this, b.this.brO);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.beV = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.brS);
        MessageManager.getInstance().registerListener(this.brQ);
        MessageManager.getInstance().registerListener(this.brR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.brP = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.brM != null) {
                this.brM.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Qh(), liveVideoChatSendCheckConnectResponseMessage.Qf(), liveVideoChatSendCheckConnectResponseMessage.Qg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.brO = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Ql = liveVideoChatSendGetChatInfoResponseMessage.Ql();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Qi();
            }
            if (Ql != null) {
                if (Ql.PT()) {
                    if (this.brM != null) {
                        this.brM.a(liveVideoChatSendGetChatInfoResponseMessage.Ql(), liveVideoChatSendGetChatInfoResponseMessage.Qj(), liveVideoChatSendGetChatInfoResponseMessage.Qk());
                    }
                } else if (Ql.PS() && this.brM != null) {
                    this.brM.a(z, liveVideoChatSendGetChatInfoResponseMessage.Ql(), liveVideoChatSendGetChatInfoResponseMessage.Qj(), liveVideoChatSendGetChatInfoResponseMessage.Qk());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.brM != null) {
                    this.brM.PE();
                }
            } else if (this.brM != null) {
                this.brM.D(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.brM = cVar;
    }

    public long PU() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.brN = aVar;
    }

    public void aB(long j) {
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aAh.mLiveInfo.live_id);
            httpMessage.setTag(this.beV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qn() {
        Qp();
        Qo();
        this.mHandler.postDelayed(this.brT, this.brP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qo() {
        if (this.aAh != null && this.aAh.mLiveInfo != null && this.aAh.aDE != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aAh.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aAh.aDE.userId);
            httpMessage.setTag(this.beV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qp() {
        this.mHandler.removeCallbacks(this.brT);
        MessageManager.getInstance().removeMessage(1021179, this.beV);
    }

    public void b(long j, boolean z) {
        this.mChatId = j;
        this.brH = z;
        Qr();
        Qq();
        this.mHandler.postDelayed(this.brU, this.brO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qq() {
        int i;
        int i2 = 0;
        if (this.aAh != null && this.aAh.mLiveInfo != null && this.aAh.aDE != null) {
            if (this.brN != null) {
                i2 = this.brN.BU();
                i = this.brN.Py();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.brH);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aAh.aDE.userId);
            bVar.addParam("live_id", this.aAh.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aAh.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.beV);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Qr() {
        this.mHandler.removeCallbacks(this.brU);
        MessageManager.getInstance().removeMessage(1021180, this.beV);
    }
}
