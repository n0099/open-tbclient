package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cmP;
    public com.baidu.swan.apps.aq.e.b<b> cmR;
    private final List<String> cmQ = new ArrayList();
    private final List<a> cmS = new ArrayList();
    private String cmT = b.class.getPackage().getName();

    public b lu(String str) {
        this.cmP = str;
        return this;
    }

    public String aiu() {
        return this.cmP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> aiv() {
        return new ArrayList(this.cmS);
    }

    public synchronized a aiq() {
        a aVar;
        aVar = new a();
        this.cmS.add(aVar);
        return aVar;
    }

    public synchronized a lt(String str) {
        return aiq().lw(str);
    }

    public synchronized a bv(String str, String str2) {
        return lt(str2).lv(str);
    }

    public b i(com.baidu.swan.apps.aq.e.b<b> bVar) {
        this.cmR = bVar;
        return this;
    }

    public synchronized b aiw() {
        return j(this.cmR);
    }

    public synchronized b j(com.baidu.swan.apps.aq.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0402b();
        }
        bVar.H(this);
        return this;
    }

    /* loaded from: classes11.dex */
    public class a {
        final List<String> cmQ;
        private final List<StackTraceElement> cmU;
        final /* synthetic */ b cmV;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cmV = bVar;
            this.msgs = new ArrayList();
            this.cmQ = new ArrayList();
            this.cmU = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cmT)) {
                    this.cmU.add(stackTraceElement);
                }
            }
        }

        public a lv(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a lw(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aix() {
            return fR(this.cmU.size());
        }

        public synchronized a fR(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cmU.size() ? this.cmU.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cmV.lt("[Trace]==> " + this.cmU.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a aiy() {
            return fR(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0402b implements com.baidu.swan.apps.aq.e.b<b> {
        private C0402b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cmS) {
                    for (String str : aVar.msgs) {
                        String aiu = bVar.aiu();
                        D(TextUtils.isEmpty(aVar.tag) ? aiu : aVar.tag, aiu + " >>> " + str);
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
