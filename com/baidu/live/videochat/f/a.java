package com.baidu.live.videochat.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.videochat.f.b;
/* loaded from: classes4.dex */
public class a {
    private Activity activity;
    private b.InterfaceC0210b bBJ;
    private b bBK;
    private b.a bxV;

    public void ac(View view) {
        if (this.bBK != null) {
            this.bBK.ac(view);
        }
    }

    public void a(u uVar, c cVar) {
        if (this.bBK != null) {
            this.bBK.a(uVar, cVar);
        }
    }

    public void SQ() {
        if (this.bBK != null) {
            this.bBK.release();
        }
    }

    public a(b.a aVar, b.InterfaceC0210b interfaceC0210b) {
        this.bxV = aVar;
        this.bBJ = interfaceC0210b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bBK == null) {
                this.bBK = new b(this.activity, this.bxV, this.bBJ);
            }
            if (this.bBK.getView() != null && this.bBK.getView().getParent() == null) {
                this.bBK.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds220), this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds392));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                viewGroup.addView(this.bBK.getView(), layoutParams);
            }
        }
    }

    public void onDestroy() {
        if (this.bBK != null) {
            this.bBK.release();
        }
    }
}
