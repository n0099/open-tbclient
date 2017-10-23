package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel aiI = null;
    private String aiH;
    private boolean aiJ;
    private boolean aiK;
    private int aiL;
    private int size;

    public n(boolean z, boolean z2, boolean z3, int i) {
        this.aiH = null;
        this.size = 0;
        this.aiJ = false;
        this.aiK = false;
        this.aiL = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aiJ = z;
        this.aiK = z3;
        this.aiL = i;
        if (f < 2.0f) {
            this.aiH = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aiH = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aiH = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aiH = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.aiK) {
            return com.baidu.tbadk.core.h.oM().oO();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, Object... objArr) {
        if (this.aiJ) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a gg = com.baidu.tbadk.imageManager.c.DT().gg(str);
        if (gg != null) {
            gg.Gz.GB = "memory";
            gg.Gz.GC = 0L;
            gg.Gz.GD = true;
            return gg;
        }
        return gg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aiJ) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.aiH + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DT = com.baidu.tbadk.imageManager.c.DT();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            DT.b(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        if (aiI == null) {
            aiI = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aiI;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.aiL;
    }
}
