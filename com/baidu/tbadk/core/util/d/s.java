package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class s extends a {
    private static BdAsyncTaskParallel asZ = null;
    private String asY;
    private boolean ata;
    private boolean atb;
    private int atc;
    private int size;

    public s(boolean z, boolean z2, boolean z3, int i) {
        this.asY = null;
        this.size = 0;
        this.ata = false;
        this.atb = false;
        this.atc = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ata = z;
        this.atb = z3;
        this.atc = i;
        if (f < 2.0f) {
            this.asY = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.asY = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.asY = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.asY = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ij() {
        if (this.atb) {
            return com.baidu.tbadk.core.i.tt().tv();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        if (this.ata) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a hd = com.baidu.tbadk.imageManager.c.ID().hd(str);
        if (hd != null) {
            hd.KL.KN = "memory";
            hd.KL.KO = 0L;
            hd.KL.KP = true;
            return hd;
        }
        return hd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ata) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String j(String str, int i, int i2) {
        return this.asY + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c ID = com.baidu.tbadk.imageManager.c.ID();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            ID.b(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        if (asZ == null) {
            asZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return asZ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.atc;
    }
}
