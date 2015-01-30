package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MediaData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ CommonImageLayout Mp;
    private final /* synthetic */ MediaData Mq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonImageLayout commonImageLayout, MediaData mediaData) {
        this.Mp = commonImageLayout;
        this.Mq = mediaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.Mp.mContext;
        com.baidu.tbadk.browser.a.x(context, this.Mq.getVideoUrl());
    }
}
