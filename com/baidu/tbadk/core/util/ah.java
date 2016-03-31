package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ah {
    private static ah abw;
    private static final BdUniqueId abx = BdUniqueId.gen();

    public static synchronized ah wf() {
        ah ahVar;
        synchronized (ah.class) {
            if (abw == null) {
                abw = new ah();
            }
            ahVar = abw;
        }
        return ahVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final boolean abA;
        private final boolean abB;
        private final String aby;
        private final boolean abz;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aby = str2;
            this.abz = z;
            this.abA = z2;
            this.abB = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ah.abx));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            try {
                ah.this.b(this.imageUrl, this.aby, this.abz, this.abA, this.abB);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dB = ba.dB(str);
            ax.ws().ad(str2, dB);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dy = ax.ws().dy(dB);
                    if (dy > 0) {
                        if (z) {
                            Bitmap dw = ax.ws().dw(dB);
                            com.baidu.tbadk.imageManager.c.EO().eT(dy);
                            if (dw != null) {
                                a(str, dw, z2, ax.ws().dx(dB), z3, dB);
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
                lVar.h("bitmap", "null");
            } else {
                lVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                lVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), lVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.EO().c(str, aVar);
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
            ax.ws().g(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int vR = LocalViewSize.vN().vR();
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
            if (i4 <= i3 && i4 > vR) {
                i3 = (int) (i3 / (i4 / vR));
            } else if (i3 > i4 || i3 <= vR) {
                vR = i4;
            } else {
                vR = (int) (i4 / (i3 / vR));
                i3 = vR;
            }
            if (z2 && i <= vR && i2 <= i3) {
                vR = (int) (vR * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (vR < 70 || i3 >= 70) {
                i6 = i3;
                i5 = vR;
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
        vR = i4;
        if (z2) {
            vR = (int) (vR * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (vR < 70) {
        }
        i6 = i3;
        i5 = vR;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
