package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes18.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bxS;
    private Context mContext;
    private boolean bxR = false;
    private final Map<String, a> bxT = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bxS = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bxS.c(this.mContext, str, str2, z));
        this.bxT.put(str, aVar);
        return aVar;
    }

    public a hD(String str) {
        return this.bxT.get(str);
    }

    public com.baidu.h.a.b.c hE(String str) {
        return this.bxT.get(str).Ro();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void hC(String str) {
        a hD = hD(str);
        if (hD != null) {
            hD.hC(str);
            this.bxT.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void IW() {
        try {
            for (Map.Entry<String, a> entry : this.bxT.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bxT.get(key);
                if (aVar != null) {
                    if (aVar.Rp()) {
                        aVar.IW();
                    }
                    this.bxT.remove(key);
                }
            }
            this.bxS.unregisterConnectListener();
            this.bxR = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a hD = hD(str);
        if (hD != null) {
            hD.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a hD = hD(str);
        if (hD != null) {
            hD.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bxR) {
            this.bxS.unregisterConnectListener();
            this.bxS.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bxS.Rd();
                    }
                }
            });
            this.bxR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bxT.entrySet()) {
                a aVar = this.bxT.get(entry.getKey());
                if (aVar != null) {
                    aVar.Br();
                }
            }
        } catch (Exception e) {
        }
    }
}
