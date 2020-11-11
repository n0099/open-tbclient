package com.baidu.tbadk.core.b;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.f.e;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a {
    private static a eyf;
    private Runnable eyg = new Runnable() { // from class: com.baidu.tbadk.core.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.nR(0);
        }
    };

    public static a bjW() {
        if (eyf == null) {
            synchronized (a.class) {
                if (eyf == null) {
                    eyf = new a();
                }
            }
        }
        return eyf;
    }

    public void nR(int i) {
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

    public boolean bjX() {
        return an.check(RomUtils.ROM_EMUI);
    }

    public void bjY() {
        if (bjX()) {
            nR(1);
            e.mY().postDelayed(this.eyg, 500L);
        }
    }
}
