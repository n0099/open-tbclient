package com.baidu.live.gift;

import android.content.DialogInterface;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public interface af {
    void initView();

    boolean isShowing();

    void resize();

    void setGiftItem(g gVar);

    void setLiveShowData(com.baidu.live.data.w wVar);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOtherParams(String str);

    void setPageContext(TbPageContext tbPageContext);

    void show();
}
