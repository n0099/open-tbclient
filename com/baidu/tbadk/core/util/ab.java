package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ab {
    private static ab ahp;
    private static final BdUniqueId ahq = BdUniqueId.gen();

    public static synchronized ab vx() {
        ab abVar;
        synchronized (ab.class) {
            if (ahp == null) {
                ahp = new ab();
            }
            abVar = ahp;
        }
        return abVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final String ahr;
        private final boolean ahs;
        private final boolean aht;
        private final boolean ahu;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.ahr = str2;
            this.ahs = z;
            this.aht = z2;
            this.ahu = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ab.ahq));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ab.this.b(this.imageUrl, this.ahr, this.ahs, this.aht, this.ahu);
            } finally {
                return null;
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String eb = an.eb(str);
            ak.vK().X(str2, eb);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dW = ak.vK().dW(eb);
                    if (dW > 0) {
                        if (z) {
                            Bitmap dU = ak.vK().dU(eb);
                            com.baidu.tbadk.imageManager.c.Ex().eX(dW);
                            if (dU != null) {
                                a(str, dU, z2, ak.vK().dV(eb), z3, eb);
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
            j jVar = new j();
            if (bitmap == null) {
                jVar.n("bitmap", "null");
            } else {
                jVar.n("bitW", Integer.valueOf(bitmap.getWidth()));
                jVar.n("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), jVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.Ex().c(str, aVar);
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
            ak.vK().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int vi = LocalViewSize.ve().vi();
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
            if (i4 <= i3 && i4 > vi) {
                i3 = (int) (i3 / (i4 / vi));
            } else if (i3 > i4 || i3 <= vi) {
                vi = i4;
            } else {
                vi = (int) (i4 / (i3 / vi));
                i3 = vi;
            }
            if (z2 && i <= vi && i2 <= i3) {
                vi = (int) (vi * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (vi < 70 || i3 >= 70) {
                i6 = i3;
                i5 = vi;
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
        vi = i4;
        if (z2) {
            vi = (int) (vi * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (vi < 70) {
        }
        i6 = i3;
        i5 = vi;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
