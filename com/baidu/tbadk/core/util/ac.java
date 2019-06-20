package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac bRC;
    private static final BdUniqueId bRD = BdUniqueId.gen();

    public static synchronized ac ahO() {
        ac acVar;
        synchronized (ac.class) {
            if (bRC == null) {
                bRC = new ac();
            }
            acVar = bRC;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String bRE;
        private final boolean bRF;
        private final boolean bRG;
        private final boolean bRH;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.bRE = str2;
            this.bRF = z;
            this.bRG = z2;
            this.bRH = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.bRD));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ac.this.c(this.imageUrl, this.bRE, this.bRF, this.bRG, this.bRH);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String nS = as.nS(str);
            ao.aig().bQ(str2, nS);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int nL = ao.aig().nL(nS);
                    if (nL > 0) {
                        if (z) {
                            Bitmap nn = ao.aig().nn(nS);
                            com.baidu.tbadk.imageManager.c.asp().kz(nL);
                            if (nn != null) {
                                a(str, nn, z2, ao.aig().nK(nS), z3, nS);
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
            com.baidu.tbadk.core.util.c.a f = f(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = f.width;
            int i2 = f.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            l lVar = new l();
            if (bitmap == null) {
                lVar.o("bitmap", "null");
            } else {
                lVar.o("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.o("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.asp().c(str, aVar);
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
            ao.aig().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.c.a f(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int ahz = LocalViewSize.ahv().ahz();
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
            if (i4 <= i3 && i4 > ahz) {
                i3 = (int) (i3 / (i4 / ahz));
            } else if (i3 > i4 || i3 <= ahz) {
                ahz = i4;
            } else {
                ahz = (int) (i4 / (i3 / ahz));
                i3 = ahz;
            }
            if (z2 && i <= ahz && i2 <= i3) {
                ahz = (int) (ahz * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (ahz < 70 || i3 >= 70) {
                i6 = i3;
                i5 = ahz;
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
        ahz = i4;
        if (z2) {
            ahz = (int) (ahz * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (ahz < 70) {
        }
        i6 = i3;
        i5 = ahz;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
