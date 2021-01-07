package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t extends a {
    private boolean Ko;
    private int ffA;
    private boolean ffB;
    private int ffC;
    private int ffD;
    private boolean mIsFromCDN;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.mIsFromCDN = z;
        this.Ko = z2;
        this.ffB = z3;
        this.ffA = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (i == 13) {
            this.ffC = equipmentWidth <= 0 ? 200 : equipmentWidth;
            if (this.ffC > 480) {
                this.ffC = 480;
            }
            if (this.ffC > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
                this.ffC = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.ffD = this.ffC;
        } else if (i == 17) {
            this.ffC = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.ffD = (int) (this.ffC * 1.6f);
        } else if (i == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
            this.ffD = dimensionPixelSize;
            this.ffC = dimensionPixelSize;
        } else if (i == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.ffD = dimensionPixelSize2;
            this.ffC = dimensionPixelSize2;
        } else if (i == 21) {
            this.ffD = 0;
            this.ffC = 0;
        } else if (i == 30) {
            if (equipmentWidth <= 0 || equipmentWidth > 644) {
                this.ffC = 644;
            }
            if (this.ffC > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.ffC = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.ffD = (int) (this.ffC * 0.43f);
        } else {
            this.ffC = equipmentWidth;
            this.ffD = equipmentHeight;
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwN() {
        return this.ffC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwO() {
        return this.ffD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean my() {
        if (this.ffB) {
            return true;
        }
        return super.my();
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap f(Bitmap bitmap, int i, int i2) {
        return (this.ffA == 13 || this.ffA == 17) ? bitmap : super.f(bitmap, i, i2);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwP() {
        return this.ffA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(booleanValue3);
                cVar.Z(this.Ko);
                com.baidu.adp.lib.Disk.d.lh().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Np = dVar;
                }
            }
        }
    }
}
