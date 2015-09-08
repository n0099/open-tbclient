package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ TbPageContext Sk;
    private final /* synthetic */ String Sl;
    private final /* synthetic */ boolean Sm;
    private final /* synthetic */ boolean Sn;
    private final /* synthetic */ boolean So;
    private final /* synthetic */ boolean Sp;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Sk = tbPageContext;
        this.val$url = str;
        this.Sl = str2;
        this.Sm = z;
        this.Sn = z2;
        this.So = z3;
        this.Sp = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qu;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qu = Static.qu();
        if (!qu) {
            TiebaStatic.eventStat(this.Sk.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Sk, this.val$url, this.Sl, this.Sm, this.Sn, this.So, this.Sp);
        }
    }
}
