package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout aib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserPhotoLayout userPhotoLayout) {
        this.aib = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.aib.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.aib.mUserPhotoPool;
                bVar2.k((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
