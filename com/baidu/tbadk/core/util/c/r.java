package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r extends a {
    private static BdAsyncTaskParallel ajw = null;
    private String ajv;
    private boolean ajx;
    private boolean ajy;
    private int ajz;
    private int size;

    public r(boolean z, boolean z2, boolean z3, int i) {
        this.ajv = null;
        this.size = 0;
        this.ajx = false;
        this.ajy = false;
        this.ajz = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ajx = z;
        this.ajy = z3;
        this.ajz = i;
        if (f < 2.0f) {
            this.ajv = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajv = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
        }
        if (z2) {
            this.ajv = TbConfig.getBigPhotoAdress();
            this.size = TbConfig.BIG_PHOTO_MAX_SIZE;
            return;
        }
        this.ajv = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.ajy) {
            return com.baidu.tbadk.core.h.oY().pa();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.ajx) {
            return null;
        }
        com.baidu.adp.widget.a.a gq = com.baidu.tbadk.imageManager.c.EA().gq(str);
        if (gq != null) {
            gq.Gk.Gm = "memory";
            gq.Gk.Gn = 0L;
            gq.Gk.Go = true;
            return gq;
        }
        return gq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ajx) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.ajv + str;
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
        if (ajw == null) {
            ajw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajw;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.ajz;
    }
}
