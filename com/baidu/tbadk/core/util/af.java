package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class af {
    private static af eTh;
    private static final BdUniqueId eTi = BdUniqueId.gen();

    public static synchronized af btE() {
        af afVar;
        synchronized (af.class) {
            if (eTh == null) {
                eTh = new af();
            }
            afVar = eTh;
        }
        return afVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String eTj;
        private final boolean eTk;
        private final boolean eTl;
        private final boolean eTm;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.eTj = str2;
            this.eTk = z;
            this.eTl = z2;
            this.eTm = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, af.eTi));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                af.this.b(this.imageUrl, this.eTj, this.eTk, this.eTl, this.eTm);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String nameMd5FromUrl = aw.getNameMd5FromUrl(str);
            at.btU().copyFile(str2, nameMd5FromUrl);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int Cb = at.btU().Cb(nameMd5FromUrl);
                    if (Cb > 0) {
                        if (z) {
                            Bitmap image = at.btU().getImage(nameMd5FromUrl);
                            com.baidu.tbadk.imageManager.c.bDV().freePicCache(Cb);
                            if (image != null) {
                                a(str, image, z2, at.btU().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
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

    public Bitmap u(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.b.a i = i(bitmap.getWidth(), bitmap.getHeight(), z);
            int i2 = i.width;
            int i3 = i.height;
            if (i2 != bitmap.getWidth() || i3 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2, i3);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            m mVar = new m();
            if (bitmap == null) {
                mVar.append("bitmap", "null");
            } else {
                mVar.append("bitW", Integer.valueOf(bitmap.getWidth()));
                mVar.append("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(-1005, "getResizedBitmap error: " + e.toString(), mVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.bDV().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap u = z2 ? u(bitmap) : bitmap;
        if (!z || u == null) {
            bitmap2 = u;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(u, (u.getHeight() < 100 || u.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            at.btU().j(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a i(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int msgSPicMaxSizeInt = LocalViewSize.bts().getMsgSPicMaxSizeInt();
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
            return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
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
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
