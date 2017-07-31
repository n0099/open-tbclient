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
    private static h By = null;
    private String[] BB;
    private g.a BF;
    private String Bz = null;
    private List<BasicNameValuePair> BA = null;
    private String BC = null;
    private i BD = null;
    private ArrayList<g.a> BE = new ArrayList<>();

    public static h ie() {
        if (By == null) {
            synchronized (h.class) {
                if (By == null) {
                    By = new h();
                }
            }
        }
        return By;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Bz = str;
        this.BC = str2;
        this.BB = strArr;
        this.BA = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.BF = null;
        this.BF = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void I(String str) {
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).I(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void u(byte[] bArr) {
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).u(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(Map<String, String> map) {
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.BD = null;
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.BE.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void id() {
                Iterator it = h.this.BE.iterator();
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
        if (this.BD != null) {
            if (this.BD.ii() || this.BD.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.BD.close(1, null);
            this.BD = null;
        }
        this.BD = new i();
        try {
            l lVar = new l();
            lVar.aY(this.BC);
            this.BD.a(this.Bz, this.BB, this.BF, lVar, this.BA);
            return true;
        } catch (WebSocketException e) {
            this.BD = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.BD != null) {
            i iVar = this.BD;
            this.BD = null;
            iVar.close(i, str);
            if (this.BD != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.BD = null;
            }
        }
    }

    public boolean ig() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return (this.BD == null || !this.BD.isOpen() || this.BD.ip()) ? false : true;
    }

    public boolean ih() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return this.BD != null && this.BD.isOpen();
    }

    public boolean ii() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hG();
        }
        return this.BD != null && this.BD.ii();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hG();
                if (this.BD != null) {
                    z = this.BD.sendMessage(cVar);
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
                if (!this.BE.contains(aVar)) {
                    return this.BE.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ij() {
        if (this.BD != null) {
            this.BD.ij();
        }
    }

    public long getUpFlowSize() {
        if (this.BD != null) {
            return this.BD.getUpFlowSize();
        }
        return -1L;
    }

    public void ik() {
        if (this.BD != null) {
            this.BD.ik();
        }
    }

    public long getDownFlowSize() {
        if (this.BD != null) {
            return this.BD.getDownFlowSize();
        }
        return -1L;
    }

    public long ib() {
        if (this.BD != null) {
            return this.BD.iq();
        }
        return -1L;
    }

    public String ia() {
        if (this.BD != null) {
            return this.BD.ir();
        }
        return null;
    }

    public long il() {
        if (this.BD != null) {
            return this.BD.is();
        }
        return -1L;
    }

    public String hJ() {
        if (this.BD != null) {
            return this.BD.hJ();
        }
        return null;
    }

    public String hK() {
        if (this.BD != null) {
            return this.BD.hK();
        }
        return null;
    }

    public String getUrl() {
        return this.Bz;
    }
}
