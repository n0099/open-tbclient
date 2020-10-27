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
/* loaded from: classes10.dex */
public class f extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, a> cRw = new HashMap();
    public final com.baidu.swan.apps.u.c.a.c cRx = new c.a();
    private final com.baidu.swan.apps.u.c.a.c cRy = new c.a();

    public f a(a... aVarArr) {
        com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(a aVar) {
                aVar.b(f.this);
                f.this.cRw.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public f A(Bundle bundle) {
        this.cRx.D(bundle);
        return this;
    }

    public synchronized f a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.cRy.awC();
        final com.baidu.swan.apps.ap.b.a W = new com.baidu.swan.apps.ap.b.a().li(32768).a(30L, TimeUnit.SECONDS).W(this.cRx.toBundle());
        W.D(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.r.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: onCallback */
            public void M(String str) {
                if ("on_progress".equals(str)) {
                    f.this.i((i.a) new i.a("installer_on_progress").e(" event_params_installer_progress", W.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    f.this.rF("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    f.this.rF("installer_on_finish");
                } else if ("start".equals(str)) {
                    f.this.rF("installer_on_start");
                }
            }
        });
        p(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(a aVar) {
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
                public void M(a aVar) {
                    aVar.atV();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.cRw.isEmpty() || this.cRy.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        p(new com.baidu.swan.apps.ap.e.b<a>() { // from class: com.baidu.swan.apps.r.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.cRy.Z("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void p(com.baidu.swan.apps.ap.e.b<a> bVar) {
        com.baidu.swan.apps.ap.e.a.a(bVar, this.cRw.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pr(this.cRx.getString("launch_id", "")).ps(str).pu("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class a implements com.baidu.swan.apps.ap.e.b<Pipe.SourceChannel> {
        private f cRC;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f fVar) {
            this.cRC = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(Pipe.SourceChannel sourceChannel) {
            if (this.cRC != null && a(sourceChannel, this.cRC.cRx.toBundle())) {
                atW();
            }
        }

        private void atW() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle atX() {
            return this.mResult;
        }

        public boolean isOk() {
            return atX().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void atV() {
        }

        public String toString() {
            return this.id;
        }
    }
}
