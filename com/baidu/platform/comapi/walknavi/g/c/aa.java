package com.baidu.platform.comapi.walknavi.g.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener;
        IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener2;
        ImageView imageView;
        Context context;
        if (com.baidu.platform.comapi.walknavi.d.e.c().p()) {
            if (com.baidu.platform.comapi.walknavi.d.e.c().j()) {
                context = this.a.l;
                Toast.makeText(context, "模型下载中, 请稍候", 0).show();
                return;
            }
            iWMoreNPCModelOnClickListener = this.a.X;
            if (iWMoreNPCModelOnClickListener != null) {
                iWMoreNPCModelOnClickListener2 = this.a.X;
                imageView = this.a.O;
                iWMoreNPCModelOnClickListener2.onMoreNPCModelOnClick(imageView);
            }
        }
    }
}
