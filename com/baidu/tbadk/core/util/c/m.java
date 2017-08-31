package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel ajt = null;
    private String ajs;
    private boolean aju;
    private boolean ajv;
    private int ajw;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ajs = null;
        this.size = 0;
        this.aju = false;
        this.ajv = false;
        this.ajw = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aju = z;
        this.ajv = z3;
        this.ajw = i;
        if (f < 2.0f) {
            this.ajs = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajs = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ajs = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ajs = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fN() {
        if (this.ajv) {
            return com.baidu.tbadk.core.h.oS().oU();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.aju) {
            return null;
        }
        com.baidu.adp.widget.a.a gn = com.baidu.tbadk.imageManager.c.Ev().gn(str);
        if (gn != null) {
            gn.Gx.Gz = "memory";
            gn.Gx.GA = 0L;
            gn.Gx.GB = true;
            return gn;
        }
        return gn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aju) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.ajs + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ev = com.baidu.tbadk.imageManager.c.Ev();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ev.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean ws() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fO() {
        if (ajt == null) {
            ajt = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.ajw;
    }
}
