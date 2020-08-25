package com.baidu.live.videochat.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendAcceptResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendBanUserResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendRefuseResponseMessage;
/* loaded from: classes7.dex */
public class d extends b {
    private e bqO;
    private HttpMessageListener brW;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.brW = new HttpMessageListener(0) { // from class: com.baidu.live.videochat.c.d.1
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
        MessageManager.getInstance().registerListener(1021174, this.brW);
        MessageManager.getInstance().registerListener(1021175, this.brW);
        MessageManager.getInstance().registerListener(1021178, this.brW);
    }

    public void a(e eVar) {
        a((c) eVar);
        this.bqO = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendAcceptResponseMessage liveVideoChatSendAcceptResponseMessage) {
        if (liveVideoChatSendAcceptResponseMessage != null && this.bqO != null) {
            if (liveVideoChatSendAcceptResponseMessage.getError() == 0) {
                this.bqO.a(liveVideoChatSendAcceptResponseMessage.Qc());
            } else {
                this.bqO.x(liveVideoChatSendAcceptResponseMessage.getError(), liveVideoChatSendAcceptResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendRefuseResponseMessage liveVideoChatSendRefuseResponseMessage) {
        if (liveVideoChatSendRefuseResponseMessage != null && this.bqO != null) {
            if (liveVideoChatSendRefuseResponseMessage.getError() == 0) {
                this.bqO.Pz();
            } else {
                this.bqO.y(liveVideoChatSendRefuseResponseMessage.getError(), liveVideoChatSendRefuseResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendBanUserResponseMessage liveVideoChatSendBanUserResponseMessage) {
        if (liveVideoChatSendBanUserResponseMessage != null && this.bqO != null && (liveVideoChatSendBanUserResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.a)) {
            com.baidu.live.videochat.message.a aVar = (com.baidu.live.videochat.message.a) liveVideoChatSendBanUserResponseMessage.getOrginalMessage();
            if (liveVideoChatSendBanUserResponseMessage.getError() == 0) {
                if (aVar.Qb()) {
                    if (aVar.Qa()) {
                        this.bqO.PB();
                    } else {
                        this.bqO.PA();
                    }
                } else if (aVar.Qa()) {
                    this.bqO.PD();
                } else {
                    this.bqO.PC();
                }
            } else if (aVar.Qb()) {
                if (aVar.Qa()) {
                    this.bqO.A(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                } else {
                    this.bqO.z(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                }
            } else if (aVar.Qa()) {
                this.bqO.C(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            } else {
                this.bqO.B(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 1;
    }
}
