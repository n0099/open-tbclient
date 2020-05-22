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
    private g bfW;
    private HttpMessageListener bgS;
    private HttpMessageListener bgT;

    public f(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bgS = new HttpMessageListener(1021177) { // from class: com.baidu.live.videochat.c.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendStartResponseMessage) {
                    f.this.a((LiveVideoChatSendStartResponseMessage) httpResponsedMessage);
                }
            }
        };
        this.bgT = new HttpMessageListener(1021173) { // from class: com.baidu.live.videochat.c.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof LiveVideoChatSendCancelResponseMessage) {
                    f.this.a((LiveVideoChatSendCancelResponseMessage) httpResponsedMessage);
                }
            }
        };
        Fv();
        registerListener();
    }

    private void Fv() {
        com.baidu.live.tieba.f.a.a.a(1021173, "ala/livechat/cancelLiveChat", LiveVideoChatSendCancelResponseMessage.class, true, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021177, "ala/livechat/startLiveChat", LiveVideoChatSendStartResponseMessage.class, true, true, true, true);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bgS);
        MessageManager.getInstance().registerListener(this.bgT);
    }

    public void a(g gVar) {
        a((c) gVar);
        this.bfW = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendStartResponseMessage liveVideoChatSendStartResponseMessage) {
        if (liveVideoChatSendStartResponseMessage != null) {
            if (liveVideoChatSendStartResponseMessage.getError() == 0 && liveVideoChatSendStartResponseMessage.Ja() != null) {
                if (liveVideoChatSendStartResponseMessage.Ja().IL()) {
                    if (this.bfW != null) {
                        this.bfW.Iw();
                    }
                } else if (this.bfW != null) {
                    this.bfW.D(liveVideoChatSendStartResponseMessage.Ja().IM(), liveVideoChatSendStartResponseMessage.Ja().IN());
                }
            } else if (this.bfW != null) {
                this.bfW.D(liveVideoChatSendStartResponseMessage.getError(), liveVideoChatSendStartResponseMessage.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveVideoChatSendCancelResponseMessage liveVideoChatSendCancelResponseMessage) {
        if (liveVideoChatSendCancelResponseMessage != null) {
            if (liveVideoChatSendCancelResponseMessage.hasError() || liveVideoChatSendCancelResponseMessage.getError() != 0) {
                if (this.bfW != null) {
                    this.bfW.E(liveVideoChatSendCancelResponseMessage.getError(), liveVideoChatSendCancelResponseMessage.getErrorString());
                }
            } else if (liveVideoChatSendCancelResponseMessage.IR()) {
                if (this.bfW != null) {
                    this.bfW.Ix();
                }
            } else if (this.bfW != null) {
                this.bfW.a(liveVideoChatSendCancelResponseMessage.IS(), liveVideoChatSendCancelResponseMessage.IT(), liveVideoChatSendCancelResponseMessage.IU());
            }
        }
    }

    @Override // com.baidu.live.videochat.c.b
    public int getChatType() {
        return 2;
    }
}
