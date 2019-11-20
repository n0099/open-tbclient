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
    private com.baidu.swan.apps.an.d.a<String> aRQ;
    private final Map<String, a> aRO = new HashMap();
    public final Bundle aRP = new Bundle();
    private final Bundle mResult = new Bundle();

    public g a(com.baidu.swan.apps.an.d.a<String> aVar) {
        this.aRQ = aVar;
        return this;
    }

    public g a(a... aVarArr) {
        a(aVarArr, new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(a aVar) {
                aVar.b(g.this);
                g.this.aRO.put(aVar.id, aVar);
            }
        });
        return this;
    }

    public synchronized g b(ReadableByteChannel readableByteChannel) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mResult.clear();
        final com.baidu.swan.apps.an.b.a a2 = new com.baidu.swan.apps.an.b.a().fy(com.baidu.swan.apps.core.pms.a.Gg()).j(this.aRQ).a(30L, TimeUnit.SECONDS);
        b(new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(a aVar) {
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
                public void B(a aVar) {
                    aVar.Je();
                }
            });
        }
        return this;
    }

    public boolean isOk() {
        if (this.aRO.isEmpty() || this.mResult.getBoolean("flag_is_ok", false)) {
            return true;
        }
        final boolean[] zArr = {true};
        b(new com.baidu.swan.apps.an.d.a<a>() { // from class: com.baidu.swan.apps.install.g.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(a aVar) {
                boolean[] zArr2 = zArr;
                zArr2[0] = zArr2[0] & aVar.isOk();
            }
        });
        this.mResult.putBoolean("flag_is_ok", zArr[0]);
        return zArr[0];
    }

    private void b(com.baidu.swan.apps.an.d.a<a> aVar) {
        a(this.aRO.values(), aVar);
    }

    private static <E> void a(Collection<E> collection, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : collection) {
            aVar.B(e);
        }
    }

    private static <E> void a(E[] eArr, com.baidu.swan.apps.an.d.a<E> aVar) {
        for (E e : eArr) {
            aVar.B(e);
        }
    }

    private void log(String str) {
        if (DEBUG) {
            com.baidu.swan.apps.v.c.a.fF(this.aRP.getString("launch_id", "")).fG(str).fI("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a implements com.baidu.swan.apps.an.d.a<Pipe.SourceChannel> {
        private g aRU;
        final String id;
        private final Bundle mResult = new Bundle();

        protected abstract boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public a(String str) {
            this.id = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(g gVar) {
            this.aRU = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void B(Pipe.SourceChannel sourceChannel) {
            if (this.aRU != null && a(sourceChannel, this.aRU.aRP)) {
                Jf();
            }
        }

        private void Jf() {
            this.mResult.putBoolean("flag_is_ok", true);
        }

        public Bundle Jg() {
            return this.mResult;
        }

        public boolean isOk() {
            return Jg().getBoolean("flag_is_ok");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void Je() {
        }

        public String toString() {
            return this.id;
        }
    }
}
