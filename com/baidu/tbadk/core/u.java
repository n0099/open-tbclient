package com.baidu.tbadk.core;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ TbadkCoreApplication Ty;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication, View view) {
        this.Ty = tbadkCoreApplication;
        this.yG = view;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aT(String str) {
        if (jl() instanceof TextView) {
            ((TextView) jl()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jl() {
        return this.yG;
    }
}
