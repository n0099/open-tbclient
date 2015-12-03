package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ag {
    private static ag abi;
    private static final BdUniqueId abj = BdUniqueId.gen();

    public static synchronized ag uX() {
        ag agVar;
        synchronized (ag.class) {
            if (abi == null) {
                abi = new ag();
            }
            agVar = abi;
        }
        return agVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String abk;
        private final boolean abl;
        private final boolean abm;
        private final boolean abn;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.abk = str2;
            this.abl = z;
            this.abm = z2;
            this.abn = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ag.abj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ag.this.b(this.imageUrl, this.abk, this.abl, this.abm, this.abn);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dy = az.dy(str);
            aw.vk().copyFile(str2, dy);
            if (z || z2 || z3) {
                synchronized (c.GC) {
                    int dv = aw.vk().dv(dy);
                    if (dv > 0) {
                        if (z) {
                            Bitmap dt = aw.vk().dt(dy);
                            com.baidu.tbadk.imageManager.c.CX().ez(dv);
                            if (dt != null) {
                                a(str, dt, z2, aw.vk().du(dy), z3, dy);
                            }
                        }
                    }
                }
            }
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        new a(str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap h(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.b.a imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = imageSize.width;
            int i2 = imageSize.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap a2 = c.a(bitmap, i, i2);
                return a2 != null ? a2 : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            m mVar = new m();
            if (bitmap == null) {
                mVar.h("bitmap", "null");
            } else {
                mVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                mVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), mVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.CX().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap h = z2 ? h(bitmap) : bitmap;
        if (!z || h == null) {
            bitmap2 = h;
        } else {
            float f = 10.0f;
            bitmap2 = c.a(h, (h.getHeight() < 100 || h.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            aw.vk().h(str, c.e(bitmap2, 100));
        }
        return bitmap2;
    }

    private void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a2 = a(bitmap, z, z3, str2);
            if (a2 != null) {
                a(str, new com.baidu.adp.widget.a.a(a2, z2));
            }
        } catch (Exception e) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_ADD_MEMORY, "addPicMemoryCache error: " + e.toString(), str);
        }
    }

    public com.baidu.tbadk.core.util.b.a getImageSize(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int uJ = LocalViewSize.uG().uJ();
        if (z) {
            if (i / i2 >= 3) {
                z2 = true;
                i3 = i / 2;
                i4 = i;
            } else if (i2 / i >= 3) {
                i4 = i2 / 2;
                z2 = true;
                i3 = i2;
            }
            if (i4 <= i3 && i4 > uJ) {
                i3 = (int) (i3 / (i4 / uJ));
            } else if (i3 > i4 || i3 <= uJ) {
                uJ = i4;
            } else {
                uJ = (int) (i4 / (i3 / uJ));
                i3 = uJ;
            }
            if (z2 && i <= uJ && i2 <= i3) {
                uJ = (int) (uJ * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uJ < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uJ;
            } else {
                i5 = 70;
            }
            return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
        }
        z2 = false;
        i3 = i2;
        i4 = i;
        if (i4 <= i3) {
        }
        if (i3 > i4) {
        }
        uJ = i4;
        if (z2) {
            uJ = (int) (uJ * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uJ < 70) {
        }
        i6 = i3;
        i5 = uJ;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
