package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bXA;
    public com.baidu.swan.apps.as.d.b<b> bXC;
    private final List<String> bXB = new ArrayList();
    private final List<a> bXD = new ArrayList();
    private String bXE = b.class.getPackage().getName();

    public b ka(String str) {
        this.bXA = str;
        return this;
    }

    public String aee() {
        return this.bXA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> aef() {
        return new ArrayList(this.bXD);
    }

    public synchronized a aea() {
        a aVar;
        aVar = new a();
        this.bXD.add(aVar);
        return aVar;
    }

    public synchronized a jZ(String str) {
        return aea().kc(str);
    }

    public synchronized a bc(String str, String str2) {
        return jZ(str2).kb(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.bXC = bVar;
        return this;
    }

    public synchronized b aeg() {
        return c(this.bXC);
    }

    public synchronized b c(com.baidu.swan.apps.as.d.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0360b();
        }
        bVar.F(this);
        return this;
    }

    /* loaded from: classes11.dex */
    public class a {
        final List<String> bXB;
        private final List<StackTraceElement> bXF;
        final /* synthetic */ b bXG;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.bXG = bVar;
            this.msgs = new ArrayList();
            this.bXB = new ArrayList();
            this.bXF = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.bXE)) {
                    this.bXF.add(stackTraceElement);
                }
            }
        }

        public a kb(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a kc(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aeh() {
            return fr(this.bXF.size());
        }

        public synchronized a fr(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.bXF.size() ? this.bXF.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.bXG.jZ("[Trace]==> " + this.bXF.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a aei() {
            return fr(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0360b implements com.baidu.swan.apps.as.d.b<b> {
        private C0360b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void F(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.bXD) {
                    for (String str : aVar.msgs) {
                        String aee = bVar.aee();
                        D(TextUtils.isEmpty(aVar.tag) ? aee : aVar.tag, aee + " >>> " + str);
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
