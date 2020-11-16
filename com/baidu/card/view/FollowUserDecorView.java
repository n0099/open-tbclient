package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes20.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c ajZ;
    private boolean aka;
    private BdUniqueId mBdUniqueId;

    public FollowUserDecorView(Context context) {
        super(context);
    }

    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FollowUserDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setData(bx bxVar) {
        if (bxVar == null || bxVar.blC() == null) {
            setVisibility(8);
            return;
        }
        if (this.ajZ == null) {
            this.ajZ = new c(W(getContext()), this);
            this.ajZ.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.ajZ.a(bxVar.blC());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajZ != null) {
            this.ajZ.l(this.mBdUniqueId);
        }
    }

    private TbPageContext W(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    @Override // com.baidu.tieba.view.FollowUserButton
    public void aP(boolean z) {
        super.aP(z);
        if (this.aka && !z) {
            b bVar = new b();
            bVar.qG(R.color.CAM_X0304);
            setConfig(bVar);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.aka = z;
    }
}
