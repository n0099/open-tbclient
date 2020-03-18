package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aJh;
    private Context mContext;
    private boolean aJg = false;
    private final Map<String, a> aJi = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aJh = dVar;
    }

    private a f(String str, String str2, boolean z) {
        if (this.aJi.get(str) != null) {
            this.aJi.get(str).et(str);
            this.aJi.remove(str);
        }
        a aVar = new a(this.aJh.l(this.mContext, str, str2));
        this.aJi.put(str, aVar);
        return aVar;
    }

    public a eu(String str) {
        return this.aJi.get(str);
    }

    public com.baidu.g.a.b.c ev(String str) {
        return this.aJi.get(str).Cc();
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.g.a.b.b bVar, boolean z) {
        register();
        f(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void et(String str) {
        a eu = eu(str);
        if (eu != null) {
            eu.et(str);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void wq() {
        try {
            for (Map.Entry<String, a> entry : this.aJi.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aJi.get(key);
                if (aVar != null) {
                    if (aVar.Cd()) {
                        aVar.wq();
                    }
                    this.aJi.remove(key);
                }
            }
            this.aJh.unregisterConnectListener();
            this.aJg = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a eu = eu(str);
        if (eu != null) {
            eu.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, com.baidu.g.a.b.a.d dVar) {
        a eu = eu(str);
        if (eu != null) {
            eu.a(str, dVar);
        }
    }

    private void register() {
        if (!this.aJg) {
            this.aJh.unregisterConnectListener();
            this.aJh.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aJh.BR();
                    }
                }
            });
            this.aJg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aJi.entrySet()) {
                a aVar = this.aJi.get(entry.getKey());
                if (aVar != null) {
                    aVar.yn();
                }
            }
        } catch (Exception e) {
        }
    }
}
