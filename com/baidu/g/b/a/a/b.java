package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aIS;
    private Context mContext;
    private boolean aIR = false;
    private final Map<String, a> aIT = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aIS = dVar;
    }

    private a f(String str, String str2, boolean z) {
        if (this.aIT.get(str) != null) {
            this.aIT.get(str).eu(str);
            this.aIT.remove(str);
        }
        a aVar = new a(this.aIS.l(this.mContext, str, str2));
        this.aIT.put(str, aVar);
        return aVar;
    }

    public a ev(String str) {
        return this.aIT.get(str);
    }

    public com.baidu.g.a.b.c ew(String str) {
        return this.aIT.get(str).BV();
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
            for (Map.Entry<String, a> entry : this.aIT.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aIT.get(key);
                if (aVar != null) {
                    if (aVar.BW()) {
                        aVar.wl();
                    }
                    this.aIT.remove(key);
                }
            }
            this.aIS.unregisterConnectListener();
            this.aIR = false;
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
        if (!this.aIR) {
            this.aIS.unregisterConnectListener();
            this.aIS.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aIS.BK();
                    }
                }
            });
            this.aIR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aIT.entrySet()) {
                a aVar = this.aIT.get(entry.getKey());
                if (aVar != null) {
                    aVar.yi();
                }
            }
        } catch (Exception e) {
        }
    }
}
