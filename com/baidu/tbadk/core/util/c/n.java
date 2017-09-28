package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends a {
    private static BdAsyncTaskParallel aiU = null;
    private String aiT;
    private boolean aiV;
    private boolean aiW;
    private int aiX;
    private int size;

    public n(boolean z, boolean z2, boolean z3, int i) {
        this.aiT = null;
        this.size = 0;
        this.aiV = false;
        this.aiW = false;
        this.aiX = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aiV = z;
        this.aiW = z3;
        this.aiX = i;
        if (f < 2.0f) {
            this.aiT = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.aiT = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.aiT = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.aiT = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.aiW) {
            return com.baidu.tbadk.core.h.oT().oV();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, Object... objArr) {
        if (this.aiV) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DZ().gh(str);
        if (gh != null) {
            gh.Gy.GA = "memory";
            gh.Gy.GB = 0L;
            gh.Gy.GC = true;
            return gh;
        }
        return gh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aiV) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.aiT + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c DZ = com.baidu.tbadk.imageManager.c.DZ();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            DZ.b(str, (com.baidu.adp.widget.ImageView.a) obj);
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
    public boolean vW() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        if (aiU == null) {
            aiU = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return aiU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vY() {
        return this.aiX;
    }
}
