package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes8.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c ahX;
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

    public void setData(bu buVar) {
        if (buVar == null || buVar.aSp() == null) {
            setVisibility(8);
            return;
        }
        if (this.ahX == null) {
            this.ahX = new c(T(getContext()), this);
            this.ahX.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.ahX.a(buVar.aSp());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.ahX != null) {
            this.ahX.l(this.mBdUniqueId);
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
}
