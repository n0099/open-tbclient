package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d bfe;
    private Context mContext;
    private boolean bfd = false;
    private final Map<String, a> bff = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bfe = dVar;
    }

    private a f(String str, String str2, boolean z) {
        a aVar = new a(this.bfe.n(this.mContext, str, str2));
        this.bff.put(str, aVar);
        return aVar;
    }

    public a fo(String str) {
        return this.bff.get(str);
    }

    public com.baidu.c.a.b.c fp(String str) {
        return this.bff.get(str).If();
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.c.a.b.b bVar, boolean z) {
        register();
        f(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void fn(String str) {
        a fo = fo(str);
        if (fo != null) {
            fo.fn(str);
            this.bff.remove(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void AY() {
        try {
            for (Map.Entry<String, a> entry : this.bff.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bff.get(key);
                if (aVar != null) {
                    if (aVar.Ig()) {
                        aVar.AY();
                    }
                    this.bff.remove(key);
                }
            }
            this.bfe.unregisterConnectListener();
            this.bfd = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a fo = fo(str);
        if (fo != null) {
            fo.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, com.baidu.c.a.b.a.d dVar) {
        a fo = fo(str);
        if (fo != null) {
            fo.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bfd) {
            this.bfe.unregisterConnectListener();
            this.bfe.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bfe.HU();
                    }
                }
            });
            this.bfd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bff.entrySet()) {
                a aVar = this.bff.get(entry.getKey());
                if (aVar != null) {
                    aVar.Df();
                }
            }
        } catch (Exception e) {
        }
    }
}
