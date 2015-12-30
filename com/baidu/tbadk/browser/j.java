package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    private final /* synthetic */ TbPageContext SL;
    private final /* synthetic */ String SM;
    private final /* synthetic */ boolean SN;
    private final /* synthetic */ boolean SO;
    private final /* synthetic */ boolean SP;
    private final /* synthetic */ boolean SQ;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.SL = tbPageContext;
        this.val$url = str;
        this.SM = str2;
        this.SN = z;
        this.SO = z2;
        this.SP = z3;
        this.SQ = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qh;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qh = Static.qh();
        if (!qh) {
            TiebaStatic.eventStat(this.SL.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.SL, this.val$url, this.SM, this.SN, this.SO, this.SP, this.SQ);
        }
    }
}
