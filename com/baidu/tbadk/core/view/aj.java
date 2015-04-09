package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox Zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(UserIconBox userIconBox) {
        this.Zn = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bs.a(this.Zn, false, new ak(this, str));
        }
    }
}
