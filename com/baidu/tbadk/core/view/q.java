package com.baidu.tbadk.core.view;

import android.widget.CompoundButton;
import com.baidu.tbadk.core.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ o agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.agb = oVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.a aVar;
        o.a aVar2;
        com.baidu.tieba.card.data.c cVar;
        aVar = this.agb.afV;
        if (aVar != null) {
            aVar2 = this.agb.afV;
            cVar = this.agb.afO;
            aVar2.a(cVar, compoundButton, z);
        }
    }
}
