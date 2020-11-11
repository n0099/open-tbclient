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
    private g bHA;
    private HttpMessageListener bJA;
    private HttpMessageListener bJz;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bJz = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.e.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.bJA = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.e.f.2
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
        MessageManager.getInstance().registerListener(this.bJz);
        MessageManager.getInstance().registerListener(this.bJA);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.bHA = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.Wc() != null) {
                if (liveVideoChatSendStartResponseMessage.Wc().VG()) {
                    if (this.bHA != null) {
                        this.bHA.Vu();
                    }
                } else if (this.bHA != null) {
                    this.bHA.N(liveVideoChatSendStartResponseMessage.Wc().VH(), liveVideoChatSendStartResponseMessage.Wc().VI());
                }
            } else if (this.bHA != null) {
                this.bHA.N(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.bHA != null) {
                    this.bHA.O(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.VT()) {
                if (this.bHA != null) {
                    this.bHA.Vv();
                }
            } else if (this.bHA != null) {
                this.bHA.a(liveVideoChatSendCancelResponseMessage.VU(), liveVideoChatSendCancelResponseMessage.VV(), liveVideoChatSendCancelResponseMessage.VW());
            }
        }
    }

    @Override // com.baidu.live.videochat.e.b
    public int getChatType() {
        return 2;
    }
}
