package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox ahJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(UserIconBox userIconBox) {
        this.ahJ = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bl.a(this.ahJ, false, new ah(this, str));
        }
    }
}
