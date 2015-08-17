package com.baidu.tbadk.core;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements k.a {
    final /* synthetic */ TbadkCoreApplication TJ;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbadkCoreApplication tbadkCoreApplication, View view) {
        this.TJ = tbadkCoreApplication;
        this.yH = view;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aU(String str) {
        if (jm() instanceof TextView) {
            ((TextView) jm()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jm() {
        return this.yH;
    }
}
