package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class n implements r.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h[] f5366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f5367c;

    public n(l lVar, String str, h[] hVarArr) {
        this.f5367c = lVar;
        this.f5365a = str;
        this.f5366b = hVarArr;
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void a() {
        LogUtil.d(l.f5359a, "====send-success==");
        if (b.o.equals(this.f5365a)) {
            f.a().a(this.f5365a);
        } else {
            i.a(RimStatisticsUtil.getAppContext()).a(this.f5366b);
        }
    }

    @Override // com.baidu.fsg.base.statistics.r.a
    public void b() {
        LogUtil.d(l.f5359a, "====send-fail=====");
    }
}
