package com.baidu.swan.apps.r;

import android.os.Bundle;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.u.c.a.c;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, a> dgv = new HashMap();
    public final com.baidu.swan.apps.u.c.a.c dgw = new c.a();
    private final com.baidu.swan.apps.u.c.a.c dgx = new c.a();

    public f a(a... aVarArr) {
        com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<a>() { // from class: com.baidu.swan.apps.r.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(a aVar) {
                aVar.b(f.this);
                f.this.dgv.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public f A(Bundle bundle) {
        this.dgw.D(bundle);
        return this;
    }

    public synchronized f a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.dgx.azC();
        final com.baidu.swan.apps.ao.b.a W = new com.baidu.swan.apps.ao.b.a().kp(32768).a(30L, TimeUnit.SECONDS).W(this.dgw.toBundle());
        W.D(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.r.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: onCallback */
            public void N(String str) {
                if ("on_progress".equals(str)) {
                    f.this.i((i.a) new i.a("installer_on_progress").e(" event_params_installer_progress", W.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    f.this.rG("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    f.this.rG("installer_on_finish");
                } else if ("start".equals(str)) {
                    f.this.rG("installer_on_start");
                }
            }
        });
        p(new com.baidu.swan.apps.ao.e.b<a>() { // from class: com.baidu.swan.apps.r.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(a aVar) {
                W.a(aVar);
            }
        });
        log("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        W.b(readableByteChannel);
        boolean isOk = isOk();
        if (DEBUG) {
            log("allOk: " + isOk + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!isOk) {
            p(new com.baidu.swan.apps.ao.e.b<a>() { // from class: com.baidu.swan.apps.r.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(a aVar) {
                    aVar.awU();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.dgv.isEmpty() || this.dgx.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        p(new com.baidu.swan.apps.ao.e.b<a>() { // from class: com.baidu.swan.apps.r.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.dgx.Z("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void p(com.baidu.swan.apps.ao.e.b<a> bVar) {
        com.baidu.swan.apps.ao.e.a.a(bVar, this.dgv.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pn(this.dgw.getString("launch_id", "")).po(str).pq("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class a implements com.baidu.swan.apps.ao.e.b<Pipe.SourceChannel> {
        private f dgB;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f fVar) {
            this.dgB = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(Pipe.SourceChannel sourceChannel) {
            if (this.dgB != null && a(sourceChannel, this.dgB.dgw.toBundle())) {
                awV();
            }
        }

        private void awV() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle awW() {
            return this.mResult;
        }

        public boolean isOk() {
            return awW().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void awU() {
        }

        public String toString() {
            return this.id;
        }
    }
}
