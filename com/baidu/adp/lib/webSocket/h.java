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
    private static h NU = null;
    private String[] NX;
    private g.a Ob;
    private String NV = null;
    private List<BasicNameValuePair> NW = null;
    private String NY = null;
    private i NZ = null;
    private ArrayList<g.a> Oa = new ArrayList<>();

    public static h mF() {
        if (NU == null) {
            synchronized (h.class) {
                if (NU == null) {
                    NU = new h();
                }
            }
        }
        return NU;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.NV = str;
        this.NY = str2;
        this.NX = strArr;
        this.NW = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Ob = null;
        this.Ob = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void k(byte[] bArr) {
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).k(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void d(int i, String str) {
                h.this.NZ = null;
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).d(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Oa.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void mE() {
                Iterator it = h.this.Oa.iterator();
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
        if (this.NZ != null) {
            if (this.NZ.isConnecting() || this.NZ.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.NZ.close(1, null);
            this.NZ = null;
        }
        this.NZ = new i();
        try {
            l lVar = new l();
            lVar.cc(this.NY);
            this.NZ.a(this.NV, this.NX, this.Ob, lVar, this.NW);
            return true;
        } catch (WebSocketException e) {
            this.NZ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.NZ != null) {
            i iVar = this.NZ;
            this.NZ = null;
            iVar.close(i, str);
            if (this.NZ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.NZ = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.NZ == null || !this.NZ.isOpen() || this.NZ.mO()) ? false : true;
    }

    public boolean mH() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.NZ != null && this.NZ.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.NZ != null && this.NZ.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.NZ != null) {
                    z = this.NZ.sendMessage(cVar);
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
                if (!this.Oa.contains(aVar)) {
                    return this.Oa.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mI() {
        if (this.NZ != null) {
            this.NZ.mI();
        }
    }

    public long getUpFlowSize() {
        if (this.NZ != null) {
            return this.NZ.getUpFlowSize();
        }
        return -1L;
    }

    public void mJ() {
        if (this.NZ != null) {
            this.NZ.mJ();
        }
    }

    public long getDownFlowSize() {
        if (this.NZ != null) {
            return this.NZ.getDownFlowSize();
        }
        return -1L;
    }

    public long mC() {
        if (this.NZ != null) {
            return this.NZ.mP();
        }
        return -1L;
    }

    public String mB() {
        if (this.NZ != null) {
            return this.NZ.mQ();
        }
        return null;
    }

    public long mK() {
        if (this.NZ != null) {
            return this.NZ.mR();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.NZ != null) {
            return this.NZ.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.NZ != null) {
            return this.NZ.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.NV;
    }
}
