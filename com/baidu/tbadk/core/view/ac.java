package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserPhotoLayout a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(UserPhotoLayout userPhotoLayout) {
        this.a = userPhotoLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.d.b bVar;
        com.baidu.adp.lib.d.b bVar2;
        if (view2 instanceof HeadImageView) {
            bVar = this.a.a;
            if (bVar != null) {
                bVar2 = this.a.a;
                bVar2.a((com.baidu.adp.lib.d.b) ((HeadImageView) view2));
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
