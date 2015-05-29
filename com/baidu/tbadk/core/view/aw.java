package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout aar;
    private final int mIndex;

    private aw(UserPhotoLayout userPhotoLayout, int i) {
        this.aar = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(UserPhotoLayout userPhotoLayout, int i, aw awVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.aar) != null) {
            UserPhotoLayout.access$0(this.aar).onChildClickCallback(this.mIndex);
        }
    }
}
