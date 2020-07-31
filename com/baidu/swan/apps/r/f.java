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
/* loaded from: classes7.dex */
public class f extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, a> cnn = new HashMap();
    public final com.baidu.swan.apps.u.c.a.c cno = new c.a();
    private final com.baidu.swan.apps.u.c.a.c cnp = new c.a();

    public f a(a... aVarArr) {
        com.baidu.swan.apps.aq.e.a.a(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                aVar.b(f.this);
                f.this.cnn.put(aVar.id, aVar);
            }
        }, aVarArr);
        return this;
    }

    public f C(Bundle bundle) {
        this.cno.F(bundle);
        return this;
    }

    public synchronized f a(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.cnp.ajF();
        final com.baidu.swan.apps.aq.b.a Y = new com.baidu.swan.apps.aq.b.a().ih(32768).a(30L, TimeUnit.SECONDS).Y(this.cno.toBundle());
        Y.w(new com.baidu.swan.apps.aq.e.b<String>() { // from class: com.baidu.swan.apps.r.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: onCallback */
            public void H(String str) {
                if ("on_progress".equals(str)) {
                    f.this.i((i.a) new i.a("installer_on_progress").d(" event_params_installer_progress", Y.getProgress()));
                } else if ("pump_finish".equals(str)) {
                    f.this.oi("installer_on_pump_finish");
                } else if ("finish".equals(str)) {
                    f.this.oi("installer_on_finish");
                } else if ("start".equals(str)) {
                    f.this.oi("installer_on_start");
                }
            }
        });
        i(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                Y.a(aVar);
            }
        });
        log("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        Y.b(readableByteChannel);
        boolean isOk = isOk();
        if (DEBUG) {
            log("allOk: " + isOk + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!isOk) {
            i(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.f.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(a aVar) {
                    aVar.ahe();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.cnn.isEmpty() || this.cnp.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        i(new com.baidu.swan.apps.aq.e.b<a>() { // from class: com.baidu.swan.apps.r.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.cnp.O("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void i(com.baidu.swan.apps.aq.e.b<a> bVar) {
        com.baidu.swan.apps.aq.e.a.a(bVar, this.cnn.values());
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.u.d.a.lT(this.cno.getString("launch_id", "")).lU(str).lW("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a implements com.baidu.swan.apps.aq.e.b<Pipe.SourceChannel> {
        private f cnu;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(f fVar) {
            this.cnu = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(Pipe.SourceChannel sourceChannel) {
            if (this.cnu != null && a(sourceChannel, this.cnu.cno.toBundle())) {
                ahf();
            }
        }

        private void ahf() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle ahg() {
            return this.mResult;
        }

        public boolean isOk() {
            return ahg().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void ahe() {
        }

        public String toString() {
            return this.id;
        }
    }
}
