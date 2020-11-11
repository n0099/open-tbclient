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
    protected w aES;
    private c bJn;
    private a bJo;
    public BdUniqueId bou;
    public Context mContext;
    private long mChatId = 0;
    private boolean bJi = false;
    private long bJp = 2000;
    private long bJq = IMConnection.RETRY_DELAY_TIMES;
    private HttpMessageListener bJr = new HttpMessageListener(1021179) { // from class: com.baidu.live.videochat.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendCheckConnectResponseMessage) {
                b.this.a((LiveVideoChatSendCheckConnectResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bJs = new HttpMessageListener(1021180) { // from class: com.baidu.live.videochat.e.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendGetChatInfoResponseMessage) {
                b.this.a((LiveVideoChatSendGetChatInfoResponseMessage) httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener bJt = new HttpMessageListener(1021176) { // from class: com.baidu.live.videochat.e.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof LiveVideoChatSendFinishResponseMessage) {
                b.this.a((LiveVideoChatSendFinishResponseMessage) httpResponsedMessage);
            }
        }
    };
    private Runnable bJu = new Runnable() { // from class: com.baidu.live.videochat.e.b.4
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021179, b.this.bou);
            b.this.We();
            b.this.mHandler.postDelayed(this, b.this.bJq);
        }
    };
    private Runnable bJv = new Runnable() { // from class: com.baidu.live.videochat.e.b.5
        @Override // java.lang.Runnable
        public void run() {
            b.this.mHandler.removeCallbacks(this);
            MessageManager.getInstance().removeMessage(1021180, b.this.bou);
            b.this.Wg();
            b.this.mHandler.postDelayed(this, b.this.bJp);
        }
    };
    public Handler mHandler = new Handler();

    public abstract int getChatType();

    public b(Context context, BdUniqueId bdUniqueId) {
        this.mContext = context;
        this.bou = bdUniqueId;
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021176, "ala/livechat/finishLiveChat", LiveVideoChatSendFinishResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021179, "ala/livechat/getLiveChatUserInfo", LiveVideoChatSendCheckConnectResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021180, "ala/livechat/getLiveChatInfo", LiveVideoChatSendGetChatInfoResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bJt);
        MessageManager.getInstance().registerListener(this.bJr);
        MessageManager.getInstance().registerListener(this.bJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCheckConnectResponseMessage liveVideoChatSendCheckConnectResponseMessage) {
        if (liveVideoChatSendCheckConnectResponseMessage != null && liveVideoChatSendCheckConnectResponseMessage.getError() == 0) {
            this.bJq = liveVideoChatSendCheckConnectResponseMessage.getInterval();
            if (this.bJn != null) {
                this.bJn.a(liveVideoChatSendCheckConnectResponseMessage.getStatus(), liveVideoChatSendCheckConnectResponseMessage.getStatusText(), liveVideoChatSendCheckConnectResponseMessage.VX(), liveVideoChatSendCheckConnectResponseMessage.VV(), liveVideoChatSendCheckConnectResponseMessage.VW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendGetChatInfoResponseMessage liveVideoChatSendGetChatInfoResponseMessage) {
        if (liveVideoChatSendGetChatInfoResponseMessage != null && liveVideoChatSendGetChatInfoResponseMessage.getError() == 0) {
            this.bJp = liveVideoChatSendGetChatInfoResponseMessage.getInterval();
            com.baidu.live.videochat.b.b Wb = liveVideoChatSendGetChatInfoResponseMessage.Wb();
            boolean z = false;
            if (liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.b) {
                z = ((com.baidu.live.videochat.message.b) liveVideoChatSendGetChatInfoResponseMessage.getOrginalMessage()).VY();
            }
            if (Wb != null) {
                if (Wb.VD()) {
                    if (this.bJn != null) {
                        this.bJn.a(liveVideoChatSendGetChatInfoResponseMessage.Wb(), liveVideoChatSendGetChatInfoResponseMessage.VZ(), liveVideoChatSendGetChatInfoResponseMessage.Wa());
                    }
                } else if (Wb.Sc() && this.bJn != null) {
                    this.bJn.a(z, liveVideoChatSendGetChatInfoResponseMessage.Wb(), liveVideoChatSendGetChatInfoResponseMessage.VZ(), liveVideoChatSendGetChatInfoResponseMessage.Wa());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendFinishResponseMessage liveVideoChatSendFinishResponseMessage) {
        if (liveVideoChatSendFinishResponseMessage != null) {
            if (liveVideoChatSendFinishResponseMessage.getError() == 0) {
                if (this.bJn != null) {
                    this.bJn.Vq();
                }
            } else if (this.bJn != null) {
                this.bJn.M(liveVideoChatSendFinishResponseMessage.getError(), liveVideoChatSendFinishResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        this.bJn = cVar;
    }

    public long VE() {
        return this.mChatId;
    }

    public void a(a aVar) {
        this.bJo = aVar;
    }

    public void bb(long j) {
        if (this.aES != null && this.aES.mLiveInfo != null) {
            HttpMessage httpMessage = new HttpMessage(1021176);
            httpMessage.addParam("chat_id", j);
            httpMessage.addParam("live_id", this.aES.mLiveInfo.live_id);
            httpMessage.setTag(this.bou);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Wd() {
        Wf();
        We();
        this.mHandler.postDelayed(this.bJu, this.bJq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.aIV != null) {
            HttpMessage httpMessage = new HttpMessage(1021179);
            httpMessage.addParam("user_type", getChatType());
            httpMessage.addParam("live_id", this.aES.mLiveInfo.live_id);
            httpMessage.addParam("anchor_id", this.aES.aIV.userId);
            httpMessage.setTag(this.bou);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Wf() {
        this.mHandler.removeCallbacks(this.bJu);
        MessageManager.getInstance().removeMessage(1021179, this.bou);
    }

    public void c(long j, boolean z) {
        this.mChatId = j;
        this.bJi = z;
        Wh();
        Wg();
        this.mHandler.postDelayed(this.bJv, this.bJp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wg() {
        int i;
        int i2 = 0;
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.aIV != null) {
            if (this.bJo != null) {
                i2 = this.bJo.DG();
                i = this.bJo.Vk();
            } else {
                i = 0;
            }
            com.baidu.live.videochat.message.b bVar = new com.baidu.live.videochat.message.b(this.bJi);
            bVar.addParam("chat_id", this.mChatId);
            bVar.addParam("anchor_id", this.aES.aIV.userId);
            bVar.addParam("live_id", this.aES.mLiveInfo.live_id);
            bVar.addParam("anchor_id", this.aES.mLiveInfo.user_id);
            bVar.addParam("avts_conn", i);
            bVar.addParam("avts_fail", i2);
            bVar.setTag(this.bou);
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    public void Wh() {
        this.mHandler.removeCallbacks(this.bJv);
        MessageManager.getInstance().removeMessage(1021180, this.bou);
    }
}
