package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dik;
    public com.baidu.swan.apps.ao.e.b<b> dil;
    private final List<a> dim = new ArrayList();
    private String din = b.class.getPackage().getName();

    public b pp(String str) {
        this.dik = str;
        return this;
    }

    public String azH() {
        return this.dik;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> azI() {
        return new ArrayList(this.dim);
    }

    public synchronized a azE() {
        a aVar;
        aVar = new a();
        this.dim.add(aVar);
        return aVar;
    }

    public synchronized a po(String str) {
        return azE().pr(str);
    }

    public synchronized a bU(String str, String str2) {
        return po(str2).pq(str);
    }

    public b q(com.baidu.swan.apps.ao.e.b<b> bVar) {
        this.dil = bVar;
        return this;
    }

    public synchronized b azJ() {
        return r(this.dil);
    }

    public synchronized b r(com.baidu.swan.apps.ao.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0481b();
        }
        bVar.N(this);
        return this;
    }

    /* loaded from: classes8.dex */
    public class a {
        final List<String> dio;
        private final List<StackTraceElement> dip;
        final List<String> msgs;
        String tag;

        private a() {
            this.msgs = new ArrayList();
            this.dio = new ArrayList();
            this.dip = new ArrayList();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                int i3 = i2 + 1;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(b.this.din)) {
                    this.dip.add(stackTraceElement);
                }
                i++;
                i2 = i3;
            }
        }

        public a pq(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pr(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a azK() {
            return hU(this.dip.size());
        }

        public synchronized a hU(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.dip.size() ? this.dip.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    b.this.po("[Trace]==> " + this.dip.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a azL() {
            return hU(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0481b implements com.baidu.swan.apps.ao.e.b<b> {
        private C0481b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void N(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.dim) {
                    for (String str : aVar.msgs) {
                        String azH = bVar.azH();
                        B(TextUtils.isEmpty(aVar.tag) ? azH : aVar.tag, azH + " >>> " + str);
                    }
                }
            }
        }

        private void B(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
