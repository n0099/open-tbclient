package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ UserIconBox ahs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(UserIconBox userIconBox) {
        this.ahs = userIconBox;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        com.baidu.adp.lib.f.b bVar;
        com.baidu.adp.lib.f.b bVar2;
        if (view2 instanceof TbImageView) {
            bVar = this.ahs.ahk;
            if (bVar != null) {
                bVar2 = this.ahs.ahk;
                bVar2.n((TbImageView) view2);
            }
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
    }
}
