package com.baidu.swan.apps.menu.fontsize;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.ap.ag;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.v.f;
/* loaded from: classes25.dex */
public class b {
    public static void jQ(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
        com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(22, bundle));
    }

    public static int aEr() {
        return aEt() + 1;
    }

    public static boolean aEs() {
        SwanAppConfigData aBU = f.aCp().aBU();
        if (aBU == null) {
            return false;
        }
        return TextUtils.equals("none", aBU.dyV.dzQ);
    }

    public static int aEt() {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.aza(), d.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            return callOnMainWithContentProvider.mResult.getInt("font_size_level", 1);
        }
        return 1;
    }

    public static int jR(int i) {
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

    public static boolean aEu() {
        return ag.uU("3.200.101");
    }
}
