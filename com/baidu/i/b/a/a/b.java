package com.baidu.i.b.a.a;

import android.content.Context;
import com.baidu.i.a.b.a.e;
import com.baidu.i.a.b.a.f;
import com.baidu.i.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class b implements com.baidu.i.a.b.a.b {
    private d bZB;
    private Context mContext;
    private boolean bZA = false;
    private final Map<String, a> bZC = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bZB = dVar;
    }

    private a j(String str, String str2, boolean z) {
        a aVar = new a(this.bZB.c(this.mContext, str, str2, z));
        this.bZC.put(str, aVar);
        return aVar;
    }

    public a jE(String str) {
        return this.bZC.get(str);
    }

    public com.baidu.i.a.b.c jF(String str) {
        return this.bZC.get(str).aal();
    }

    @Override // com.baidu.i.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.i.a.b.b bVar, boolean z) {
        register();
        j(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.i.a.b.a.b
    public synchronized void jD(String str) {
        a jE = jE(str);
        if (jE != null) {
            jE.jD(str);
            this.bZC.remove(str);
        }
    }

    @Override // com.baidu.i.a.b.a.b
    public synchronized void MU() {
        try {
            for (Map.Entry<String, a> entry : this.bZC.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bZC.get(key);
                if (aVar != null) {
                    if (aVar.aam()) {
                        aVar.MU();
                    }
                    this.bZC.remove(key);
                }
            }
            this.bZB.unregisterConnectListener();
            this.bZA = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.i.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a jE = jE(str);
        if (jE != null) {
            jE.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.i.a.b.a.b
    public void a(String str, com.baidu.i.a.b.a.d dVar) {
        a jE = jE(str);
        if (jE != null) {
            jE.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bZA) {
            this.bZB.unregisterConnectListener();
            this.bZB.a(new com.baidu.i.a.b.a() { // from class: com.baidu.i.b.a.a.b.1
                @Override // com.baidu.i.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bZB.aaa();
                    }
                }
            });
            this.bZA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bZC.entrySet()) {
                a aVar = this.bZC.get(entry.getKey());
                if (aVar != null) {
                    aVar.Ed();
                }
            }
        } catch (Exception e) {
        }
    }
}
