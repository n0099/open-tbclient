package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ag {
    private static ag abN;
    private static final BdUniqueId abO = BdUniqueId.gen();

    public static synchronized ag uH() {
        ag agVar;
        synchronized (ag.class) {
            if (abN == null) {
                abN = new ag();
            }
            agVar = abN;
        }
        return agVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String abP;
        private final boolean abQ;
        private final boolean abR;
        private final boolean abS;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.abP = str2;
            this.abQ = z;
            this.abR = z2;
            this.abS = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ag.abO));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            try {
                ag.this.b(this.imageUrl, this.abP, this.abQ, this.abR, this.abS);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dB = az.dB(str);
            aw.uU().copyFile(str2, dB);
            if (z || z2 || z3) {
                synchronized (c.GT) {
                    int dy = aw.uU().dy(dB);
                    if (dy > 0) {
                        if (z) {
                            Bitmap dw = aw.uU().dw(dB);
                            com.baidu.tbadk.imageManager.c.CM().et(dy);
                            if (dw != null) {
                                a(str, dw, z2, aw.uU().dx(dB), z3, dB);
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

    public Bitmap h(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.b.a imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = imageSize.width;
            int i2 = imageSize.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap a2 = c.a(bitmap, i, i2);
                return a2 != null ? a2 : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            m mVar = new m();
            if (bitmap == null) {
                mVar.h("bitmap", "null");
            } else {
                mVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                mVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), mVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.CM().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap h = z2 ? h(bitmap) : bitmap;
        if (!z || h == null) {
            bitmap2 = h;
        } else {
            float f = 10.0f;
            bitmap2 = c.a(h, (h.getHeight() < 100 || h.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            aw.uU().h(str, c.e(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a getImageSize(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int ut = LocalViewSize.uq().ut();
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
            if (i4 <= i3 && i4 > ut) {
                i3 = (int) (i3 / (i4 / ut));
            } else if (i3 > i4 || i3 <= ut) {
                ut = i4;
            } else {
                ut = (int) (i4 / (i3 / ut));
                i3 = ut;
            }
            if (z2 && i <= ut && i2 <= i3) {
                ut = (int) (ut * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (ut < 70 || i3 >= 70) {
                i6 = i3;
                i5 = ut;
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
        ut = i4;
        if (z2) {
            ut = (int) (ut * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (ut < 70) {
        }
        i6 = i3;
        i5 = ut;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
