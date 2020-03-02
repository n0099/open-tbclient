package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bzc;
    public com.baidu.swan.apps.as.d.b<b> bze;
    private final List<String> bzd = new ArrayList();
    private final List<a> bzf = new ArrayList();
    private String bzg = b.class.getPackage().getName();

    public b iO(String str) {
        this.bzc = str;
        return this;
    }

    public String Wn() {
        return this.bzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Wo() {
        return new ArrayList(this.bzf);
    }

    public synchronized a Wj() {
        a aVar;
        aVar = new a();
        this.bzf.add(aVar);
        return aVar;
    }

    public synchronized a iN(String str) {
        return Wj().iQ(str);
    }

    public synchronized a aT(String str, String str2) {
        return iN(str2).iP(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.bze = bVar;
        return this;
    }

    public synchronized b Wp() {
        return c(this.bze);
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
        final List<String> bzd;
        private final List<StackTraceElement> bzh;
        final /* synthetic */ b bzi;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.bzi = bVar;
            this.msgs = new ArrayList();
            this.bzd = new ArrayList();
            this.bzh = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.bzg)) {
                    this.bzh.add(stackTraceElement);
                }
            }
        }

        public a iP(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a iQ(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a Wq() {
            return fm(this.bzh.size());
        }

        public synchronized a fm(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.bzh.size() ? this.bzh.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.bzi.iN("[Trace]==> " + this.bzh.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Wr() {
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
                for (a aVar : bVar.bzf) {
                    for (String str : aVar.msgs) {
                        String Wn = bVar.Wn();
                        z(TextUtils.isEmpty(aVar.tag) ? Wn : aVar.tag, Wn + " >>> " + str);
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
