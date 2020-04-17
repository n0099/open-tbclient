package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean aPB;

    public static a Dl() {
        return C0118a.aPC;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0118a {
        private static final a aPC = new a();
    }

    public boolean Dm() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.tH().getInt("guide_rename_switch", 0);
        int i2 = c.tH().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.aPB + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.aPB || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.r.a.Ek().El() != null) {
                return com.baidu.live.r.a.Ek().El().En();
            }
            return false;
        }
        return z;
    }

    public void bE(boolean z) {
        this.aPB = z;
    }
}
