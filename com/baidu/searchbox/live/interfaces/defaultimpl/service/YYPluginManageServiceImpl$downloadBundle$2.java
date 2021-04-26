package com.baidu.searchbox.live.interfaces.defaultimpl.service;

import com.baidu.nps.pm.IBundleInfo;
import d.a.x.f.a;
import d.a.x.f.b;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "bundle", "Lcom/baidu/nps/pm/IBundleInfo;", "kotlin.jvm.PlatformType", "type", "", "listener", "Lcom/baidu/nps/plugin/IDownloadAuthorListener;", "checkAuthorization"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YYPluginManageServiceImpl$downloadBundle$2 implements a {
    public static final YYPluginManageServiceImpl$downloadBundle$2 INSTANCE = new YYPluginManageServiceImpl$downloadBundle$2();

    @Override // d.a.x.f.a
    public final void checkAuthorization(IBundleInfo iBundleInfo, int i2, b bVar) {
        bVar.onResult(1);
    }
}
