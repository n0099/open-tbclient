package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class al {
    private static al Vq;
    private static final BdUniqueId Vr = BdUniqueId.gen();

    public static synchronized al tm() {
        al alVar;
        synchronized (al.class) {
            if (Vq == null) {
                Vq = new al();
            }
            alVar = Vq;
        }
        return alVar;
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String db = bd.db(str);
            ba.tw().copyFile(str2, db);
            if (z || z2 || z3) {
                synchronized (c.Gk) {
                    int da = ba.tw().da(db);
                    if (da > 0) {
                        if (z) {
                            Bitmap image = ba.tw().getImage(db);
                            com.baidu.tbadk.imageManager.e.Am().dN(da);
                            if (image != null) {
                                a(str, image, z2, ba.tw().cZ(db), z3, db);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        new am(this, str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap f(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.a.a imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = imageSize.width;
            int i2 = imageSize.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap a = c.a(bitmap, i, i2);
                return a != null ? a : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            n nVar = new n();
            if (bitmap == null) {
                nVar.h("bitmap", "null");
            } else {
                nVar.h("bitW", Integer.valueOf(bitmap.getWidth()));
                nVar.h("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), nVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.Am().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap f = z2 ? f(bitmap) : bitmap;
        if (!z || f == null) {
            bitmap2 = f;
        } else {
            float f2 = 10.0f;
            bitmap2 = c.a(f, (f.getHeight() < 100 || f.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            ba.tw().h(str, c.e(bitmap2, 100));
        }
        return bitmap2;
    }

    private void a(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        try {
            Bitmap a = a(bitmap, z, z3, str2);
            if (a != null) {
                a(str, new com.baidu.adp.widget.a.a(a, z2));
            }
        } catch (Exception e) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_ADD_MEMORY, "addPicMemoryCache error: " + e.toString(), str);
        }
    }

    public com.baidu.tbadk.core.util.a.a getImageSize(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int sU = LocalViewSize.sR().sU();
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
            if (i4 <= i3 && i4 > sU) {
                i3 = (int) (i3 / (i4 / sU));
            } else if (i3 > i4 || i3 <= sU) {
                sU = i4;
            } else {
                sU = (int) (i4 / (i3 / sU));
                i3 = sU;
            }
            if (z2 && i <= sU && i2 <= i3) {
                sU = (int) (sU * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (sU < 70 || i3 >= 70) {
                i6 = i3;
                i5 = sU;
            } else {
                i5 = 70;
            }
            return new com.baidu.tbadk.core.util.a.a(i5, i6, z2);
        }
        z2 = false;
        i3 = i2;
        i4 = i;
        if (i4 <= i3) {
        }
        if (i3 > i4) {
        }
        sU = i4;
        if (z2) {
            sU = (int) (sU * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (sU < 70) {
        }
        i6 = i3;
        i5 = sU;
        return new com.baidu.tbadk.core.util.a.a(i5, i6, z2);
    }
}
