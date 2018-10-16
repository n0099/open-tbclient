package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac axc;
    private static final BdUniqueId axd = BdUniqueId.gen();

    public static synchronized ac Ck() {
        ac acVar;
        synchronized (ac.class) {
            if (axc == null) {
                axc = new ac();
            }
            acVar = axc;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String axe;
        private final boolean axf;
        private final boolean axg;
        private final boolean axh;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.axe = str2;
            this.axf = z;
            this.axg = z2;
            this.axh = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.axd));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ac.this.c(this.imageUrl, this.axe, this.axf, this.axg, this.axh);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String fs = ar.fs(str);
            an.CA().copyFile(str2, fs);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int fn = an.CA().fn(fs);
                    if (fn > 0) {
                        if (z) {
                            Bitmap eQ = an.CA().eQ(fs);
                            com.baidu.tbadk.imageManager.c.Me().fy(fn);
                            if (eQ != null) {
                                a(str, eQ, z2, an.CA().fm(fs), z3, fs);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(String str, String str2, boolean z, boolean z2, boolean z3) {
        new a(str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap e(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.c.a b = b(bitmap.getWidth(), bitmap.getHeight(), z);
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
                kVar.h("bitmap", "null");
            } else {
                kVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                kVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), kVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.Me().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap e = z2 ? e(bitmap) : bitmap;
        if (!z || e == null) {
            bitmap2 = e;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(e, (e.getHeight() < 100 || e.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            an.CA().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
        }
        return bitmap2;
    }

    private void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a2 = a(bitmap, z, z3, str2);
            if (a2 != null) {
                a(str, new com.baidu.adp.widget.ImageView.a(a2, z2));
            }
        } catch (Exception e) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_ADD_MEMORY, "addPicMemoryCache error: " + e.toString(), str);
        }
    }

    public com.baidu.tbadk.core.util.c.a b(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int BV = LocalViewSize.BR().BV();
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
            if (i4 <= i3 && i4 > BV) {
                i3 = (int) (i3 / (i4 / BV));
            } else if (i3 > i4 || i3 <= BV) {
                BV = i4;
            } else {
                BV = (int) (i4 / (i3 / BV));
                i3 = BV;
            }
            if (z2 && i <= BV && i2 <= i3) {
                BV = (int) (BV * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (BV < 70 || i3 >= 70) {
                i6 = i3;
                i5 = BV;
            } else {
                i5 = 70;
            }
            return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
        }
        z2 = false;
        i3 = i2;
        i4 = i;
        if (i4 <= i3) {
        }
        if (i3 > i4) {
        }
        BV = i4;
        if (z2) {
            BV = (int) (BV * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (BV < 70) {
        }
        i6 = i3;
        i5 = BV;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
