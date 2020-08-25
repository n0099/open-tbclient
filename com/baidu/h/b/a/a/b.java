package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes18.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bxP;
    private Context mContext;
    private boolean bxO = false;
    private final Map<String, a> bxQ = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bxP = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bxP.c(this.mContext, str, str2, z));
        this.bxQ.put(str, aVar);
        return aVar;
    }

    public a hC(String str) {
        return this.bxQ.get(str);
    }

    public com.baidu.h.a.b.c hD(String str) {
        return this.bxQ.get(str).Ro();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void hB(String str) {
        a hC = hC(str);
        if (hC != null) {
            hC.hB(str);
            this.bxQ.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void IW() {
        try {
            for (Map.Entry<String, a> entry : this.bxQ.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bxQ.get(key);
                if (aVar != null) {
                    if (aVar.Rp()) {
                        aVar.IW();
                    }
                    this.bxQ.remove(key);
                }
            }
            this.bxP.unregisterConnectListener();
            this.bxO = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a hC = hC(str);
        if (hC != null) {
            hC.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a hC = hC(str);
        if (hC != null) {
            hC.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bxO) {
            this.bxP.unregisterConnectListener();
            this.bxP.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bxP.Rd();
                    }
                }
            });
            this.bxO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bxQ.entrySet()) {
                a aVar = this.bxQ.get(entry.getKey());
                if (aVar != null) {
                    aVar.Br();
                }
            }
        } catch (Exception e) {
        }
    }
}
