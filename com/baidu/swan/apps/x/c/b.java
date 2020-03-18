package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bzo;
    public com.baidu.swan.apps.as.d.b<b> bzq;
    private final List<String> bzp = new ArrayList();
    private final List<a> bzr = new ArrayList();
    private String bzs = b.class.getPackage().getName();

    public b iN(String str) {
        this.bzo = str;
        return this;
    }

    public String Wq() {
        return this.bzo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Wr() {
        return new ArrayList(this.bzr);
    }

    public synchronized a Wm() {
        a aVar;
        aVar = new a();
        this.bzr.add(aVar);
        return aVar;
    }

    public synchronized a iM(String str) {
        return Wm().iP(str);
    }

    public synchronized a aS(String str, String str2) {
        return iM(str2).iO(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.bzq = bVar;
        return this;
    }

    public synchronized b Ws() {
        return c(this.bzq);
    }

    public synchronized b c(com.baidu.swan.apps.as.d.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0309b();
        }
        bVar.D(this);
        return this;
    }

    /* loaded from: classes11.dex */
    public class a {
        final List<String> bzp;
        private final List<StackTraceElement> bzt;
        final /* synthetic */ b bzu;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.bzu = bVar;
            this.msgs = new ArrayList();
            this.bzp = new ArrayList();
            this.bzt = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.bzs)) {
                    this.bzt.add(stackTraceElement);
                }
            }
        }

        public a iO(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a iP(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a Wt() {
            return fm(this.bzt.size());
        }

        public synchronized a fm(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.bzt.size() ? this.bzt.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.bzu.iM("[Trace]==> " + this.bzt.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Wu() {
            return fm(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0309b implements com.baidu.swan.apps.as.d.b<b> {
        private C0309b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void D(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.bzr) {
                    for (String str : aVar.msgs) {
                        String Wq = bVar.Wq();
                        z(TextUtils.isEmpty(aVar.tag) ? Wq : aVar.tag, Wq + " >>> " + str);
                    }
                }
            }
        }

        private void z(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
