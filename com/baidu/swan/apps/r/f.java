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
    private final Map<String, a> cuU = new HashMap();
    public final com.baidu.swan.apps.u.c.a.c cuV = new c.a();
    private final com.baidu.swan.apps.u.c.a.c cuW = new c.a();

    public f a(a... aVarArr) {
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(a aVar) {
                aVar.b(f.this);
                f.this.cuU.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public f A(Bundle bundle) {
        this.cuV.D(bundle);
        return this;
    }

    public synchronized f a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.cuW.arm();
        final com.baidu.swan.apps.ap.b.a W = new com.baidu.swan.apps.ap.b.a().kp(32768).a(30L, TimeUnit.SECONDS).W(this.cuV.toBundle());
        W.D(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.r.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void I(String str) {
                if ("on_progress".equals(str)) {
                    f.this.i((i.a) new i.a("installer_on_progress").d(" event_params_installer_progress", W.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    f.this.qh("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    f.this.qh("installer_on_finish");
                } else if ("start".equals(str)) {
                    f.this.qh("installer_on_start");
                }
            }
        });
        p(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(a aVar) {
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
            p(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(a aVar) {
                    aVar.aoE();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.cuU.isEmpty() || this.cuW.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        p(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.cuW.T("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void p(com.baidu.swan.apps.ap.e.b<a> bVar) {
        com.baidu.swan.apps.ap.e.a.a(bVar, this.cuU.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.nR(this.cuV.getString("launch_id", "")).nS(str).nU("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class a implements com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> {
        private f cva;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f fVar) {
            this.cva = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(Pipe.SourceChannel sourceChannel) {
            if (this.cva != null && a(sourceChannel, this.cva.cuV.toBundle())) {
                aoF();
            }
        }

        private void aoF() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle aoG() {
            return this.mResult;
        }

        public boolean isOk() {
            return aoG().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void aoE() {
        }

        public String toString() {
            return this.id;
        }
    }
}
