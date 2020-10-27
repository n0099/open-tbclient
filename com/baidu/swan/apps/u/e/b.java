package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cTk;
    public com.baidu.swan.apps.ap.e.b<b> cTl;
    private final List<a> cTm = new ArrayList();
    private String cTn = b.class.getPackage().getName();

    public b pt(String str) {
        this.cTk = str;
        return this;
    }

    public String awH() {
        return this.cTk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> awI() {
        return new ArrayList(this.cTm);
    }

    public synchronized a awE() {
        a aVar;
        aVar = new a();
        this.cTm.add(aVar);
        return aVar;
    }

    public synchronized a ps(String str) {
        return awE().pv(str);
    }

    public synchronized a bW(String str, String str2) {
        return ps(str2).pu(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cTl = bVar;
        return this;
    }

    public synchronized b awJ() {
        return r(this.cTl);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0480b();
        }
        bVar.M(this);
        return this;
    }

    /* loaded from: classes10.dex */
    public class a {
        final List<String> cTo;
        private final List<StackTraceElement> cTp;
        final /* synthetic */ b cTq;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cTq = bVar;
            this.msgs = new ArrayList();
            this.cTo = new ArrayList();
            this.cTp = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cTn)) {
                    this.cTp.add(stackTraceElement);
                }
            }
        }

        public a pu(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pv(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a awK() {
            return iX(this.cTp.size());
        }

        public synchronized a iX(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cTp.size() ? this.cTp.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cTq.ps("[Trace]==> " + this.cTp.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a awL() {
            return iX(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0480b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0480b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cTm) {
                    for (String str : aVar.msgs) {
                        String awH = bVar.awH();
                        E(TextUtils.isEmpty(aVar.tag) ? awH : aVar.tag, awH + " >>> " + str);
                    }
                }
            }
        }

        private void E(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
