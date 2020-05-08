package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean aPH;

    public static a Dk() {
        return C0139a.aPI;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0139a {
        private static final a aPI = new a();
    }

    public boolean Dl() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.tG().getInt("guide_rename_switch", 0);
        int i2 = c.tG().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.aPH + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.aPH || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.r.a.Ej().Ek() != null) {
                return com.baidu.live.r.a.Ej().Ek().Em();
            }
            return false;
        }
        return z;
    }

    public void bE(boolean z) {
        this.aPH = z;
    }
}
