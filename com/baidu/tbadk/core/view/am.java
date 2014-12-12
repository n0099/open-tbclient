package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.util.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox ND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(UserIconBox userIconBox) {
        this.ND = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bp.a(this.ND, false, new an(this, str));
        }
    }
}
