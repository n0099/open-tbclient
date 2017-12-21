package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel ajz = null;
    private boolean ajA;
    private boolean ajB;
    private int ajC;
    private String ajy;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.ajy = null;
        this.size = 0;
        this.ajA = false;
        this.ajB = false;
        this.ajC = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ajA = z;
        this.ajB = z3;
        this.ajC = i;
        if (f < 2.0f) {
            this.ajy = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajy = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
        }
        if (z2) {
            this.ajy = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
            return;
        }
        this.ajy = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.ajB) {
            return com.baidu.tbadk.core.h.oY().pa();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.ajA) {
            return null;
        }
        com.baidu.adp.widget.a.a gq = com.baidu.tbadk.imageManager.c.EA().gq(str);
        if (gq != null) {
            gq.Gl.Gn = "memory";
            gq.Gl.Go = 0L;
            gq.Gl.Gp = true;
            return gq;
        }
        return gq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ajA) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.ajy + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c EA = com.baidu.tbadk.imageManager.c.EA();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            EA.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        if (ajz == null) {
            ajz = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajz;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.ajC;
    }
}
