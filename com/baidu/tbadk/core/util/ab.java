package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ab {
    private static ab aas;
    private static final BdUniqueId aat = BdUniqueId.gen();

    public static synchronized ab ur() {
        ab abVar;
        synchronized (ab.class) {
            if (aas == null) {
                aas = new ab();
            }
            abVar = aas;
        }
        return abVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String aau;
        private final boolean aav;
        private final boolean aaw;
        private final boolean aax;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aau = str2;
            this.aav = z;
            this.aaw = z2;
            this.aax = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ab.aat));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ab.this.b(this.imageUrl, this.aau, this.aav, this.aaw, this.aax);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dn = au.dn(str);
            ar.uD().copyFile(str2, dn);
            if (z || z2 || z3) {
                synchronized (c.Gm) {
                    int dl = ar.uD().dl(dn);
                    if (dl > 0) {
                        if (z) {
                            Bitmap dj = ar.uD().dj(dn);
                            com.baidu.tbadk.imageManager.c.Cf().en(dl);
                            if (dj != null) {
                                a(str, dj, z2, ar.uD().dk(dn), z3, dn);
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
        com.baidu.tbadk.imageManager.c.Cf().c(str, aVar);
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
            ar.uD().h(str, c.e(bitmap2, 100));
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
        int ue = LocalViewSize.ub().ue();
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
            if (i4 <= i3 && i4 > ue) {
                i3 = (int) (i3 / (i4 / ue));
            } else if (i3 > i4 || i3 <= ue) {
                ue = i4;
            } else {
                ue = (int) (i4 / (i3 / ue));
                i3 = ue;
            }
            if (z2 && i <= ue && i2 <= i3) {
                ue = (int) (ue * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (ue < 70 || i3 >= 70) {
                i6 = i3;
                i5 = ue;
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
        ue = i4;
        if (z2) {
            ue = (int) (ue * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (ue < 70) {
        }
        i6 = i3;
        i5 = ue;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
