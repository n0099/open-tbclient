package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac agM;
    private static final BdUniqueId agN = BdUniqueId.gen();

    public static synchronized ac vc() {
        ac acVar;
        synchronized (ac.class) {
            if (agM == null) {
                agM = new ac();
            }
            acVar = agM;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String agO;
        private final boolean agP;
        private final boolean agQ;
        private final boolean agR;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.agO = str2;
            this.agP = z;
            this.agQ = z2;
            this.agR = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.agN));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ac.this.a(this.imageUrl, this.agO, this.agP, this.agQ, this.agR);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dX = ao.dX(str);
            al.vp().Z(str2, dX);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dS = al.vp().dS(dX);
                    if (dS > 0) {
                        if (z) {
                            Bitmap dQ = al.vp().dQ(dX);
                            com.baidu.tbadk.imageManager.c.Ez().fg(dS);
                            if (dQ != null) {
                                a(str, dQ, z2, al.vp().dR(dX), z3, dX);
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

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.Ez().c(str, aVar);
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
            al.vp().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a b(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int uN = LocalViewSize.uJ().uN();
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
            if (i4 <= i3 && i4 > uN) {
                i3 = (int) (i3 / (i4 / uN));
            } else if (i3 > i4 || i3 <= uN) {
                uN = i4;
            } else {
                uN = (int) (i4 / (i3 / uN));
                i3 = uN;
            }
            if (z2 && i <= uN && i2 <= i3) {
                uN = (int) (uN * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uN < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uN;
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
        uN = i4;
        if (z2) {
            uN = (int) (uN * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uN < 70) {
        }
        i6 = i3;
        i5 = uN;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
