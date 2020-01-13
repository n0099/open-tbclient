package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a {
    private boolean arQ;

    public static a wl() {
        return C0084a.arR;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0084a {
        private static final a arR = new a();
    }

    public boolean wm() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.oJ().getInt("guide_rename_switch", 0);
        int i2 = c.oJ().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.arQ + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.arQ || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.o.a.wN().wO() != null) {
                return com.baidu.live.o.a.wN().wO().wQ();
            }
            return false;
        }
        return z;
    }

    public void aX(boolean z) {
        this.arQ = z;
    }
}
