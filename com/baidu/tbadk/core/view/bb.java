package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout amH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UserPhotoLayout userPhotoLayout) {
        this.amH = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.amH.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.amH.mUserPhotoPool;
                bVar2.n((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
