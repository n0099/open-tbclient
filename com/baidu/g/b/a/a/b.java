package com.baidu.g.b.a.a;

import android.content.Context;
import com.baidu.g.a.b.a.e;
import com.baidu.g.a.b.a.f;
import com.baidu.g.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b implements com.baidu.g.a.b.a.b {
    private d aEL;
    private Context mContext;
    private boolean aEK = false;
    private final Map<String, a> aEM = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.aEL = dVar;
    }

    private a e(String str, String str2, boolean z) {
        if (this.aEM.get(str) != null) {
            this.aEM.get(str).ef(str);
            this.aEM.remove(str);
        }
        a aVar = new a(this.aEL.l(this.mContext, str, str2));
        this.aEM.put(str, aVar);
        return aVar;
    }

    public a eg(String str) {
        return this.aEM.get(str);
    }

    public com.baidu.g.a.b.c eh(String str) {
        return this.aEM.get(str).zD();
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.g.a.b.b bVar, boolean z) {
        register();
        e(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void ef(String str) {
        a eg = eg(str);
        if (eg != null) {
            eg.ef(str);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void uH() {
        try {
            for (Map.Entry<String, a> entry : this.aEM.entrySet()) {
                String key = entry.getKey();
                a aVar = this.aEM.get(key);
                if (aVar != null) {
                    if (aVar.zE()) {
                        aVar.uH();
                    }
                    this.aEM.remove(key);
                }
            }
            this.aEL.unregisterConnectListener();
            this.aEK = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a eg = eg(str);
        if (eg != null) {
            eg.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.g.a.b.a.b
    public void a(String str, com.baidu.g.a.b.a.d dVar) {
        a eg = eg(str);
        if (eg != null) {
            eg.a(str, dVar);
        }
    }

    private void register() {
        if (!this.aEK) {
            this.aEL.unregisterConnectListener();
            this.aEL.a(new com.baidu.g.a.b.a() { // from class: com.baidu.g.b.a.a.b.1
                @Override // com.baidu.g.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.aEL.zs();
                    }
                }
            });
            this.aEK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.aEM.entrySet()) {
                a aVar = this.aEM.get(entry.getKey());
                if (aVar != null) {
                    aVar.we();
                }
            }
        } catch (Exception e) {
        }
    }
}
