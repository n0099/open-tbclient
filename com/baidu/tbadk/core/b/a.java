package com.baidu.tbadk.core.b;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.f.e;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a {
    private static a eNi;
    private Runnable eNj = new Runnable() { // from class: com.baidu.tbadk.core.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.ov(0);
        }
    };

    public static a boL() {
        if (eNi == null) {
            synchronized (a.class) {
                if (eNi == null) {
                    eNi = new a();
                }
            }
        }
        return eNi;
    }

    public void ov(int i) {
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

    public boolean boM() {
        return am.check(RomUtils.ROM_EMUI);
    }

    public void boN() {
        if (boM()) {
            ov(1);
            e.mB().postDelayed(this.eNj, 500L);
        }
    }
}
