package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2967a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(c cVar) {
        this.f2967a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener;
        IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener2;
        View view2;
        Context context;
        if (com.baidu.platform.comapi.walknavi.d.e.c().p()) {
            if (com.baidu.platform.comapi.walknavi.d.e.c().j()) {
                context = this.f2967a.l;
                Toast.makeText(context, "模型下载中, 请稍候", 0).show();
                return;
            }
            iWMoreNPCModelOnClickListener = this.f2967a.V;
            if (iWMoreNPCModelOnClickListener != null) {
                iWMoreNPCModelOnClickListener2 = this.f2967a.V;
                view2 = this.f2967a.N;
                iWMoreNPCModelOnClickListener2.onMoreNPCModelOnClick(view2);
            }
        }
    }
}
