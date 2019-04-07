package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac bJQ;
    private static final BdUniqueId bJR = BdUniqueId.gen();

    public static synchronized ac acQ() {
        ac acVar;
        synchronized (ac.class) {
            if (bJQ == null) {
                bJQ = new ac();
            }
            acVar = bJQ;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String bJS;
        private final boolean bJT;
        private final boolean bJU;
        private final boolean bJV;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.bJS = str2;
            this.bJT = z;
            this.bJU = z2;
            this.bJV = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.bJR));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ac.this.c(this.imageUrl, this.bJS, this.bJT, this.bJU, this.bJV);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String mL = as.mL(str);
            ao.adh().bG(str2, mL);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int mE = ao.adh().mE(mL);
                    if (mE > 0) {
                        if (z) {
                            Bitmap mg = ao.adh().mg(mL);
                            com.baidu.tbadk.imageManager.c.anm().jL(mE);
                            if (mg != null) {
                                a(str, mg, z2, ao.adh().mD(mL), z3, mL);
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

    public Bitmap l(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.c.a d = d(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = d.width;
            int i2 = d.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            l lVar = new l();
            if (bitmap == null) {
                lVar.l("bitmap", "null");
            } else {
                lVar.l("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.l("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.anm().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap l = z2 ? l(bitmap) : bitmap;
        if (!z || l == null) {
            bitmap2 = l;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(l, (l.getHeight() < 100 || l.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            ao.adh().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.c.a d(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int acB = LocalViewSize.acx().acB();
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
            if (i4 <= i3 && i4 > acB) {
                i3 = (int) (i3 / (i4 / acB));
            } else if (i3 > i4 || i3 <= acB) {
                acB = i4;
            } else {
                acB = (int) (i4 / (i3 / acB));
                i3 = acB;
            }
            if (z2 && i <= acB && i2 <= i3) {
                acB = (int) (acB * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (acB < 70 || i3 >= 70) {
                i6 = i3;
                i5 = acB;
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
        acB = i4;
        if (z2) {
            acB = (int) (acB * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (acB < 70) {
        }
        i6 = i3;
        i5 = acB;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
