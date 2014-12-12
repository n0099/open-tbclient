package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout NF;
    private final int mIndex;

    private au(UserPhotoLayout userPhotoLayout, int i) {
        this.NF = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(UserPhotoLayout userPhotoLayout, int i, au auVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.NF) != null) {
            UserPhotoLayout.access$0(this.NF).onChildClickCallback(this.mIndex);
        }
    }
}
