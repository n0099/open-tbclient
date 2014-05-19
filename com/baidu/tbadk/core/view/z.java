package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout a;
    private final int b;

    private z(UserPhotoLayout userPhotoLayout, int i) {
        this.a = userPhotoLayout;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(UserPhotoLayout userPhotoLayout, int i, z zVar) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (UserPhotoLayout.a(this.a) != null) {
            UserPhotoLayout.a(this.a).a(this.b);
        }
    }
}
