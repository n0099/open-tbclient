package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox Iz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(UserIconBox userIconBox) {
        this.Iz = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bn.a(this.Iz, false, new aa(this, str));
        }
    }
}
