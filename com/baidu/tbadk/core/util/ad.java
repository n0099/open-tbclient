package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ad {
    private static ad aqr;
    private static final BdUniqueId aqs = BdUniqueId.gen();

    public static synchronized ad zj() {
        ad adVar;
        synchronized (ad.class) {
            if (aqr == null) {
                aqr = new ad();
            }
            adVar = aqr;
        }
        return adVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String aqt;
        private final boolean aqu;
        private final boolean aqv;
        private final boolean aqw;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aqt = str2;
            this.aqu = z;
            this.aqv = z2;
            this.aqw = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ad.aqs));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ad.this.b(this.imageUrl, this.aqt, this.aqu, this.aqv, this.aqw);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String eO = as.eO(str);
            ao.zz().ac(str2, eO);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int eJ = ao.zz().eJ(eO);
                    if (eJ > 0) {
                        if (z) {
                            Bitmap ek = ao.zz().ek(eO);
                            com.baidu.tbadk.imageManager.c.IV().fd(eJ);
                            if (ek != null) {
                                a(str, ek, z2, ao.zz().eI(eO), z3, eO);
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
        com.baidu.tbadk.imageManager.c.IV().c(str, aVar);
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
            ao.zz().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int yU = LocalViewSize.yQ().yU();
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
            if (i4 <= i3 && i4 > yU) {
                i3 = (int) (i3 / (i4 / yU));
            } else if (i3 > i4 || i3 <= yU) {
                yU = i4;
            } else {
                yU = (int) (i4 / (i3 / yU));
                i3 = yU;
            }
            if (z2 && i <= yU && i2 <= i3) {
                yU = (int) (yU * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (yU < 70 || i3 >= 70) {
                i6 = i3;
                i5 = yU;
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
        yU = i4;
        if (z2) {
            yU = (int) (yU * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (yU < 70) {
        }
        i6 = i3;
        i5 = yU;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
