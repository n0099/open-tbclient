package com.baidu.live.videochat.c;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendCancelResponseMessage;
import com.baidu.live.videochat.message.LiveVideoChatSendStartResponseMessage;
/* loaded from: classes3.dex */
public class f extends b {
    private HttpMessageListener blY;
    private HttpMessageListener blZ;
    private g bld;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.blY = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.c.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.blZ = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.c.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendCancelResponseMessage) {
                    f.this.a((LiveVideoChatSendCancelResponseMessage) httpResponsedMessage);
                }
            }
        };
        xp();
        registerListener();
    }

    private void xp() {
        com.baidu.live.tieba.f.a.a.a(1021173, "ala/livechat/cancelLiveChat", LiveVideoChatSendCancelResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021177, "ala/livechat/startLiveChat", LiveVideoChatSendStartResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.blY);
        MessageManager.getInstance().registerListener(this.blZ);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.bld = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.Kn() != null) {
                if (liveVideoChatSendStartResponseMessage.Kn().JY()) {
                    if (this.bld != null) {
                        this.bld.JJ();
                    }
                } else if (this.bld != null) {
                    this.bld.F(liveVideoChatSendStartResponseMessage.Kn().JZ(), liveVideoChatSendStartResponseMessage.Kn().Ka());
                }
            } else if (this.bld != null) {
                this.bld.F(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.bld != null) {
                    this.bld.G(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.Ke()) {
                if (this.bld != null) {
                    this.bld.JK();
                }
            } else if (this.bld != null) {
                this.bld.a(liveVideoChatSendCancelResponseMessage.Kf(), liveVideoChatSendCancelResponseMessage.Kg(), liveVideoChatSendCancelResponseMessage.Kh());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 2;
    }
}
