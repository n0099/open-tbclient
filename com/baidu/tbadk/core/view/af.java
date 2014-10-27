package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout IC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(UserPhotoLayout userPhotoLayout) {
        this.IC = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.IC.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.IC.mUserPhotoPool;
                bVar2.h((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
