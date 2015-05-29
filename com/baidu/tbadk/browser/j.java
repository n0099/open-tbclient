package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    private final /* synthetic */ TbPageContext NC;
    private final /* synthetic */ String ND;
    private final /* synthetic */ boolean NE;
    private final /* synthetic */ boolean NF;
    private final /* synthetic */ boolean NG;
    private final /* synthetic */ boolean NH;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.NC = tbPageContext;
        this.val$url = str;
        this.ND = str2;
        this.NE = z;
        this.NF = z2;
        this.NG = z3;
        this.NH = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean pw;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        pw = Static.pw();
        if (!pw) {
            TiebaStatic.eventStat(this.NC.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.NC, this.val$url, this.ND, this.NE, this.NF, this.NG, this.NH);
        }
    }
}
