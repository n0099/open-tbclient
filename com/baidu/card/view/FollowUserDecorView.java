package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c agS;
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

    public void setData(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null) {
            setVisibility(8);
            return;
        }
        if (this.agS == null) {
            this.agS = new c(S(getContext()), this);
            this.agS.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.agS.a(bkVar.aQx());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.agS != null) {
            this.agS.l(this.mBdUniqueId);
        }
    }

    private TbPageContext S(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }
}
