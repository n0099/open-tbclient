package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public interface d {
    void eq(boolean z);

    ClickableHeaderImageView getHeaderImg();

    boolean getIsSimpleThread();

    TextView getUserName();

    boolean setData(bh bhVar);

    void setPageUniqueId(BdUniqueId bdUniqueId);

    void setUserAfterClickListener(View.OnClickListener onClickListener);
}
