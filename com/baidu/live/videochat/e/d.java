package com.baidu.live.videochat.e;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendAcceptResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendBanUserResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendRefuseResponseMessage;
/* loaded from: classes10.dex */
public class d extends b {
    private e bKL;
    private HttpMessageListener bMV;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bMV = new HttpMessageListener(0) { // from class: com.baidu.live.videochat.e.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendAcceptResponseMessage) {
                    d.this.a((LiveVideoChatSendAcceptResponseMessage) httpResponsedMessage);
                } else if (httpResponsedMessage instanceof LiveVideoChatSendRefuseResponseMessage) {
                    d.this.a((LiveVideoChatSendRefuseResponseMessage) httpResponsedMessage);
                } else if (httpResponsedMessage instanceof LiveVideoChatSendBanUserResponseMessage) {
                    d.this.a((LiveVideoChatSendBanUserResponseMessage) httpResponsedMessage);
                }
            }
        };
        registerTask();
        registerListener();
    }

    private void registerTask() {
        com.baidu.live.tieba.f.a.a.a(1021175, "ala/livechat/refuseLiveChat", LiveVideoChatSendRefuseResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021174, "ala/livechat/acceptLiveChat", LiveVideoChatSendAcceptResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021178, "ala/livechat/chatBan", LiveVideoChatSendBanUserResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021174, this.bMV);
        MessageManager.getInstance().registerListener(1021175, this.bMV);
        MessageManager.getInstance().registerListener(1021178, this.bMV);
    }

    public void a(e eVar) {
        a((c) eVar);
        this.bKL = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendAcceptResponseMessage liveVideoChatSendAcceptResponseMessage) {
        if (liveVideoChatSendAcceptResponseMessage != null && this.bKL != null) {
            if (liveVideoChatSendAcceptResponseMessage.getError() == 0) {
                this.bKL.a(liveVideoChatSendAcceptResponseMessage.UY());
            } else {
                this.bKL.J(liveVideoChatSendAcceptResponseMessage.getError(), liveVideoChatSendAcceptResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendRefuseResponseMessage liveVideoChatSendRefuseResponseMessage) {
        if (liveVideoChatSendRefuseResponseMessage != null && this.bKL != null) {
            if (liveVideoChatSendRefuseResponseMessage.getError() == 0) {
                this.bKL.Us();
            } else {
                this.bKL.K(liveVideoChatSendRefuseResponseMessage.getError(), liveVideoChatSendRefuseResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendBanUserResponseMessage liveVideoChatSendBanUserResponseMessage) {
        if (liveVideoChatSendBanUserResponseMessage != null && this.bKL != null && (liveVideoChatSendBanUserResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.a)) {
            com.baidu.live.videochat.message.a aVar = (com.baidu.live.videochat.message.a) liveVideoChatSendBanUserResponseMessage.getOrginalMessage();
            if (liveVideoChatSendBanUserResponseMessage.getError() == 0) {
                if (aVar.UX()) {
                    if (aVar.UW()) {
                        this.bKL.Uu();
                    } else {
                        this.bKL.Ut();
                    }
                } else if (aVar.UW()) {
                    this.bKL.Uw();
                } else {
                    this.bKL.Uv();
                }
            } else if (aVar.UX()) {
                if (aVar.UW()) {
                    this.bKL.M(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                } else {
                    this.bKL.L(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                }
            } else if (aVar.UW()) {
                this.bKL.O(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            } else {
                this.bKL.N(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            }
        }
    }

    @Override // com.baidu.live.videochat.e.b
    public int getChatType() {
        return 1;
    }
}
