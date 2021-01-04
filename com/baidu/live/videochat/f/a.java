package com.baidu.live.videochat.f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.videochat.f.b;
/* loaded from: classes11.dex */
public class a {
    private Activity activity;
    private b.a bPl;
    private b.InterfaceC0233b bSw;
    private b bSx;
    private com.baidu.live.follow.pendant.a bSy;

    public void ag(View view) {
        if (this.bSx != null) {
            this.bSx.ag(view);
        }
        if (this.bSy != null) {
            this.bSy.m(Zo());
        }
    }

    public void a(x xVar, c cVar) {
        if (this.bSx != null) {
            this.bSx.a(xVar, cVar);
        }
        if (this.bSy != null) {
            this.bSy.n(cVar.getAvatar(), cVar.getNickName(), cVar.getUserId());
        }
    }

    public void Zn() {
        if (this.bSx != null) {
            this.bSx.release();
        }
        if (this.bSy != null) {
            this.bSy.FX();
        }
    }

    public a(b.a aVar, b.InterfaceC0233b interfaceC0233b) {
        this.bPl = aVar;
        this.bSw = interfaceC0233b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bSx == null) {
                this.bSx = new b(this.activity, this.bPl, this.bSw);
            }
            if (this.bSx.getView() != null && this.bSx.getView().getParent() == null) {
                this.bSx.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds200), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds440));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bSx.getView(), layoutParams);
            }
            if (this.bSy == null) {
                this.bSy = new com.baidu.live.follow.pendant.a(this.activity);
            }
        }
    }

    public FrameLayout Zo() {
        if (this.bSx != null) {
            return this.bSx.Zo();
        }
        return null;
    }

    public void onDestroy() {
        if (this.bSx != null) {
            this.bSx.release();
        }
        if (this.bSy != null) {
            this.bSy.onDestroy();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bSx != null && this.bSx.getView() != null) {
            this.bSx.getView().setVisibility(z ? 4 : 0);
            if (this.bSy != null) {
                this.bSy.onKeyboardVisibilityChanged(z);
            }
        }
    }
}
