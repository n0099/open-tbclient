package com.baidu.tbadk.core.view;

import android.widget.CompoundButton;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ o ajZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.ajZ = oVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.am amVar;
        aVar = this.ajZ.ajO;
        if (aVar != null) {
            aVar2 = this.ajZ.ajO;
            amVar = this.ajZ.ajI;
            aVar2.a(amVar, compoundButton, z);
        }
    }
}
