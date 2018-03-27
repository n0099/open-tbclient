package com.baidu.tbadk.core.util.d;

import android.media.ThumbnailUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import java.io.File;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean np() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mx().gP(eP(str));
        if (gP == null || gP.sh() == null) {
            return null;
        }
        return gP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return eQ(str);
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Mx().c(eP(str), (com.baidu.adp.widget.a.a) obj);
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

    public com.baidu.adp.widget.a.a eQ(String str) {
        try {
            File file = new File(str);
            if (file != null && file.exists()) {
                return new com.baidu.adp.widget.a.a(ThumbnailUtils.createVideoThumbnail(str, 1), false, str);
            }
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public String eP(String str) {
        return "videoThumb_" + str;
    }
}
