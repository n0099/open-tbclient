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
    private b.a bAR;
    private b.InterfaceC0216b bEF;
    private b bEG;

    public void ac(View view) {
        if (this.bEG != null) {
            this.bEG.ac(view);
        }
    }

    public void a(w wVar, c cVar) {
        if (this.bEG != null) {
            this.bEG.a(wVar, cVar);
        }
    }

    public void TP() {
        if (this.bEG != null) {
            this.bEG.release();
        }
    }

    public a(b.a aVar, b.InterfaceC0216b interfaceC0216b) {
        this.bAR = aVar;
        this.bEF = interfaceC0216b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bEG == null) {
                this.bEG = new b(this.activity, this.bAR, this.bEF);
            }
            if (this.bEG.getView() != null && this.bEG.getView().getParent() == null) {
                this.bEG.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds220), this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds392));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
                viewGroup.addView(this.bEG.getView(), layoutParams);
            }
        }
    }

    public void onDestroy() {
        if (this.bEG != null) {
            this.bEG.release();
        }
    }
}
