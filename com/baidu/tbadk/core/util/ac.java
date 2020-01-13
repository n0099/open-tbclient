package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac cVC;
    private static final BdUniqueId cVD = BdUniqueId.gen();

    public static synchronized ac aEa() {
        ac acVar;
        synchronized (ac.class) {
            if (cVC == null) {
                cVC = new ac();
            }
            acVar = cVC;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String cVE;
        private final boolean cVF;
        private final boolean cVG;
        private final boolean cVH;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.cVE = str2;
            this.cVF = z;
            this.cVG = z2;
            this.cVH = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.cVD));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ac.this.b(this.imageUrl, this.cVE, this.cVF, this.cVG, this.cVH);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(str);
            ap.aEn().copyFile(str2, nameMd5FromUrl);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int th = ap.aEn().th(nameMd5FromUrl);
                    if (th > 0) {
                        if (z) {
                            Bitmap image = ap.aEn().getImage(nameMd5FromUrl);
                            com.baidu.tbadk.imageManager.c.aNs().freePicCache(th);
                            if (image != null) {
                                a(str, image, z2, ap.aEn().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
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

    public Bitmap n(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.c.a g = g(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = g.width;
            int i2 = g.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            l lVar = new l();
            if (bitmap == null) {
                lVar.append("bitmap", "null");
            } else {
                lVar.append("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.append("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(-1005, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.aNs().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap n = z2 ? n(bitmap) : bitmap;
        if (!z || n == null) {
            bitmap2 = n;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(n, (n.getHeight() < 100 || n.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            ap.aEn().j(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
            TiebaStatic.imgError(-1006, "addPicMemoryCache error: " + e.toString(), str);
        }
    }

    public com.baidu.tbadk.core.util.c.a g(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int msgSPicMaxSizeInt = LocalViewSize.aDR().getMsgSPicMaxSizeInt();
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
            if (i4 <= i3 && i4 > msgSPicMaxSizeInt) {
                i3 = (int) (i3 / (i4 / msgSPicMaxSizeInt));
            } else if (i3 > i4 || i3 <= msgSPicMaxSizeInt) {
                msgSPicMaxSizeInt = i4;
            } else {
                msgSPicMaxSizeInt = (int) (i4 / (i3 / msgSPicMaxSizeInt));
                i3 = msgSPicMaxSizeInt;
            }
            if (z2 && i <= msgSPicMaxSizeInt && i2 <= i3) {
                msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (msgSPicMaxSizeInt < 70 || i3 >= 70) {
                i6 = i3;
                i5 = msgSPicMaxSizeInt;
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
        msgSPicMaxSizeInt = i4;
        if (z2) {
            msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (msgSPicMaxSizeInt < 70) {
        }
        i6 = i3;
        i5 = msgSPicMaxSizeInt;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
