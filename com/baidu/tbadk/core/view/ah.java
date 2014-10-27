package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout IC;
    private final int mIndex;

    private ah(UserPhotoLayout userPhotoLayout, int i) {
        this.IC = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(UserPhotoLayout userPhotoLayout, int i, ah ahVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.IC) != null) {
            UserPhotoLayout.access$0(this.IC).bO(this.mIndex);
        }
    }
}
