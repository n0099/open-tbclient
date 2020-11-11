package com.baidu.live.videochat.e;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendAcceptResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendBanUserResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendRefuseResponseMessage;
/* loaded from: classes4.dex */
public class d extends b {
    private e bHm;
    private HttpMessageListener bJx;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bJx = new HttpMessageListener(0) { // from class: com.baidu.live.videochat.e.d.1
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
        MessageManager.getInstance().registerListener(1021174, this.bJx);
        MessageManager.getInstance().registerListener(1021175, this.bJx);
        MessageManager.getInstance().registerListener(1021178, this.bJx);
    }

    public void a(e eVar) {
        a((c) eVar);
        this.bHm = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendAcceptResponseMessage liveVideoChatSendAcceptResponseMessage) {
        if (liveVideoChatSendAcceptResponseMessage != null && this.bHm != null) {
            if (liveVideoChatSendAcceptResponseMessage.getError() == 0) {
                this.bHm.a(liveVideoChatSendAcceptResponseMessage.VS());
            } else {
                this.bHm.G(liveVideoChatSendAcceptResponseMessage.getError(), liveVideoChatSendAcceptResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendRefuseResponseMessage liveVideoChatSendRefuseResponseMessage) {
        if (liveVideoChatSendRefuseResponseMessage != null && this.bHm != null) {
            if (liveVideoChatSendRefuseResponseMessage.getError() == 0) {
                this.bHm.Vl();
            } else {
                this.bHm.H(liveVideoChatSendRefuseResponseMessage.getError(), liveVideoChatSendRefuseResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendBanUserResponseMessage liveVideoChatSendBanUserResponseMessage) {
        if (liveVideoChatSendBanUserResponseMessage != null && this.bHm != null && (liveVideoChatSendBanUserResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.a)) {
            com.baidu.live.videochat.message.a aVar = (com.baidu.live.videochat.message.a) liveVideoChatSendBanUserResponseMessage.getOrginalMessage();
            if (liveVideoChatSendBanUserResponseMessage.getError() == 0) {
                if (aVar.VR()) {
                    if (aVar.VQ()) {
                        this.bHm.Vn();
                    } else {
                        this.bHm.Vm();
                    }
                } else if (aVar.VQ()) {
                    this.bHm.Vp();
                } else {
                    this.bHm.Vo();
                }
            } else if (aVar.VR()) {
                if (aVar.VQ()) {
                    this.bHm.J(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                } else {
                    this.bHm.I(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                }
            } else if (aVar.VQ()) {
                this.bHm.L(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            } else {
                this.bHm.K(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            }
        }
    }

    @Override // com.baidu.live.videochat.e.b
    public int getChatType() {
        return 1;
    }
}
