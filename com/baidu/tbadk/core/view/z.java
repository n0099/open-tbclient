package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox ahE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(UserIconBox userIconBox) {
        this.ahE = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bi.a(this.ahE, false, new aa(this, str));
        }
    }
}
