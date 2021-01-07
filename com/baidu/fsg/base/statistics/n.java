package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes6.dex */
class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2009a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h[] f2010b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, String str, h[] hVarArr) {
        this.c = lVar;
        this.f2009a = str;
        this.f2010b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d("LogSender", "====send-success==");
        if (b.o.equals(this.f2009a)) {
            f.a().a(this.f2009a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.f2010b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d("LogSender", "====send-fail=====");
    }
}
