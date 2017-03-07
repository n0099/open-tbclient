package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox alZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconBox userIconBox) {
        this.alZ = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bg.a(this.alZ, false, new an(this, str));
        }
    }
}
