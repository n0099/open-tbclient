package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d awb;
    private Context mContext;
    private boolean awa = false;
    private final Map<String, a> awc = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.awb = dVar;
    }

    private a e(String str, String str2, boolean z) {
        if (this.awc.get(str) != null) {
            this.awc.get(str).dm(str);
            this.awc.remove(str);
        }
        a aVar = new a(this.awb.l(this.mContext, str, str2));
        this.awc.put(str, aVar);
        return aVar;
    }

    public a dn(String str) {
        return this.awc.get(str);
    }

    /* renamed from: do  reason: not valid java name */
    public com.baidu.c.a.b.c m14do(String str) {
        return this.awc.get(str).xj();
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.c.a.b.b bVar, boolean z) {
        register();
        e(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void dm(String str) {
        a dn = dn(str);
        if (dn != null) {
            dn.dm(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void sz() {
        try {
            for (Map.Entry<String, a> entry : this.awc.entrySet()) {
                String key = entry.getKey();
                a aVar = this.awc.get(key);
                if (aVar != null) {
                    if (aVar.xk()) {
                        aVar.sz();
                    }
                    this.awc.remove(key);
                }
            }
            this.awb.unregisterConnectListener();
            this.awa = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a dn = dn(str);
        if (dn != null) {
            dn.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, com.baidu.c.a.b.a.d dVar) {
        a dn = dn(str);
        if (dn != null) {
            dn.a(str, dVar);
        }
    }

    private void register() {
        if (!this.awa) {
            this.awb.unregisterConnectListener();
            this.awb.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.awb.wY();
                    }
                }
            });
            this.awa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.awc.entrySet()) {
                a aVar = this.awc.get(entry.getKey());
                if (aVar != null) {
                    aVar.tR();
                }
            }
        } catch (Exception e) {
        }
    }
}
