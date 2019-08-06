package com.baidu.tbadk.core.c;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a {
    private static a bEm;
    private Runnable bEn = new Runnable() { // from class: com.baidu.tbadk.core.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.gS(0);
        }
    };

    public static a acv() {
        if (bEm == null) {
            synchronized (a.class) {
                if (bEm == null) {
                    bEm = new a();
                }
            }
        }
        return bEm;
    }

    public void gS(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("package", "com.baidu.tieba");
            bundle.putString(DealIntentService.KEY_CLASS, "com.baidu.tieba.LogoActivity");
            bundle.putInt("badgenumber", i);
            TbadkApplication.getInst().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Throwable th) {
            Log.i("huawei_corner", th.getMessage());
        }
    }

    public boolean acw() {
        return ak.check("EMUI");
    }

    public void acx() {
        if (acw()) {
            gS(1);
            e.iK().postDelayed(this.bEn, 500L);
        }
    }
}
