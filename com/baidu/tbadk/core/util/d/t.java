package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t extends a {
    private boolean LH;
    private int feG;
    private boolean feH;
    private int feI;
    private int feJ;
    private boolean mIsFromCDN;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.mIsFromCDN = z;
        this.LH = z2;
        this.feH = z3;
        this.feG = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (i == 13) {
            this.feI = equipmentWidth <= 0 ? 200 : equipmentWidth;
            if (this.feI > 480) {
                this.feI = 480;
            }
            if (this.feI > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
                this.feI = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.feJ = this.feI;
        } else if (i == 17) {
            this.feI = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.feJ = (int) (this.feI * 1.6f);
        } else if (i == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
            this.feJ = dimensionPixelSize;
            this.feI = dimensionPixelSize;
        } else if (i == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.feJ = dimensionPixelSize2;
            this.feI = dimensionPixelSize2;
        } else if (i == 21) {
            this.feJ = 0;
            this.feI = 0;
        } else if (i == 30) {
            if (equipmentWidth <= 0 || equipmentWidth > 644) {
                this.feI = 644;
            }
            if (this.feI > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.feI = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.feJ = (int) (this.feI * 0.43f);
        } else {
            this.feI = equipmentWidth;
            this.feJ = equipmentHeight;
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btq() {
        return this.feI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btr() {
        return this.feJ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean mx() {
        if (this.feH) {
            return true;
        }
        return super.mx();
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        return (this.feG == 13 || this.feG == 17) ? bitmap : super.e(bitmap, i, i2);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bts() {
        return this.feG;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(booleanValue3);
                cVar.Z(this.LH);
                com.baidu.adp.lib.Disk.d.lg().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.OL = dVar;
                }
            }
        }
    }
}
