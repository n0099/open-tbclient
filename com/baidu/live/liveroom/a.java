package com.baidu.live.liveroom;

import android.util.Log;
import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    private boolean avN;

    public static a ym() {
        return C0092a.avO;
    }

    /* renamed from: com.baidu.live.liveroom.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0092a {
        private static final a avO = new a();
    }

    public boolean yn() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isTieba()) {
            return false;
        }
        int i = c.pr().getInt("guide_rename_switch", 0);
        int i2 = c.pr().getInt("guide_rename_show_count", 0);
        Log.i("RenameManager", "CanShowGuideRename renameSwitch:" + i + ", renameShowCount:" + i2 + ", mHasShowGuideRename:" + this.avN + ", isLogin:" + TbadkCoreApplication.isLogin());
        if (i != 1 || i2 >= 3 || this.avN || !TbadkCoreApplication.isLogin()) {
            z = false;
        }
        if (z) {
            if (com.baidu.live.r.a.zf().zg() != null) {
                return com.baidu.live.r.a.zf().zg().zi();
            }
            return false;
        }
        return z;
    }

    public void ba(boolean z) {
        this.avN = z;
    }
}
