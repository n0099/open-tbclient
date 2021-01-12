package com.baidu.swan.apps.u.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dex;
    public com.baidu.swan.apps.ao.e.b<b> dey;
    private final List<a> dez = new ArrayList();
    private String deA = b.class.getPackage().getName();

    public b oQ(String str) {
        this.dex = str;
        return this;
    }

    public String azg() {
        return this.dex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> azh() {
        return new ArrayList(this.dez);
    }

    public synchronized a azd() {
        a aVar;
        aVar = new a();
        this.dez.add(aVar);
        return aVar;
    }

    public synchronized a oP(String str) {
        return azd().oS(str);
    }

    public synchronized a ca(String str, String str2) {
        return oP(str2).oR(str);
    }

    public b q(com.baidu.swan.apps.ao.e.b<b> bVar) {
        this.dey = bVar;
        return this;
    }

    public synchronized b azi() {
        return r(this.dey);
    }

    public synchronized b r(com.baidu.swan.apps.ao.e.b<b> bVar) {
        if (bVar == null) {
            bVar = new C0478b();
        }
        bVar.L(this);
        return this;
    }

    /* loaded from: classes8.dex */
    public class a {
        final List<String> deB;
        private final List<StackTraceElement> deC;
        final List<String> msgs;
        String tag;

        private a() {
            this.msgs = new ArrayList();
            this.deB = new ArrayList();
            this.deC = new ArrayList();
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                int i3 = i2 + 1;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(b.this.deA)) {
                    this.deC.add(stackTraceElement);
                }
                i++;
                i2 = i3;
            }
        }

        public a oR(String str) {
            this.tag = str;
            return this;
        }

        public synchronized a oS(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a azj() {
            return hQ(this.deC.size());
        }

        public synchronized a hQ(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.deC.size() ? this.deC.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    b.this.oP("[Trace]==> " + this.deC.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a azk() {
            return hQ(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.u.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0478b implements com.baidu.swan.apps.ao.e.b<b> {
        private C0478b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public void L(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.dez) {
                    for (String str : aVar.msgs) {
                        String azg = bVar.azg();
                        D(TextUtils.isEmpty(aVar.tag) ? azg : aVar.tag, azg + " >>> " + str);
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
