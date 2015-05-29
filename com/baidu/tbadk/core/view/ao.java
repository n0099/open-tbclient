package com.baidu.tbadk.core.view;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.util.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox aao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserIconBox userIconBox) {
        this.aao = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null && str != null) {
            bq.a((ViewGroup) this.aao, false, (bs) new ap(this, str));
        }
    }
}
