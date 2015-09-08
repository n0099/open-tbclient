package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout adq;
    private final /* synthetic */ MediaData adr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.adq = commonImageLayout;
        this.adr = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.adq.mContext;
        com.baidu.tbadk.browser.g.B(context, this.adr.getVideoUrl());
    }
}
