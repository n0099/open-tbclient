package com.baidu.d.b.a.a;

import android.content.Context;
import com.baidu.d.a.b.a.e;
import com.baidu.d.a.b.a.f;
import com.baidu.d.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class b implements com.baidu.d.a.b.a.b {
    private d brZ;
    private Context mContext;
    private boolean brY = false;
    private final Map<String, a> bsa = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.brZ = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.brZ.c(this.mContext, str, str2, z));
        this.bsa.put(str, aVar);
        return aVar;
    }

    public a gh(String str) {
        return this.bsa.get(str);
    }

    public com.baidu.d.a.b.c gi(String str) {
        return this.bsa.get(str).Lo();
    }

    @Override // com.baidu.d.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.d.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.d.a.b.a.b
    public synchronized void gg(String str) {
        a gh = gh(str);
        if (gh != null) {
            gh.gg(str);
            this.bsa.remove(str);
        }
    }

    @Override // com.baidu.d.a.b.a.b
    public synchronized void Dt() {
        try {
            for (Map.Entry<String, a> entry : this.bsa.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bsa.get(key);
                if (aVar != null) {
                    if (aVar.Lp()) {
                        aVar.Dt();
                    }
                    this.bsa.remove(key);
                }
            }
            this.brZ.unregisterConnectListener();
            this.brY = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.d.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a gh = gh(str);
        if (gh != null) {
            gh.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.d.a.b.a.b
    public void a(String str, com.baidu.d.a.b.a.d dVar) {
        a gh = gh(str);
        if (gh != null) {
            gh.a(str, dVar);
        }
    }

    private void register() {
        if (!this.brY) {
            this.brZ.unregisterConnectListener();
            this.brZ.a(new com.baidu.d.a.b.a() { // from class: com.baidu.d.b.a.a.b.1
                @Override // com.baidu.d.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.brZ.Ld();
                    }
                }
            });
            this.brY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bsa.entrySet()) {
                a aVar = this.bsa.get(entry.getKey());
                if (aVar != null) {
                    aVar.vT();
                }
            }
        } catch (Exception e) {
        }
    }
}
