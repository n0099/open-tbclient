package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox aeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(UserIconBox userIconBox) {
        this.aeP = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bn.a(this.aeP, false, new aj(this, str));
        }
    }
}
