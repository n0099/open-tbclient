package com.baidu.platform.comapi.walknavi.g.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(c cVar) {
        this.a = cVar;
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
        z = this.a.E;
        if (!z) {
            textView = this.a.A;
            if (textView != null) {
                textView2 = this.a.A;
                textView2.setText("查看全览");
            }
            c cVar = this.a;
            z2 = this.a.E;
            cVar.E = z2 ? false : true;
            if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
                this.a.q();
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().I().run("[3D车头向上]按钮点击");
            aVar = this.a.F;
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().G().j();
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().I().run("[查看全览]按钮点击");
        textView3 = this.a.A;
        if (textView3 != null) {
            textView4 = this.a.A;
            textView4.setText("继续当前导航");
        }
        c cVar2 = this.a;
        z3 = this.a.E;
        cVar2.E = z3 ? false : true;
        aVar2 = this.a.m;
        if (aVar2 != null) {
            aVar3 = this.a.m;
            aVar3.v();
        }
    }
}
