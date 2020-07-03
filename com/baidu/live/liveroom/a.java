package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean aYx;

    public static a Fp() {
        return C0171a.aYy;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0171a {
        private static final a aYy = new a();
    }

    public boolean Fq() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.vf().getInt("guide_rename_switch", 0);
        int i2 = c.vf().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.aYx + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.aYx || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.s.a.GJ().GK() != null) {
                return com.baidu.live.s.a.GJ().GK().GM();
            }
            return false;
        }
        return z;
    }

    public void bP(boolean z) {
        this.aYx = z;
    }
}
