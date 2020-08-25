package com.baidu.live.tieba.pb.interactionpopupwindow;

import android.view.ViewGroup;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes7.dex */
public interface d<D extends IBaseDialogData> {
    void a(D d);

    int getLayout();

    ViewGroup getViewGroup();

    void initView();
}
