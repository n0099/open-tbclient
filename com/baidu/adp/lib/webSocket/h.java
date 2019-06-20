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
    private static h EZ = null;
    private String[] Fc;
    private g.a Fg;
    private String Fa = null;
    private List<BasicNameValuePair> Fb = null;
    private String Fd = null;
    private i Fe = null;
    private ArrayList<g.a> Ff = new ArrayList<>();

    public static h kD() {
        if (EZ == null) {
            synchronized (h.class) {
                if (EZ == null) {
                    EZ = new h();
                }
            }
        }
        return EZ;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Fa = str;
        this.Fd = str2;
        this.Fc = strArr;
        this.Fb = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Fg = null;
        this.Fg = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void p(byte[] bArr) {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).p(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Fe = null;
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void kC() {
                Iterator it = h.this.Ff.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).kC();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.fp();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.G(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.fq();
                }
            }
        };
    }

    public boolean kE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        if (this.Fe != null) {
            if (this.Fe.isConnecting() || this.Fe.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Fe.close(1, null);
            this.Fe = null;
        }
        this.Fe = new i();
        try {
            l lVar = new l();
            lVar.bp(this.Fd);
            this.Fe.a(this.Fa, this.Fc, this.Fg, lVar, this.Fb);
            return true;
        } catch (WebSocketException e) {
            this.Fe = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Fe != null) {
            i iVar = this.Fe;
            this.Fe = null;
            iVar.close(i, str);
            if (this.Fe != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Fe = null;
            }
        }
    }

    public boolean kF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return (this.Fe == null || !this.Fe.isOpen() || this.Fe.kN()) ? false : true;
    }

    public boolean kG() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return this.Fe != null && this.Fe.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return this.Fe != null && this.Fe.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.kg();
                if (this.Fe != null) {
                    z = this.Fe.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.G(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Ff.contains(aVar)) {
                    return this.Ff.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kH() {
        if (this.Fe != null) {
            this.Fe.kH();
        }
    }

    public long getUpFlowSize() {
        if (this.Fe != null) {
            return this.Fe.getUpFlowSize();
        }
        return -1L;
    }

    public void kI() {
        if (this.Fe != null) {
            this.Fe.kI();
        }
    }

    public long getDownFlowSize() {
        if (this.Fe != null) {
            return this.Fe.getDownFlowSize();
        }
        return -1L;
    }

    public long kA() {
        if (this.Fe != null) {
            return this.Fe.kO();
        }
        return -1L;
    }

    public String kz() {
        if (this.Fe != null) {
            return this.Fe.kP();
        }
        return null;
    }

    public long kJ() {
        if (this.Fe != null) {
            return this.Fe.kQ();
        }
        return -1L;
    }

    public String kj() {
        if (this.Fe != null) {
            return this.Fe.kj();
        }
        return null;
    }

    public String kk() {
        if (this.Fe != null) {
            return this.Fe.kk();
        }
        return null;
    }

    public String getUrl() {
        return this.Fa;
    }
}
