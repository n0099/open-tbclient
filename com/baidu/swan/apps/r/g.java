package com.baidu.swan.apps.r;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.v.b.a.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class g extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, a> cgv = new HashMap();
    public final com.baidu.swan.apps.v.b.a.c cgw = new c.a();
    private final com.baidu.swan.apps.v.b.a.c cgx = new c.a();

    public g a(a... aVarArr) {
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                aVar.b(g.this);
                g.this.cgv.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public g B(Bundle bundle) {
        this.cgw.E(bundle);
        return this;
    }

    public synchronized g a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.cgx.ahi();
        final com.baidu.swan.apps.aq.b.a X = new com.baidu.swan.apps.aq.b.a().hL(32768).a(30L, TimeUnit.SECONDS).X(this.cgw.toBundle());
        X.t(new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.apps.r.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: onCallback */
            public void H(String str) {
                if ("on_progress".equals(str)) {
                    g.this.i((i.a) new i.a("installer_on_progress").d(" event_params_installer_progress", X.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    g.this.ns("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    g.this.ns("installer_on_finish");
                } else if ("start".equals(str)) {
                    g.this.ns("installer_on_start");
                }
            }
        });
        h(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                X.a(aVar);
            }
        });
        log("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        X.b(readableByteChannel);
        boolean isOk = isOk();
        if (DEBUG) {
            log("allOk: " + isOk + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!isOk) {
            h(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.g.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(a aVar) {
                    aVar.aeM();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.cgv.isEmpty() || this.cgx.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        h(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.g.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.cgx.N("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void h(com.baidu.swan.apps.aq.e.b<a> bVar) {
        com.baidu.swan.apps.aq.e.a.a(bVar, this.cgv.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.v.c.a.lk(this.cgw.getString("launch_id", "")).ll(str).ln("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class a implements com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> {
        private g cgB;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(g gVar) {
            this.cgB = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(Pipe.SourceChannel sourceChannel) {
            if (this.cgB != null && a(sourceChannel, this.cgB.cgw.toBundle())) {
                aeN();
            }
        }

        private void aeN() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle aeO() {
            return this.mResult;
        }

        public boolean isOk() {
            return aeO().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void aeM() {
        }

        public String toString() {
            return this.id;
        }
    }
}
