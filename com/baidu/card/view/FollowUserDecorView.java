package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes15.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c ahO;
    private boolean ahP;
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

    public void setData(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null) {
            setVisibility(8);
            return;
        }
        if (this.ahO == null) {
            this.ahO = new c(T(getContext()), this);
            this.ahO.m(this.mBdUniqueId);
        }
        setVisibility(0);
        this.ahO.a(bvVar.aWl());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ahO != null) {
            this.ahO.m(this.mBdUniqueId);
        }
    }

    private TbPageContext T(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    @Override // com.baidu.tieba.view.FollowUserButton
    public void aM(boolean z) {
        super.aM(z);
        if (this.ahP && !z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mV(R.color.cp_link_tip_a);
            cVar.mR(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
            cVar.k(R.drawable.icon_pure_add12_svg, 0, true);
            setConfig(cVar);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.ahP = z;
    }
}
