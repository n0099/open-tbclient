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
    private static a dXK;
    private Runnable dXL = new Runnable() { // from class: com.baidu.tbadk.core.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.mZ(0);
        }
    };

    public static a bcV() {
        if (dXK == null) {
            synchronized (a.class) {
                if (dXK == null) {
                    dXK = new a();
                }
            }
        }
        return dXK;
    }

    public void mZ(int i) {
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

    public boolean bcW() {
        return an.check(RomUtils.ROM_EMUI);
    }

    public void bcX() {
        if (bcW()) {
            mZ(1);
            e.mX().postDelayed(this.dXL, 500L);
        }
    }
}
