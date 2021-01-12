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
/* loaded from: classes10.dex */
public class a {
    private Activity activity;
    private b.a bKz;
    private b.InterfaceC0224b bNK;
    private b bNL;
    private com.baidu.live.follow.pendant.a bNM;

    public void ag(View view) {
        if (this.bNL != null) {
            this.bNL.ag(view);
        }
        if (this.bNM != null) {
            this.bNM.m(Vw());
        }
    }

    public void a(x xVar, c cVar) {
        if (this.bNL != null) {
            this.bNL.a(xVar, cVar);
        }
        if (this.bNM != null) {
            this.bNM.m(cVar.getAvatar(), cVar.getNickName(), cVar.getUserId());
        }
    }

    public void Vv() {
        if (this.bNL != null) {
            this.bNL.release();
        }
        if (this.bNM != null) {
            this.bNM.Cc();
        }
    }

    public a(b.a aVar, b.InterfaceC0224b interfaceC0224b) {
        this.bKz = aVar;
        this.bNK = interfaceC0224b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bNL == null) {
                this.bNL = new b(this.activity, this.bKz, this.bNK);
            }
            if (this.bNL.getView() != null && this.bNL.getView().getParent() == null) {
                this.bNL.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds200), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds440));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bNL.getView(), layoutParams);
            }
            if (this.bNM == null) {
                this.bNM = new com.baidu.live.follow.pendant.a(this.activity);
            }
        }
    }

    public FrameLayout Vw() {
        if (this.bNL != null) {
            return this.bNL.Vw();
        }
        return null;
    }

    public void onDestroy() {
        if (this.bNL != null) {
            this.bNL.release();
        }
        if (this.bNM != null) {
            this.bNM.onDestroy();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bNL != null && this.bNL.getView() != null) {
            this.bNL.getView().setVisibility(z ? 4 : 0);
            if (this.bNM != null) {
                this.bNM.onKeyboardVisibilityChanged(z);
            }
        }
    }
}
