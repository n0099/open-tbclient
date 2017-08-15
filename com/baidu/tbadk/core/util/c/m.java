package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends a {
    private static BdAsyncTaskParallel ajZ = null;
    private String ajY;
    private boolean aka;
    private boolean akb;
    private int akc;
    private int size;

    public m(boolean z, boolean z2, boolean z3, int i) {
        this.ajY = null;
        this.size = 0;
        this.aka = false;
        this.akb = false;
        this.akc = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.aka = z;
        this.akb = z3;
        this.akc = i;
        if (f < 2.0f) {
            this.ajY = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajY = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ajY = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ajY = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fX() {
        if (this.akb) {
            return com.baidu.tbadk.core.h.oX().oZ();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.aka) {
            return null;
        }
        com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Ex().go(str);
        if (go != null) {
            go.IE.IG = "memory";
            go.IE.IH = 0L;
            go.IE.II = true;
            return go;
        }
        return go;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.aka) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String c(String str, int i, int i2) {
        return this.ajY + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ex = com.baidu.tbadk.imageManager.c.Ex();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ex.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wu() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fY() {
        if (ajZ == null) {
            ajZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajZ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int ww() {
        return this.akc;
    }
}
