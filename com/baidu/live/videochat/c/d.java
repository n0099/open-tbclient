package com.baidu.live.videochat.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendAcceptResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendBanUserResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendRefuseResponseMessage;
/* loaded from: classes3.dex */
public class d extends b {
    private e bfG;
    private HttpMessageListener bgQ;

    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bgQ = new HttpMessageListener(0) { // from class: com.baidu.live.videochat.c.d.1
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
        Fv();
        registerListener();
    }

    private void Fv() {
        com.baidu.live.tieba.f.a.a.a(1021175, "ala/livechat/refuseLiveChat", LiveVideoChatSendRefuseResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021174, "ala/livechat/acceptLiveChat", LiveVideoChatSendAcceptResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021178, "ala/livechat/chatBan", LiveVideoChatSendBanUserResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(1021174, this.bgQ);
        MessageManager.getInstance().registerListener(1021175, this.bgQ);
        MessageManager.getInstance().registerListener(1021178, this.bgQ);
    }

    public void a(e eVar) {
        a((c) eVar);
        this.bfG = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendAcceptResponseMessage liveVideoChatSendAcceptResponseMessage) {
        if (liveVideoChatSendAcceptResponseMessage != null && this.bfG != null) {
            if (liveVideoChatSendAcceptResponseMessage.getError() == 0) {
                this.bfG.a(liveVideoChatSendAcceptResponseMessage.IQ());
            } else {
                this.bfG.w(liveVideoChatSendAcceptResponseMessage.getError(), liveVideoChatSendAcceptResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendRefuseResponseMessage liveVideoChatSendRefuseResponseMessage) {
        if (liveVideoChatSendRefuseResponseMessage != null && this.bfG != null) {
            if (liveVideoChatSendRefuseResponseMessage.getError() == 0) {
                this.bfG.In();
            } else {
                this.bfG.x(liveVideoChatSendRefuseResponseMessage.getError(), liveVideoChatSendRefuseResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendBanUserResponseMessage liveVideoChatSendBanUserResponseMessage) {
        if (liveVideoChatSendBanUserResponseMessage != null && this.bfG != null && (liveVideoChatSendBanUserResponseMessage.getOrginalMessage() instanceof com.baidu.live.videochat.message.a)) {
            com.baidu.live.videochat.message.a aVar = (com.baidu.live.videochat.message.a) liveVideoChatSendBanUserResponseMessage.getOrginalMessage();
            if (liveVideoChatSendBanUserResponseMessage.getError() == 0) {
                if (aVar.IP()) {
                    if (aVar.IO()) {
                        this.bfG.Ip();
                    } else {
                        this.bfG.Io();
                    }
                } else if (aVar.IO()) {
                    this.bfG.Ir();
                } else {
                    this.bfG.Iq();
                }
            } else if (aVar.IP()) {
                if (aVar.IO()) {
                    this.bfG.z(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                } else {
                    this.bfG.y(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
                }
            } else if (aVar.IO()) {
                this.bfG.B(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            } else {
                this.bfG.A(liveVideoChatSendBanUserResponseMessage.getError(), liveVideoChatSendBanUserResponseMessage.getErrorString());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 1;
    }
}
