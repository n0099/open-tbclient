package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class a {
    private boolean ajh;

    public static a tZ() {
        return C0069a.aji;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0069a {
        private static final a aji = new a();
    }

    public boolean ua() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.np().getInt("guide_rename_switch", 0);
        int i2 = c.np().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.ajh + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.ajh || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        return z;
    }

    public void aE(boolean z) {
        this.ajh = z;
    }
}
