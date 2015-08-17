package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout adg;
    private final /* synthetic */ MediaData adh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.adg = commonImageLayout;
        this.adh = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.adg.mContext;
        com.baidu.tbadk.browser.f.B(context, this.adh.getVideoUrl());
    }
}
