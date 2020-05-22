package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d bmE;
    private Context mContext;
    private boolean bmD = false;
    private final Map<String, a> bmF = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bmE = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.bmE.n(this.mContext, str, str2));
        this.bmF.put(str, aVar);
        return aVar;
    }

    public a ga(String str) {
        return this.bmF.get(str);
    }

    public com.baidu.c.a.b.c gb(String str) {
        return this.bmF.get(str).JY();
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.c.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void fZ(String str) {
        a ga = ga(str);
        if (ga != null) {
            ga.fZ(str);
            this.bmF.remove(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void Cs() {
        try {
            for (Map.Entry<String, a> entry : this.bmF.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bmF.get(key);
                if (aVar != null) {
                    if (aVar.JZ()) {
                        aVar.Cs();
                    }
                    this.bmF.remove(key);
                }
            }
            this.bmE.unregisterConnectListener();
            this.bmD = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a ga = ga(str);
        if (ga != null) {
            ga.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, com.baidu.c.a.b.a.d dVar) {
        a ga = ga(str);
        if (ga != null) {
            ga.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bmD) {
            this.bmE.unregisterConnectListener();
            this.bmE.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bmE.JN();
                    }
                }
            });
            this.bmD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bmF.entrySet()) {
                a aVar = this.bmF.get(entry.getKey());
                if (aVar != null) {
                    aVar.ED();
                }
            }
        } catch (Exception e) {
        }
    }
}
