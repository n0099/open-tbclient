package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout Zq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserPhotoLayout userPhotoLayout) {
        this.Zq = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.Zq.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.Zq.mUserPhotoPool;
                bVar2.j((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
