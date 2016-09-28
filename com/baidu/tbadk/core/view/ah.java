package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox ahs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(UserIconBox userIconBox) {
        this.ahs = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bm.a(this.ahs, false, new ai(this, str));
        }
    }
}
