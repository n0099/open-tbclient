package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ac {
    private static ac ahL;
    private static final BdUniqueId ahM = BdUniqueId.gen();

    public static synchronized ac vu() {
        ac acVar;
        synchronized (ac.class) {
            if (ahL == null) {
                ahL = new ac();
            }
            acVar = ahL;
        }
        return acVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String ahN;
        private final boolean ahO;
        private final boolean ahP;
        private final boolean ahQ;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.ahN = str2;
            this.ahO = z;
            this.ahP = z2;
            this.ahQ = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ac.ahM));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ac.this.b(this.imageUrl, this.ahN, this.ahO, this.ahP, this.ahQ);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String em = aq.em(str);
            am.vJ().Z(str2, em);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int eh = am.vJ().eh(em);
                    if (eh > 0) {
                        if (z) {
                            Bitmap dH = am.vJ().dH(em);
                            com.baidu.tbadk.imageManager.c.EY().eY(eh);
                            if (dH != null) {
                                a(str, dH, z2, am.vJ().eg(em), z3, em);
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

    public Bitmap e(Bitmap bitmap) {
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
        com.baidu.tbadk.imageManager.c.EY().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap e = z2 ? e(bitmap) : bitmap;
        if (!z || e == null) {
            bitmap2 = e;
        } else {
            float f = 10.0f;
            bitmap2 = BitmapHelper.getRoundedCornerBitmap(e, (e.getHeight() < 100 || e.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            am.vJ().i(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int vf = LocalViewSize.vb().vf();
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
            if (i4 <= i3 && i4 > vf) {
                i3 = (int) (i3 / (i4 / vf));
            } else if (i3 > i4 || i3 <= vf) {
                vf = i4;
            } else {
                vf = (int) (i4 / (i3 / vf));
                i3 = vf;
            }
            if (z2 && i <= vf && i2 <= i3) {
                vf = (int) (vf * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (vf < 70 || i3 >= 70) {
                i6 = i3;
                i5 = vf;
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
        vf = i4;
        if (z2) {
            vf = (int) (vf * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (vf < 70) {
        }
        i6 = i3;
        i5 = vf;
        return new com.baidu.tbadk.core.util.c.a(i5, i6, z2);
    }
}
