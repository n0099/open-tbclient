package com.baidu.platform.comapi.walknavi.g.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes2.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10040a;

    public z(c cVar) {
        this.f10040a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        boolean z2;
        c.a aVar;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        boolean z3;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        com.baidu.platform.comapi.walknavi.g.a aVar3;
        TextView textView5;
        TextView textView6;
        z = this.f10040a.D;
        if (!z) {
            textView = this.f10040a.A;
            if (textView != null) {
                textView2 = this.f10040a.A;
                textView2.setTextColor(-8749952);
                textView3 = this.f10040a.A;
                textView3.setText("查看全览");
            }
            c cVar = this.f10040a;
            z2 = cVar.D;
            cVar.D = !z2;
            if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("st", 2);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.continue");
                this.f10040a.m();
                return;
            }
            if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE && com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() != com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING) {
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE) {
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("st", 3);
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.continue");
                }
            } else {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("st", 1);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.continue");
            }
            com.baidu.platform.comapi.walknavi.b.a().F().run("[3D车头向上]按钮点击");
            aVar = this.f10040a.E;
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().F().run("[查看全览]按钮点击");
        textView4 = this.f10040a.A;
        if (textView4 != null) {
            textView5 = this.f10040a.A;
            textView5.setTextColor(-13400577);
            textView6 = this.f10040a.A;
            textView6.setText("继续");
        }
        c cVar2 = this.f10040a;
        z3 = cVar2.D;
        cVar2.D = !z3;
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("st", 2);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.overview");
        } else {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("st", 1);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.overview");
        }
        aVar2 = this.f10040a.m;
        if (aVar2 != null) {
            aVar3 = this.f10040a.m;
            aVar3.w();
        }
    }
}
