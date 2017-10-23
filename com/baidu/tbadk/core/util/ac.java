package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac afT;
    private static final BdUniqueId afU = BdUniqueId.gen();

    public static synchronized ac uS() {
        ac acVar;
        synchronized (ac.class) {
            if (afT == null) {
                afT = new ac();
            }
            acVar = afT;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String afV;
        private final boolean afW;
        private final boolean afX;
        private final boolean afY;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.afV = str2;
            this.afW = z;
            this.afX = z2;
            this.afY = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.afU));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ac.this.a(this.imageUrl, this.afV, this.afW, this.afX, this.afY);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dP = ao.dP(str);
            al.vf().Z(str2, dP);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dK = al.vf().dK(dP);
                    if (dK > 0) {
                        if (z) {
                            Bitmap dI = al.vf().dI(dP);
                            com.baidu.tbadk.imageManager.c.DT().fh(dK);
                            if (dI != null) {
                                a(str, dI, z2, al.vf().dJ(dP), z3, dP);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        new a(str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap c(Bitmap bitmap) {
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
            j jVar = new j();
            if (bitmap == null) {
                jVar.h("bitmap", "null");
            } else {
                jVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                jVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), jVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.DT().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap c = z2 ? c(bitmap) : bitmap;
        if (!z || c == null) {
            bitmap2 = c;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(c, (c.getHeight() < 100 || c.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            al.vf().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a b(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int uD = LocalViewSize.uz().uD();
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
            if (i4 <= i3 && i4 > uD) {
                i3 = (int) (i3 / (i4 / uD));
            } else if (i3 > i4 || i3 <= uD) {
                uD = i4;
            } else {
                uD = (int) (i4 / (i3 / uD));
                i3 = uD;
            }
            if (z2 && i <= uD && i2 <= i3) {
                uD = (int) (uD * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uD < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uD;
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
        uD = i4;
        if (z2) {
            uD = (int) (uD * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uD < 70) {
        }
        i6 = i3;
        i5 = uD;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
