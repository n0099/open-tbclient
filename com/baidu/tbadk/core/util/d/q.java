package com.baidu.tbadk.core.util.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q extends a {
    private static BdAsyncTaskParallel ffx = null;
    private String ffw;
    private boolean ffy;
    private int ffz;
    private int size;

    public q(boolean z, boolean z2, int i) {
        this.ffw = null;
        this.size = 0;
        this.ffy = false;
        this.ffz = 0;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.ffy = z;
        this.ffz = i;
        if (f < 2.0f) {
            this.ffw = TbConfig.getPhotoSmallAddress();
            this.size = 80;
        } else {
            this.ffw = TbConfig.getBigPhotoAdress();
            this.size = 110;
        }
        if (z2) {
            this.ffw = TbConfig.getBigPhotoAdress();
            this.size = 110;
            return;
        }
        this.ffw = TbConfig.getPhotoSmallAddress();
        this.size = 80;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwN() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwO() {
        return this.size;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public boolean my() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        if (this.ffy) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a Ed = com.baidu.tbadk.imageManager.c.bGq().Ed(str);
        if (z) {
            com.baidu.adp.lib.e.a.b(Ed != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return Ed;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        if (this.ffy) {
            return null;
        }
        return super.a(str, str2, i, i2, bVar, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public String p(String str, int i, int i2) {
        return (str == null || !(str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) ? this.ffw + str : str;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if ((obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bGq().a(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mz() {
        if (ffx == null) {
            ffx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return ffx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwP() {
        return this.ffz;
    }
}
