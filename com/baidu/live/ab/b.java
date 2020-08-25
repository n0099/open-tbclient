package com.baidu.live.ab;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class b {
    public static int i(boolean z, boolean z2) {
        if (z) {
            return (int) (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(z2 ? a.e.sdk_tbds64 : a.e.sdk_tbds120) + (BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) * (z2 ? 0.2f : 0.33f)));
        }
        return (int) (((z2 ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_tbds64));
    }

    public static int c(boolean z, boolean z2, boolean z3) {
        return i(z2, z3) + cD(z);
    }

    public static int cC(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds90);
    }

    public static int cD(boolean z) {
        if (z) {
            return 0;
        }
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds27);
    }

    public static int Pf() {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds168);
    }
}
