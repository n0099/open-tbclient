package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h Au = null;
    private g.a AB;
    private String[] Ax;
    private String Av = null;
    private List<BasicNameValuePair> Aw = null;
    private String Ay = null;
    private j Az = null;
    private ArrayList<g.a> AA = new ArrayList<>();

    public static h hS() {
        if (Au == null) {
            synchronized (h.class) {
                if (Au == null) {
                    Au = new h();
                }
            }
        }
        return Au;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Av = str;
        this.Ay = str2;
        this.Ax = strArr;
        this.Aw = list;
        hX();
    }

    private h() {
        this.AB = null;
        this.AB = new i(this);
    }

    public boolean hT() {
        if (hX()) {
            com.baidu.adp.lib.util.k.ht();
        }
        if (this.Az != null) {
            if (this.Az.hW() || this.Az.isOpen()) {
                hX();
                return true;
            }
            this.Az.close(1, null);
            this.Az = null;
        }
        this.Az = new j();
        try {
            n nVar = new n();
            nVar.aQ(this.Ay);
            this.Az.a(this.Av, this.Ax, this.AB, nVar, this.Aw);
            return true;
        } catch (WebSocketException e) {
            this.Az = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Az != null) {
            j jVar = this.Az;
            this.Az = null;
            jVar.close(i, str);
            if (this.Az != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Az = null;
            }
        }
    }

    public boolean hU() {
        if (hX()) {
            com.baidu.adp.lib.util.k.ht();
        }
        return (this.Az == null || !this.Az.isOpen() || this.Az.ie()) ? false : true;
    }

    public boolean hV() {
        if (hX()) {
            com.baidu.adp.lib.util.k.ht();
        }
        return this.Az != null && this.Az.isOpen();
    }

    public boolean hW() {
        if (hX()) {
            com.baidu.adp.lib.util.k.ht();
        }
        return this.Az != null && this.Az.hW();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.ht();
                if (this.Az != null) {
                    z = this.Az.sendMessage(cVar);
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
                if (!this.AA.contains(aVar)) {
                    return this.AA.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hX() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hY() {
        if (this.Az != null) {
            this.Az.hY();
        }
    }

    public long getUpFlowSize() {
        if (this.Az != null) {
            return this.Az.getUpFlowSize();
        }
        return -1L;
    }

    public void hZ() {
        if (this.Az != null) {
            this.Az.hZ();
        }
    }

    public long getDownFlowSize() {
        if (this.Az != null) {
            return this.Az.getDownFlowSize();
        }
        return -1L;
    }

    public long hP() {
        if (this.Az != null) {
            return this.Az.m5if();
        }
        return -1L;
    }

    public String hO() {
        if (this.Az != null) {
            return this.Az.ig();
        }
        return null;
    }

    public long ia() {
        if (this.Az != null) {
            return this.Az.ih();
        }
        return -1L;
    }

    public String hw() {
        if (this.Az != null) {
            return this.Az.hw();
        }
        return null;
    }

    public String hx() {
        if (this.Az != null) {
            return this.Az.hx();
        }
        return null;
    }

    public String getUrl() {
        return this.Av;
    }
}
