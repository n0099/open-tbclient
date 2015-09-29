package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ TbPageContext RW;
    private final /* synthetic */ String RX;
    private final /* synthetic */ boolean RY;
    private final /* synthetic */ boolean RZ;
    private final /* synthetic */ boolean Sa;
    private final /* synthetic */ boolean Sb;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.RW = tbPageContext;
        this.val$url = str;
        this.RX = str2;
        this.RY = z;
        this.RZ = z2;
        this.Sa = z3;
        this.Sb = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qq;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qq = Static.qq();
        if (!qq) {
            TiebaStatic.eventStat(this.RW.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.RW, this.val$url, this.RX, this.RY, this.RZ, this.Sa, this.Sb);
        }
    }
}
