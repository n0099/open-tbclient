package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox agG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(UserIconBox userIconBox) {
        this.agG = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bf.a(this.agG, false, new am(this, str));
        }
    }
}
