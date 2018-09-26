package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.s;
import com.baidu.fsg.base.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class o implements s.a {
    final /* synthetic */ String a;
    final /* synthetic */ h[] b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, String str, h[] hVarArr) {
        this.c = lVar;
        this.a = str;
        this.b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.s.a
    public void a() {
        LogUtil.d("LogSender", "====send-success==");
        if (b.o.equals(this.a)) {
            f.a().a(this.a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.s.a
    public void b() {
        LogUtil.d("LogSender", "====send-fail=====");
    }
}
