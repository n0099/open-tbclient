package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mapapi.model.inner.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Activity activity;
        Point y;
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
        if (message.what == 1) {
            com.baidu.platform.comapi.wnplatform.c.a.a("aaa", ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q())) + "");
            i = this.a.v;
            if (i <= ((int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a * com.baidu.platform.comapi.walknavi.segmentbrowse.c.q()))) {
                StringBuilder append = new StringBuilder().append("handlemessage == ");
                i8 = this.a.v;
                com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", append.append(i8).toString());
                com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
                a.a(this.a, 20);
                this.a.w = true;
            }
            i2 = this.a.v;
            if (i2 < 0) {
                int a = com.baidu.platform.comapi.walknavi.segmentbrowse.c.a();
                runnable3 = this.a.M;
                if (runnable3 != null) {
                    handler3 = this.a.L;
                    if (handler3 != null) {
                        handler4 = this.a.L;
                        runnable4 = this.a.M;
                        handler4.removeCallbacks(runnable4);
                    }
                }
                if (a != com.baidu.platform.comapi.walknavi.segmentbrowse.c.h()) {
                    int i9 = a + 1;
                    StringBuilder append2 = new StringBuilder().append("handle uid").append(i9).append("width");
                    i6 = this.a.v;
                    com.baidu.platform.comapi.wnplatform.c.a.c("yang13", append2.append(i6).toString());
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(i9);
                    this.a.v = com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
                    StringBuilder append3 = new StringBuilder().append("handlemessage width<0== ");
                    i7 = this.a.v;
                    com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", append3.append(i7).toString());
                    com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", "finalid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.h());
                    com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", "curid" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
                } else {
                    return;
                }
            }
            hVar = this.a.t;
            if (hVar != null) {
                hVar2 = this.a.t;
                i5 = this.a.v;
                hVar2.a(i5);
            }
            iVar = this.a.u;
            if (iVar != null) {
                iVar2 = this.a.u;
                i4 = this.a.v;
                iVar2.a(i4);
            }
            i3 = this.a.v;
            if (i3 != com.baidu.platform.comapi.walknavi.segmentbrowse.c.o()) {
                handler = this.a.L;
                if (handler != null) {
                    runnable = this.a.M;
                    if (runnable != null) {
                        handler2 = this.a.L;
                        runnable2 = this.a.M;
                        handler2.postDelayed(runnable2, 20L);
                    }
                }
            }
        } else if (message.what == 2) {
            activity = this.a.i;
            float a2 = com.baidu.platform.comapi.wnplatform.o.f.a(activity);
            y = this.a.y();
            int[] iArr = {y.getmPtx(), y.getmPty()};
            int[] iArr2 = {0, 0};
            float[] fArr = {0.0f, 0.0f};
            com.baidu.platform.comapi.walknavi.b.a().B().a(iArr, iArr2);
            if (iArr2[0] != 0 || iArr2[1] != 0) {
                str = this.a.W;
                if (!TextUtils.isEmpty(str)) {
                    activity2 = this.a.i;
                    fArr[0] = com.baidu.platform.comapi.wnplatform.o.f.a(iArr2[0] / a2, activity2);
                    float f = iArr2[1] / a2;
                    activity3 = this.a.i;
                    fArr[1] = com.baidu.platform.comapi.wnplatform.o.f.b(f, activity3);
                    this.a.a(fArr[0], fArr[1]);
                    return;
                }
            }
            relativeLayout = this.a.P;
            if (relativeLayout != null) {
                relativeLayout2 = this.a.P;
                relativeLayout2.setVisibility(8);
            }
        } else if (message.what == 3) {
            this.a.q();
        }
    }
}
