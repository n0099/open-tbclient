package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox ahS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(UserIconBox userIconBox) {
        this.ahS = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bk.a(this.ahS, false, new aj(this, str));
        }
    }
}
