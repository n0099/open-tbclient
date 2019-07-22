package com.baidu.swan.apps.v.c;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String azH;
    public com.baidu.swan.apps.an.d.a<b> azJ;
    private final List<String> azI = new ArrayList();
    private final List<a> azK = new ArrayList();
    private String azL = b.class.getPackage().getName();

    public b eY(String str) {
        this.azH = str;
        return this;
    }

    public String Gc() {
        return this.azH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<a> Gd() {
        return new ArrayList(this.azK);
    }

    public synchronized a FY() {
        a aVar;
        aVar = new a();
        this.azK.add(aVar);
        return aVar;
    }

    public synchronized a eX(String str) {
        return FY().fb(str);
    }

    public synchronized a ak(String str, String str2) {
        return eX(str2).eZ(str);
    }

    public b c(com.baidu.swan.apps.an.d.a<b> aVar) {
        this.azJ = aVar;
        return this;
    }

    public synchronized b Ge() {
        return d(this.azJ);
    }

    public synchronized b d(com.baidu.swan.apps.an.d.a<b> aVar) {
        if (aVar == null) {
            aVar = new C0183b();
        }
        aVar.D(this);
        return this;
    }

    /* loaded from: classes2.dex */
    public class a {
        final List<String> azI;
        private final List<StackTraceElement> azM;
        final /* synthetic */ b azN;
        final List<String> msgs;
        String tag;

        private a(b bVar) {
            StackTraceElement[] stackTrace;
            this.azN = bVar;
            this.msgs = new ArrayList();
            this.azI = new ArrayList();
            this.azM = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(bVar.azL)) {
                    this.azM.add(stackTraceElement);
                }
            }
        }

        public a eZ(String str) {
            this.tag = str;
            return this;
        }

        public a fa(String str) {
            this.azI.add(str);
            return this;
        }

        public synchronized a fb(String str) {
            List<String> list = this.msgs;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public synchronized a cH(int i) {
            synchronized (this) {
                int i2 = i >= 1 ? i : 1;
                int size = i2 > this.azM.size() ? this.azM.size() : i2;
                for (int i3 = 0; i3 < size; i3++) {
                    this.azN.eX("[Trace]==> " + this.azM.get(i3).toString());
                }
            }
            return this;
        }

        public synchronized a Gg() {
            return cH(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.v.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0183b implements com.baidu.swan.apps.an.d.a<b> {
        private C0183b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.a
        /* renamed from: a */
        public void D(b bVar) {
            if (b.DEBUG) {
                for (a aVar : bVar.azK) {
                    for (String str : aVar.msgs) {
                        String Gc = bVar.Gc();
                        am(TextUtils.isEmpty(aVar.tag) ? Gc : aVar.tag, Gc + " >>> " + str);
                    }
                }
            }
        }

        private void am(String str, String str2) {
            Log.i(str, str2);
        }
    }
}
