package com.baidu.tbadk.core.view;

import android.widget.CompoundButton;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ o akn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.akn = oVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.al alVar;
        aVar = this.akn.akc;
        if (aVar != null) {
            aVar2 = this.akn.akc;
            alVar = this.akn.ajW;
            aVar2.a(alVar, compoundButton, z);
        }
    }
}
