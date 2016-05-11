package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    private final /* synthetic */ TbPageContext Kq;
    private final /* synthetic */ String Kr;
    private final /* synthetic */ boolean Ks;
    private final /* synthetic */ boolean Kt;
    private final /* synthetic */ boolean Ku;
    private final /* synthetic */ boolean Kv;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Kq = tbPageContext;
        this.val$url = str;
        this.Kr = str2;
        this.Ks = z;
        this.Kt = z2;
        this.Ku = z3;
        this.Kv = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean nm;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        nm = Static.nm();
        if (!nm) {
            TiebaStatic.eventStat(this.Kq.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Kq, this.val$url, this.Kr, this.Ks, this.Kt, this.Ku, this.Kv);
        }
    }
}
