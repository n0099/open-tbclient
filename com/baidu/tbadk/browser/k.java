package com.baidu.tbadk.browser;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    private final /* synthetic */ TbPageContext RY;
    private final /* synthetic */ String RZ;
    private final /* synthetic */ boolean Sa;
    private final /* synthetic */ boolean Sb;
    private final /* synthetic */ boolean Sc;
    private final /* synthetic */ boolean Sd;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.RY = tbPageContext;
        this.val$url = str;
        this.RZ = str2;
        this.Sa = z;
        this.Sb = z2;
        this.Sc = z3;
        this.Sd = z4;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean qo;
        super.handleMessage(message);
        if (message.what != 1) {
            return;
        }
        qo = Static.qo();
        if (!qo) {
            TiebaStatic.eventStat(this.RY.getPageActivity(), "url_3", null);
        } else {
            Static.c(this.RY, this.val$url, this.RZ, this.Sa, this.Sb, this.Sc, this.Sd);
        }
    }
}
