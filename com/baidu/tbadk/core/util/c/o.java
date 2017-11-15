package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o extends a {
    private static BdAsyncTaskParallel ajg = null;
    private String ajf;
    private boolean ajh;
    private boolean aji;
    private int ajj;
    private int size;

    public o(boolean z, boolean z2, boolean z3, int i) {
        this.ajf = null;
        this.size = 0;
        this.ajh = false;
        this.aji = false;
        this.ajj = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ajh = z;
        this.aji = z3;
        this.ajj = i;
        if (f < 2.0f) {
            this.ajf = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajf = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ajf = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ajf = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.aji) {
            return com.baidu.tbadk.core.h.oT().oV();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.ajh) {
            return null;
        }
        com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Es().go(str);
        if (go != null) {
            go.Gk.Gm = "memory";
            go.Gk.Gn = 0L;
            go.Gk.Go = true;
            return go;
        }
        return go;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ajh) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.ajf + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Es = com.baidu.tbadk.imageManager.c.Es();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Es.b(str, (com.baidu.adp.widget.a.a) obj);
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
        if (ajg == null) {
            ajg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajg;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.ajj;
    }
}
