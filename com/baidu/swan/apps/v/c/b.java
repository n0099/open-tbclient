package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aza;
    public com.baidu.swan.apps.an.d.a<b> azc;
    private final List<String> azb = new ArrayList();
    private final List<a> azd = new ArrayList();
    private String aze = b.class.getPackage().getName();

    public b eT(String str) {
        this.aza = str;
        return this;
    }

    public String Fs() {
        return this.aza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Ft() {
        return new ArrayList(this.azd);
    }

    public synchronized a Fo() {
        a aVar;
        aVar = new a();
        this.azd.add(aVar);
        return aVar;
    }

    public synchronized a eS(String str) {
        return Fo().eW(str);
    }

    public synchronized a ak(String str, String str2) {
        return eS(str2).eU(str);
    }

    public b c(com.baidu.swan.apps.an.d.a<b> aVar) {
        this.azc = aVar;
        return this;
    }

    public synchronized b Fu() {
        return d(this.azc);
    }

    public synchronized b d(com.baidu.swan.apps.an.d.a<b> aVar) {
        if (aVar == null) {
            aVar = new C0186b();
        }
        aVar.D(this);
        return this;
    }

    /* loaded from: classes2.dex */
    public class a {
        final List<String> azb;
        private final List<StackTraceElement> azf;
        final /* synthetic */ b azg;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.azg = bVar;
            this.msgs = new ArrayList();
            this.azb = new ArrayList();
            this.azf = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.aze)) {
                    this.azf.add(stackTraceElement);
                }
            }
        }

        public a eU(String str) {
            this.tag = str;
            return this;
        }

        public a eV(String str) {
            this.azb.add(str);
            return this;
        }

        public synchronized a eW(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a cG(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.azf.size() ? this.azf.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.azg.eS("[Trace]==> " + this.azf.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Fw() {
            return cG(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0186b implements com.baidu.swan.apps.an.d.a<b> {
        private C0186b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.azd) {
                    for (String str : aVar.msgs) {
                        String Fs = bVar.Fs();
                        am(TextUtils.isEmpty(aVar.tag) ? Fs : aVar.tag, Fs + " >>> " + str);
                    }
                }
            }
        }

        private void am(String str, String str2) {
            Log.i(str, str2);
        }
    }
}
