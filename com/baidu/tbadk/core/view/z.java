package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox IA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(UserIconBox userIconBox) {
        this.IA = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bo.a(this.IA, false, new aa(this, str));
        }
    }
}
