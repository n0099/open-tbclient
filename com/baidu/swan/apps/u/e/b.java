package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String djm;
    public com.baidu.swan.apps.ao.e.b<b> djn;
    private final List<a> djo = new ArrayList();
    private String djp = b.class.getPackage().getName();

    public b qb(String str) {
        this.djm = str;
        return this;
    }

    public String aCZ() {
        return this.djm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> aDa() {
        return new ArrayList(this.djo);
    }

    public synchronized a aCW() {
        a aVar;
        aVar = new a();
        this.djo.add(aVar);
        return aVar;
    }

    public synchronized a qa(String str) {
        return aCW().qd(str);
    }

    public synchronized a cb(String str, String str2) {
        return qa(str2).qc(str);
    }

    public b q(com.baidu.swan.apps.ao.e.b<b> bVar) {
        this.djn = bVar;
        return this;
    }

    public synchronized b aDb() {
        return r(this.djn);
    }

    public synchronized b r(com.baidu.swan.apps.ao.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0495b();
        }
        bVar.L(this);
        return this;
    }

    /* loaded from: classes9.dex */
    public class a {
        final List<String> djq;
        private final List<StackTraceElement> djr;
        final List<String> msgs;
        String tag;

        private a() {
            this.msgs = new ArrayList();
            this.djq = new ArrayList();
            this.djr = new ArrayList();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                int i3 = i2 + 1;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(b.this.djp)) {
                    this.djr.add(stackTraceElement);
                }
                i++;
                i2 = i3;
            }
        }

        public a qc(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a qd(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a aDc() {
            return jw(this.djr.size());
        }

        public synchronized a jw(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.djr.size() ? this.djr.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    b.this.qa("[Trace]==> " + this.djr.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a aDd() {
            return jw(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0495b implements com.baidu.swan.apps.ao.e.b<b> {
        private C0495b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.djo) {
                    for (String str : aVar.msgs) {
                        String aCZ = bVar.aCZ();
                        D(TextUtils.isEmpty(aVar.tag) ? aCZ : aVar.tag, aCZ + " >>> " + str);
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
