package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dgI;
    public com.baidu.swan.apps.ao.e.b<b> dgJ;
    private final List<a> dgK = new ArrayList();
    private String dgL = b.class.getPackage().getName();

    public b pi(String str) {
        this.dgI = str;
        return this;
    }

    public String azE() {
        return this.dgI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> azF() {
        return new ArrayList(this.dgK);
    }

    public synchronized a azB() {
        a aVar;
        aVar = new a();
        this.dgK.add(aVar);
        return aVar;
    }

    public synchronized a ph(String str) {
        return azB().pk(str);
    }

    public synchronized a bU(String str, String str2) {
        return ph(str2).pj(str);
    }

    public b q(com.baidu.swan.apps.ao.e.b<b> bVar) {
        this.dgJ = bVar;
        return this;
    }

    public synchronized b azG() {
        return r(this.dgJ);
    }

    public synchronized b r(com.baidu.swan.apps.ao.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0475b();
        }
        bVar.L(this);
        return this;
    }

    /* loaded from: classes9.dex */
    public class a {
        final List<String> dgM;
        private final List<StackTraceElement> dgN;
        final List<String> msgs;
        String tag;

        private a() {
            this.msgs = new ArrayList();
            this.dgM = new ArrayList();
            this.dgN = new ArrayList();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                int i3 = i2 + 1;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(b.this.dgL)) {
                    this.dgN.add(stackTraceElement);
                }
                i++;
                i2 = i3;
            }
        }

        public a pj(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pk(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a azH() {
            return hT(this.dgN.size());
        }

        public synchronized a hT(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.dgN.size() ? this.dgN.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    b.this.ph("[Trace]==> " + this.dgN.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a azI() {
            return hT(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0475b implements com.baidu.swan.apps.ao.e.b<b> {
        private C0475b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.dgK) {
                    for (String str : aVar.msgs) {
                        String azE = bVar.azE();
                        B(TextUtils.isEmpty(aVar.tag) ? azE : aVar.tag, azE + " >>> " + str);
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
