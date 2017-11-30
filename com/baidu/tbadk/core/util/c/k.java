package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.io.File;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private int height;
    private int width;

    public k() {
        this.width = 0;
        this.height = 0;
        wg();
    }

    public k(int i, int i2) {
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        wg();
    }

    private void wg() {
        this.width = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        this.height = com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ez().gt(ep(str));
        if (gt == null || gt.kK() == null) {
            return null;
        }
        return gt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return eo(str);
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ez().c(ep(str), (com.baidu.adp.widget.a.a) obj);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return 1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002e -> B:9:0x001d). Please submit an issue!!! */
    public com.baidu.adp.widget.a.a eo(String str) {
        try {
            File file = new File(str);
            if (file != null && file.exists()) {
                if (com.baidu.tbadk.core.util.k.dq(str)) {
                    return new com.baidu.adp.widget.a.a(BitmapHelper.loadBitmap(str), true, str);
                }
                return new com.baidu.adp.widget.a.a(BitmapHelper.loadResizedBitmap(str, this.width, this.height), false, str);
            }
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public String ep(String str) {
        ImageOperation I = com.baidu.tbadk.img.effect.d.I(this.width, this.height);
        StringBuilder sb = new StringBuilder();
        sb.append("image_");
        sb.append(str);
        sb.append(':').append(I.actionName).append('=').append(I.actionParam);
        return sb.toString();
    }
}
