package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout Xt;
    private final /* synthetic */ MediaData Xu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.Xt = commonImageLayout;
        this.Xu = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.Xt.mContext;
        com.baidu.tbadk.browser.f.x(context, this.Xu.getVideoUrl());
    }
}
