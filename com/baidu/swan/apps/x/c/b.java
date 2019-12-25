package com.baidu.swan.apps.x.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bud;
    public com.baidu.swan.apps.as.d.b<b> bug;
    private final List<String> bue = new ArrayList();
    private final List<a> buh = new ArrayList();
    private String bui = b.class.getPackage().getName();

    public b iw(String str) {
        this.bud = str;
        return this;
    }

    public String TA() {
        return this.bud;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> TB() {
        return new ArrayList(this.buh);
    }

    public synchronized a Tw() {
        a aVar;
        aVar = new a();
        this.buh.add(aVar);
        return aVar;
    }

    public synchronized a iv(String str) {
        return Tw().iy(str);
    }

    public synchronized a aI(String str, String str2) {
        return iv(str2).ix(str);
    }

    public b b(com.baidu.swan.apps.as.d.b<b> bVar) {
        this.bug = bVar;
        return this;
    }

    public synchronized b TC() {
        return c(this.bug);
    }

    public synchronized b c(com.baidu.swan.apps.as.d.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0297b();
        }
        bVar.B(this);
        return this;
    }

    /* loaded from: classes9.dex */
    public class a {
        final List<String> bue;
        private final List<StackTraceElement> buj;
        final /* synthetic */ b buk;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.buk = bVar;
            this.msgs = new ArrayList();
            this.bue = new ArrayList();
            this.buj = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.bui)) {
                    this.buj.add(stackTraceElement);
                }
            }
        }

        public a ix(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a iy(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a TD() {
            return eV(this.buj.size());
        }

        public synchronized a eV(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.buj.size() ? this.buj.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.buk.iv("[Trace]==> " + this.buj.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a TE() {
            return eV(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.x.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0297b implements com.baidu.swan.apps.as.d.b<b> {
        private C0297b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.b
        /* renamed from: a */
        public void B(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.buh) {
                    for (String str : aVar.msgs) {
                        String TA = bVar.TA();
                        aJ(TextUtils.isEmpty(aVar.tag) ? TA : aVar.tag, TA + " >>> " + str);
                    }
                }
            }
        }

        private void aJ(String str, String str2) {
            if (b.DEBUG) {
                Log.i(str, str2);
            }
        }
    }
}
