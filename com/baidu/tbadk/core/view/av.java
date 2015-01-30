package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class av implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout Og;
    private final int mIndex;

    private av(UserPhotoLayout userPhotoLayout, int i) {
        this.Og = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(UserPhotoLayout userPhotoLayout, int i, av avVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.Og) != null) {
            UserPhotoLayout.access$0(this.Og).onChildClickCallback(this.mIndex);
        }
    }
}
