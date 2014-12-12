package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout LV;
    private final /* synthetic */ MediaData LW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.LV = commonImageLayout;
        this.LW = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.LV.mContext;
        com.baidu.tbadk.browser.a.y(context, this.LW.getVideoUrl());
    }
}
