package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a {
    private boolean are;

    public static a vU() {
        return C0084a.arf;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0084a {
        private static final a arf = new a();
    }

    public boolean vV() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.oI().getInt("guide_rename_switch", 0);
        int i2 = c.oI().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.are + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.are || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.n.a.ww().wx() != null) {
                return com.baidu.live.n.a.ww().wx().wz();
            }
            return false;
        }
        return z;
    }

    public void aV(boolean z) {
        this.are = z;
    }
}
