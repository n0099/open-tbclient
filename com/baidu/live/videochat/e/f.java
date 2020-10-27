package com.baidu.live.videochat.e;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendCancelResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendStartResponseMessage;
/* loaded from: classes4.dex */
public class f extends b {
    private g bBu;
    private HttpMessageListener bDS;
    private HttpMessageListener bDT;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bDS = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.e.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.bDT = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.e.f.2
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
        MessageManager.getInstance().registerListener(this.bDS);
        MessageManager.getInstance().registerListener(this.bDT);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.bBu = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.TC() != null) {
                if (liveVideoChatSendStartResponseMessage.TC().Tc()) {
                    if (this.bBu != null) {
                        this.bBu.SN();
                    }
                } else if (this.bBu != null) {
                    this.bBu.J(liveVideoChatSendStartResponseMessage.TC().Td(), liveVideoChatSendStartResponseMessage.TC().Te());
                }
            } else if (this.bBu != null) {
                this.bBu.J(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.bBu != null) {
                    this.bBu.K(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.Tt()) {
                if (this.bBu != null) {
                    this.bBu.SO();
                }
            } else if (this.bBu != null) {
                this.bBu.a(liveVideoChatSendCancelResponseMessage.Tu(), liveVideoChatSendCancelResponseMessage.Tv(), liveVideoChatSendCancelResponseMessage.Tw());
            }
        }
    }

    @Override // com.baidu.live.videochat.e.b
    public int getChatType() {
        return 2;
    }
}
