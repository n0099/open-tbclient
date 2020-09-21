package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes23.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bBp;
    private Context mContext;
    private boolean bBo = false;
    private final Map<String, a> bBq = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bBp = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bBp.c(this.mContext, str, str2, z));
        this.bBq.put(str, aVar);
        return aVar;
    }

    public a hZ(String str) {
        return this.bBq.get(str);
    }

    public com.baidu.h.a.b.c ia(String str) {
        return this.bBq.get(str).Sf();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void hY(String str) {
        a hZ = hZ(str);
        if (hZ != null) {
            hZ.hY(str);
            this.bBq.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void JA() {
        try {
            for (Map.Entry<String, a> entry : this.bBq.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bBq.get(key);
                if (aVar != null) {
                    if (aVar.Sg()) {
                        aVar.JA();
                    }
                    this.bBq.remove(key);
                }
            }
            this.bBp.unregisterConnectListener();
            this.bBo = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a hZ = hZ(str);
        if (hZ != null) {
            hZ.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a hZ = hZ(str);
        if (hZ != null) {
            hZ.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bBo) {
            this.bBp.unregisterConnectListener();
            this.bBp.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bBp.RU();
                    }
                }
            });
            this.bBo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bBq.entrySet()) {
                a aVar = this.bBq.get(entry.getKey());
                if (aVar != null) {
                    aVar.BG();
                }
            }
        } catch (Exception e) {
        }
    }
}
