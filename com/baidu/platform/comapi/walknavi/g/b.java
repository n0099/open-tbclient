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
    public final /* synthetic */ a f9631a;

    public b(a aVar) {
        this.f9631a = aVar;
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
                    this.f9631a.s();
                    return;
                }
                return;
            }
            activity = this.f9631a.i;
            float a2 = com.baidu.platform.comapi.wnplatform.o.g.a(activity);
            A = this.f9631a.A();
            int[] iArr = {A.getmPtx(), A.getmPty()};
            int[] iArr2 = {0, 0};
            float[] fArr = {0.0f, 0.0f};
            com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2);
            if (iArr2[0] != 0 || iArr2[1] != 0) {
                str = this.f9631a.ab;
                if (!TextUtils.isEmpty(str)) {
                    activity2 = this.f9631a.i;
                    fArr[0] = com.baidu.platform.comapi.wnplatform.o.g.a(iArr2[0] / a2, activity2);
                    float f2 = iArr2[1] / a2;
                    activity3 = this.f9631a.i;
                    fArr[1] = com.baidu.platform.comapi.wnplatform.o.g.b(f2, activity3);
                    this.f9631a.a(fArr[0], fArr[1]);
                    return;
                }
            }
            relativeLayout = this.f9631a.U;
            if (relativeLayout != null) {
                relativeLayout2 = this.f9631a.U;
                relativeLayout2.setVisibility(8);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.wnplatform.d.a.a("aaa", ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9725a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q())) + "");
        i = this.f9631a.v;
        if (i <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9725a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q()))) {
            StringBuilder sb = new StringBuilder();
            sb.append("handlemessage == ");
            i8 = this.f9631a.v;
            sb.append(i8);
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", sb.toString());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
            a aVar = this.f9631a;
            i9 = aVar.v;
            aVar.v = i9 + (-20);
            this.f9631a.w = true;
        }
        i2 = this.f9631a.v;
        if (i2 < 0) {
            int a3 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
            runnable3 = this.f9631a.R;
            if (runnable3 != null) {
                handler3 = this.f9631a.Q;
                if (handler3 != null) {
                    handler4 = this.f9631a.Q;
                    runnable4 = this.f9631a.R;
                    handler4.removeCallbacks(runnable4);
                }
            }
            if (a3 == com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                return;
            }
            int i11 = a3 + 1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handle uid");
            sb2.append(i11);
            sb2.append("width");
            i6 = this.f9631a.v;
            sb2.append(i6);
            com.baidu.platform.comapi.wnplatform.d.a.c("yang13", sb2.toString());
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(i11);
            this.f9631a.v = com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("handlemessage width<0== ");
            i7 = this.f9631a.v;
            sb3.append(i7);
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", sb3.toString());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "finalid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.h());
            com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
        }
        hVar = this.f9631a.t;
        if (hVar != null) {
            hVar2 = this.f9631a.t;
            i5 = this.f9631a.v;
            hVar2.a(i5);
        }
        iVar = this.f9631a.u;
        if (iVar != null) {
            iVar2 = this.f9631a.u;
            i4 = this.f9631a.v;
            iVar2.a(i4);
        }
        i3 = this.f9631a.v;
        if (i3 != com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
            handler = this.f9631a.Q;
            if (handler != null) {
                runnable = this.f9631a.R;
                if (runnable != null) {
                    handler2 = this.f9631a.Q;
                    runnable2 = this.f9631a.R;
                    handler2.postDelayed(runnable2, 20L);
                }
            }
        }
    }
}
