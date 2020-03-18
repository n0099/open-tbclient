package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean avY;

    public static a yr() {
        return C0092a.avZ;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0092a {
        private static final a avZ = new a();
    }

    public boolean ys() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.pw().getInt("guide_rename_switch", 0);
        int i2 = c.pw().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.avY + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.avY || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.r.a.zo().zp() != null) {
                return com.baidu.live.r.a.zo().zp().zr();
            }
            return false;
        }
        return z;
    }

    public void ba(boolean z) {
        this.avY = z;
    }
}
