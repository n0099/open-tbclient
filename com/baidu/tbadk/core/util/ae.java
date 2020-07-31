package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ae {
    private static ae eay;
    private static final BdUniqueId eaz = BdUniqueId.gen();

    public static synchronized ae baB() {
        ae aeVar;
        synchronized (ae.class) {
            if (eay == null) {
                eay = new ae();
            }
            aeVar = eay;
        }
        return aeVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String eaA;
        private final boolean eaB;
        private final boolean eaC;
        private final boolean eaD;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.eaA = str2;
            this.eaB = z;
            this.eaC = z2;
            this.eaD = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ae.eaz));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ae.this.b(this.imageUrl, this.eaA, this.eaB, this.eaC, this.eaD);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String nameMd5FromUrl = au.getNameMd5FromUrl(str);
            ar.baP().copyFile(str2, nameMd5FromUrl);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int xR = ar.baP().xR(nameMd5FromUrl);
                    if (xR > 0) {
                        if (z) {
                            Bitmap image = ar.baP().getImage(nameMd5FromUrl);
                            com.baidu.tbadk.imageManager.c.bkk().freePicCache(xR);
                            if (image != null) {
                                a(str, image, z2, ar.baP().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
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
            com.baidu.tbadk.core.util.b.a h = h(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = h.width;
            int i2 = h.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
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
        com.baidu.tbadk.imageManager.c.bkk().c(str, aVar);
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
            ar.baP().j(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a h(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int msgSPicMaxSizeInt = LocalViewSize.bas().getMsgSPicMaxSizeInt();
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
