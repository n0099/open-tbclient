package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserIconBox Iz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(UserIconBox userIconBox) {
        this.Iz = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.Iz.Iu;
            if (bVar != null) {
                bVar2 = this.Iz.Iu;
                bVar2.h((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
