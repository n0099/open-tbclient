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
    private static h Fg = null;
    private String[] Fj;
    private g.a Fn;
    private String Fh = null;
    private List<BasicNameValuePair> Fi = null;
    private String Fk = null;
    private i Fl = null;
    private ArrayList<g.a> Fm = new ArrayList<>();

    public static h kS() {
        if (Fg == null) {
            synchronized (h.class) {
                if (Fg == null) {
                    Fg = new h();
                }
            }
        }
        return Fg;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Fh = str;
        this.Fk = str2;
        this.Fj = strArr;
        this.Fi = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Fn = null;
        this.Fn = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void q(byte[] bArr) {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).q(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Fl = null;
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void kR() {
                Iterator it = h.this.Fm.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).kR();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.fx();
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
                    cVar.fy();
                }
            }
        };
    }

    public boolean kT() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kr();
        }
        if (this.Fl != null) {
            if (this.Fl.isConnecting() || this.Fl.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Fl.close(1, null);
            this.Fl = null;
        }
        this.Fl = new i();
        try {
            l lVar = new l();
            lVar.br(this.Fk);
            this.Fl.a(this.Fh, this.Fj, this.Fn, lVar, this.Fi);
            return true;
        } catch (WebSocketException e) {
            this.Fl = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Fl != null) {
            i iVar = this.Fl;
            this.Fl = null;
            iVar.close(i, str);
            if (this.Fl != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Fl = null;
            }
        }
    }

    public boolean kU() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kr();
        }
        return (this.Fl == null || !this.Fl.isOpen() || this.Fl.lc()) ? false : true;
    }

    public boolean kV() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kr();
        }
        return this.Fl != null && this.Fl.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kr();
        }
        return this.Fl != null && this.Fl.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.kr();
                if (this.Fl != null) {
                    z = this.Fl.sendMessage(cVar);
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
                if (!this.Fm.contains(aVar)) {
                    return this.Fm.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kW() {
        if (this.Fl != null) {
            this.Fl.kW();
        }
    }

    public long getUpFlowSize() {
        if (this.Fl != null) {
            return this.Fl.getUpFlowSize();
        }
        return -1L;
    }

    public void kX() {
        if (this.Fl != null) {
            this.Fl.kX();
        }
    }

    public long getDownFlowSize() {
        if (this.Fl != null) {
            return this.Fl.getDownFlowSize();
        }
        return -1L;
    }

    public long kP() {
        if (this.Fl != null) {
            return this.Fl.ld();
        }
        return -1L;
    }

    public String kO() {
        if (this.Fl != null) {
            return this.Fl.le();
        }
        return null;
    }

    public long kY() {
        if (this.Fl != null) {
            return this.Fl.lf();
        }
        return -1L;
    }

    public String ku() {
        if (this.Fl != null) {
            return this.Fl.ku();
        }
        return null;
    }

    public String kv() {
        if (this.Fl != null) {
            return this.Fl.kv();
        }
        return null;
    }

    public String getUrl() {
        return this.Fh;
    }
}
