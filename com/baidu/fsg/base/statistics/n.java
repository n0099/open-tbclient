package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes5.dex */
class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1542a;
    final /* synthetic */ h[] b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, String str, h[] hVarArr) {
        this.c = lVar;
        this.f1542a = str;
        this.b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d("LogSender", "====send-success==");
        if (b.o.equals(this.f1542a)) {
            f.a().a(this.f1542a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d("LogSender", "====send-fail=====");
    }
}
