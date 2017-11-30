package com.baidu.tbadk.core.util.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q extends a {
    private static BdAsyncTaskParallel ajC = null;
    private String ajB;
    private boolean ajD;
    private boolean ajE;
    private int ajF;
    private int size;

    public q(boolean z, boolean z2, boolean z3, int i) {
        this.ajB = null;
        this.size = 0;
        this.ajD = false;
        this.ajE = false;
        this.ajF = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ajD = z;
        this.ajE = z3;
        this.ajF = i;
        if (f < 2.0f) {
            this.ajB = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ajB = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ajB = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ajB = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public boolean fM() {
        if (this.ajE) {
            return com.baidu.tbadk.core.h.pa().pc();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.ajD) {
            return null;
        }
        com.baidu.adp.widget.a.a gr = com.baidu.tbadk.imageManager.c.Ez().gr(str);
        if (gr != null) {
            gr.Gk.Gm = "memory";
            gr.Gk.Gn = 0L;
            gr.Gk.Go = true;
            return gr;
        }
        return gr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ajD) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected String d(String str, int i, int i2) {
        return this.ajB + str;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c Ez = com.baidu.tbadk.imageManager.c.Ez();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            Ez.b(str, (com.baidu.adp.widget.a.a) obj);
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
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        if (ajC == null) {
            ajC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ajC;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.ajF;
    }
}
