package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zN = null;
    private String[] zQ;
    private g.a zU;
    private String zO = null;
    private List<BasicNameValuePair> zP = null;
    private String zR = null;
    private j zS = null;
    private ArrayList<g.a> zT = new ArrayList<>();

    public static h jL() {
        if (zN == null) {
            synchronized (h.class) {
                if (zN == null) {
                    zN = new h();
                }
            }
        }
        return zN;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zO = str;
        this.zR = str2;
        this.zQ = strArr;
        this.zP = list;
        isDebug();
    }

    private h() {
        this.zU = null;
        this.zU = new i(this);
    }

    public boolean jM() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jo();
        }
        if (this.zS != null) {
            if (this.zS.jP() || this.zS.isOpen()) {
                isDebug();
                return true;
            }
            this.zS.close(1, null);
            this.zS = null;
        }
        this.zS = new j();
        try {
            n nVar = new n();
            nVar.aZ(this.zR);
            this.zS.a(this.zO, this.zQ, this.zU, nVar, this.zP);
            return true;
        } catch (WebSocketException e) {
            this.zS = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zS != null) {
            j jVar = this.zS;
            this.zS = null;
            jVar.close(i, str);
            if (this.zS != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zS = null;
            }
        }
    }

    public boolean jN() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jo();
        }
        return (this.zS == null || !this.zS.isOpen() || this.zS.jW()) ? false : true;
    }

    public boolean jO() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jo();
        }
        return this.zS != null && this.zS.isOpen();
    }

    public boolean jP() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jo();
        }
        return this.zS != null && this.zS.jP();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.jo();
                if (this.zS != null) {
                    z = this.zS.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.J(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zT.contains(aVar)) {
                    return this.zT.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jQ() {
        if (this.zS != null) {
            this.zS.jQ();
        }
    }

    public long getUpFlowSize() {
        if (this.zS != null) {
            return this.zS.getUpFlowSize();
        }
        return -1L;
    }

    public void jR() {
        if (this.zS != null) {
            this.zS.jR();
        }
    }

    public long getDownFlowSize() {
        if (this.zS != null) {
            return this.zS.getDownFlowSize();
        }
        return -1L;
    }

    public long jI() {
        if (this.zS != null) {
            return this.zS.jX();
        }
        return -1L;
    }

    public String jH() {
        if (this.zS != null) {
            return this.zS.jY();
        }
        return null;
    }

    public long jS() {
        if (this.zS != null) {
            return this.zS.jZ();
        }
        return -1L;
    }

    public String jr() {
        if (this.zS != null) {
            return this.zS.jr();
        }
        return null;
    }

    public String js() {
        if (this.zS != null) {
            return this.zS.js();
        }
        return null;
    }

    public String getUrl() {
        return this.zO;
    }
}
