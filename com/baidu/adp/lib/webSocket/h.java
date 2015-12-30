package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h zF = null;
    private String[] zI;
    private g.a zM;
    private String zG = null;
    private List<BasicNameValuePair> zH = null;
    private String zJ = null;
    private j zK = null;
    private ArrayList<g.a> zL = new ArrayList<>();

    public static synchronized h jC() {
        h hVar;
        synchronized (h.class) {
            if (zF == null) {
                zF = new h();
            }
            hVar = zF;
        }
        return hVar;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zG = str;
        this.zJ = str2;
        this.zI = strArr;
        this.zH = list;
        isDebug();
    }

    private h() {
        this.zM = null;
        this.zM = new i(this);
    }

    public boolean jD() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jf();
        }
        if (this.zK != null) {
            if (this.zK.jG() || this.zK.isOpen()) {
                isDebug();
                return true;
            }
            this.zK.close(1, null);
            this.zK = null;
        }
        this.zK = new j();
        try {
            n nVar = new n();
            nVar.ba(this.zJ);
            this.zK.a(this.zG, this.zI, this.zM, nVar, this.zH);
            return true;
        } catch (WebSocketException e) {
            this.zK = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zK != null) {
            j jVar = this.zK;
            this.zK = null;
            jVar.close(i, str);
            if (this.zK != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zK = null;
            }
        }
    }

    public boolean jE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jf();
        }
        return (this.zK == null || !this.zK.isOpen() || this.zK.jN()) ? false : true;
    }

    public boolean jF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jf();
        }
        return this.zK != null && this.zK.isOpen();
    }

    public boolean jG() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.jf();
        }
        return this.zK != null && this.zK.jG();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.jf();
                if (this.zK != null) {
                    z = this.zK.sendMessage(cVar);
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
                if (!this.zL.contains(aVar)) {
                    return this.zL.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jH() {
        if (this.zK != null) {
            this.zK.jH();
        }
    }

    public long getUpFlowSize() {
        if (this.zK != null) {
            return this.zK.getUpFlowSize();
        }
        return 0L;
    }

    public void jI() {
        if (this.zK != null) {
            this.zK.jI();
        }
    }

    public long getDownFlowSize() {
        if (this.zK != null) {
            return this.zK.getDownFlowSize();
        }
        return 0L;
    }

    public long jz() {
        if (this.zK != null) {
            return this.zK.jO();
        }
        return 0L;
    }

    public String jy() {
        if (this.zK != null) {
            return this.zK.jP();
        }
        return null;
    }

    public long jJ() {
        if (this.zK != null) {
            return this.zK.jQ();
        }
        return 0L;
    }

    public String ji() {
        if (this.zK != null) {
            return this.zK.ji();
        }
        return null;
    }

    public String jj() {
        if (this.zK != null) {
            return this.zK.jj();
        }
        return null;
    }

    public String getUrl() {
        return this.zG;
    }
}
