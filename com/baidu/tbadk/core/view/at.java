package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout Od;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UserPhotoLayout userPhotoLayout) {
        this.Od = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.Od.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.Od.mUserPhotoPool;
                bVar2.j((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
