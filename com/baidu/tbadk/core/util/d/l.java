package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private int height;
    private int width;

    public l() {
        this.width = 0;
        this.height = 0;
        Dv();
    }

    public l(int i, int i2) {
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        Dv();
    }

    private void Dv() {
        this.width = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean np() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gG = com.baidu.tbadk.imageManager.c.LR().gG(eE(str));
        if (gG == null || gG.sj() == null) {
            return null;
        }
        return gG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return eD(str);
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.LR().c(eE(str), (com.baidu.adp.widget.a.a) obj);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int nr() {
        return 1;
    }

    public com.baidu.adp.widget.a.a eD(String str) {
        com.baidu.adp.widget.a.a aVar;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                aVar = new com.baidu.adp.widget.a.a(BitmapHelper.loadBitmap(str), true, str);
            } else {
                aVar = new com.baidu.adp.widget.a.a(BitmapHelper.loadResizedBitmap(str, this.width, this.height), false, str);
            }
            return aVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public String eE(String str) {
        ImageOperation aI = com.baidu.tbadk.img.effect.d.aI(this.width, this.height);
        StringBuilder sb = new StringBuilder();
        sb.append("image_");
        sb.append(str);
        sb.append(':').append(aI.actionName).append('=').append(aI.actionParam);
        return sb.toString();
    }
}
