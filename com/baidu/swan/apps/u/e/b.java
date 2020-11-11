package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cZd;
    public com.baidu.swan.apps.ap.e.b<b> cZe;
    private final List<a> cZf = new ArrayList();
    private String cZg = b.class.getPackage().getName();

    public b pH(String str) {
        this.cZd = str;
        return this;
    }

    public String azh() {
        return this.cZd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> azi() {
        return new ArrayList(this.cZf);
    }

    public synchronized a aze() {
        a aVar;
        aVar = new a();
        this.cZf.add(aVar);
        return aVar;
    }

    public synchronized a pG(String str) {
        return aze().pJ(str);
    }

    public synchronized a bW(String str, String str2) {
        return pG(str2).pI(str);
    }

    public b q(com.baidu.swan.apps.ap.e.b<b> bVar) {
        this.cZe = bVar;
        return this;
    }

    public synchronized b azj() {
        return r(this.cZe);
    }

    public synchronized b r(com.baidu.swan.apps.ap.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0492b();
        }
        bVar.M(this);
        return this;
    }

    /* loaded from: classes10.dex */
    public class a {
        final List<String> cZh;
        private final List<StackTraceElement> cZi;
        final /* synthetic */ b cZj;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cZj = bVar;
            this.msgs = new ArrayList();
            this.cZh = new ArrayList();
            this.cZi = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.cZg)) {
                    this.cZi.add(stackTraceElement);
                }
            }
        }

        public a pI(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a pJ(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a azk() {
            return jh(this.cZi.size());
        }

        public synchronized a jh(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cZi.size() ? this.cZi.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cZj.pG("[Trace]==> " + this.cZi.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a azl() {
            return jh(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0492b implements com.baidu.swan.apps.ap.e.b<b> {
        private C0492b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public void M(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.cZf) {
                    for (String str : aVar.msgs) {
                        String azh = bVar.azh();
                        E(TextUtils.isEmpty(aVar.tag) ? azh : aVar.tag, azh + " >>> " + str);
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
