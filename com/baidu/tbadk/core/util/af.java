package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class af {
    private static af fap;
    private static final BdUniqueId faq = BdUniqueId.gen();

    public static synchronized af bsA() {
        af afVar;
        synchronized (af.class) {
            if (fap == null) {
                fap = new af();
            }
            afVar = fap;
        }
        return afVar;
    }

    public Bitmap u(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.c.a i = i(bitmap.getWidth(), bitmap.getHeight(), z);
            int i2 = i.width;
            int i3 = i.height;
            if (i2 != bitmap.getWidth() || i3 != bitmap.getHeight()) {
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2, i3);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            n nVar = new n();
            if (bitmap == null) {
                nVar.append("bitmap", "null");
            } else {
                nVar.append("bitW", Integer.valueOf(bitmap.getWidth()));
                nVar.append("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError(-1005, "getResizedBitmap error: " + e.toString(), nVar.toString());
            return bitmap;
        }
    }

    public com.baidu.tbadk.core.util.c.a i(int i, int i2, boolean z) {
        int i3;
        int i4;
        boolean z2 = true;
        int msgSPicMaxSizeInt = LocalViewSize.bso().getMsgSPicMaxSizeInt();
        if (z) {
            if (i / i2 >= 3) {
                i3 = i / 2;
                i4 = i;
            } else if (i2 / i >= 3) {
                i4 = i2 / 2;
                i3 = i2;
            }
            if (i4 <= i3 && i4 > msgSPicMaxSizeInt) {
                i3 = (int) (i3 / (i4 / msgSPicMaxSizeInt));
                i4 = msgSPicMaxSizeInt;
            } else if (i3 > i4 && i3 > msgSPicMaxSizeInt) {
                i4 = (int) (i4 / (i3 / msgSPicMaxSizeInt));
                i3 = msgSPicMaxSizeInt;
            }
            if (z2 && i <= i4 && i2 <= i3) {
                i4 = (int) (i4 * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (i4 < 70 && i3 < 70) {
                i3 = 70;
                i4 = 70;
            }
            return new com.baidu.tbadk.core.util.c.a(i4, i3, z2);
        }
        z2 = false;
        i3 = i2;
        i4 = i;
        if (i4 <= i3) {
        }
        if (i3 > i4) {
            i4 = (int) (i4 / (i3 / msgSPicMaxSizeInt));
            i3 = msgSPicMaxSizeInt;
        }
        if (z2) {
            i4 = (int) (i4 * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (i4 < 70) {
            i3 = 70;
            i4 = 70;
        }
        return new com.baidu.tbadk.core.util.c.a(i4, i3, z2);
    }
}
