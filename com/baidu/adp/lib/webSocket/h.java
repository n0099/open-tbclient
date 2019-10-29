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
    private static h sq = null;
    private String[] su;
    private g.a sy;
    private String sr = null;
    private List<BasicNameValuePair> ss = null;
    private String sv = null;
    private i sw = null;
    private ArrayList<g.a> sx = new ArrayList<>();

    public static h hr() {
        if (sq == null) {
            synchronized (h.class) {
                if (sq == null) {
                    sq = new h();
                }
            }
        }
        return sq;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.sr = str;
        this.sv = str2;
        this.su = strArr;
        this.ss = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.sy = null;
        this.sy = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void i(byte[] bArr) {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).i(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.sw = null;
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hq() {
                Iterator it = h.this.sx.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hq();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.onStartSend();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.onSendError(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.onFinishSend();
                }
            }
        };
    }

    public boolean hs() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.sw != null) {
            if (this.sw.isConnecting() || this.sw.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.sw.close(1, null);
            this.sw = null;
        }
        this.sw = new i();
        try {
            l lVar = new l();
            lVar.ay(this.sv);
            this.sw.a(this.sr, this.su, this.sy, lVar, this.ss);
            return true;
        } catch (WebSocketException e) {
            this.sw = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.sw != null) {
            i iVar = this.sw;
            this.sw = null;
            iVar.close(i, str);
            if (this.sw != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.sw = null;
            }
        }
    }

    public boolean ht() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.sw == null || !this.sw.isOpen() || this.sw.hB()) ? false : true;
    }

    public boolean hu() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.sw != null && this.sw.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.sw != null && this.sw.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.sw != null) {
                    z = this.sw.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.onSendError(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.sx.contains(aVar)) {
                    return this.sx.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hv() {
        if (this.sw != null) {
            this.sw.hv();
        }
    }

    public long getUpFlowSize() {
        if (this.sw != null) {
            return this.sw.getUpFlowSize();
        }
        return -1L;
    }

    public void hw() {
        if (this.sw != null) {
            this.sw.hw();
        }
    }

    public long getDownFlowSize() {
        if (this.sw != null) {
            return this.sw.getDownFlowSize();
        }
        return -1L;
    }

    public long ho() {
        if (this.sw != null) {
            return this.sw.hC();
        }
        return -1L;
    }

    public String hn() {
        if (this.sw != null) {
            return this.sw.hD();
        }
        return null;
    }

    public long hx() {
        if (this.sw != null) {
            return this.sw.hE();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.sw != null) {
            return this.sw.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.sw != null) {
            return this.sw.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.sr;
    }
}
