package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac aUS;
    private static final BdUniqueId aUT = BdUniqueId.gen();

    public static synchronized ac Cr() {
        ac acVar;
        synchronized (ac.class) {
            if (aUS == null) {
                aUS = new ac();
            }
            acVar = aUS;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String aUU;
        private final boolean aUV;
        private final boolean aUW;
        private final boolean aUX;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.aUU = str2;
            this.aUV = z;
            this.aUW = z2;
            this.aUX = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.aUT));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ac.this.a(this.imageUrl, this.aUU, this.aUV, this.aUW, this.aUX);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String ee = ao.ee(str);
            al.CE().Y(str2, ee);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dZ = al.CE().dZ(ee);
                    if (dZ > 0) {
                        if (z) {
                            Bitmap dX = al.CE().dX(ee);
                            com.baidu.tbadk.imageManager.c.LP().ia(dZ);
                            if (dX != null) {
                                a(str, dX, z2, al.CE().dY(ee), z3, ee);
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

    public Bitmap f(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.b.a e = e(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = e.width;
            int i2 = e.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e2) {
            j jVar = new j();
            if (bitmap == null) {
                jVar.h("bitmap", "null");
            } else {
                jVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                jVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e2.toString(), jVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.LP().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap f = z2 ? f(bitmap) : bitmap;
        if (!z || f == null) {
            bitmap2 = f;
        } else {
            float f2 = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(f, (f.getHeight() < 100 || f.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            al.CE().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.b.a e(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int Cc = LocalViewSize.BY().Cc();
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
            if (i4 <= i3 && i4 > Cc) {
                i3 = (int) (i3 / (i4 / Cc));
            } else if (i3 > i4 || i3 <= Cc) {
                Cc = i4;
            } else {
                Cc = (int) (i4 / (i3 / Cc));
                i3 = Cc;
            }
            if (z2 && i <= Cc && i2 <= i3) {
                Cc = (int) (Cc * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (Cc < 70 || i3 >= 70) {
                i6 = i3;
                i5 = Cc;
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
        Cc = i4;
        if (z2) {
            Cc = (int) (Cc * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (Cc < 70) {
        }
        i6 = i3;
        i5 = Cc;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
