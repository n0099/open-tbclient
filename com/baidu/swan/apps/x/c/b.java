package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bXu;
    public com.baidu.swan.apps.as.d.b<b> bXw;
    private final List<String> bXv = new ArrayList();
    private final List<a> bXx = new ArrayList();
    private String bXy = b.class.getPackage().getName();

    public b ka(String str) {
        this.bXu = str;
        return this;
    }

    public String aef() {
        return this.bXu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> aeg() {
        return new ArrayList(this.bXx);
    }

    public synchronized a aeb() {
        a aVar;
        aVar = new a();
        this.bXx.add(aVar);
        return aVar;
    }

    public synchronized a jZ(String str) {
        return aeb().kc(str);
    }

    public synchronized a bc(String str, String str2) {
        return jZ(str2).kb(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.bXw = bVar;
        return this;
    }

    public synchronized b aeh() {
        return c(this.bXw);
    }

    public synchronized b c(com.baidu.swan.apps.as.d.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0339b();
        }
        bVar.E(this);
        return this;
    }

    /* loaded from: classes11.dex */
    public class a {
        final /* synthetic */ b bXA;
        final List<String> bXv;
        private final List<StackTraceElement> bXz;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.bXA = bVar;
            this.msgs = new ArrayList();
            this.bXv = new ArrayList();
            this.bXz = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.bXy)) {
                    this.bXz.add(stackTraceElement);
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

        public synchronized a aei() {
            return fr(this.bXz.size());
        }

        public synchronized a fr(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.bXz.size() ? this.bXz.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.bXA.jZ("[Trace]==> " + this.bXz.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a aej() {
            return fr(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0339b implements com.baidu.swan.apps.as.d.b<b> {
        private C0339b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void E(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.bXx) {
                    for (String str : aVar.msgs) {
                        String aef = bVar.aef();
                        D(TextUtils.isEmpty(aVar.tag) ? aef : aVar.tag, aef + " >>> " + str);
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
