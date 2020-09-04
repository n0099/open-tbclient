package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cwI;
    public com.baidu.swan.apps.ap.e.b<b> cwJ;
    private final List<a> cwK = new ArrayList();
    private String cwL = b.class.getPackage().getName();

    public b nT(String str) {
        this.cwI = str;
        return this;
    }

    public String arr() {
        return this.cwI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> ars() {
        return new ArrayList(this.cwK);
    }

    public synchronized a aro() {
        a aVar;
        aVar = new a();
        this.cwK.add(aVar);
        return aVar;
    }

    public synchronized a nS(String str) {
        return aro().nV(str);
    }

    public synchronized a bK(String str, String str2) {
        return nS(str2).nU(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cwJ = bVar;
        return this;
    }

    public synchronized b art() {
        return r(this.cwJ);
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
        final List<String> cwM;
        private final List<StackTraceElement> cwN;
        final /* synthetic */ b cwO;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cwO = bVar;
            this.msgs = new ArrayList();
            this.cwM = new ArrayList();
            this.cwN = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cwL)) {
                    this.cwN.add(stackTraceElement);
                }
            }
        }

        public a nU(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a nV(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aru() {
            return m34if(this.cwN.size());
        }

        /* renamed from: if  reason: not valid java name */
        public synchronized a m34if(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cwN.size() ? this.cwN.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cwO.nS("[Trace]==> " + this.cwN.get(i3).toString());
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
                for (a aVar : bVar.cwK) {
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
