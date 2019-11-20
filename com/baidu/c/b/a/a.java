package com.baidu.c.b.a;

import android.content.Context;
import com.baidu.android.imsdk.BIMConversation;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.c.a.b.c;
import com.baidu.c.a.b.e;
import com.baidu.c.a.b.f;
import com.baidu.c.a.b.g;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class a implements c {
    private BIMConversation avJ;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, BIMConversation bIMConversation) {
        this.mContext = context;
        this.avJ = bIMConversation;
    }

    @Override // com.baidu.c.a.b.c
    public void setPullInterval(int i) {
        this.avJ.setPullInterval(i);
    }

    @Override // com.baidu.c.a.b.c
    public void a(String str, boolean z, final e eVar) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
        }
        this.avJ.registerLiveMsgReceiveListener(j, z, new ILiveMsgReceiveListener() { // from class: com.baidu.c.b.a.a.1
            @Override // com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener
            public void onReceiveMessage(int i, JSONArray jSONArray) {
                if (eVar != null) {
                    eVar.b(i, com.baidu.c.b.a.a.a.a.m(jSONArray));
                }
            }
        });
    }

    @Override // com.baidu.c.a.b.c
    public void dl(String str) {
        try {
            this.avJ.unregisterLiveMsgReceiveListener(Long.parseLong(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.c.a.b.c
    public void a(final com.baidu.c.a.b.b bVar) {
        this.avJ.beginWithCompletion(new IMcastSetListener() { // from class: com.baidu.c.b.a.a.2
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.c.a.b.c
    public void b(final com.baidu.c.a.b.b bVar) {
        this.avJ.endWithCompletion(new IMcastSetListener() { // from class: com.baidu.c.b.a.a.3
            @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
            public void onResult(int i, long j, long j2) {
                if (bVar != null) {
                    bVar.onResult(i, j, j2);
                }
            }
        });
    }

    @Override // com.baidu.c.a.b.c
    public void a(Object obj, final g gVar, final f fVar) {
        this.avJ.sendMessage(com.baidu.c.b.a.a.a.a.a(this.mContext, (com.baidu.c.a.b.a.e) obj), new ISendMessageStatusListener() { // from class: com.baidu.c.b.a.a.4
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
        }, new ISendMessageListener() { // from class: com.baidu.c.b.a.a.5
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
                arrayList.add(com.baidu.c.b.a.a.a.a.a(chatMsg));
            }
            fVar.c(i, arrayList);
        }
    }

    @Override // com.baidu.c.a.b.c
    public void quitLiveShow() {
        this.avJ.quitLiveShow();
    }

    public BIMConversation xi() {
        return this.avJ;
    }
}
