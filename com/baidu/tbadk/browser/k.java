package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ TbPageContext RX;
    private final /* synthetic */ String RY;
    private final /* synthetic */ boolean RZ;
    private final /* synthetic */ boolean Sa;
    private final /* synthetic */ boolean Sb;
    private final /* synthetic */ boolean Sc;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.RX = tbPageContext;
        this.val$url = str;
        this.RY = str2;
        this.RZ = z;
        this.Sa = z2;
        this.Sb = z3;
        this.Sc = z4;
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
            TiebaStatic.eventStat(this.RX.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.RX, this.val$url, this.RY, this.RZ, this.Sa, this.Sb, this.Sc);
        }
    }
}
