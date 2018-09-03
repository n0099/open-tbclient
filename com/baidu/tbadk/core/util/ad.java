package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ad {
    private static ad apT;
    private static final BdUniqueId apU = BdUniqueId.gen();

    public static synchronized ad yY() {
        ad adVar;
        synchronized (ad.class) {
            if (apT == null) {
                apT = new ad();
            }
            adVar = apT;
        }
        return adVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String apV;
        private final boolean apW;
        private final boolean apX;
        private final boolean apY;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.apV = str2;
            this.apW = z;
            this.apX = z2;
            this.apY = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ad.apU));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ad.this.b(this.imageUrl, this.apV, this.apW, this.apX, this.apY);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String eM = as.eM(str);
            ao.zo().ab(str2, eM);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int eH = ao.zo().eH(eM);
                    if (eH > 0) {
                        if (z) {
                            Bitmap ei = ao.zo().ei(eM);
                            com.baidu.tbadk.imageManager.c.IQ().fd(eH);
                            if (ei != null) {
                                a(str, ei, z2, ao.zo().eG(eM), z3, eM);
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

    public Bitmap d(Bitmap bitmap) {
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
        com.baidu.tbadk.imageManager.c.IQ().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap d = z2 ? d(bitmap) : bitmap;
        if (!z || d == null) {
            bitmap2 = d;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(d, (d.getHeight() < 100 || d.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            ao.zo().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int yJ = LocalViewSize.yF().yJ();
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
            if (i4 <= i3 && i4 > yJ) {
                i3 = (int) (i3 / (i4 / yJ));
            } else if (i3 > i4 || i3 <= yJ) {
                yJ = i4;
            } else {
                yJ = (int) (i4 / (i3 / yJ));
                i3 = yJ;
            }
            if (z2 && i <= yJ && i2 <= i3) {
                yJ = (int) (yJ * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (yJ < 70 || i3 >= 70) {
                i6 = i3;
                i5 = yJ;
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
        yJ = i4;
        if (z2) {
            yJ = (int) (yJ * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (yJ < 70) {
        }
        i6 = i3;
        i5 = yJ;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
