package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox afB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(UserIconBox userIconBox) {
        this.afB = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bb.a((ViewGroup) this.afB, false, (bb.a) new ad(this, str));
        }
    }
}
