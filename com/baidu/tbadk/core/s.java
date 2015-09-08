package com.baidu.tbadk.core;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements k.a {
    final /* synthetic */ TbadkCoreApplication TK;
    private final /* synthetic */ View yF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbadkCoreApplication tbadkCoreApplication, View view) {
        this.TK = tbadkCoreApplication;
        this.yF = view;
    }

    @Override // com.baidu.adp.lib.util.k.a
    public void aU(String str) {
        if (jj() instanceof TextView) {
            ((TextView) jj()).setText(str);
        }
    }

    @Override // com.baidu.adp.lib.util.k.a
    public View jj() {
        return this.yF;
    }
}
