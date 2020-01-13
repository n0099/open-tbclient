package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String buS;
    public com.baidu.swan.apps.as.d.b<b> buU;
    private final List<String> buT = new ArrayList();
    private final List<a> buV = new ArrayList();
    private String buW = b.class.getPackage().getName();

    public b iz(String str) {
        this.buS = str;
        return this;
    }

    public String TX() {
        return this.buS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> TY() {
        return new ArrayList(this.buV);
    }

    public synchronized a TT() {
        a aVar;
        aVar = new a();
        this.buV.add(aVar);
        return aVar;
    }

    public synchronized a iy(String str) {
        return TT().iB(str);
    }

    public synchronized a aJ(String str, String str2) {
        return iy(str2).iA(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.buU = bVar;
        return this;
    }

    public synchronized b TZ() {
        return c(this.buU);
    }

    public synchronized b c(com.baidu.swan.apps.as.d.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0299b();
        }
        bVar.B(this);
        return this;
    }

    /* loaded from: classes10.dex */
    public class a {
        final List<String> buT;
        private final List<StackTraceElement> buX;
        final /* synthetic */ b buY;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.buY = bVar;
            this.msgs = new ArrayList();
            this.buT = new ArrayList();
            this.buX = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.buW)) {
                    this.buX.add(stackTraceElement);
                }
            }
        }

        public a iA(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a iB(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a Ua() {
            return eW(this.buX.size());
        }

        public synchronized a eW(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.buX.size() ? this.buX.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.buY.iy("[Trace]==> " + this.buX.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Ub() {
            return eW(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0299b implements com.baidu.swan.apps.as.d.b<b> {
        private C0299b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void B(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.buV) {
                    for (String str : aVar.msgs) {
                        String TX = bVar.TX();
                        aK(TextUtils.isEmpty(aVar.tag) ? TX : aVar.tag, TX + " >>> " + str);
                    }
                }
            }
        }

        private void aK(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
