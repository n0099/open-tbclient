package com.baidu.swan.apps.u.d;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String coW;
    public com.baidu.swan.apps.aq.e.b<b> coX;
    private final List<a> coY = new ArrayList();
    private String coZ = b.class.getPackage().getName();

    public b lV(String str) {
        this.coW = str;
        return this;
    }

    public String ajK() {
        return this.coW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> ajL() {
        return new ArrayList(this.coY);
    }

    public synchronized a ajH() {
        a aVar;
        aVar = new a();
        this.coY.add(aVar);
        return aVar;
    }

    public synchronized a lU(String str) {
        return ajH().lX(str);
    }

    public synchronized a bx(String str, String str2) {
        return lU(str2).lW(str);
    }

    public b j(com.baidu.swan.apps.aq.e.b<b> bVar) {
        this.coX = bVar;
        return this;
    }

    public synchronized b ajM() {
        return k(this.coX);
    }

    public synchronized b k(com.baidu.swan.apps.aq.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0407b();
        }
        bVar.H(this);
        return this;
    }

    /* loaded from: classes7.dex */
    public class a {
        final List<String> cpa;
        private final List<StackTraceElement> cpb;
        final /* synthetic */ b cpc;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.cpc = bVar;
            this.msgs = new ArrayList();
            this.cpa = new ArrayList();
            this.cpb = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.coZ)) {
                    this.cpb.add(stackTraceElement);
                }
            }
        }

        public a lW(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a lX(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a ajN() {
            return gb(this.cpb.size());
        }

        public synchronized a gb(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.cpb.size() ? this.cpb.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.cpc.lU("[Trace]==> " + this.cpb.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a ajO() {
            return gb(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0407b implements com.baidu.swan.apps.aq.e.b<b> {
        private C0407b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.b
        /* renamed from: a */
        public void H(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.coY) {
                    for (String str : aVar.msgs) {
                        String ajK = bVar.ajK();
                        C(TextUtils.isEmpty(aVar.tag) ? ajK : aVar.tag, ajK + " >>> " + str);
                    }
                }
            }
        }

        private void C(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
