package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d beY;
    private Context mContext;
    private boolean beX = false;
    private final Map<String, a> beZ = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.beY = dVar;
    }

    private a f(String str, String str2, boolean z) {
        a aVar = new a(this.beY.l(this.mContext, str, str2));
        this.beZ.put(str, aVar);
        return aVar;
    }

    public a fo(String str) {
        return this.beZ.get(str);
    }

    public com.baidu.c.a.b.c fp(String str) {
        return this.beZ.get(str).Ig();
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
            this.beZ.remove(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void AZ() {
        try {
            for (Map.Entry<String, a> entry : this.beZ.entrySet()) {
                String key = entry.getKey();
                a aVar = this.beZ.get(key);
                if (aVar != null) {
                    if (aVar.Ih()) {
                        aVar.AZ();
                    }
                    this.beZ.remove(key);
                }
            }
            this.beY.unregisterConnectListener();
            this.beX = false;
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
        if (!this.beX) {
            this.beY.unregisterConnectListener();
            this.beY.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.beY.HV();
                    }
                }
            });
            this.beX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.beZ.entrySet()) {
                a aVar = this.beZ.get(entry.getKey());
                if (aVar != null) {
                    aVar.Dg();
                }
            }
        } catch (Exception e) {
        }
    }
}
