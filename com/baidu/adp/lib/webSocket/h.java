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
    private static h BA = null;
    private String[] BD;
    private g.a BH;
    private String BB = null;
    private List<BasicNameValuePair> BC = null;
    private String BE = null;
    private i BF = null;
    private ArrayList<g.a> BG = new ArrayList<>();

    public static h ie() {
        if (BA == null) {
            synchronized (h.class) {
                if (BA == null) {
                    BA = new h();
                }
            }
        }
        return BA;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.BB = str;
        this.BE = str2;
        this.BD = strArr;
        this.BC = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.BH = null;
        this.BH = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void u(byte[] bArr) {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).u(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(Map<String, String> map) {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.BF = null;
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void id() {
                Iterator it = h.this.BG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).id();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.cO();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.P(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.cP();
                }
            }
        };
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m5if() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        if (this.BF != null) {
            if (this.BF.ii() || this.BF.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.BF.close(1, null);
            this.BF = null;
        }
        this.BF = new i();
        try {
            l lVar = new l();
            lVar.aZ(this.BE);
            this.BF.a(this.BB, this.BD, this.BH, lVar, this.BC);
            return true;
        } catch (WebSocketException e) {
            this.BF = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.BF != null) {
            i iVar = this.BF;
            this.BF = null;
            iVar.close(i, str);
            if (this.BF != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.BF = null;
            }
        }
    }

    public boolean ig() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return (this.BF == null || !this.BF.isOpen() || this.BF.ip()) ? false : true;
    }

    public boolean ih() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return this.BF != null && this.BF.isOpen();
    }

    public boolean ii() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return this.BF != null && this.BF.ii();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hG();
                if (this.BF != null) {
                    z = this.BF.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.P(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.BG.contains(aVar)) {
                    return this.BG.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ij() {
        if (this.BF != null) {
            this.BF.ij();
        }
    }

    public long getUpFlowSize() {
        if (this.BF != null) {
            return this.BF.getUpFlowSize();
        }
        return -1L;
    }

    public void ik() {
        if (this.BF != null) {
            this.BF.ik();
        }
    }

    public long getDownFlowSize() {
        if (this.BF != null) {
            return this.BF.getDownFlowSize();
        }
        return -1L;
    }

    public long ib() {
        if (this.BF != null) {
            return this.BF.iq();
        }
        return -1L;
    }

    public String ia() {
        if (this.BF != null) {
            return this.BF.ir();
        }
        return null;
    }

    public long il() {
        if (this.BF != null) {
            return this.BF.is();
        }
        return -1L;
    }

    public String hJ() {
        if (this.BF != null) {
            return this.BF.hJ();
        }
        return null;
    }

    public String hK() {
        if (this.BF != null) {
            return this.BF.hK();
        }
        return null;
    }

    public String getUrl() {
        return this.BB;
    }
}
