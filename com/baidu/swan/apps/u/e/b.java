package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cKO;
    public com.baidu.swan.apps.ap.e.b<b> cKP;
    private final List<a> cKQ = new ArrayList();
    private String cKR = b.class.getPackage().getName();

    public b pa(String str) {
        this.cKO = str;
        return this;
    }

    public String auN() {
        return this.cKO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> auO() {
        return new ArrayList(this.cKQ);
    }

    public synchronized a auK() {
        a aVar;
        aVar = new a();
        this.cKQ.add(aVar);
        return aVar;
    }

    public synchronized a oZ(String str) {
        return auK().pc(str);
    }

    public synchronized a bP(String str, String str2) {
        return oZ(str2).pb(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cKP = bVar;
        return this;
    }

    public synchronized b auP() {
        return r(this.cKP);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0466b();
        }
        bVar.M(this);
        return this;
    }

    /* loaded from: classes10.dex */
    public class a {
        final List<String> cKS;
        private final List<StackTraceElement> cKT;
        final /* synthetic */ b cKU;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cKU = bVar;
            this.msgs = new ArrayList();
            this.cKS = new ArrayList();
            this.cKT = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cKR)) {
                    this.cKT.add(stackTraceElement);
                }
            }
        }

        public a pb(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pc(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a auQ() {
            return iM(this.cKT.size());
        }

        public synchronized a iM(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cKT.size() ? this.cKT.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cKU.oZ("[Trace]==> " + this.cKT.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a auR() {
            return iM(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0466b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0466b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cKQ) {
                    for (String str : aVar.msgs) {
                        String auN = bVar.auN();
                        E(TextUtils.isEmpty(aVar.tag) ? auN : aVar.tag, auN + " >>> " + str);
                    }
                }
            }
        }

        private void E(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
