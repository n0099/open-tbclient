package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.util.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bx.a((ViewGroup) this.a, false, (bz) new s(this, str));
        }
    }
}
