package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ag {
    private static ag abw;
    private static final BdUniqueId abx = BdUniqueId.gen();

    public static synchronized ag vj() {
        ag agVar;
        synchronized (ag.class) {
            if (abw == null) {
                abw = new ag();
            }
            agVar = abw;
        }
        return agVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final boolean abA;
        private final boolean abB;
        private final String aby;
        private final boolean abz;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aby = str2;
            this.abz = z;
            this.abA = z2;
            this.abB = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ag.abx));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ag.this.b(this.imageUrl, this.aby, this.abz, this.abA, this.abB);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dH = az.dH(str);
            aw.vw().ac(str2, dH);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dE = aw.vw().dE(dH);
                    if (dE > 0) {
                        if (z) {
                            Bitmap dC = aw.vw().dC(dH);
                            com.baidu.tbadk.imageManager.c.Ep().eT(dE);
                            if (dC != null) {
                                a(str, dC, z2, aw.vw().dD(dH), z3, dH);
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

    public Bitmap g(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.b.a b = b(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = b.width;
            int i2 = b.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            l lVar = new l();
            if (bitmap == null) {
                lVar.n("bitmap", "null");
            } else {
                lVar.n("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.n("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.Ep().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap g = z2 ? g(bitmap) : bitmap;
        if (!z || g == null) {
            bitmap2 = g;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(g, (g.getHeight() < 100 || g.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            aw.vw().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a b(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int uT = LocalViewSize.uP().uT();
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
            if (i4 <= i3 && i4 > uT) {
                i3 = (int) (i3 / (i4 / uT));
            } else if (i3 > i4 || i3 <= uT) {
                uT = i4;
            } else {
                uT = (int) (i4 / (i3 / uT));
                i3 = uT;
            }
            if (z2 && i <= uT && i2 <= i3) {
                uT = (int) (uT * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uT < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uT;
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
        uT = i4;
        if (z2) {
            uT = (int) (uT * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uT < 70) {
        }
        i6 = i3;
        i5 = uT;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
