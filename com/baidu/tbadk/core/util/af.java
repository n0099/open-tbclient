package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class af {
    private static af afG;
    private static final BdUniqueId afH = BdUniqueId.gen();

    public static synchronized af vH() {
        af afVar;
        synchronized (af.class) {
            if (afG == null) {
                afG = new af();
            }
            afVar = afG;
        }
        return afVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String afI;
        private final boolean afJ;
        private final boolean afK;
        private final boolean afL;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.afI = str2;
            this.afJ = z;
            this.afK = z2;
            this.afL = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, af.afH));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                af.this.b(this.imageUrl, this.afI, this.afJ, this.afK, this.afL);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dD = aw.dD(str);
            at.vU().ab(str2, dD);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dy = at.vU().dy(dD);
                    if (dy > 0) {
                        if (z) {
                            Bitmap dw = at.vU().dw(dD);
                            com.baidu.tbadk.imageManager.c.EJ().eT(dy);
                            if (dw != null) {
                                a(str, dw, z2, at.vU().dx(dD), z3, dD);
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

    public Bitmap f(Bitmap bitmap) {
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
            k kVar = new k();
            if (bitmap == null) {
                kVar.n("bitmap", "null");
            } else {
                kVar.n("bitW", Integer.valueOf(bitmap.getWidth()));
                kVar.n("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), kVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.EJ().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap f = z2 ? f(bitmap) : bitmap;
        if (!z || f == null) {
            bitmap2 = f;
        } else {
            float f2 = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(f, (f.getHeight() < 100 || f.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            at.vU().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int vt = LocalViewSize.vp().vt();
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
            if (i4 <= i3 && i4 > vt) {
                i3 = (int) (i3 / (i4 / vt));
            } else if (i3 > i4 || i3 <= vt) {
                vt = i4;
            } else {
                vt = (int) (i4 / (i3 / vt));
                i3 = vt;
            }
            if (z2 && i <= vt && i2 <= i3) {
                vt = (int) (vt * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (vt < 70 || i3 >= 70) {
                i6 = i3;
                i5 = vt;
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
        vt = i4;
        if (z2) {
            vt = (int) (vt * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (vt < 70) {
        }
        i6 = i3;
        i5 = vt;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
