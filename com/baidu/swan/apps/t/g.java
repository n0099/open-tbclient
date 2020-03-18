package com.baidu.swan.apps.t;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.l;
import com.baidu.swan.apps.x.b.a.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class g extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, a> bxO = new HashMap();
    public final com.baidu.swan.apps.x.b.a.c bxP = new c.a();
    private final com.baidu.swan.apps.x.b.a.c bxQ = new c.a();

    public g a(a... aVarArr) {
        com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<a>() { // from class: com.baidu.swan.apps.t.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(a aVar) {
                aVar.b(g.this);
                g.this.bxO.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public g x(Bundle bundle) {
        this.bxP.B(bundle);
        return this;
    }

    public synchronized g a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.bxQ.Wk();
        final com.baidu.swan.apps.as.b.a Q = new com.baidu.swan.apps.as.b.a().hg(32768).a(30L, TimeUnit.SECONDS).Q(this.bxP.toBundle());
        Q.k(new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.t.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: onCallback */
            public void D(String str) {
                if ("on_progress".equals(str)) {
                    g.this.d((i.a) new i.a("installer_on_progress").d(" event_params_installer_progress", Q.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    g.this.kK("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    g.this.kK("installer_on_finish");
                } else if ("start".equals(str)) {
                    g.this.kK("installer_on_start");
                }
            }
        });
        a(new com.baidu.swan.apps.as.d.b<a>() { // from class: com.baidu.swan.apps.t.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(a aVar) {
                Q.a(aVar);
            }
        });
        log("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        Q.b(readableByteChannel);
        boolean isOk = isOk();
        if (DEBUG) {
            log("allOk: " + isOk + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!isOk) {
            a(new com.baidu.swan.apps.as.d.b<a>() { // from class: com.baidu.swan.apps.t.g.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(a aVar) {
                    aVar.TU();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.bxO.isEmpty() || this.bxQ.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        a(new com.baidu.swan.apps.as.d.b<a>() { // from class: com.baidu.swan.apps.t.g.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.bxQ.w("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void a(com.baidu.swan.apps.as.d.b<a> bVar) {
        com.baidu.swan.apps.as.d.a.a(bVar, this.bxO.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.x.c.a.iL(this.bxP.getString("launch_id", "")).iM(str).iO("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class a implements com.baidu.swan.apps.as.d.b<Pipe.SourceChannel> {
        private g bxU;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(g gVar) {
            this.bxU = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void D(Pipe.SourceChannel sourceChannel) {
            if (this.bxU != null && a(sourceChannel, this.bxU.bxP.toBundle())) {
                TV();
            }
        }

        private void TV() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle TW() {
            return this.mResult;
        }

        public boolean isOk() {
            return TW().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void TU() {
        }

        public String toString() {
            return this.id;
        }
    }
}
