package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox aeO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UserIconBox userIconBox) {
        this.aeO = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bc.a((ViewGroup) this.aeO, false, (bc.a) new v(this, str));
        }
    }
}
