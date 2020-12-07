package com.baidu.i.b.a;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.i.a.b.c;
import com.baidu.i.a.b.e;
import com.baidu.i.a.b.f;
import com.baidu.i.a.b.g;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class a implements c {
    private BIMConversation bZk;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, BIMConversation bIMConversation) {
        this.mContext = context;
        this.bZk = bIMConversation;
    }

    @Override // com.baidu.i.a.b.c
    public void setPullInterval(int i) {
        this.bZk.setPullInterval(i);
    }

    @Override // com.baidu.i.a.b.c
    public void a(String str, final e eVar) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
        }
        this.bZk.registerLiveMsgReceiveListener(j, new ILiveMsgReceiveListener() { // from class: com.baidu.i.b.a.a.1
            @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
            public void onReceiveMessage(int i, JSONArray jSONArray) {
                if (eVar != null) {
                    eVar.b(i, com.baidu.i.b.a.a.a.a.o(jSONArray));
                }
            }
        });
    }

    @Override // com.baidu.i.a.b.c
    public void jC(String str) {
        try {
            this.bZk.unregisterLiveMsgReceiveListener(Long.parseLong(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.i.a.b.c
    public void a(final com.baidu.i.a.b.b bVar) {
        this.bZk.beginWithCompletion(new IMcastSetListener() { // from class: com.baidu.i.b.a.a.2
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.i.a.b.c
    public void b(final com.baidu.i.a.b.b bVar) {
        this.bZk.endWithCompletion(new IMcastSetListener() { // from class: com.baidu.i.b.a.a.3
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.i.a.b.c
    public void a(Object obj, final g gVar, final f fVar) {
        this.bZk.sendMessage(com.baidu.i.b.a.a.a.a.a(this.mContext, (com.baidu.i.a.b.a.e) obj), new ISendMessageStatusListener() { // from class: com.baidu.i.b.a.a.4
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendStatus(int i, ChatMsg chatMsg) {
                if (gVar != null) {
                    gVar.d(i, chatMsg);
                }
            }

            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener
            public void onSendProgress(int i, ChatMsg chatMsg) {
                if (gVar != null) {
                    gVar.e(i, chatMsg);
                }
            }
        }, new ISendMessageListener() { // from class: com.baidu.i.b.a.a.5
            @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
            public void onSendMessageResult(int i, ChatMsg chatMsg) {
                a.this.a(i, chatMsg, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ChatMsg chatMsg, f fVar) {
        if (fVar != null) {
            ArrayList arrayList = null;
            if (i != 22 && i != 1024 && i != 1001) {
                arrayList = new ArrayList();
                arrayList.add(com.baidu.i.b.a.a.a.a.a(chatMsg));
            }
            fVar.c(i, arrayList);
        }
    }

    @Override // com.baidu.i.a.b.c
    public void quitLiveShow() {
    }

    public BIMConversation aak() {
        return this.bZk;
    }
}
