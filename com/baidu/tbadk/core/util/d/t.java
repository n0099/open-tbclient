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
    private boolean Kl;
    private int fdh;
    private boolean fdi;
    private int fdj;
    private int fdk;
    private boolean mIsFromCDN;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.mIsFromCDN = z;
        this.Kl = z2;
        this.fdi = z3;
        this.fdh = i;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (i == 13) {
            this.fdj = equipmentWidth <= 0 ? 200 : equipmentWidth;
            if (this.fdj > 480) {
                this.fdj = 480;
            }
            if (this.fdj > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f)) {
                this.fdj = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.fdk = this.fdj;
        } else if (i == 17) {
            this.fdj = Math.min(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.fdk = (int) (this.fdj * 1.6f);
        } else if (i == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds184);
            this.fdk = dimensionPixelSize;
            this.fdj = dimensionPixelSize;
        } else if (i == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.fdk = dimensionPixelSize2;
            this.fdj = dimensionPixelSize2;
        } else if (i == 21) {
            this.fdk = 0;
            this.fdj = 0;
        } else if (i == 30) {
            if (equipmentWidth <= 0 || equipmentWidth > 644) {
                this.fdj = 644;
            }
            if (this.fdj > com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.fdj = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.fdk = (int) (this.fdj * 0.43f);
        } else {
            this.fdj = equipmentWidth;
            this.fdk = equipmentHeight;
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btn() {
        return this.fdj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bto() {
        return this.fdk;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean mx() {
        if (this.fdi) {
            return true;
        }
        return super.mx();
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap f(Bitmap bitmap, int i, int i2) {
        return (this.fdh == 13 || this.fdh == 17) ? bitmap : super.f(bitmap, i, i2);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btp() {
        return this.fdh;
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
                cVar.Z(this.Kl);
                com.baidu.adp.lib.Disk.d.lg().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Nl = dVar;
                }
            }
        }
    }
}
