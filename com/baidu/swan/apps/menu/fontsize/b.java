package com.baidu.swan.apps.menu.fontsize;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.ap.ag;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.v.f;
/* loaded from: classes10.dex */
public class b {
    public static void jw(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(22, bundle));
    }

    public static int aBQ() {
        return aBS() + 1;
    }

    public static boolean aBR() {
        SwanAppConfigData azt = f.azO().azt();
        if (azt == null) {
            return false;
        }
        return TextUtils.equals("none", azt.dtD.duy);
    }

    public static int aBS() {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.awA(), d.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult.getInt("font_size_level", 1);
        }
        return 1;
    }

    public static int jx(int i) {
        switch (i) {
            case 0:
                return 82;
            case 1:
            default:
                return 100;
            case 2:
                return 112;
            case 3:
                return 118;
        }
    }

    public static boolean aBT() {
        return ag.us("3.200.101");
    }
}
