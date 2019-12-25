package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public interface c {
    void fF(boolean z);

    ClickableHeaderImageView getHeaderImg();

    boolean getIsSimpleThread();

    boolean setData(bj bjVar);

    void setPageUniqueId(BdUniqueId bdUniqueId);

    void setUserAfterClickListener(View.OnClickListener onClickListener);
}
