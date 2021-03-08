package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d chh;
    private Context mContext;
    private boolean chg = false;
    private final Map<String, a> chi = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.chh = dVar;
    }

    private a l(String str, String str2, boolean z) {
        a aVar = new a(this.chh.c(this.mContext, str, str2, z));
        this.chi.put(str, aVar);
        return aVar;
    }

    public a iY(String str) {
        return this.chi.get(str);
    }

    public com.baidu.h.a.b.c iZ(String str) {
        return this.chi.get(str).aad();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        l(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void iX(String str) {
        a iY = iY(str);
        if (iY != null) {
            iY.iX(str);
            this.chi.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void JX() {
        try {
            for (Map.Entry<String, a> entry : this.chi.entrySet()) {
                String key = entry.getKey();
                a aVar = this.chi.get(key);
                if (aVar != null) {
                    if (aVar.aae()) {
                        aVar.JX();
                    }
                    this.chi.remove(key);
                }
            }
            this.chh.unregisterConnectListener();
            this.chg = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a iY = iY(str);
        if (iY != null) {
            iY.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a iY = iY(str);
        if (iY != null) {
            iY.a(str, dVar);
        }
    }

    private void register() {
        if (!this.chg) {
            this.chh.unregisterConnectListener();
            this.chh.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.chh.ZS();
                    }
                }
            });
            this.chg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.chi.entrySet()) {
                a aVar = this.chi.get(entry.getKey());
                if (aVar != null) {
                    aVar.Ak();
                }
            }
        } catch (Exception e) {
        }
    }
}
