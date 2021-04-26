package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5503a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h[] f5504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f5505c;

    public n(l lVar, String str, h[] hVarArr) {
        this.f5505c = lVar;
        this.f5503a = str;
        this.f5504b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d(l.f5497a, "====send-success==");
        if (b.o.equals(this.f5503a)) {
            f.a().a(this.f5503a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.f5504b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d(l.f5497a, "====send-fail=====");
    }
}
