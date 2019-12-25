package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aDT;
    private Context mContext;
    private boolean aDS = false;
    private final Map<String, a> aDU = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aDT = dVar;
    }

    private a e(String str, String str2, boolean z) {
        if (this.aDU.get(str) != null) {
            this.aDU.get(str).ec(str);
            this.aDU.remove(str);
        }
        a aVar = new a(this.aDT.l(this.mContext, str, str2));
        this.aDU.put(str, aVar);
        return aVar;
    }

    public a ed(String str) {
        return this.aDU.get(str);
    }

    public com.baidu.g.a.b.c ee(String str) {
        return this.aDU.get(str).zh();
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.g.a.b.b bVar, boolean z) {
        register();
        e(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void ec(String str) {
        a ed = ed(str);
        if (ed != null) {
            ed.ec(str);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void uq() {
        try {
            for (Map.Entry<String, a> entry : this.aDU.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aDU.get(key);
                if (aVar != null) {
                    if (aVar.zi()) {
                        aVar.uq();
                    }
                    this.aDU.remove(key);
                }
            }
            this.aDT.unregisterConnectListener();
            this.aDS = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a ed = ed(str);
        if (ed != null) {
            ed.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, com.baidu.g.a.b.a.d dVar) {
        a ed = ed(str);
        if (ed != null) {
            ed.a(str, dVar);
        }
    }

    private void register() {
        if (!this.aDS) {
            this.aDT.unregisterConnectListener();
            this.aDT.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aDT.yW();
                    }
                }
            });
            this.aDS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aDU.entrySet()) {
                a aVar = this.aDU.get(entry.getKey());
                if (aVar != null) {
                    aVar.vN();
                }
            }
        } catch (Exception e) {
        }
    }
}
