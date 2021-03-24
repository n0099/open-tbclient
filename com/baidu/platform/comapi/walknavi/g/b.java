package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mapapi.model.inner.Point;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10072a;

    public b(a aVar) {
        this.f10072a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Activity activity;
        Point A;
        String str;
        Activity activity2;
        Activity activity3;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i;
        int i2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h hVar;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.i iVar;
        int i3;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.i iVar2;
        int i4;
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h hVar2;
        int i5;
        Runnable runnable3;
        int i6;
        int i7;
        Handler handler3;
        Handler handler4;
        Runnable runnable4;
        int i8;
        int i9;
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    this.f10072a.s();
                    return;
                }
                return;
            }
            activity = this.f10072a.i;
            float a2 = com.baidu.platform.comapi.wnplatform.o.g.a(activity);
            A = this.f10072a.A();
            int[] iArr = {A.getmPtx(), A.getmPty()};
            int[] iArr2 = {0, 0};
            float[] fArr = {0.0f, 0.0f};
            com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2);
            if (iArr2[0] != 0 || iArr2[1] != 0) {
                str = this.f10072a.ab;
                if (!TextUtils.isEmpty(str)) {
                    activity2 = this.f10072a.i;
                    fArr[0] = com.baidu.platform.comapi.wnplatform.o.g.a(iArr2[0] / a2, activity2);
                    float f2 = iArr2[1] / a2;
                    activity3 = this.f10072a.i;
                    fArr[1] = com.baidu.platform.comapi.wnplatform.o.g.b(f2, activity3);
                    this.f10072a.a(fArr[0], fArr[1]);
                    return;
                }
            }
            relativeLayout = this.f10072a.U;
            if (relativeLayout != null) {
                relativeLayout2 = this.f10072a.U;
                relativeLayout2.setVisibility(8);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        double d2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10166a;
        double q = com.baidu.platform.comapi.walknavi.segmentbrowse.c.q();
        Double.isNaN(d2);
        sb.append((int) (d2 * q));
        sb.append("");
        com.baidu.platform.comapi.wnplatform.d.a.a("aaa", sb.toString());
        i = this.f10072a.v;
        double d3 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.f10166a;
        double q2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.q();
        Double.isNaN(d3);
        if (i <= ((int) (d3 * q2))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handlemessage == ");
            i8 = this.f10072a.v;
            sb2.append(i8);
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", sb2.toString());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            a aVar = this.f10072a;
            i9 = aVar.v;
            aVar.v = i9 + (-20);
            this.f10072a.w = true;
        }
        i2 = this.f10072a.v;
        if (i2 < 0) {
            int a3 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
            runnable3 = this.f10072a.R;
            if (runnable3 != null) {
                handler3 = this.f10072a.Q;
                if (handler3 != null) {
                    handler4 = this.f10072a.Q;
                    runnable4 = this.f10072a.R;
                    handler4.removeCallbacks(runnable4);
                }
            }
            if (a3 == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                return;
            }
            int i11 = a3 + 1;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("handle uid");
            sb3.append(i11);
            sb3.append("width");
            i6 = this.f10072a.v;
            sb3.append(i6);
            com.baidu.platform.comapi.wnplatform.d.a.c("yang13", sb3.toString());
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(i11);
            this.f10072a.v = com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("handlemessage width<0== ");
            i7 = this.f10072a.v;
            sb4.append(i7);
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", sb4.toString());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "finalid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.h());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
        }
        hVar = this.f10072a.t;
        if (hVar != null) {
            hVar2 = this.f10072a.t;
            i5 = this.f10072a.v;
            hVar2.a(i5);
        }
        iVar = this.f10072a.u;
        if (iVar != null) {
            iVar2 = this.f10072a.u;
            i4 = this.f10072a.v;
            iVar2.a(i4);
        }
        i3 = this.f10072a.v;
        if (i3 != com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
            handler = this.f10072a.Q;
            if (handler != null) {
                runnable = this.f10072a.R;
                if (runnable != null) {
                    handler2 = this.f10072a.Q;
                    runnable2 = this.f10072a.R;
                    handler2.postDelayed(runnable2, 20L);
                }
            }
        }
    }
}
