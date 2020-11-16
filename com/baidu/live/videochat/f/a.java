package com.baidu.live.videochat.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.videochat.f.b;
/* loaded from: classes4.dex */
public class a {
    private Activity activity;
    private b.a bFp;
    private b.InterfaceC0226b bIB;
    private b bIC;

    public void ag(View view) {
        if (this.bIC != null) {
            this.bIC.ag(view);
        }
    }

    public void a(w wVar, c cVar) {
        if (this.bIC != null) {
            this.bIC.a(wVar, cVar);
        }
    }

    public void VG() {
        if (this.bIC != null) {
            this.bIC.release();
        }
    }

    public a(b.a aVar, b.InterfaceC0226b interfaceC0226b) {
        this.bFp = aVar;
        this.bIB = interfaceC0226b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bIC == null) {
                this.bIC = new b(this.activity, this.bFp, this.bIB);
            }
            if (this.bIC.getView() != null && this.bIC.getView().getParent() == null) {
                this.bIC.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds220), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds392));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bIC.getView(), layoutParams);
            }
        }
    }

    public void onDestroy() {
        if (this.bIC != null) {
            this.bIC.release();
        }
    }
}
