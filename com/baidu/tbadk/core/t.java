package com.baidu.tbadk.core;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.adp.lib.util.q {
    final /* synthetic */ TbadkCoreApplication OW;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbadkCoreApplication tbadkCoreApplication, View view) {
        this.OW = tbadkCoreApplication;
        this.yH = view;
    }

    @Override // com.baidu.adp.lib.util.q
    public void aY(String str) {
        if (js() instanceof TextView) {
            ((TextView) js()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.q
    public View js() {
        return this.yH;
    }
}
