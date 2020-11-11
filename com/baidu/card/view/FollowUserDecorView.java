package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes21.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c ajW;
    private boolean ajX;
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

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.bmA() == null) {
            setVisibility(8);
            return;
        }
        if (this.ajW == null) {
            this.ajW = new c(W(getContext()), this);
            this.ajW.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.ajW.a(bwVar.bmA());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ajW != null) {
            this.ajW.l(this.mBdUniqueId);
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
    public void aN(boolean z) {
        super.aN(z);
        if (this.ajX && !z) {
            b bVar = new b();
            bVar.qi(R.color.cp_link_tip_a);
            bVar.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
            bVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.ajX = z;
    }
}
