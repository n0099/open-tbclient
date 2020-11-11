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
    private b.a bHa;
    private b.InterfaceC0228b bKm;
    private b bKn;

    public void ag(View view) {
        if (this.bKn != null) {
            this.bKn.ag(view);
        }
    }

    public void a(w wVar, c cVar) {
        if (this.bKn != null) {
            this.bKn.a(wVar, cVar);
        }
    }

    public void Wp() {
        if (this.bKn != null) {
            this.bKn.release();
        }
    }

    public a(b.a aVar, b.InterfaceC0228b interfaceC0228b) {
        this.bHa = aVar;
        this.bKm = interfaceC0228b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bKn == null) {
                this.bKn = new b(this.activity, this.bHa, this.bKm);
            }
            if (this.bKn.getView() != null && this.bKn.getView().getParent() == null) {
                this.bKn.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds220), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds392));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bKn.getView(), layoutParams);
            }
        }
    }

    public void onDestroy() {
        if (this.bKn != null) {
            this.bKn.release();
        }
    }
}
