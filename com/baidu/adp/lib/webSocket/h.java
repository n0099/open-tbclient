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
    private static h NY = null;
    private String[] Ob;
    private g.a Og;
    private String NZ = null;
    private List<BasicNameValuePair> Oa = null;
    private String Oc = null;
    private i Oe = null;
    private ArrayList<g.a> Of = new ArrayList<>();

    public static h mF() {
        if (NY == null) {
            synchronized (h.class) {
                if (NY == null) {
                    NY = new h();
                }
            }
        }
        return NY;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.NZ = str;
        this.Oc = str2;
        this.Ob = strArr;
        this.Oa = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Og = null;
        this.Og = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void k(byte[] bArr) {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).k(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.Oe = null;
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void mE() {
                Iterator it = h.this.Of.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).mE();
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

    public boolean mG() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Oe != null) {
            if (this.Oe.isConnecting() || this.Oe.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Oe.close(1, null);
            this.Oe = null;
        }
        this.Oe = new i();
        try {
            l lVar = new l();
            lVar.cc(this.Oc);
            this.Oe.a(this.NZ, this.Ob, this.Og, lVar, this.Oa);
            return true;
        } catch (WebSocketException e) {
            this.Oe = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Oe != null) {
            i iVar = this.Oe;
            this.Oe = null;
            iVar.close(i, str);
            if (this.Oe != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Oe = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Oe == null || !this.Oe.isOpen() || this.Oe.mO()) ? false : true;
    }

    public boolean mH() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Oe != null && this.Oe.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Oe != null && this.Oe.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Oe != null) {
                    z = this.Oe.sendMessage(cVar);
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
                if (!this.Of.contains(aVar)) {
                    return this.Of.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mI() {
        if (this.Oe != null) {
            this.Oe.mI();
        }
    }

    public long getUpFlowSize() {
        if (this.Oe != null) {
            return this.Oe.getUpFlowSize();
        }
        return -1L;
    }

    public void mJ() {
        if (this.Oe != null) {
            this.Oe.mJ();
        }
    }

    public long getDownFlowSize() {
        if (this.Oe != null) {
            return this.Oe.getDownFlowSize();
        }
        return -1L;
    }

    public long mC() {
        if (this.Oe != null) {
            return this.Oe.mP();
        }
        return -1L;
    }

    public String mB() {
        if (this.Oe != null) {
            return this.Oe.mQ();
        }
        return null;
    }

    public long mK() {
        if (this.Oe != null) {
            return this.Oe.mR();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Oe != null) {
            return this.Oe.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Oe != null) {
            return this.Oe.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.NZ;
    }
}
