package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bQm;
    private Context mContext;
    private boolean bQl = false;
    private final Map<String, a> bQn = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bQm = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bQm.c(this.mContext, str, str2, z));
        this.bQn.put(str, aVar);
        return aVar;
    }

    public a iT(String str) {
        return this.bQn.get(str);
    }

    public com.baidu.h.a.b.c iU(String str) {
        return this.bQn.get(str).VS();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void iS(String str) {
        a iT = iT(str);
        if (iT != null) {
            iT.iS(str);
            this.bQn.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void La() {
        try {
            for (Map.Entry<String, a> entry : this.bQn.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bQn.get(key);
                if (aVar != null) {
                    if (aVar.VT()) {
                        aVar.La();
                    }
                    this.bQn.remove(key);
                }
            }
            this.bQm.unregisterConnectListener();
            this.bQl = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a iT = iT(str);
        if (iT != null) {
            iT.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a iT = iT(str);
        if (iT != null) {
            iT.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bQl) {
            this.bQm.unregisterConnectListener();
            this.bQm.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bQm.VH();
                    }
                }
            });
            this.bQl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bQn.entrySet()) {
                a aVar = this.bQn.get(entry.getKey());
                if (aVar != null) {
                    aVar.CJ();
                }
            }
        } catch (Exception e) {
        }
    }
}
