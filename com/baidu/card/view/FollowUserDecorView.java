package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c akZ;
    private boolean ala;
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

    public void setData(by byVar) {
        if (byVar == null || byVar.boP() == null) {
            setVisibility(8);
            return;
        }
        if (this.akZ == null) {
            this.akZ = new c(X(getContext()), this);
            this.akZ.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.akZ.a(byVar.boP());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.akZ != null) {
            this.akZ.l(this.mBdUniqueId);
        }
    }

    private TbPageContext X(Context context) {
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
        if (this.ala && !z) {
            b bVar = new b();
            bVar.rh(R.color.CAM_X0304);
            setConfig(bVar);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.ala = z;
    }
}
