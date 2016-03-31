package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ String PA;
    private final /* synthetic */ boolean PC;
    private final /* synthetic */ boolean PD;
    private final /* synthetic */ boolean PE;
    private final /* synthetic */ boolean PF;
    private final /* synthetic */ TbPageContext Pz;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Pz = tbPageContext;
        this.val$url = str;
        this.PA = str2;
        this.PC = z;
        this.PD = z2;
        this.PE = z3;
        this.PF = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean pP;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        pP = Static.pP();
        if (!pP) {
            TiebaStatic.eventStat(this.Pz.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Pz, this.val$url, this.PA, this.PC, this.PD, this.PE, this.PF);
        }
    }
}
