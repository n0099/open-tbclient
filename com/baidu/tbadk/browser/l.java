package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    private final /* synthetic */ TbPageContext MB;
    private final /* synthetic */ String MC;
    private final /* synthetic */ boolean MD;
    private final /* synthetic */ boolean ME;
    private final /* synthetic */ boolean MF;
    private final /* synthetic */ boolean MG;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.MB = tbPageContext;
        this.val$url = str;
        this.MC = str2;
        this.MD = z;
        this.ME = z2;
        this.MF = z3;
        this.MG = z4;
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
            TiebaStatic.eventStat(this.MB.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.MB, this.val$url, this.MC, this.MD, this.ME, this.MF, this.MG);
        }
    }
}
