package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout IE;
    private final int mIndex;

    private ah(UserPhotoLayout userPhotoLayout, int i) {
        this.IE = userPhotoLayout;
        this.mIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(UserPhotoLayout userPhotoLayout, int i, ah ahVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.access$0(this.IE) != null) {
            UserPhotoLayout.access$0(this.IE).bO(this.mIndex);
        }
    }
}
