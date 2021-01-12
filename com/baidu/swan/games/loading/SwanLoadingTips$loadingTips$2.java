package com.baidu.swan.games.loading;

import android.app.Application;
import android.content.res.Resources;
import com.baidu.swan.apps.a;
import kotlin.e;
import kotlin.jvm.internal.Lambda;
@e
/* loaded from: classes8.dex */
final class SwanLoadingTips$loadingTips$2 extends Lambda implements kotlin.jvm.a.a<String[]> {
    public static final SwanLoadingTips$loadingTips$2 INSTANCE = new SwanLoadingTips$loadingTips$2();

    SwanLoadingTips$loadingTips$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final String[] invoke() {
        Resources resources;
        Resources resources2;
        switch ((int) (Math.random() * 2)) {
            case 0:
                Application awy = com.baidu.swan.apps.t.a.awy();
                if (awy == null || (resources = awy.getResources()) == null) {
                    return null;
                }
                return resources.getStringArray(a.b.aiapps_loading_tips_skill);
            default:
                Application awy2 = com.baidu.swan.apps.t.a.awy();
                if (awy2 == null || (resources2 = awy2.getResources()) == null) {
                    return null;
                }
                return resources2.getStringArray(a.b.aiapps_loading_tips_prepare);
        }
    }
}
