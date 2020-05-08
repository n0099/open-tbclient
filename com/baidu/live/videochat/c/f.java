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
    private g aYA;
    private HttpMessageListener aZv;
    private HttpMessageListener aZw;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aZv = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.c.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.aZw = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.c.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendCancelResponseMessage) {
                    f.this.a((LiveVideoChatSendCancelResponseMessage) httpResponsedMessage);
                }
            }
        };
        xB();
        registerListener();
    }

    private void xB() {
        com.baidu.live.tieba.f.a.a.a(1021173, "ala/livechat/cancelLiveChat", LiveVideoChatSendCancelResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021177, "ala/livechat/startLiveChat", LiveVideoChatSendStartResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aZv);
        MessageManager.getInstance().registerListener(this.aZw);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.aYA = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.Hh() != null) {
                if (liveVideoChatSendStartResponseMessage.Hh().GS()) {
                    if (this.aYA != null) {
                        this.aYA.GD();
                    }
                } else if (this.aYA != null) {
                    this.aYA.D(liveVideoChatSendStartResponseMessage.Hh().GT(), liveVideoChatSendStartResponseMessage.Hh().GU());
                }
            } else if (this.aYA != null) {
                this.aYA.D(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.aYA != null) {
                    this.aYA.E(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.GY()) {
                if (this.aYA != null) {
                    this.aYA.GE();
                }
            } else if (this.aYA != null) {
                this.aYA.a(liveVideoChatSendCancelResponseMessage.GZ(), liveVideoChatSendCancelResponseMessage.Ha(), liveVideoChatSendCancelResponseMessage.Hb());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 2;
    }
}
