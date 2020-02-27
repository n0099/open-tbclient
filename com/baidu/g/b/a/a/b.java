package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aIR;
    private Context mContext;
    private boolean aIQ = false;
    private final Map<String, a> aIS = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aIR = dVar;
    }

    private a f(String str, String str2, boolean z) {
        if (this.aIS.get(str) != null) {
            this.aIS.get(str).eu(str);
            this.aIS.remove(str);
        }
        a aVar = new a(this.aIR.l(this.mContext, str, str2));
        this.aIS.put(str, aVar);
        return aVar;
    }

    public a ev(String str) {
        return this.aIS.get(str);
    }

    public com.baidu.g.a.b.c ew(String str) {
        return this.aIS.get(str).BT();
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.g.a.b.b bVar, boolean z) {
        register();
        f(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void eu(String str) {
        a ev = ev(str);
        if (ev != null) {
            ev.eu(str);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void wl() {
        try {
            for (Map.Entry<String, a> entry : this.aIS.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aIS.get(key);
                if (aVar != null) {
                    if (aVar.BU()) {
                        aVar.wl();
                    }
                    this.aIS.remove(key);
                }
            }
            this.aIR.unregisterConnectListener();
            this.aIQ = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a ev = ev(str);
        if (ev != null) {
            ev.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, com.baidu.g.a.b.a.d dVar) {
        a ev = ev(str);
        if (ev != null) {
            ev.a(str, dVar);
        }
    }

    private void register() {
        if (!this.aIQ) {
            this.aIR.unregisterConnectListener();
            this.aIR.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aIR.BI();
                    }
                }
            });
            this.aIQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aIS.entrySet()) {
                a aVar = this.aIS.get(entry.getKey());
                if (aVar != null) {
                    aVar.yi();
                }
            }
        } catch (Exception e) {
        }
    }
}
