package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ai {
    private static ai aaK;
    private static final BdUniqueId aaL = BdUniqueId.gen();

    public static synchronized ai uQ() {
        ai aiVar;
        synchronized (ai.class) {
            if (aaK == null) {
                aaK = new ai();
            }
            aiVar = aaK;
        }
        return aiVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String aaM;
        private final boolean aaN;
        private final boolean aaO;
        private final boolean aaP;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aaM = str2;
            this.aaN = z;
            this.aaO = z2;
            this.aaP = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ai.aaL));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ai.this.b(this.imageUrl, this.aaM, this.aaN, this.aaO, this.aaP);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dC = bc.dC(str);
            az.vd().ac(str2, dC);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dA = az.vd().dA(dC);
                    if (dA > 0) {
                        if (z) {
                            Bitmap dy = az.vd().dy(dC);
                            com.baidu.tbadk.imageManager.c.Ek().eR(dA);
                            if (dy != null) {
                                a(str, dy, z2, az.vd().dz(dC), z3, dC);
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

    public Bitmap g(Bitmap bitmap) {
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
            l lVar = new l();
            if (bitmap == null) {
                lVar.n("bitmap", "null");
            } else {
                lVar.n("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.n("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.Ek().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap g = z2 ? g(bitmap) : bitmap;
        if (!z || g == null) {
            bitmap2 = g;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(g, (g.getHeight() < 100 || g.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            az.vd().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int uA = LocalViewSize.uw().uA();
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
            if (i4 <= i3 && i4 > uA) {
                i3 = (int) (i3 / (i4 / uA));
            } else if (i3 > i4 || i3 <= uA) {
                uA = i4;
            } else {
                uA = (int) (i4 / (i3 / uA));
                i3 = uA;
            }
            if (z2 && i <= uA && i2 <= i3) {
                uA = (int) (uA * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uA < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uA;
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
        uA = i4;
        if (z2) {
            uA = (int) (uA * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uA < 70) {
        }
        i6 = i3;
        i5 = uA;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
