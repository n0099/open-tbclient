package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h tl = null;
    private String[] tq;
    private g.a tu;
    private String tm = null;
    private List<BasicNameValuePair> tp = null;
    private String tr = null;
    private j ts = null;
    private ArrayList<g.a> tt = new ArrayList<>();

    public static h ha() {
        if (tl == null) {
            synchronized (h.class) {
                if (tl == null) {
                    tl = new h();
                }
            }
        }
        return tl;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.tm = str;
        this.tr = str2;
        this.tq = strArr;
        this.tp = list;
        hf();
    }

    private h() {
        this.tu = null;
        this.tu = new i(this);
    }

    public boolean hb() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        if (this.ts != null) {
            if (this.ts.he() || this.ts.isOpen()) {
                hf();
                return true;
            }
            this.ts.close(1, null);
            this.ts = null;
        }
        this.ts = new j();
        try {
            n nVar = new n();
            nVar.aX(this.tr);
            this.ts.a(this.tm, this.tq, this.tu, nVar, this.tp);
            return true;
        } catch (WebSocketException e) {
            this.ts = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.ts != null) {
            j jVar = this.ts;
            this.ts = null;
            jVar.close(i, str);
            if (this.ts != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.ts = null;
            }
        }
    }

    public boolean hc() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return (this.ts == null || !this.ts.isOpen() || this.ts.hm()) ? false : true;
    }

    public boolean hd() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return this.ts != null && this.ts.isOpen();
    }

    public boolean he() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return this.ts != null && this.ts.he();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.gB();
                if (this.ts != null) {
                    z = this.ts.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.N(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.tt.contains(aVar)) {
                    return this.tt.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hf() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hg() {
        if (this.ts != null) {
            this.ts.hg();
        }
    }

    public long getUpFlowSize() {
        if (this.ts != null) {
            return this.ts.getUpFlowSize();
        }
        return -1L;
    }

    public void hh() {
        if (this.ts != null) {
            this.ts.hh();
        }
    }

    public long getDownFlowSize() {
        if (this.ts != null) {
            return this.ts.getDownFlowSize();
        }
        return -1L;
    }

    public long gX() {
        if (this.ts != null) {
            return this.ts.hn();
        }
        return -1L;
    }

    public String gW() {
        if (this.ts != null) {
            return this.ts.ho();
        }
        return null;
    }

    public long hi() {
        if (this.ts != null) {
            return this.ts.hp();
        }
        return -1L;
    }

    public String gE() {
        if (this.ts != null) {
            return this.ts.gE();
        }
        return null;
    }

    public String gF() {
        if (this.ts != null) {
            return this.ts.gF();
        }
        return null;
    }

    public String getUrl() {
        return this.tm;
    }
}
