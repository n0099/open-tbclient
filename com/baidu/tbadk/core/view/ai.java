package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox adD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(UserIconBox userIconBox) {
        this.adD = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bl.a(this.adD, false, new aj(this, str));
        }
    }
}
