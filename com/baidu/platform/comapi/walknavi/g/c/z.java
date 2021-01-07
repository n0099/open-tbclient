package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(c cVar) {
        this.f4548a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        TextView textView;
        boolean z2;
        c.a aVar;
        TextView textView2;
        TextView textView3;
        boolean z3;
        com.baidu.platform.comapi.walknavi.g.a aVar2;
        com.baidu.platform.comapi.walknavi.g.a aVar3;
        TextView textView4;
        z = this.f4548a.E;
        if (!z) {
            textView = this.f4548a.A;
            if (textView != null) {
                textView2 = this.f4548a.A;
                textView2.setText("查看全览");
            }
            c cVar = this.f4548a;
            z2 = this.f4548a.E;
            cVar.E = z2 ? false : true;
            if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
                this.f4548a.q();
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().I().run("[3D车头向上]按钮点击");
            aVar = this.f4548a.F;
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().G().j();
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().I().run("[查看全览]按钮点击");
        textView3 = this.f4548a.A;
        if (textView3 != null) {
            textView4 = this.f4548a.A;
            textView4.setText("继续当前导航");
        }
        c cVar2 = this.f4548a;
        z3 = this.f4548a.E;
        cVar2.E = z3 ? false : true;
        aVar2 = this.f4548a.m;
        if (aVar2 != null) {
            aVar3 = this.f4548a.m;
            aVar3.v();
        }
    }
}
