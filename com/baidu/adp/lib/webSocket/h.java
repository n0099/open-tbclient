package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h OI = null;
    private String[] OM;
    private g.a OR;
    private String OJ = null;
    private List<BasicNameValuePair> OL = null;
    private String OO = null;
    private i OP = null;
    private ArrayList<g.a> OQ = new ArrayList<>();

    public static h mX() {
        if (OI == null) {
            synchronized (h.class) {
                if (OI == null) {
                    OI = new h();
                }
            }
        }
        return OI;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.OJ = str;
        this.OO = str2;
        this.OM = strArr;
        this.OL = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.OR = null;
        this.OR = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.OP = null;
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void mW() {
                Iterator it = h.this.OQ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).mW();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.onStartSend();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.onSendError(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.onFinishSend();
                }
            }
        };
    }

    public boolean mY() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.OP != null) {
            if (this.OP.isConnecting() || this.OP.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.OP.close(1, null);
            this.OP = null;
        }
        this.OP = new i();
        try {
            l lVar = new l();
            lVar.ce(this.OO);
            this.OP.a(this.OJ, this.OM, this.OR, lVar, this.OL);
            return true;
        } catch (WebSocketException e) {
            this.OP = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.OP != null) {
            i iVar = this.OP;
            this.OP = null;
            iVar.close(i, str);
            if (this.OP != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.OP = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.OP == null || !this.OP.isOpen() || this.OP.ng()) ? false : true;
    }

    public boolean mZ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.OP != null && this.OP.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.OP != null && this.OP.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.OP != null) {
                    z = this.OP.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.onSendError(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.OQ.contains(aVar)) {
                    return this.OQ.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void na() {
        if (this.OP != null) {
            this.OP.na();
        }
    }

    public long getUpFlowSize() {
        if (this.OP != null) {
            return this.OP.getUpFlowSize();
        }
        return -1L;
    }

    public void nb() {
        if (this.OP != null) {
            this.OP.nb();
        }
    }

    public long getDownFlowSize() {
        if (this.OP != null) {
            return this.OP.getDownFlowSize();
        }
        return -1L;
    }

    public long mU() {
        if (this.OP != null) {
            return this.OP.nh();
        }
        return -1L;
    }

    public String mT() {
        if (this.OP != null) {
            return this.OP.ni();
        }
        return null;
    }

    public long nc() {
        if (this.OP != null) {
            return this.OP.nj();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.OP != null) {
            return this.OP.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.OP != null) {
            return this.OP.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.OJ;
    }
}
