package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    private final /* synthetic */ TbPageContext MA;
    private final /* synthetic */ String MB;
    private final /* synthetic */ boolean MC;
    private final /* synthetic */ boolean MD;
    private final /* synthetic */ boolean ME;
    private final /* synthetic */ boolean MF;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.MA = tbPageContext;
        this.val$url = str;
        this.MB = str2;
        this.MC = z;
        this.MD = z2;
        this.ME = z3;
        this.MF = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean nS;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        nS = Static.nS();
        if (!nS) {
            TiebaStatic.eventStat(this.MA.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.MA, this.val$url, this.MB, this.MC, this.MD, this.ME, this.MF);
        }
    }
}
