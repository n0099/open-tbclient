package com.baidu.live.gift;

import android.content.DialogInterface;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes7.dex */
public interface z {
    void d(com.baidu.live.data.r rVar);

    void initView();

    boolean isShowing();

    void resize();

    void setGiftItem(g gVar);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOtherParams(String str);

    void setPageContext(TbPageContext tbPageContext);

    void show();
}
