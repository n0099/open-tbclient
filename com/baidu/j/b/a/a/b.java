package com.baidu.j.b.a.a;

import android.content.Context;
import com.baidu.j.a.b.a.e;
import com.baidu.j.a.b.a.f;
import com.baidu.j.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class b implements com.baidu.j.a.b.a.b {
    private d cgl;
    private Context mContext;
    private boolean cgk = false;
    private final Map<String, a> cgm = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.cgl = dVar;
    }

    private a l(String str, String str2, boolean z) {
        a aVar = new a(this.cgl.c(this.mContext, str, str2, z));
        this.cgm.put(str, aVar);
        return aVar;
    }

    public a jx(String str) {
        return this.cgm.get(str);
    }

    public com.baidu.j.a.b.c jy(String str) {
        return this.cgm.get(str).abY();
    }

    @Override // com.baidu.j.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.j.a.b.b bVar, boolean z) {
        register();
        l(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.j.a.b.a.b
    public synchronized void jw(String str) {
        a jx = jx(str);
        if (jx != null) {
            jx.jw(str);
            this.cgm.remove(str);
        }
    }

    @Override // com.baidu.j.a.b.a.b
    public synchronized void Mr() {
        try {
            for (Map.Entry<String, a> entry : this.cgm.entrySet()) {
                String key = entry.getKey();
                a aVar = this.cgm.get(key);
                if (aVar != null) {
                    if (aVar.abZ()) {
                        aVar.Mr();
                    }
                    this.cgm.remove(key);
                }
            }
            this.cgl.unregisterConnectListener();
            this.cgk = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.j.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a jx = jx(str);
        if (jx != null) {
            jx.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.j.a.b.a.b
    public void a(String str, com.baidu.j.a.b.a.d dVar) {
        a jx = jx(str);
        if (jx != null) {
            jx.a(str, dVar);
        }
    }

    private void register() {
        if (!this.cgk) {
            this.cgl.unregisterConnectListener();
            this.cgl.a(new com.baidu.j.a.b.a() { // from class: com.baidu.j.b.a.a.b.1
                @Override // com.baidu.j.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.cgl.abN();
                    }
                }
            });
            this.cgk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.cgm.entrySet()) {
                a aVar = this.cgm.get(entry.getKey());
                if (aVar != null) {
                    aVar.Ds();
                }
            }
        } catch (Exception e) {
        }
    }
}
