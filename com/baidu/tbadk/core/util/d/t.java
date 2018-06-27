package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel atC = null;
    private String atB;
    private boolean atD;
    private boolean atE;
    private int atF;
    private int size;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.atB = null;
        this.size = 0;
        this.atD = false;
        this.atE = false;
        this.atF = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.atD = z;
        this.atE = z3;
        this.atF = i;
        if (f < 2.0f) {
            this.atB = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.atB = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.atB = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.atB = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ij() {
        if (this.atE) {
            return com.baidu.tbadk.core.i.tt().tv();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        if (this.atD) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a hh = com.baidu.tbadk.imageManager.c.IV().hh(str);
        if (hh != null) {
            hh.KN.KP = "memory";
            hh.KN.KQ = 0L;
            hh.KN.KR = true;
            return hh;
        }
        return hh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.atD) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String j(String str, int i, int i2) {
        return this.atB + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c IV = com.baidu.tbadk.imageManager.c.IV();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            IV.b(str, (com.baidu.adp.widget.ImageView.a) obj);
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
    public boolean Ak() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        if (atC == null) {
            atC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return atC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
        return this.atF;
    }
}
