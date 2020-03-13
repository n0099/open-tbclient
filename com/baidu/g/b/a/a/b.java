package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aIT;
    private Context mContext;
    private boolean aIS = false;
    private final Map<String, a> aIU = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aIT = dVar;
    }

    private a f(String str, String str2, boolean z) {
        if (this.aIU.get(str) != null) {
            this.aIU.get(str).eu(str);
            this.aIU.remove(str);
        }
        a aVar = new a(this.aIT.l(this.mContext, str, str2));
        this.aIU.put(str, aVar);
        return aVar;
    }

    public a ev(String str) {
        return this.aIU.get(str);
    }

    public com.baidu.g.a.b.c ew(String str) {
        return this.aIU.get(str).BV();
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
            for (Map.Entry<String, a> entry : this.aIU.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aIU.get(key);
                if (aVar != null) {
                    if (aVar.BW()) {
                        aVar.wl();
                    }
                    this.aIU.remove(key);
                }
            }
            this.aIT.unregisterConnectListener();
            this.aIS = false;
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
        if (!this.aIS) {
            this.aIT.unregisterConnectListener();
            this.aIT.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aIT.BK();
                    }
                }
            });
            this.aIS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aIU.entrySet()) {
                a aVar = this.aIU.get(entry.getKey());
                if (aVar != null) {
                    aVar.yi();
                }
            }
        } catch (Exception e) {
        }
    }
}
