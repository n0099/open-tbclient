package com.baidu.tbadk.core;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k.a {
    final /* synthetic */ TbadkCoreApplication Tw;
    private final /* synthetic */ View yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbadkCoreApplication tbadkCoreApplication, View view) {
        this.Tw = tbadkCoreApplication;
        this.yG = view;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aV(String str) {
        if (jk() instanceof TextView) {
            ((TextView) jk()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jk() {
        return this.yG;
    }
}
