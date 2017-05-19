package com.baidu.tbadk.core.view;

import android.widget.CompoundButton;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ o ajL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.ajL = oVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.am amVar;
        aVar = this.ajL.ajA;
        if (aVar != null) {
            aVar2 = this.ajL.ajA;
            amVar = this.ajL.aju;
            aVar2.a(amVar, compoundButton, z);
        }
    }
}
