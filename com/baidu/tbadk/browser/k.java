package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ TbPageContext Se;
    private final /* synthetic */ String Sf;
    private final /* synthetic */ boolean Sg;
    private final /* synthetic */ boolean Sh;
    private final /* synthetic */ boolean Si;
    private final /* synthetic */ boolean Sj;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Se = tbPageContext;
        this.val$url = str;
        this.Sf = str2;
        this.Sg = z;
        this.Sh = z2;
        this.Si = z3;
        this.Sj = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qB;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qB = Static.qB();
        if (!qB) {
            TiebaStatic.eventStat(this.Se.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Se, this.val$url, this.Sf, this.Sg, this.Sh, this.Si, this.Sj);
        }
    }
}
