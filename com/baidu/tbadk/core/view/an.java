package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox Od;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserIconBox userIconBox) {
        this.Od = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bu.a(this.Od, false, new ao(this, str));
        }
    }
}
