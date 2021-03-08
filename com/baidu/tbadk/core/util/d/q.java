package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q extends a {
    private static BdAsyncTaskParallel feD = null;
    private String feC;
    private boolean feE;
    private int feF;
    private int size;

    public q(boolean z, boolean z2, int i) {
        this.feC = null;
        this.size = 0;
        this.feE = false;
        this.feF = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.feE = z;
        this.feF = i;
        if (f < 2.0f) {
            this.feC = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.feC = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.feC = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.feC = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btq() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btr() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean mx() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        if (this.feE) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a Do = com.baidu.tbadk.imageManager.c.bCS().Do(str);
        if (z) {
            com.baidu.adp.lib.e.a.c(Do != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return Do;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        if (this.feE) {
            return null;
        }
        return super.a(str, str2, i, i2, bVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public String p(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.feC + str : str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if ((obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCS().a(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        if (feD == null) {
            feD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return feD;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bts() {
        return this.feF;
    }
}
