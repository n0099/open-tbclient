package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d brE;
    private Context mContext;
    private boolean brD = false;
    private final Map<String, a> brF = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.brE = dVar;
    }

    private a h(String str, String str2, boolean z) {
        a aVar = new a(this.brE.n(this.mContext, str, str2));
        this.brF.put(str, aVar);
        return aVar;
    }

    public a gi(String str) {
        return this.brF.get(str);
    }

    public com.baidu.c.a.b.c gj(String str) {
        return this.brF.get(str).Lh();
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.c.a.b.b bVar, boolean z) {
        register();
        h(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void gh(String str) {
        a gi = gi(str);
        if (gi != null) {
            gi.gh(str);
            this.brF.remove(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void CS() {
        try {
            for (Map.Entry<String, a> entry : this.brF.entrySet()) {
                String key = entry.getKey();
                a aVar = this.brF.get(key);
                if (aVar != null) {
                    if (aVar.Li()) {
                        aVar.CS();
                    }
                    this.brF.remove(key);
                }
            }
            this.brE.unregisterConnectListener();
            this.brD = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a gi = gi(str);
        if (gi != null) {
            gi.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, com.baidu.c.a.b.a.d dVar) {
        a gi = gi(str);
        if (gi != null) {
            gi.a(str, dVar);
        }
    }

    private void register() {
        if (!this.brD) {
            this.brE.unregisterConnectListener();
            this.brE.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.brE.KW();
                    }
                }
            });
            this.brD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.brF.entrySet()) {
                a aVar = this.brF.get(entry.getKey());
                if (aVar != null) {
                    aVar.Fh();
                }
            }
        } catch (Exception e) {
        }
    }
}
