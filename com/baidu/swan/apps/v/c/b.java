package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aAf;
    public com.baidu.swan.apps.an.d.a<b> aAh;
    private final List<String> aAg = new ArrayList();
    private final List<a> aAi = new ArrayList();
    private String aAj = b.class.getPackage().getName();

    public b fa(String str) {
        this.aAf = str;
        return this;
    }

    public String Gg() {
        return this.aAf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Gh() {
        return new ArrayList(this.aAi);
    }

    public synchronized a Gc() {
        a aVar;
        aVar = new a();
        this.aAi.add(aVar);
        return aVar;
    }

    public synchronized a eZ(String str) {
        return Gc().fd(str);
    }

    public synchronized a ak(String str, String str2) {
        return eZ(str2).fb(str);
    }

    public b c(com.baidu.swan.apps.an.d.a<b> aVar) {
        this.aAh = aVar;
        return this;
    }

    public synchronized b Gi() {
        return d(this.aAh);
    }

    public synchronized b d(com.baidu.swan.apps.an.d.a<b> aVar) {
        if (aVar == null) {
            aVar = new C0197b();
        }
        aVar.D(this);
        return this;
    }

    /* loaded from: classes2.dex */
    public class a {
        final List<String> aAg;
        private final List<StackTraceElement> aAk;
        final /* synthetic */ b aAl;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.aAl = bVar;
            this.msgs = new ArrayList();
            this.aAg = new ArrayList();
            this.aAk = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.aAj)) {
                    this.aAk.add(stackTraceElement);
                }
            }
        }

        public a fb(String str) {
            this.tag = str;
            return this;
        }

        public a fc(String str) {
            this.aAg.add(str);
            return this;
        }

        public synchronized a fd(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a cI(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.aAk.size() ? this.aAk.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.aAl.eZ("[Trace]==> " + this.aAk.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Gk() {
            return cI(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0197b implements com.baidu.swan.apps.an.d.a<b> {
        private C0197b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.aAi) {
                    for (String str : aVar.msgs) {
                        String Gg = bVar.Gg();
                        am(TextUtils.isEmpty(aVar.tag) ? Gg : aVar.tag, Gg + " >>> " + str);
                    }
                }
            }
        }

        private void am(String str, String str2) {
            Log.i(str, str2);
        }
    }
}
