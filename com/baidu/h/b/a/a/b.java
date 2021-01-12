package com.baidu.h.b.a.a;

import android.content.Context;
import com.baidu.h.a.b.a.e;
import com.baidu.h.a.b.a.f;
import com.baidu.h.a.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b implements com.baidu.h.a.b.a.b {
    private d cbw;
    private Context mContext;
    private boolean cbv = false;
    private final Map<String, a> cbx = new ConcurrentHashMap();

    public b(Context context, d dVar) {
        this.mContext = context;
        this.cbw = dVar;
    }

    private a l(String str, String str2, boolean z) {
        a aVar = new a(this.cbw.c(this.mContext, str, str2, z));
        this.cbx.put(str, aVar);
        return aVar;
    }

    public a im(String str) {
        return this.cbx.get(str);
    }

    public com.baidu.h.a.b.c in(String str) {
        return this.cbx.get(str).Yg();
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, String str2, int i, com.baidu.h.a.b.b bVar, boolean z) {
        register();
        l(str, str2, z).a(str, str2, i, bVar, z);
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void il(String str) {
        a im = im(str);
        if (im != null) {
            im.il(str);
            this.cbx.remove(str);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void Iw() {
        try {
            for (Map.Entry<String, a> entry : this.cbx.entrySet()) {
                String key = entry.getKey();
                a aVar = this.cbx.get(key);
                if (aVar != null) {
                    if (aVar.Yh()) {
                        aVar.Iw();
                    }
                    this.cbx.remove(key);
                }
            }
            this.cbw.unregisterConnectListener();
            this.cbv = false;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public synchronized void a(String str, e eVar, f fVar) {
        a im = im(str);
        if (im != null) {
            im.a(str, eVar, fVar);
        }
    }

    @Override // com.baidu.h.a.b.a.b
    public void a(String str, com.baidu.h.a.b.a.d dVar) {
        a im = im(str);
        if (im != null) {
            im.a(str, dVar);
        }
    }

    private void register() {
        if (!this.cbv) {
            this.cbw.unregisterConnectListener();
            this.cbw.a(new com.baidu.h.a.b.a() { // from class: com.baidu.h.b.a.a.b.1
                @Override // com.baidu.h.a.b.a
                public void onResult(int i) {
                    if (i == 0) {
                        b.this.reconnect();
                    } else if (1 == i) {
                        b.this.cbw.XV();
                    }
                }
            });
            this.cbv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        try {
            for (Map.Entry<String, a> entry : this.cbx.entrySet()) {
                a aVar = this.cbx.get(entry.getKey());
                if (aVar != null) {
                    aVar.zx();
                }
            }
        } catch (Exception e) {
        }
    }
}
