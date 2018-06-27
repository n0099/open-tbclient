package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    private int height;
    private int width;

    public m() {
        this.width = 0;
        this.height = 0;
        Aq();
    }

    public m(int i, int i2) {
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        Aq();
    }

    private void Aq() {
        this.width = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean ij() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(fk(str));
        if (hi == null || hi.mZ() == null) {
            return null;
        }
        return hi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return fj(str);
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.IV().c(fk(str), (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int il() {
        return 1;
    }

    public com.baidu.adp.widget.ImageView.a fj(String str) {
        com.baidu.adp.widget.ImageView.a aVar;
        try {
            if (str.toLowerCase().endsWith(".gif")) {
                aVar = new com.baidu.adp.widget.ImageView.a(BitmapHelper.loadBitmap(str), true, str);
            } else {
                aVar = new com.baidu.adp.widget.ImageView.a(BitmapHelper.loadResizedBitmap(str, this.width, this.height), false, str);
            }
            return aVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public String fk(String str) {
        ImageOperation H = com.baidu.tbadk.img.effect.d.H(this.width, this.height);
        StringBuilder sb = new StringBuilder();
        sb.append("image_");
        sb.append(str);
        sb.append(':').append(H.actionName).append('=').append(H.actionParam);
        return sb.toString();
    }
}
