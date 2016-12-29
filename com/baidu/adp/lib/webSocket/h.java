package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h tm = null;
    private String[] tr;

    /* renamed from: tv  reason: collision with root package name */
    private g.a f1tv;
    private String tp = null;
    private List<BasicNameValuePair> tq = null;
    private String ts = null;
    private j tt = null;
    private ArrayList<g.a> tu = new ArrayList<>();

    public static h ha() {
        if (tm == null) {
            synchronized (h.class) {
                if (tm == null) {
                    tm = new h();
                }
            }
        }
        return tm;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.tp = str;
        this.ts = str2;
        this.tr = strArr;
        this.tq = list;
        hf();
    }

    private h() {
        this.f1tv = null;
        this.f1tv = new i(this);
    }

    public boolean hb() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        if (this.tt != null) {
            if (this.tt.he() || this.tt.isOpen()) {
                hf();
                return true;
            }
            this.tt.close(1, null);
            this.tt = null;
        }
        this.tt = new j();
        try {
            n nVar = new n();
            nVar.aX(this.ts);
            this.tt.a(this.tp, this.tr, this.f1tv, nVar, this.tq);
            return true;
        } catch (WebSocketException e) {
            this.tt = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.tt != null) {
            j jVar = this.tt;
            this.tt = null;
            jVar.close(i, str);
            if (this.tt != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.tt = null;
            }
        }
    }

    public boolean hc() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return (this.tt == null || !this.tt.isOpen() || this.tt.hm()) ? false : true;
    }

    public boolean hd() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return this.tt != null && this.tt.isOpen();
    }

    public boolean he() {
        if (hf()) {
            com.baidu.adp.lib.util.k.gB();
        }
        return this.tt != null && this.tt.he();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.gB();
                if (this.tt != null) {
                    z = this.tt.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.O(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.tu.contains(aVar)) {
                    return this.tu.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hf() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hg() {
        if (this.tt != null) {
            this.tt.hg();
        }
    }

    public long getUpFlowSize() {
        if (this.tt != null) {
            return this.tt.getUpFlowSize();
        }
        return -1L;
    }

    public void hh() {
        if (this.tt != null) {
            this.tt.hh();
        }
    }

    public long getDownFlowSize() {
        if (this.tt != null) {
            return this.tt.getDownFlowSize();
        }
        return -1L;
    }

    public long gX() {
        if (this.tt != null) {
            return this.tt.hn();
        }
        return -1L;
    }

    public String gW() {
        if (this.tt != null) {
            return this.tt.ho();
        }
        return null;
    }

    public long hi() {
        if (this.tt != null) {
            return this.tt.hp();
        }
        return -1L;
    }

    public String gE() {
        if (this.tt != null) {
            return this.tt.gE();
        }
        return null;
    }

    public String gF() {
        if (this.tt != null) {
            return this.tt.gF();
        }
        return null;
    }

    public String getUrl() {
        return this.tp;
    }
}
