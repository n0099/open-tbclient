package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout aar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(UserPhotoLayout userPhotoLayout) {
        this.aar = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.aar.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.aar.mUserPhotoPool;
                bVar2.j((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
