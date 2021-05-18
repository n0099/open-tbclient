package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h[] f5358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f5359c;

    public n(l lVar, String str, h[] hVarArr) {
        this.f5359c = lVar;
        this.f5357a = str;
        this.f5358b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d(l.f5351a, "====send-success==");
        if (b.o.equals(this.f5357a)) {
            f.a().a(this.f5357a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.f5358b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d(l.f5351a, "====send-fail=====");
    }
}
