package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.q;
import com.baidu.fsg.base.utils.LogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n implements q.a {
    final /* synthetic */ String a;
    final /* synthetic */ h[] b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, String str, h[] hVarArr) {
        this.c = lVar;
        this.a = str;
        this.b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.q.a
    public void a() {
        LogUtil.d("LogSender", "====send-success==");
        if (b.o.equals(this.a)) {
            f.a().a(this.a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.q.a
    public void b() {
        LogUtil.d("LogSender", "====send-fail=====");
    }
}
