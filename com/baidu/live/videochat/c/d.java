package com.baidu.live.videochat.c;

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
    private e bug;
    private HttpMessageListener bvo;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bvo = new HttpMessageListener(0) { // from class: com.baidu.live.videochat.c.d.1
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
        MessageManager.getInstance().registerListener(1021174, this.bvo);
        MessageManager.getInstance().registerListener(1021175, this.bvo);
        MessageManager.getInstance().registerListener(1021178, this.bvo);
    }

    public void a(e eVar) {
        a((c) eVar);
        this.bug = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendAcceptResponseMessage liveVideoChatSendAcceptResponseMessage) {
        if (liveVideoChatSendAcceptResponseMessage != null && this.bug != null) {
            if (liveVideoChatSendAcceptResponseMessage.getError() == 0) {
                this.bug.a(liveVideoChatSendAcceptResponseMessage.QK());
            } else {
                this.bug.y(liveVideoChatSendAcceptResponseMessage.getError(), liveVideoChatSendAcceptResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendRefuseResponseMessage liveVideoChatSendRefuseResponseMessage) {
        if (liveVideoChatSendRefuseResponseMessage != null && this.bug != null) {
            if (liveVideoChatSendRefuseResponseMessage.getError() == 0) {
                this.bug.Qh();
            } else {
                this.bug.z(liveVideoChatSendRefuseResponseMessage.getError(), liveVideoChatSendRefuseResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendBanUserResponseMessage liveVideoChatSendBanUserResponseMessage) {
        if (liveVideoChatSendBanUserResponseMessage != null && this.bug != null && (liveVideoChatSendBanUserResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.a)) {
            com.baidu.live.videochat.message.a aVar = (com.baidu.live.videochat.message.a) liveVideoChatSendBanUserResponseMessage.getOrginalMessage();
            if (liveVideoChatSendBanUserResponseMessage.getError() == 0) {
                if (aVar.QJ()) {
                    if (aVar.QI()) {
                        this.bug.Qj();
                    } else {
                        this.bug.Qi();
                    }
                } else if (aVar.QI()) {
                    this.bug.Ql();
                } else {
                    this.bug.Qk();
                }
            } else if (aVar.QJ()) {
                if (aVar.QI()) {
                    this.bug.B(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                } else {
                    this.bug.A(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                }
            } else if (aVar.QI()) {
                this.bug.D(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            } else {
                this.bug.C(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 1;
    }
}
