package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aTt;
    public com.baidu.swan.apps.an.d.a<b> aTv;
    private final List<String> aTu = new ArrayList();
    private final List<a> aTw = new ArrayList();
    private String aTx = b.class.getPackage().getName();

    public b fH(String str) {
        this.aTt = str;
        return this;
    }

    public String La() {
        return this.aTt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Lb() {
        return new ArrayList(this.aTw);
    }

    public synchronized a KW() {
        a aVar;
        aVar = new a();
        this.aTw.add(aVar);
        return aVar;
    }

    public synchronized a fG(String str) {
        return KW().fK(str);
    }

    public synchronized a as(String str, String str2) {
        return fG(str2).fI(str);
    }

    public b c(com.baidu.swan.apps.an.d.a<b> aVar) {
        this.aTv = aVar;
        return this;
    }

    public synchronized b Lc() {
        return d(this.aTv);
    }

    public synchronized b d(com.baidu.swan.apps.an.d.a<b> aVar) {
        if (aVar == null) {
            aVar = new C0229b();
        }
        aVar.B(this);
        return this;
    }

    /* loaded from: classes2.dex */
    public class a {
        final List<String> aTu;
        private final List<StackTraceElement> aTy;
        final /* synthetic */ b aTz;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.aTz = bVar;
            this.msgs = new ArrayList();
            this.aTu = new ArrayList();
            this.aTy = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.aTx)) {
                    this.aTy.add(stackTraceElement);
                }
            }
        }

        public a fI(String str) {
            this.tag = str;
            return this;
        }

        public a fJ(String str) {
            this.aTu.add(str);
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
                int size = i2 > this.aTy.size() ? this.aTy.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.aTz.fG("[Trace]==> " + this.aTy.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Le() {
            return dD(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0229b implements com.baidu.swan.apps.an.d.a<b> {
        private C0229b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void B(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.aTw) {
                    for (String str : aVar.msgs) {
                        String La = bVar.La();
                        au(TextUtils.isEmpty(aVar.tag) ? La : aVar.tag, La + " >>> " + str);
                    }
                }
            }
        }

        private void au(String str, String str2) {
            Log.i(str, str2);
        }
    }
}
