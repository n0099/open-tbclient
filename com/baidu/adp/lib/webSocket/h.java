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
    private static h vc = null;
    private String[] vf;
    private g.a vj;
    private String vd = null;
    private List<BasicNameValuePair> ve = null;
    private String vg = null;
    private i vh = null;
    private ArrayList<g.a> vi = new ArrayList<>();

    public static h ia() {
        if (vc == null) {
            synchronized (h.class) {
                if (vc == null) {
                    vc = new h();
                }
            }
        }
        return vc;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.vd = str;
        this.vg = str2;
        this.vf = strArr;
        this.ve = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.vj = null;
        this.vj = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void h(byte[] bArr) {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).h(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.vh = null;
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hZ() {
                Iterator it = h.this.vi.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hZ();
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

    public boolean ib() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.vh != null) {
            if (this.vh.isConnecting() || this.vh.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.vh.close(1, null);
            this.vh = null;
        }
        this.vh = new i();
        try {
            l lVar = new l();
            lVar.aN(this.vg);
            this.vh.a(this.vd, this.vf, this.vj, lVar, this.ve);
            return true;
        } catch (WebSocketException e) {
            this.vh = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.vh != null) {
            i iVar = this.vh;
            this.vh = null;
            iVar.close(i, str);
            if (this.vh != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.vh = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.vh == null || !this.vh.isOpen() || this.vh.ik()) ? false : true;
    }

    public boolean ic() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.vh != null && this.vh.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.vh != null && this.vh.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.vh != null) {
                    z = this.vh.sendMessage(cVar);
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
                if (!this.vi.contains(aVar)) {
                    return this.vi.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ie() {
        if (this.vh != null) {
            this.vh.ie();
        }
    }

    public long getUpFlowSize() {
        if (this.vh != null) {
            return this.vh.getUpFlowSize();
        }
        return -1L;
    }

    /* renamed from: if  reason: not valid java name */
    public void m12if() {
        if (this.vh != null) {
            this.vh.m13if();
        }
    }

    public long getDownFlowSize() {
        if (this.vh != null) {
            return this.vh.getDownFlowSize();
        }
        return -1L;
    }

    public long hX() {
        if (this.vh != null) {
            return this.vh.il();
        }
        return -1L;
    }

    public String hW() {
        if (this.vh != null) {
            return this.vh.im();
        }
        return null;
    }

    public long ig() {
        if (this.vh != null) {
            return this.vh.in();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.vh != null) {
            return this.vh.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.vh != null) {
            return this.vh.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.vd;
    }
}
