package com.baidu.tbadk.core.relogin;

import com.baidu.adp.framework.c.b;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends b {
    final /* synthetic */ ReloginManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ReloginManager reloginManager, int i) {
        super(1002001);
        this.a = reloginManager;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        ArrayList arrayList;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || !(httpResponsedMessage2 instanceof ReloginManager.BgLoginHttpResponsedMessage)) {
            return;
        }
        this.a.a = false;
        ReloginManager.BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (ReloginManager.BgLoginHttpResponsedMessage) httpResponsedMessage2;
        int d = bgLoginHttpResponsedMessage.d();
        int e = bgLoginHttpResponsedMessage.e();
        if ((d != 200 || e == 0) && d == 200) {
            ReloginManager.b(this.a);
            return;
        }
        AccountData N = TbadkApplication.N();
        ReloginManager reloginManager = this.a;
        ReloginManager.a(N);
        if (bgLoginHttpResponsedMessage.f() != null) {
            i.a(TbadkApplication.j().c(), bgLoginHttpResponsedMessage.f());
        }
        arrayList = this.a.c;
        arrayList.clear();
    }
}
