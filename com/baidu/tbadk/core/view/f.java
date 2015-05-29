package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout Yi;
    private final /* synthetic */ MediaData Yj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.Yi = commonImageLayout;
        this.Yj = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.Yi.mContext;
        com.baidu.tbadk.browser.f.x(context, this.Yj.getVideoUrl());
    }
}
