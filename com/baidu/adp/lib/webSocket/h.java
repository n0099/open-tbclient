package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zx = null;
    private String[] zA;
    private g.a zE;
    private String zy = null;
    private List<BasicNameValuePair> zz = null;
    private String zB = null;
    private j zC = null;
    private ArrayList<g.a> zD = new ArrayList<>();

    public static synchronized h jz() {
        h hVar;
        synchronized (h.class) {
            if (zx == null) {
                zx = new h();
            }
            hVar = zx;
        }
        return hVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zy = str;
        this.zB = str2;
        this.zA = strArr;
        this.zz = list;
        isDebug();
    }

    private h() {
        this.zE = null;
        this.zE = new i(this);
    }

    public boolean jA() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jb();
        }
        if (this.zC != null) {
            if (this.zC.jD() || this.zC.isOpen()) {
                isDebug();
                return true;
            }
            this.zC.close(1, null);
            this.zC = null;
        }
        this.zC = new j();
        try {
            n nVar = new n();
            nVar.aY(this.zB);
            this.zC.a(this.zy, this.zA, this.zE, nVar, this.zz);
            return true;
        } catch (WebSocketException e) {
            this.zC = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zC != null) {
            j jVar = this.zC;
            this.zC = null;
            jVar.close(i, str);
            if (this.zC != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zC = null;
            }
        }
    }

    public boolean jB() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jb();
        }
        return (this.zC == null || !this.zC.isOpen() || this.zC.jK()) ? false : true;
    }

    public boolean jC() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jb();
        }
        return this.zC != null && this.zC.isOpen();
    }

    public boolean jD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jb();
        }
        return this.zC != null && this.zC.jD();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.jb();
                if (this.zC != null) {
                    z = this.zC.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.y(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zD.contains(aVar)) {
                    return this.zD.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jE() {
        if (this.zC != null) {
            this.zC.jE();
        }
    }

    public long getUpFlowSize() {
        if (this.zC != null) {
            return this.zC.getUpFlowSize();
        }
        return 0L;
    }

    public void jF() {
        if (this.zC != null) {
            this.zC.jF();
        }
    }

    public long getDownFlowSize() {
        if (this.zC != null) {
            return this.zC.getDownFlowSize();
        }
        return 0L;
    }

    public long jw() {
        if (this.zC != null) {
            return this.zC.jL();
        }
        return 0L;
    }

    public String jv() {
        if (this.zC != null) {
            return this.zC.jM();
        }
        return null;
    }

    public long jG() {
        if (this.zC != null) {
            return this.zC.jN();
        }
        return 0L;
    }

    public String je() {
        if (this.zC != null) {
            return this.zC.je();
        }
        return null;
    }

    public String jf() {
        if (this.zC != null) {
            return this.zC.jf();
        }
        return null;
    }

    public String getUrl() {
        return this.zy;
    }
}
