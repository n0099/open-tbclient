package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aTb;
    public com.baidu.swan.apps.an.d.a<b> aTd;
    private final List<String> aTc = new ArrayList();
    private final List<a> aTe = new ArrayList();
    private String aTf = b.class.getPackage().getName();

    public b fH(String str) {
        this.aTb = str;
        return this;
    }

    public String Lb() {
        return this.aTb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Lc() {
        return new ArrayList(this.aTe);
    }

    public synchronized a KX() {
        a aVar;
        aVar = new a();
        this.aTe.add(aVar);
        return aVar;
    }

    public synchronized a fG(String str) {
        return KX().fK(str);
    }

    public synchronized a as(String str, String str2) {
        return fG(str2).fI(str);
    }

    public b c(com.baidu.swan.apps.an.d.a<b> aVar) {
        this.aTd = aVar;
        return this;
    }

    public synchronized b Ld() {
        return d(this.aTd);
    }

    public synchronized b d(com.baidu.swan.apps.an.d.a<b> aVar) {
        if (aVar == null) {
            aVar = new C0224b();
        }
        aVar.B(this);
        return this;
    }

    /* loaded from: classes2.dex */
    public class a {
        final List<String> aTc;
        private final List<StackTraceElement> aTg;
        final /* synthetic */ b aTh;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.aTh = bVar;
            this.msgs = new ArrayList();
            this.aTc = new ArrayList();
            this.aTg = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.aTf)) {
                    this.aTg.add(stackTraceElement);
                }
            }
        }

        public a fI(String str) {
            this.tag = str;
            return this;
        }

        public a fJ(String str) {
            this.aTc.add(str);
            return this;
        }

        public synchronized a fK(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a dD(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.aTg.size() ? this.aTg.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.aTh.fG("[Trace]==> " + this.aTg.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Lf() {
            return dD(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0224b implements com.baidu.swan.apps.an.d.a<b> {
        private C0224b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void B(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.aTe) {
                    for (String str : aVar.msgs) {
                        String Lb = bVar.Lb();
                        au(TextUtils.isEmpty(aVar.tag) ? Lb : aVar.tag, Lb + " >>> " + str);
                    }
                }
            }
        }

        private void au(String str, String str2) {
            Log.i(str, str2);
        }
    }
}
