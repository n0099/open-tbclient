package com.baidu.live.al;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class c {
    public static int i(boolean z, boolean z2) {
        if (z) {
            return (int) (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(z2 ? a.d.sdk_tbds64 : a.d.sdk_tbds120) + (BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) * (z2 ? 0.2f : 0.33f)));
        }
        return (int) (((z2 ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_tbds64));
    }

    public static int d(boolean z, boolean z2, boolean z3) {
        return i(z2, z3) + m19do(z);
    }

    public static int dn(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds90);
    }

    /* renamed from: do  reason: not valid java name */
    public static int m19do(boolean z) {
        if (z) {
            return 0;
        }
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds27);
    }

    public static int Xu() {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds168);
    }
}
