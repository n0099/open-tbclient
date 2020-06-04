package com.baidu.tbadk.core.b;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.f.e;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a {
    private static a dzJ;
    private Runnable dzK = new Runnable() { // from class: com.baidu.tbadk.core.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.kd(0);
        }
    };

    public static a aOf() {
        if (dzJ == null) {
            synchronized (a.class) {
                if (dzJ == null) {
                    dzJ = new a();
                }
            }
        }
        return dzJ;
    }

    public void kd(int i) {
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

    public boolean aOg() {
        return ak.check(RomUtils.ROM_EMUI);
    }

    public void aOh() {
        if (aOg()) {
            kd(1);
            e.ld().postDelayed(this.dzK, 500L);
        }
    }
}
