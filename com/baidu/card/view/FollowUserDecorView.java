package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import d.a.m0.r.f0.m.b;
import d.a.m0.r.f0.q.c;
import d.a.m0.r.q.a2;
/* loaded from: classes.dex */
public class FollowUserDecorView extends FollowUserButton {
    public BdUniqueId v;
    public c w;
    public boolean x;

    public FollowUserDecorView(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.FollowUserButton
    public void s(boolean z) {
        super.s(z);
        if (!this.x || z) {
            return;
        }
        b bVar = new b();
        bVar.q(R.color.CAM_X0304);
        setConfig(bVar);
    }

    public void setData(a2 a2Var) {
        if (a2Var != null && a2Var.T() != null) {
            if (this.w == null) {
                c cVar = new c(t(getContext()), this);
                this.w = cVar;
                cVar.l(this.v);
            }
            setVisibility(0);
            this.w.p(true);
            this.w.n(a2Var.T());
            return;
        }
        setVisibility(8);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.v = bdUniqueId;
        c cVar = this.w;
        if (cVar != null) {
            cVar.l(bdUniqueId);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.x = z;
    }

    public final TbPageContext t(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
