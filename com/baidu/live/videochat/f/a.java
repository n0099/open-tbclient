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
/* loaded from: classes11.dex */
public class a {
    private Activity activity;
    private b.a bOj;
    private b.InterfaceC0226b bRA;
    private b bRB;
    private com.baidu.live.follow.pendant.a bRC;

    public void ag(View view) {
        if (this.bRB != null) {
            this.bRB.ag(view);
        }
        if (this.bRC != null) {
            this.bRC.m(Xf());
        }
    }

    public void a(ab abVar, c cVar) {
        if (this.bRB != null) {
            this.bRB.a(abVar, cVar);
        }
        if (this.bRC != null) {
            this.bRC.m(cVar.getAvatar(), cVar.getNickName(), cVar.getUserId());
        }
    }

    public void Xe() {
        if (this.bRB != null) {
            this.bRB.release();
        }
        if (this.bRC != null) {
            this.bRC.Dr();
        }
    }

    public a(b.a aVar, b.InterfaceC0226b interfaceC0226b) {
        this.bOj = aVar;
        this.bRA = interfaceC0226b;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (tbPageContext != null) {
            this.activity = tbPageContext.getPageActivity();
        }
        if (this.activity != null && viewGroup != null) {
            if (this.bRB == null) {
                this.bRB = new b(this.activity, this.bOj, this.bRA);
            }
            if (this.bRB.getView() != null && this.bRB.getView().getParent() == null) {
                this.bRB.getView().setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds200), this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds440));
                layoutParams.topMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds274);
                layoutParams.leftMargin = this.activity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
                viewGroup.addView(this.bRB.getView(), layoutParams);
            }
            if (this.bRC == null) {
                this.bRC = new com.baidu.live.follow.pendant.a(this.activity);
            }
        }
    }

    public FrameLayout Xf() {
        if (this.bRB != null) {
            return this.bRB.Xf();
        }
        return null;
    }

    public void onDestroy() {
        if (this.bRB != null) {
            this.bRB.release();
        }
        if (this.bRC != null) {
            this.bRC.onDestroy();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bRB != null && this.bRB.getView() != null) {
            this.bRB.getView().setVisibility(z ? 4 : 0);
            if (this.bRC != null) {
                this.bRC.onKeyboardVisibilityChanged(z);
            }
        }
    }
}
