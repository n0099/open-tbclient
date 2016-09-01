package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox ahK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(UserIconBox userIconBox) {
        this.ahK = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bn.a(this.ahK, false, new ak(this, str));
        }
    }
}
