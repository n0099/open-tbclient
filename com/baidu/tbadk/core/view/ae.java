package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserIconBox afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(UserIconBox userIconBox) {
        this.afB = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.afB.afu;
            if (bVar != null) {
                bVar2 = this.afB.afu;
                bVar2.k((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
