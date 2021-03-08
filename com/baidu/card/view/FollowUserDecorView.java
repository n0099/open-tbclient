package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
/* loaded from: classes.dex */
public class FollowUserDecorView extends FollowUserButton {
    private c alS;
    private boolean alT;
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

    public void setData(cb cbVar) {
        if (cbVar == null || cbVar.bnS() == null) {
            setVisibility(8);
            return;
        }
        if (this.alS == null) {
            this.alS = new c(V(getContext()), this);
            this.alS.l(this.mBdUniqueId);
        }
        setVisibility(0);
        this.alS.a(cbVar.bnS());
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        if (this.alS != null) {
            this.alS.l(this.mBdUniqueId);
        }
    }

    private TbPageContext V(Context context) {
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
        if (this.alT && !z) {
            b bVar = new b();
            bVar.pS(R.color.CAM_X0304);
            setConfig(bVar);
        }
    }

    public void setUseNewStyle(boolean z) {
        this.alT = z;
    }
}
