package com.baidu.live.gift;

import android.content.DialogInterface;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public interface x {
    void a(g gVar);

    void d(com.baidu.live.data.m mVar);

    void initView();

    boolean isShowing();

    void resize();

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOtherParams(String str);

    void setPageContext(TbPageContext tbPageContext);

    void show();
}
