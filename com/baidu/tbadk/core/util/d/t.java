package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends a {
    private static BdAsyncTaskParallel atg = null;
    private String atf;
    private boolean ath;
    private boolean ati;
    private int atj;
    private int size;

    public t(boolean z, boolean z2, boolean z3, int i) {
        this.atf = null;
        this.size = 0;
        this.ath = false;
        this.ati = false;
        this.atj = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ath = z;
        this.ati = z3;
        this.atj = i;
        if (f < 2.0f) {
            this.atf = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.atf = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.atf = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.atf = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public boolean ik() {
        if (this.ati) {
            return com.baidu.tbadk.core.i.te().tg();
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        if (this.ath) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a hd = com.baidu.tbadk.imageManager.c.IQ().hd(str);
        if (hd != null) {
            hd.KJ.KL = "memory";
            hd.KJ.KM = 0L;
            hd.KJ.KN = true;
            return hd;
        }
        return hd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (this.ath) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected String j(String str, int i, int i2) {
        return this.atf + str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.c IQ = com.baidu.tbadk.imageManager.c.IQ();
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            IQ.b(str, (com.baidu.adp.widget.ImageView.a) obj);
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
    public boolean Aa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ab() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel il() {
        if (atg == null) {
            atg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return atg;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Ac() {
        return this.atj;
    }
}
