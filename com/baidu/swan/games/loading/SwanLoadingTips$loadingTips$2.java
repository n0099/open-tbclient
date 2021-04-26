package com.baidu.swan.games.loading;

import android.app.Application;
import android.content.res.Resources;
import d.a.h0.a.b;
import d.a.h0.a.w0.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a*\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class SwanLoadingTips$loadingTips$2 extends Lambda implements Function0<String[]> {
    public static final SwanLoadingTips$loadingTips$2 INSTANCE = new SwanLoadingTips$loadingTips$2();

    public SwanLoadingTips$loadingTips$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final String[] invoke() {
        Resources resources;
        Resources resources2;
        if (((int) (Math.random() * 2)) != 0) {
            Application c2 = a.c();
            if (c2 == null || (resources2 = c2.getResources()) == null) {
                return null;
            }
            return resources2.getStringArray(b.aiapps_loading_tips_prepare);
        }
        Application c3 = a.c();
        if (c3 == null || (resources = c3.getResources()) == null) {
            return null;
        }
        return resources.getStringArray(b.aiapps_loading_tips_skill);
    }
}
