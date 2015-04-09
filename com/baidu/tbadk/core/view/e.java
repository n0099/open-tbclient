package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout Xv;
    private final /* synthetic */ MediaData Xw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.Xv = commonImageLayout;
        this.Xw = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.Xv.mContext;
        com.baidu.tbadk.browser.f.x(context, this.Xw.getVideoUrl());
    }
}
