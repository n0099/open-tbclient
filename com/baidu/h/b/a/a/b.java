package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d bUm;
    private Context mContext;
    private boolean bUl = false;
    private final Map<String, a> bUn = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.bUm = dVar;
    }

    private a i(String str, String str2, boolean z) {
        a aVar = new a(this.bUm.c(this.mContext, str, str2, z));
        this.bUn.put(str, aVar);
        return aVar;
    }

    public a ja(String str) {
        return this.bUn.get(str);
    }

    public com.baidu.h.a.b.c jb(String str) {
        return this.bUn.get(str).XI();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        i(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void iZ(String str) {
        a ja = ja(str);
        if (ja != null) {
            ja.iZ(str);
            this.bUn.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void KR() {
        try {
            for (Map.Entry<String, a> entry : this.bUn.entrySet()) {
                String key = entry.getKey();
                a aVar = this.bUn.get(key);
                if (aVar != null) {
                    if (aVar.XJ()) {
                        aVar.KR();
                    }
                    this.bUn.remove(key);
                }
            }
            this.bUm.unregisterConnectListener();
            this.bUl = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a ja = ja(str);
        if (ja != null) {
            ja.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a ja = ja(str);
        if (ja != null) {
            ja.a(str, dVar);
        }
    }

    private void register() {
        if (!this.bUl) {
            this.bUm.unregisterConnectListener();
            this.bUm.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.bUm.Xx();
                    }
                }
            });
            this.bUl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.bUn.entrySet()) {
                a aVar = this.bUn.get(entry.getKey());
                if (aVar != null) {
                    aVar.Ct();
                }
            }
        } catch (Exception e) {
        }
    }
}
