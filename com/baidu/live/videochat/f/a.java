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
    private b.a bKy;
    private b.InterfaceC0235b bNJ;
    private b bNK;

    public void ag(View view) {
        if (this.bNK != null) {
            this.bNK.ag(view);
        }
    }

    public void a(w wVar, c cVar) {
        if (this.bNK != null) {
            this.bNK.a(wVar, cVar);
        }
    }

    public void Yg() {
        if (this.bNK != null) {
            this.bNK.release();
        }
    }

    public a(b.a aVar, b.InterfaceC0235b interfaceC0235b) {
        this.bKy = aVar;
        this.bNJ = interfaceC0235b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bNK == null) {
                this.bNK = new b(this.activity, this.bKy, this.bNJ);
            }
            if (this.bNK.getView() != null && this.bNK.getView().getParent() == null) {
                this.bNK.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds220), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds392));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bNK.getView(), layoutParams);
            }
        }
    }

    public void onDestroy() {
        if (this.bNK != null) {
            this.bNK.release();
        }
    }
}
