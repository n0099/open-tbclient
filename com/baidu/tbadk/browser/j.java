package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    private final /* synthetic */ TbPageContext Sn;
    private final /* synthetic */ String So;
    private final /* synthetic */ boolean Sp;
    private final /* synthetic */ boolean Sq;
    private final /* synthetic */ boolean Sr;
    private final /* synthetic */ boolean Ss;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Sn = tbPageContext;
        this.val$url = str;
        this.So = str2;
        this.Sp = z;
        this.Sq = z2;
        this.Sr = z3;
        this.Ss = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qA;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qA = Static.qA();
        if (!qA) {
            TiebaStatic.eventStat(this.Sn.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Sn, this.val$url, this.So, this.Sp, this.Sq, this.Sr, this.Ss);
        }
    }
}
