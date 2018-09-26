package cn.jiguang.d.f;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.e;
import cn.jiguang.d.a.d;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    private Context b;
    final /* synthetic */ a lI;

    public b(a aVar, Context context) {
        this.lI = aVar;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        List b;
        String str3;
        long[] jArr;
        String str4;
        String str5;
        long[] jArr2;
        long j;
        long j2;
        String str6;
        String str7;
        long j3;
        long j4;
        long j5;
        int i;
        long j6;
        String str8;
        try {
            new ArrayList();
            this.lI.d = d.r(this.b);
            long af = d.af(this.b);
            boolean z = false;
            str = this.lI.d;
            if (TextUtils.isEmpty(str) || af < 0) {
                z = true;
                this.lI.d = UUID.randomUUID().toString();
                af = System.currentTimeMillis();
                d.h(this.b, af);
                Context context = this.b;
                str2 = this.lI.d;
                d.f(context, str2);
            }
            boolean z2 = z;
            long j7 = af;
            b = this.lI.b(this.b);
            if (b.isEmpty()) {
                this.lI.h = false;
                a.b(this.lI, this.b);
                return;
            }
            int v = cn.jiguang.d.a.a.v();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < b.size(); i2++) {
                c cVar = (c) b.get(i2);
                i = cVar.b;
                if (v == i) {
                    j6 = cVar.d;
                    if (j6 > 0) {
                        String packageName = this.b.getPackageName();
                        str8 = cVar.e;
                        if (!packageName.equals(str8)) {
                            arrayList.add(cVar);
                        }
                    }
                }
            }
            if (arrayList.size() == 0) {
                this.lI.h = false;
                a.b(this.lI, this.b);
                return;
            }
            String str9 = "";
            long j8 = -1;
            this.lI.lG = new long[arrayList.size()];
            String str10 = "";
            int i3 = 0;
            while (i3 < arrayList.size()) {
                jArr2 = this.lI.lG;
                j = ((c) arrayList.get(i3)).d;
                jArr2[i3] = j;
                StringBuilder append = new StringBuilder().append(str10);
                j2 = ((c) arrayList.get(i3)).d;
                str10 = append.append(j2).append(",").toString();
                str6 = ((c) arrayList.get(i3)).c;
                if (!TextUtils.isEmpty(str6)) {
                    j4 = ((c) arrayList.get(i3)).h;
                    if (j4 > 0) {
                        j5 = ((c) arrayList.get(i3)).h;
                        if (j5 < j8 || j8 == -1) {
                            str7 = ((c) arrayList.get(i3)).c;
                            j3 = ((c) arrayList.get(i3)).h;
                            i3++;
                            String str11 = str7;
                            j8 = j3;
                            str9 = str11;
                        }
                    }
                }
                long j9 = j8;
                str7 = str9;
                j3 = j9;
                i3++;
                String str112 = str7;
                j8 = j3;
                str9 = str112;
            }
            if (!TextUtils.isEmpty(str9)) {
                if (z2) {
                    this.lI.d = str9;
                    Context context2 = this.b;
                    str5 = this.lI.d;
                    d.f(context2, str5);
                    d.h(this.b, j8);
                } else {
                    if (j7 != j8) {
                        d.f(this.b, str9);
                        d.h(this.b, j8);
                    } else {
                        str4 = this.lI.d;
                        if (!str4.equals(str9)) {
                            d.h(this.b, System.currentTimeMillis());
                        }
                    }
                    this.lI.d = str9;
                }
            }
            long bh = e.bh();
            int sid = e.getSid();
            long c = d.c(this.b);
            str3 = this.lI.d;
            jArr = this.lI.lG;
            byte[] a = cn.jiguang.d.e.a.a.b.a(bh, sid, c, str3, jArr);
            cn.jiguang.d.b.d.bx();
            cn.jiguang.d.b.d.a(a, SdkType.JCORE.name(), 0);
            this.lI.h = false;
            a.b(this.lI, this.b);
        } catch (Throwable th) {
            this.lI.h = false;
            a.b(this.lI, this.b);
        }
    }
}
