package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean aVQ;

    public static a EI() {
        return C0169a.aVR;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0169a {
        private static final a aVR = new a();
    }

    public boolean EJ() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.uN().getInt("guide_rename_switch", 0);
        int i2 = c.uN().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.aVQ + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.aVQ || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.r.a.Ga().Gb() != null) {
                return com.baidu.live.r.a.Ga().Gb().Gd();
            }
            return false;
        }
        return z;
    }

    public void bN(boolean z) {
        this.aVQ = z;
    }
}
