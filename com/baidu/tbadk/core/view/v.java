package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ UserIconBox afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(UserIconBox userIconBox) {
        this.afR = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bj.a((ViewGroup) this.afR, false, (bj.a) new w(this, str));
        }
    }
}
