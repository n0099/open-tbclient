package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zD = null;
    private String[] zG;
    private g.a zK;
    private String zE = null;
    private List<BasicNameValuePair> zF = null;
    private String zH = null;
    private j zI = null;
    private ArrayList<g.a> zJ = new ArrayList<>();

    public static synchronized h jB() {
        h hVar;
        synchronized (h.class) {
            if (zD == null) {
                zD = new h();
            }
            hVar = zD;
        }
        return hVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zE = str;
        this.zH = str2;
        this.zG = strArr;
        this.zF = list;
        isDebug();
    }

    private h() {
        this.zK = null;
        this.zK = new i(this);
    }

    public boolean jC() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.je();
        }
        if (this.zI != null) {
            if (this.zI.jF() || this.zI.isOpen()) {
                isDebug();
                return true;
            }
            this.zI.close(1, null);
            this.zI = null;
        }
        this.zI = new j();
        try {
            n nVar = new n();
            nVar.ba(this.zH);
            this.zI.a(this.zE, this.zG, this.zK, nVar, this.zF);
            return true;
        } catch (WebSocketException e) {
            this.zI = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zI != null) {
            j jVar = this.zI;
            this.zI = null;
            jVar.close(i, str);
            if (this.zI != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zI = null;
            }
        }
    }

    public boolean jD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.je();
        }
        return (this.zI == null || !this.zI.isOpen() || this.zI.jM()) ? false : true;
    }

    public boolean jE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.je();
        }
        return this.zI != null && this.zI.isOpen();
    }

    public boolean jF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.je();
        }
        return this.zI != null && this.zI.jF();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.je();
                if (this.zI != null) {
                    z = this.zI.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.z(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zJ.contains(aVar)) {
                    return this.zJ.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jG() {
        if (this.zI != null) {
            this.zI.jG();
        }
    }

    public long getUpFlowSize() {
        if (this.zI != null) {
            return this.zI.getUpFlowSize();
        }
        return 0L;
    }

    public void jH() {
        if (this.zI != null) {
            this.zI.jH();
        }
    }

    public long getDownFlowSize() {
        if (this.zI != null) {
            return this.zI.getDownFlowSize();
        }
        return 0L;
    }

    public long jy() {
        if (this.zI != null) {
            return this.zI.jN();
        }
        return 0L;
    }

    public String jx() {
        if (this.zI != null) {
            return this.zI.jO();
        }
        return null;
    }

    public long jI() {
        if (this.zI != null) {
            return this.zI.jP();
        }
        return 0L;
    }

    public String jh() {
        if (this.zI != null) {
            return this.zI.jh();
        }
        return null;
    }

    public String ji() {
        if (this.zI != null) {
            return this.zI.ji();
        }
        return null;
    }

    public String getUrl() {
        return this.zE;
    }
}
