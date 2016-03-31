package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h Ag = null;
    private String[] Aj;
    private g.a An;
    private String Ah = null;
    private List<BasicNameValuePair> Ai = null;
    private String Ak = null;
    private j Al = null;
    private ArrayList<g.a> Am = new ArrayList<>();

    public static h jR() {
        if (Ag == null) {
            synchronized (h.class) {
                if (Ag == null) {
                    Ag = new h();
                }
            }
        }
        return Ag;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Ah = str;
        this.Ak = str2;
        this.Aj = strArr;
        this.Ai = list;
        isDebug();
    }

    private h() {
        this.An = null;
        this.An = new i(this);
    }

    public boolean jS() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ju();
        }
        if (this.Al != null) {
            if (this.Al.jV() || this.Al.isOpen()) {
                isDebug();
                return true;
            }
            this.Al.close(1, null);
            this.Al = null;
        }
        this.Al = new j();
        try {
            n nVar = new n();
            nVar.bc(this.Ak);
            this.Al.a(this.Ah, this.Aj, this.An, nVar, this.Ai);
            return true;
        } catch (WebSocketException e) {
            this.Al = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Al != null) {
            j jVar = this.Al;
            this.Al = null;
            jVar.close(i, str);
            if (this.Al != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Al = null;
            }
        }
    }

    public boolean jT() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ju();
        }
        return (this.Al == null || !this.Al.isOpen() || this.Al.kd()) ? false : true;
    }

    public boolean jU() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ju();
        }
        return this.Al != null && this.Al.isOpen();
    }

    public boolean jV() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.ju();
        }
        return this.Al != null && this.Al.jV();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.ju();
                if (this.Al != null) {
                    z = this.Al.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.I(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Am.contains(aVar)) {
                    return this.Am.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jW() {
        if (this.Al != null) {
            this.Al.jW();
        }
    }

    public long getUpFlowSize() {
        if (this.Al != null) {
            return this.Al.getUpFlowSize();
        }
        return -1L;
    }

    public void jX() {
        if (this.Al != null) {
            this.Al.jX();
        }
    }

    public long getDownFlowSize() {
        if (this.Al != null) {
            return this.Al.getDownFlowSize();
        }
        return -1L;
    }

    public long jO() {
        if (this.Al != null) {
            return this.Al.ke();
        }
        return -1L;
    }

    public String jN() {
        if (this.Al != null) {
            return this.Al.kf();
        }
        return null;
    }

    public long jY() {
        if (this.Al != null) {
            return this.Al.kg();
        }
        return -1L;
    }

    public String jx() {
        if (this.Al != null) {
            return this.Al.jx();
        }
        return null;
    }

    public String jy() {
        if (this.Al != null) {
            return this.Al.jy();
        }
        return null;
    }

    public String getUrl() {
        return this.Ah;
    }
}
