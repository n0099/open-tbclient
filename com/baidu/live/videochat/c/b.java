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
    protected r aAj;
    public BdUniqueId beX;
    private c brP;
    private a brQ;
    public Context mContext;
    private long mChatId = 0;
    private boolean brK = false;
    private long brR = 2000;
    private long brS = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener brT = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener brU = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener brV = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable brW = new Runnable() { // from class: com.baidu.live.videochat.c.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.beX);
            b.this.Qo();
            b.this.mHandler.postDelayed(this, b.this.brS);
        }
    };
    private Runnable brX = new Runnable() { // from class: com.baidu.live.videochat.c.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.beX);
            b.this.Qq();
            b.this.mHandler.postDelayed(this, b.this.brR);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.beX = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.brV);
        MessageManager.getInstance().registerListener(this.brT);
        MessageManager.getInstance().registerListener(this.brU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.brS = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.brP != null) {
                this.brP.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.Qh(), liveVideoChatSendCheckConnectResponseMessage.Qf(), liveVideoChatSendCheckConnectResponseMessage.Qg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.brR = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Ql = liveVideoChatSendGetChatInfoResponseMessage.Ql();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).Qi();
            }
            if (Ql != null) {
                if (Ql.PT()) {
                    if (this.brP != null) {
                        this.brP.a(liveVideoChatSendGetChatInfoResponseMessage.Ql(), liveVideoChatSendGetChatInfoResponseMessage.Qj(), liveVideoChatSendGetChatInfoResponseMessage.Qk());
                    }
                } else if (Ql.PS() && this.brP != null) {
                    this.brP.a(z, liveVideoChatSendGetChatInfoResponseMessage.Ql(), liveVideoChatSendGetChatInfoResponseMessage.Qj(), liveVideoChatSendGetChatInfoResponseMessage.Qk());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.brP != null) {
                    this.brP.PE();
                }
            } else if (this.brP != null) {
                this.brP.D(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.brP = cVar;
    }

    public long PU() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.brQ = aVar;
    }

    public void aB(long j) {
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aAj.mLiveInfo.live_id);
            httpMessage.setTag(this.beX);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qn() {
        Qp();
        Qo();
        this.mHandler.postDelayed(this.brW, this.brS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qo() {
        if (this.aAj != null && this.aAj.mLiveInfo != null && this.aAj.aDG != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aAj.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aAj.aDG.userId);
            httpMessage.setTag(this.beX);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qp() {
        this.mHandler.removeCallbacks(this.brW);
        MessageManager.getInstance().removeMessage(1021179, this.beX);
    }

    public void b(long j, boolean z) {
        this.mChatId = j;
        this.brK = z;
        Qr();
        Qq();
        this.mHandler.postDelayed(this.brX, this.brR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qq() {
        int i;
        int i2 = 0;
        if (this.aAj != null && this.aAj.mLiveInfo != null && this.aAj.aDG != null) {
            if (this.brQ != null) {
                i2 = this.brQ.BU();
                i = this.brQ.Py();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.brK);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aAj.aDG.userId);
            bVar.addParam("live_id", this.aAj.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aAj.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.beX);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Qr() {
        this.mHandler.removeCallbacks(this.brX);
        MessageManager.getInstance().removeMessage(1021180, this.beX);
    }
}
