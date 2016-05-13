package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ah {
    private static ah WV;
    private static final BdUniqueId WW = BdUniqueId.gen();

    public static synchronized ah tM() {
        ah ahVar;
        synchronized (ah.class) {
            if (WV == null) {
                WV = new ah();
            }
            ahVar = WV;
        }
        return ahVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String WX;
        private final boolean WY;
        private final boolean WZ;
        private final boolean Xa;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.WX = str2;
            this.WY = z;
            this.WZ = z2;
            this.Xa = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ah.WW));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ah.this.b(this.imageUrl, this.WX, this.WY, this.WZ, this.Xa);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dy = ba.dy(str);
            ax.tZ().ad(str2, dy);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dv = ax.tZ().dv(dy);
                    if (dv > 0) {
                        if (z) {
                            Bitmap dt = ax.tZ().dt(dy);
                            com.baidu.tbadk.imageManager.c.CI().ey(dv);
                            if (dt != null) {
                                a(str, dt, z2, ax.tZ().du(dy), z3, dy);
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
        com.baidu.tbadk.imageManager.c.CI().c(str, aVar);
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
            ax.tZ().g(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int ty = LocalViewSize.tu().ty();
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
            if (i4 <= i3 && i4 > ty) {
                i3 = (int) (i3 / (i4 / ty));
            } else if (i3 > i4 || i3 <= ty) {
                ty = i4;
            } else {
                ty = (int) (i4 / (i3 / ty));
                i3 = ty;
            }
            if (z2 && i <= ty && i2 <= i3) {
                ty = (int) (ty * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (ty < 70 || i3 >= 70) {
                i6 = i3;
                i5 = ty;
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
        ty = i4;
        if (z2) {
            ty = (int) (ty * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (ty < 70) {
        }
        i6 = i3;
        i5 = ty;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
