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
    private static a bWB;
    private Runnable bWC = new Runnable() { // from class: com.baidu.tbadk.core.c.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.hs(0);
        }
    };

    public static a agF() {
        if (bWB == null) {
            synchronized (a.class) {
                if (bWB == null) {
                    bWB = new a();
                }
            }
        }
        return bWB;
    }

    public void hs(int i) {
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

    public boolean agG() {
        return ak.check("EMUI");
    }

    public void agH() {
        if (agG()) {
            hs(1);
            e.fZ().postDelayed(this.bWC, 500L);
        }
    }
}
