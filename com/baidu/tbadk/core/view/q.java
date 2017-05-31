package com.baidu.tbadk.core.view;

import android.widget.CompoundButton;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ o ajB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.ajB = oVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.a aVar;
        o.a aVar2;
        com.baidu.tbadk.core.data.an anVar;
        aVar = this.ajB.ajq;
        if (aVar != null) {
            aVar2 = this.ajB.ajq;
            anVar = this.ajB.ajk;
            aVar2.a(anVar, compoundButton, z);
        }
    }
}
