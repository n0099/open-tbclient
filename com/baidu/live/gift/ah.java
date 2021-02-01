package com.baidu.live.gift;

import android.content.DialogInterface;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public interface ah {
    void initView();

    boolean isShowing();

    void resize();

    void setGiftItem(g gVar);

    void setLiveShowData(com.baidu.live.data.ab abVar);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOtherParams(String str);

    void setPageContext(TbPageContext tbPageContext);

    void show();
}
