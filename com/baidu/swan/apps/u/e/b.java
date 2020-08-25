package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cwE;
    public com.baidu.swan.apps.ap.e.b<b> cwF;
    private final List<a> cwG = new ArrayList();
    private String cwH = b.class.getPackage().getName();

    public b nS(String str) {
        this.cwE = str;
        return this;
    }

    public String arr() {
        return this.cwE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> ars() {
        return new ArrayList(this.cwG);
    }

    public synchronized a aro() {
        a aVar;
        aVar = new a();
        this.cwG.add(aVar);
        return aVar;
    }

    public synchronized a nR(String str) {
        return aro().nU(str);
    }

    public synchronized a bK(String str, String str2) {
        return nR(str2).nT(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cwF = bVar;
        return this;
    }

    public synchronized b art() {
        return r(this.cwF);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0454b();
        }
        bVar.I(this);
        return this;
    }

    /* loaded from: classes8.dex */
    public class a {
        final List<String> cwI;
        private final List<StackTraceElement> cwJ;
        final /* synthetic */ b cwK;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cwK = bVar;
            this.msgs = new ArrayList();
            this.cwI = new ArrayList();
            this.cwJ = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cwH)) {
                    this.cwJ.add(stackTraceElement);
                }
            }
        }

        public a nT(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a nU(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aru() {
            return m34if(this.cwJ.size());
        }

        /* renamed from: if  reason: not valid java name */
        public synchronized a m34if(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cwJ.size() ? this.cwJ.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cwK.nR("[Trace]==> " + this.cwJ.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a arv() {
            return m34if(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0454b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0454b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void I(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cwG) {
                    for (String str : aVar.msgs) {
                        String arr = bVar.arr();
                        E(TextUtils.isEmpty(aVar.tag) ? arr : aVar.tag, arr + " >>> " + str);
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
