package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cyJ;
    public com.baidu.swan.apps.ap.e.b<b> cyK;
    private final List<a> cyL = new ArrayList();
    private String cyM = b.class.getPackage().getName();

    public b oo(String str) {
        this.cyJ = str;
        return this;
    }

    public String asb() {
        return this.cyJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> asc() {
        return new ArrayList(this.cyL);
    }

    public synchronized a arY() {
        a aVar;
        aVar = new a();
        this.cyL.add(aVar);
        return aVar;
    }

    public synchronized a om(String str) {
        return arY().oq(str);
    }

    public synchronized a bK(String str, String str2) {
        return om(str2).op(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cyK = bVar;
        return this;
    }

    public synchronized b asd() {
        return r(this.cyK);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0449b();
        }
        bVar.J(this);
        return this;
    }

    /* loaded from: classes3.dex */
    public class a {
        final List<String> cyN;
        private final List<StackTraceElement> cyO;
        final /* synthetic */ b cyP;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cyP = bVar;
            this.msgs = new ArrayList();
            this.cyN = new ArrayList();
            this.cyO = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cyM)) {
                    this.cyO.add(stackTraceElement);
                }
            }
        }

        public a op(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a oq(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a ase() {
            return ip(this.cyO.size());
        }

        public synchronized a ip(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cyO.size() ? this.cyO.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cyP.om("[Trace]==> " + this.cyO.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a asf() {
            return ip(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0449b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0449b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void J(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cyL) {
                    for (String str : aVar.msgs) {
                        String asb = bVar.asb();
                        E(TextUtils.isEmpty(aVar.tag) ? asb : aVar.tag, asb + " >>> " + str);
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
