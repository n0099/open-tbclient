package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mapapi.model.inner.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4286a = aVar;
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
        if (message.what == 1) {
            com.baidu.platform.comapi.wnplatform.d.a.a("aaa", ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.f4361a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q())) + "");
            i = this.f4286a.v;
            if (i <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.f4361a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q()))) {
                StringBuilder append = new StringBuilder().append("handlemessage == ");
                i8 = this.f4286a.v;
                com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", append.append(i8).toString());
                com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
                a aVar = this.f4286a;
                i9 = this.f4286a.v;
                aVar.v = i9 - 20;
                this.f4286a.w = true;
            }
            i2 = this.f4286a.v;
            if (i2 < 0) {
                int a2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
                runnable3 = this.f4286a.R;
                if (runnable3 != null) {
                    handler3 = this.f4286a.Q;
                    if (handler3 != null) {
                        handler4 = this.f4286a.Q;
                        runnable4 = this.f4286a.R;
                        handler4.removeCallbacks(runnable4);
                    }
                }
                if (a2 != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    int i10 = a2 + 1;
                    StringBuilder append2 = new StringBuilder().append("handle uid").append(i10).append("width");
                    i6 = this.f4286a.v;
                    com.baidu.platform.comapi.wnplatform.d.a.c("yang13", append2.append(i6).toString());
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(i10);
                    this.f4286a.v = com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
                    StringBuilder append3 = new StringBuilder().append("handlemessage width<0== ");
                    i7 = this.f4286a.v;
                    com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", append3.append(i7).toString());
                    com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "finalid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.h());
                    com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
                } else {
                    return;
                }
            }
            hVar = this.f4286a.t;
            if (hVar != null) {
                hVar2 = this.f4286a.t;
                i5 = this.f4286a.v;
                hVar2.a(i5);
            }
            iVar = this.f4286a.u;
            if (iVar != null) {
                iVar2 = this.f4286a.u;
                i4 = this.f4286a.v;
                iVar2.a(i4);
            }
            i3 = this.f4286a.v;
            if (i3 != com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                handler = this.f4286a.Q;
                if (handler != null) {
                    runnable = this.f4286a.R;
                    if (runnable != null) {
                        handler2 = this.f4286a.Q;
                        runnable2 = this.f4286a.R;
                        handler2.postDelayed(runnable2, 20L);
                    }
                }
            }
        } else if (message.what == 2) {
            activity = this.f4286a.i;
            float a3 = com.baidu.platform.comapi.wnplatform.o.g.a(activity);
            A = this.f4286a.A();
            int[] iArr = {A.getmPtx(), A.getmPty()};
            int[] iArr2 = {0, 0};
            float[] fArr = {0.0f, 0.0f};
            com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2);
            if (iArr2[0] != 0 || iArr2[1] != 0) {
                str = this.f4286a.ab;
                if (!TextUtils.isEmpty(str)) {
                    activity2 = this.f4286a.i;
                    fArr[0] = com.baidu.platform.comapi.wnplatform.o.g.a(iArr2[0] / a3, activity2);
                    float f = iArr2[1] / a3;
                    activity3 = this.f4286a.i;
                    fArr[1] = com.baidu.platform.comapi.wnplatform.o.g.b(f, activity3);
                    this.f4286a.a(fArr[0], fArr[1]);
                    return;
                }
            }
            relativeLayout = this.f4286a.U;
            if (relativeLayout != null) {
                relativeLayout2 = this.f4286a.U;
                relativeLayout2.setVisibility(8);
            }
        } else if (message.what == 3) {
            this.f4286a.s();
        }
    }
}
