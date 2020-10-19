package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bHR;
    private Context mContext;
    private boolean bHQ = false;
    private final Map<String, a> bHS = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bHR = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bHR.c(this.mContext, str, str2, z));
        this.bHS.put(str, aVar);
        return aVar;
    }

    public a iA(String str) {
        return this.bHS.get(str);
    }

    public com.baidu.h.a.b.c iB(String str) {
        return this.bHS.get(str).TY();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void iz(String str) {
        a iA = iA(str);
        if (iA != null) {
            iA.iz(str);
            this.bHS.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void KG() {
        try {
            for (Map.Entry<String, a> entry : this.bHS.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bHS.get(key);
                if (aVar != null) {
                    if (aVar.TZ()) {
                        aVar.KG();
                    }
                    this.bHS.remove(key);
                }
            }
            this.bHR.unregisterConnectListener();
            this.bHQ = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a iA = iA(str);
        if (iA != null) {
            iA.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a iA = iA(str);
        if (iA != null) {
            iA.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bHQ) {
            this.bHR.unregisterConnectListener();
            this.bHR.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bHR.TN();
                    }
                }
            });
            this.bHQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bHS.entrySet()) {
                a aVar = this.bHS.get(entry.getKey());
                if (aVar != null) {
                    aVar.CD();
                }
            }
        } catch (Exception e) {
        }
    }
}
