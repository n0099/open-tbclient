package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout NF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UserPhotoLayout userPhotoLayout) {
        this.NF = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.NF.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.NF.mUserPhotoPool;
                bVar2.j((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
