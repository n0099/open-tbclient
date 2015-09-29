package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserIconBox aeO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(UserIconBox userIconBox) {
        this.aeO = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.e.b bVar;
        com.baidu.adp.lib.e.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.aeO.aeH;
            if (bVar != null) {
                bVar2 = this.aeO.aeH;
                bVar2.k((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
