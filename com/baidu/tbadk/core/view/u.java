package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox aeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UserIconBox userIconBox) {
        this.aeP = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bd.a((ViewGroup) this.aeP, false, (bd.a) new v(this, str));
        }
    }
}
