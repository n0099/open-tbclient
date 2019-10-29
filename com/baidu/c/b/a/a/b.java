package com.baidu.c.b.a.a;

import android.content.Context;
import com.baidu.c.a.b.a.e;
import com.baidu.c.a.b.a.f;
import com.baidu.c.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class b implements com.baidu.c.a.b.a.b {
    private d awt;
    private Context mContext;
    private boolean aws = false;
    private final Map<String, a> awu = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.awt = dVar;
    }

    private a e(String str, String str2, boolean z) {
        if (this.awu.get(str) != null) {
            this.awu.get(str).dm(str);
            this.awu.remove(str);
        }
        a aVar = new a(this.awt.l(this.mContext, str, str2));
        this.awu.put(str, aVar);
        return aVar;
    }

    public a dn(String str) {
        return this.awu.get(str);
    }

    /* renamed from: do  reason: not valid java name */
    public com.baidu.c.a.b.c m14do(String str) {
        return this.awu.get(str).xi();
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.c.a.b.b bVar, boolean z) {
        register();
        e(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void dm(String str) {
        a dn = dn(str);
        if (dn != null) {
            dn.dm(str);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void sy() {
        try {
            for (Map.Entry<String, a> entry : this.awu.entrySet()) {
                String key = entry.getKey();
                a aVar = this.awu.get(key);
                if (aVar != null) {
                    if (aVar.xj()) {
                        aVar.sy();
                    }
                    this.awu.remove(key);
                }
            }
            this.awt.unregisterConnectListener();
            this.aws = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a dn = dn(str);
        if (dn != null) {
            dn.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.c.a.b.a.b
    public void a(String str, com.baidu.c.a.b.a.d dVar) {
        a dn = dn(str);
        if (dn != null) {
            dn.a(str, dVar);
        }
    }

    private void register() {
        if (!this.aws) {
            this.awt.unregisterConnectListener();
            this.awt.a(new com.baidu.c.a.b.a() { // from class: com.baidu.c.b.a.a.b.1
                @Override // com.baidu.c.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.awt.wX();
                    }
                }
            });
            this.aws = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.awu.entrySet()) {
                a aVar = this.awu.get(entry.getKey());
                if (aVar != null) {
                    aVar.tQ();
                }
            }
        } catch (Exception e) {
        }
    }
}
