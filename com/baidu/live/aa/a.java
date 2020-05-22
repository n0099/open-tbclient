package com.baidu.live.aa;

import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    public static int cm(boolean z) {
        return (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds64));
    }

    public static int h(boolean z, boolean z2) {
        if (z) {
            return cm(z2);
        }
        return cm(z2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds27);
    }

    public static int cn(boolean z) {
        return z ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds132) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16) : TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds90);
    }
}
