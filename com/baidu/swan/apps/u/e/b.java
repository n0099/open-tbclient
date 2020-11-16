package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cXt;
    public com.baidu.swan.apps.ap.e.b<b> cXu;
    private final List<a> cXv = new ArrayList();
    private String cXw = b.class.getPackage().getName();

    public b pB(String str) {
        this.cXt = str;
        return this;
    }

    public String ayz() {
        return this.cXt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> ayA() {
        return new ArrayList(this.cXv);
    }

    public synchronized a ayw() {
        a aVar;
        aVar = new a();
        this.cXv.add(aVar);
        return aVar;
    }

    public synchronized a pA(String str) {
        return ayw().pD(str);
    }

    public synchronized a bV(String str, String str2) {
        return pA(str2).pC(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cXu = bVar;
        return this;
    }

    public synchronized b ayB() {
        return r(this.cXu);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0490b();
        }
        bVar.M(this);
        return this;
    }

    /* loaded from: classes7.dex */
    public class a {
        final List<String> cXx;
        private final List<StackTraceElement> cXy;
        final /* synthetic */ b cXz;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cXz = bVar;
            this.msgs = new ArrayList();
            this.cXx = new ArrayList();
            this.cXy = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cXw)) {
                    this.cXy.add(stackTraceElement);
                }
            }
        }

        public a pC(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pD(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a ayC() {
            return jd(this.cXy.size());
        }

        public synchronized a jd(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cXy.size() ? this.cXy.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cXz.pA("[Trace]==> " + this.cXy.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a ayD() {
            return jd(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0490b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0490b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cXv) {
                    for (String str : aVar.msgs) {
                        String ayz = bVar.ayz();
                        D(TextUtils.isEmpty(aVar.tag) ? ayz : aVar.tag, ayz + " >>> " + str);
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
