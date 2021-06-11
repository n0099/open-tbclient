package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5300a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h[] f5301b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f5302c;

    public n(l lVar, String str, h[] hVarArr) {
        this.f5302c = lVar;
        this.f5300a = str;
        this.f5301b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d(l.f5294a, "====send-success==");
        if (b.o.equals(this.f5300a)) {
            f.a().a(this.f5300a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.f5301b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d(l.f5294a, "====send-fail=====");
    }
}
