package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox aht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(UserIconBox userIconBox) {
        this.aht = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bh.a(this.aht, false, new al(this, str));
        }
    }
}
