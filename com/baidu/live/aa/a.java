package com.baidu.live.aa;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class a {
    public static int ct(boolean z) {
        return (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds64));
    }

    public static int h(boolean z, boolean z2) {
        return ct(z2) + cv(z);
    }

    public static int cu(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds90);
    }

    public static int cv(boolean z) {
        if (z) {
            return 0;
        }
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds27);
    }

    public static int Jn() {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds168);
    }
}
