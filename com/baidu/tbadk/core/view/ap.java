package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout aih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserPhotoLayout userPhotoLayout) {
        this.aih = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.aih.mUserPhotoPool;
            if (bVar != null) {
                bVar2 = this.aih.mUserPhotoPool;
                bVar2.n((HeadImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
