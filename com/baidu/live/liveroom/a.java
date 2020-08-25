package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class a {
    private boolean bdM;

    public static a KQ() {
        return C0179a.bdN;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0179a {
        private static final a bdN = new a();
    }

    public boolean KR() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.AD().getInt("guide_rename_switch", 0);
        int i2 = c.AD().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.bdM + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.bdM || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.t.a.MF().MG() != null) {
                return com.baidu.live.t.a.MF().MG().MI();
            }
            return false;
        }
        return z;
    }

    public void bX(boolean z) {
        this.bdM = z;
    }
}
