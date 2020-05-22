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
    private static h Og = null;
    private String[] Oj;
    private g.a Oo;
    private String Oh = null;
    private List<BasicNameValuePair> Oi = null;
    private String Ok = null;
    private i Ol = null;
    private ArrayList<g.a> Om = new ArrayList<>();

    public static h mH() {
        if (Og == null) {
            synchronized (h.class) {
                if (Og == null) {
                    Og = new h();
                }
            }
        }
        return Og;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Oh = str;
        this.Ok = str2;
        this.Oj = strArr;
        this.Oi = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Oo = null;
        this.Oo = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void k(byte[] bArr) {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).k(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.Ol = null;
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void mG() {
                Iterator it = h.this.Om.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).mG();
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

    public boolean mI() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Ol != null) {
            if (this.Ol.isConnecting() || this.Ol.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Ol.close(1, null);
            this.Ol = null;
        }
        this.Ol = new i();
        try {
            l lVar = new l();
            lVar.cd(this.Ok);
            this.Ol.a(this.Oh, this.Oj, this.Oo, lVar, this.Oi);
            return true;
        } catch (WebSocketException e) {
            this.Ol = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ol != null) {
            i iVar = this.Ol;
            this.Ol = null;
            iVar.close(i, str);
            if (this.Ol != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ol = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Ol == null || !this.Ol.isOpen() || this.Ol.mQ()) ? false : true;
    }

    public boolean mJ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Ol != null && this.Ol.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Ol != null && this.Ol.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Ol != null) {
                    z = this.Ol.sendMessage(cVar);
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
                if (!this.Om.contains(aVar)) {
                    return this.Om.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mK() {
        if (this.Ol != null) {
            this.Ol.mK();
        }
    }

    public long getUpFlowSize() {
        if (this.Ol != null) {
            return this.Ol.getUpFlowSize();
        }
        return -1L;
    }

    public void mL() {
        if (this.Ol != null) {
            this.Ol.mL();
        }
    }

    public long getDownFlowSize() {
        if (this.Ol != null) {
            return this.Ol.getDownFlowSize();
        }
        return -1L;
    }

    public long mE() {
        if (this.Ol != null) {
            return this.Ol.mR();
        }
        return -1L;
    }

    public String mD() {
        if (this.Ol != null) {
            return this.Ol.mS();
        }
        return null;
    }

    public long mM() {
        if (this.Ol != null) {
            return this.Ol.mT();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Ol != null) {
            return this.Ol.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Ol != null) {
            return this.Ol.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Oh;
    }
}
