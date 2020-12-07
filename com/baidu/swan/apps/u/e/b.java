package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String der;
    public com.baidu.swan.apps.ap.e.b<b> det;
    private final List<a> deu = new ArrayList();
    private String dev = b.class.getPackage().getName();

    public b qi(String str) {
        this.der = str;
        return this;
    }

    public String aBI() {
        return this.der;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> aBJ() {
        return new ArrayList(this.deu);
    }

    public synchronized a aBF() {
        a aVar;
        aVar = new a();
        this.deu.add(aVar);
        return aVar;
    }

    public synchronized a qh(String str) {
        return aBF().qk(str);
    }

    public synchronized a cc(String str, String str2) {
        return qh(str2).qj(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.det = bVar;
        return this;
    }

    public synchronized b aBK() {
        return r(this.det);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0502b();
        }
        bVar.M(this);
        return this;
    }

    /* loaded from: classes25.dex */
    public class a {
        final List<String> dew;
        private final List<StackTraceElement> dex;
        final /* synthetic */ b dey;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.dey = bVar;
            this.msgs = new ArrayList();
            this.dew = new ArrayList();
            this.dex = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.dev)) {
                    this.dex.add(stackTraceElement);
                }
            }
        }

        public a qj(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a qk(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aBL() {
            return jB(this.dex.size());
        }

        public synchronized a jB(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.dex.size() ? this.dex.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.dey.qh("[Trace]==> " + this.dex.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a aBM() {
            return jB(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C0502b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0502b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.deu) {
                    for (String str : aVar.msgs) {
                        String aBI = bVar.aBI();
                        D(TextUtils.isEmpty(aVar.tag) ? aBI : aVar.tag, aBI + " >>> " + str);
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
