package com.baidu.live.aa;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a {
    public static int cr(boolean z) {
        return (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds64));
    }

    public static int h(boolean z, boolean z2) {
        return cr(z2) + ct(z);
    }

    public static int cs(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds90);
    }

    public static int ct(boolean z) {
        if (z) {
            return 0;
        }
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds27);
    }
}
