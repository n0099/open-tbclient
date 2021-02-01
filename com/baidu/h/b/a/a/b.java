package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d cfH;
    private Context mContext;
    private boolean cfG = false;
    private final Map<String, a> cfI = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.cfH = dVar;
    }

    private a l(String str, String str2, boolean z) {
        a aVar = new a(this.cfH.c(this.mContext, str, str2, z));
        this.cfI.put(str, aVar);
        return aVar;
    }

    public a iS(String str) {
        return this.cfI.get(str);
    }

    public com.baidu.h.a.b.c iT(String str) {
        return this.cfI.get(str).aaa();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        l(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void iR(String str) {
        a iS = iS(str);
        if (iS != null) {
            iS.iR(str);
            this.cfI.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void JU() {
        try {
            for (Map.Entry<String, a> entry : this.cfI.entrySet()) {
                String key = entry.getKey();
                a aVar = this.cfI.get(key);
                if (aVar != null) {
                    if (aVar.aab()) {
                        aVar.JU();
                    }
                    this.cfI.remove(key);
                }
            }
            this.cfH.unregisterConnectListener();
            this.cfG = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a iS = iS(str);
        if (iS != null) {
            iS.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a iS = iS(str);
        if (iS != null) {
            iS.a(str, dVar);
        }
    }

    private void register() {
        if (!this.cfG) {
            this.cfH.unregisterConnectListener();
            this.cfH.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.cfH.ZP();
                    }
                }
            });
            this.cfG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.cfI.entrySet()) {
                a aVar = this.cfI.get(entry.getKey());
                if (aVar != null) {
                    aVar.Ah();
                }
            }
        } catch (Exception e) {
        }
    }
}
