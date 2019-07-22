package com.baidu.swan.apps.install;

import android.os.Bundle;
import android.util.Log;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.an.d.a<String> ayu;
    private final Map<String, a> ays = new HashMap();
    public final Bundle ayt = new Bundle();
    private final Bundle mResult = new Bundle();

    public g a(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.ayu = aVar;
        return this;
    }

    public g a(a... aVarArr) {
        a(aVarArr, new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(a aVar) {
                aVar.b(g.this);
                g.this.ays.put(aVar.id, aVar);
            }
        });
        return this;
    }

    public synchronized g b(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mResult.clear();
        final com.baidu.swan.apps.an.b.a a2 = new com.baidu.swan.apps.an.b.a().eD(com.baidu.swan.apps.core.pms.a.Bg()).j(this.ayu).a(30L, TimeUnit.SECONDS);
        b(new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(a aVar) {
                a2.a(aVar);
            }
        });
        log("connect: " + readableByteChannel + " at: " + currentTimeMillis);
        a2.c(readableByteChannel);
        boolean isOk = isOk();
        if (DEBUG) {
            log("allOk: " + isOk + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!isOk) {
            b(new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void D(a aVar) {
                    aVar.Ef();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.ays.isEmpty() || this.mResult.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        b(new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.mResult.putBoolean("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void b(com.baidu.swan.apps.an.d.a<a> aVar) {
        a(this.ays.values(), aVar);
    }

    private static <E> void a(Collection<E> collection, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : collection) {
            aVar.D(e);
        }
    }

    private static <E> void a(E[] eArr, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : eArr) {
            aVar.D(e);
        }
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.v.c.a.eW(this.ayt.getString("launch_id", "")).eX(str).eZ("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a implements com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> {
        private g ayy;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(g gVar) {
            this.ayy = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(Pipe.SourceChannel sourceChannel) {
            if (this.ayy != null && a(sourceChannel, this.ayy.ayt)) {
                Eg();
            }
        }

        private void Eg() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle Eh() {
            return this.mResult;
        }

        public boolean isOk() {
            return Eh().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void Ef() {
        }

        public String toString() {
            return this.id;
        }
    }
}
