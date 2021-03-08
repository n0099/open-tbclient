package com.baidu.live.videochat.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.videochat.f.b;
/* loaded from: classes10.dex */
public class a {
    private Activity activity;
    private b.a bPJ;
    private b.InterfaceC0232b bTa;
    private b bTb;
    private com.baidu.live.follow.pendant.a bTc;

    public void ag(View view) {
        if (this.bTb != null) {
            this.bTb.ag(view);
        }
        if (this.bTc != null) {
            this.bTc.m(Xi());
        }
    }

    public void a(ab abVar, c cVar) {
        if (this.bTb != null) {
            this.bTb.a(abVar, cVar);
        }
        if (this.bTc != null) {
            this.bTc.m(cVar.getAvatar(), cVar.getNickName(), cVar.getUserId());
        }
    }

    public void Xh() {
        if (this.bTb != null) {
            this.bTb.release();
        }
        if (this.bTc != null) {
            this.bTc.Du();
        }
    }

    public a(b.a aVar, b.InterfaceC0232b interfaceC0232b) {
        this.bPJ = aVar;
        this.bTa = interfaceC0232b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bTb == null) {
                this.bTb = new b(this.activity, this.bPJ, this.bTa);
            }
            if (this.bTb.getView() != null && this.bTb.getView().getParent() == null) {
                this.bTb.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds200), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds440));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bTb.getView(), layoutParams);
            }
            if (this.bTc == null) {
                this.bTc = new com.baidu.live.follow.pendant.a(this.activity);
            }
        }
    }

    public FrameLayout Xi() {
        if (this.bTb != null) {
            return this.bTb.Xi();
        }
        return null;
    }

    public void onDestroy() {
        if (this.bTb != null) {
            this.bTb.release();
        }
        if (this.bTc != null) {
            this.bTc.onDestroy();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bTb != null && this.bTb.getView() != null) {
            this.bTb.getView().setVisibility(z ? 4 : 0);
            if (this.bTc != null) {
                this.bTc.onKeyboardVisibilityChanged(z);
            }
        }
    }
}
