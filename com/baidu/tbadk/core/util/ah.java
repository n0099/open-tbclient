package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ah {
    private static ah afx;
    private static final BdUniqueId afy = BdUniqueId.gen();

    public static synchronized ah vh() {
        ah ahVar;
        synchronized (ah.class) {
            if (afx == null) {
                afx = new ah();
            }
            ahVar = afx;
        }
        return ahVar;
    }

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, String> {
        private final boolean afA;
        private final boolean afB;
        private final boolean afC;
        private final String afz;
        private final String imageUrl;

        public a(String str, String str2, boolean z, boolean z2, boolean z3) {
            this.imageUrl = str;
            this.afz = str2;
            this.afA = z;
            this.afB = z2;
            this.afC = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ah.afy));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            try {
                ah.this.b(this.imageUrl, this.afz, this.afA, this.afB, this.afC);
            } catch (Throwable th) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
            }
            return null;
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String dS = ay.dS(str);
            av.vu().aa(str2, dS);
            if (z || z2 || z3) {
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    int dN = av.vu().dN(dS);
                    if (dN > 0) {
                        if (z) {
                            Bitmap dL = av.vu().dL(dS);
                            com.baidu.tbadk.imageManager.c.Eb().eS(dN);
                            if (dL != null) {
                                a(str, dL, z2, av.vu().dM(dS), z3, dS);
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

    public Bitmap f(Bitmap bitmap) {
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
            m mVar = new m();
            if (bitmap == null) {
                mVar.n("bitmap", "null");
            } else {
                mVar.n("bitW", Integer.valueOf(bitmap.getWidth()));
                mVar.n("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), mVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.Eb().c(str, aVar);
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
            av.vu().h(str, BitmapHelper.Bitmap2Bytes(bitmap2, 100));
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
        int uS = LocalViewSize.uO().uS();
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
            if (i4 <= i3 && i4 > uS) {
                i3 = (int) (i3 / (i4 / uS));
            } else if (i3 > i4 || i3 <= uS) {
                uS = i4;
            } else {
                uS = (int) (i4 / (i3 / uS));
                i3 = uS;
            }
            if (z2 && i <= uS && i2 <= i3) {
                uS = (int) (uS * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (uS < 70 || i3 >= 70) {
                i6 = i3;
                i5 = uS;
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
        uS = i4;
        if (z2) {
            uS = (int) (uS * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (uS < 70) {
        }
        i6 = i3;
        i5 = uS;
        return new com.baidu.tbadk.core.util.b.a(i5, i6, z2);
    }
}
