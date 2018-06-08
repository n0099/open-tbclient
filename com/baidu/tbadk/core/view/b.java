package com.baidu.tbadk.core.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public interface b {
    ClickableHeaderImageView getHeaderImg();

    boolean getIsSimpleThread();

    TextView getUserName();

    boolean setData(bd bdVar);

    void setPageUniqueId(BdUniqueId bdUniqueId);

    void setUserAfterClickListener(View.OnClickListener onClickListener);

    void showForumNameView(boolean z);
}
