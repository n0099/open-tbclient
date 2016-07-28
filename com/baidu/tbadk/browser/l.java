package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    private final /* synthetic */ TbPageContext Kp;
    private final /* synthetic */ String Kq;
    private final /* synthetic */ boolean Kr;
    private final /* synthetic */ boolean Ks;
    private final /* synthetic */ boolean Kt;
    private final /* synthetic */ boolean Ku;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.Kp = tbPageContext;
        this.val$url = str;
        this.Kq = str2;
        this.Kr = z;
        this.Ks = z2;
        this.Kt = z3;
        this.Ku = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean mX;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        mX = Static.mX();
        if (!mX) {
            TiebaStatic.eventStat(this.Kp.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.Kp, this.val$url, this.Kq, this.Kr, this.Ks, this.Kt, this.Ku);
        }
    }
}
