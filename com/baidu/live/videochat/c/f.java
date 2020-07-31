package com.baidu.live.videochat.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendCancelResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendStartResponseMessage;
/* loaded from: classes4.dex */
public class f extends b {
    private g blx;
    private HttpMessageListener bmt;
    private HttpMessageListener bmu;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bmt = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.c.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.bmu = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.c.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendCancelResponseMessage) {
                    f.this.a((LiveVideoChatSendCancelResponseMessage) httpResponsedMessage);
                }
            }
        };
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021173, "ala/livechat/cancelLiveChat", LiveVideoChatSendCancelResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021177, "ala/livechat/startLiveChat", LiveVideoChatSendStartResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bmt);
        MessageManager.getInstance().registerListener(this.bmu);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.blx = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.Ku() != null) {
                if (liveVideoChatSendStartResponseMessage.Ku().Kf()) {
                    if (this.blx != null) {
                        this.blx.JQ();
                    }
                } else if (this.blx != null) {
                    this.blx.F(liveVideoChatSendStartResponseMessage.Ku().Kg(), liveVideoChatSendStartResponseMessage.Ku().Kh());
                }
            } else if (this.blx != null) {
                this.blx.F(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.blx != null) {
                    this.blx.G(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.Kl()) {
                if (this.blx != null) {
                    this.blx.JR();
                }
            } else if (this.blx != null) {
                this.blx.a(liveVideoChatSendCancelResponseMessage.Km(), liveVideoChatSendCancelResponseMessage.Kn(), liveVideoChatSendCancelResponseMessage.Ko());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 2;
    }
}
