package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bVW;
    private Context mContext;
    private boolean bVV = false;
    private final Map<String, a> bVX = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bVW = dVar;
    }

    private a i(String str, String str2, boolean z) {
        a aVar = new a(this.bVW.c(this.mContext, str, str2, z));
        this.bVX.put(str, aVar);
        return aVar;
    }

    public a jg(String str) {
        return this.bVX.get(str);
    }

    public com.baidu.h.a.b.c jh(String str) {
        return this.bVX.get(str).Yr();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        i(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void jf(String str) {
        a jg = jg(str);
        if (jg != null) {
            jg.jf(str);
            this.bVX.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void LA() {
        try {
            for (Map.Entry<String, a> entry : this.bVX.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bVX.get(key);
                if (aVar != null) {
                    if (aVar.Ys()) {
                        aVar.LA();
                    }
                    this.bVX.remove(key);
                }
            }
            this.bVW.unregisterConnectListener();
            this.bVV = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a jg = jg(str);
        if (jg != null) {
            jg.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a jg = jg(str);
        if (jg != null) {
            jg.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bVV) {
            this.bVW.unregisterConnectListener();
            this.bVW.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bVW.Yg();
                    }
                }
            });
            this.bVV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bVX.entrySet()) {
                a aVar = this.bVX.get(entry.getKey());
                if (aVar != null) {
                    aVar.Dc();
                }
            }
        } catch (Exception e) {
        }
    }
}
