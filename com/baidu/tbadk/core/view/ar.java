package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout Zq;
    private final int mIndex;

    private ar(UserPhotoLayout userPhotoLayout, int i) {
        this.Zq = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(UserPhotoLayout userPhotoLayout, int i, ar arVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.Zq) != null) {
            UserPhotoLayout.access$0(this.Zq).onChildClickCallback(this.mIndex);
        }
    }
}
