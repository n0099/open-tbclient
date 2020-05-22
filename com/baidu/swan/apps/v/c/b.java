package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cia;
    public com.baidu.swan.apps.aq.e.b<b> cic;
    private final List<String> cib = new ArrayList();
    private final List<a> cie = new ArrayList();
    private String cif = b.class.getPackage().getName();

    public b lm(String str) {
        this.cia = str;
        return this;
    }

    public String aho() {
        return this.cia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> ahp() {
        return new ArrayList(this.cie);
    }

    public synchronized a ahk() {
        a aVar;
        aVar = new a();
        this.cie.add(aVar);
        return aVar;
    }

    public synchronized a ll(String str) {
        return ahk().lo(str);
    }

    public synchronized a bt(String str, String str2) {
        return ll(str2).ln(str);
    }

    public b i(com.baidu.swan.apps.aq.e.b<b> bVar) {
        this.cic = bVar;
        return this;
    }

    public synchronized b ahq() {
        return j(this.cic);
    }

    public synchronized b j(com.baidu.swan.apps.aq.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0396b();
        }
        bVar.H(this);
        return this;
    }

    /* loaded from: classes11.dex */
    public class a {
        final List<String> cib;
        private final List<StackTraceElement> cig;
        final /* synthetic */ b cih;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cih = bVar;
            this.msgs = new ArrayList();
            this.cib = new ArrayList();
            this.cig = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cif)) {
                    this.cig.add(stackTraceElement);
                }
            }
        }

        public a ln(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a lo(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a ahr() {
            return fE(this.cig.size());
        }

        public synchronized a fE(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cig.size() ? this.cig.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cih.ll("[Trace]==> " + this.cig.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a ahs() {
            return fE(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0396b implements com.baidu.swan.apps.aq.e.b<b> {
        private C0396b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cie) {
                    for (String str : aVar.msgs) {
                        String aho = bVar.aho();
                        D(TextUtils.isEmpty(aVar.tag) ? aho : aVar.tag, aho + " >>> " + str);
                    }
                }
            }
        }

        private void D(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
