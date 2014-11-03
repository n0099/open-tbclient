package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ap {
    private static ap EL;
    private static final BdUniqueId EM = BdUniqueId.gen();

    public static synchronized ap mw() {
        ap apVar;
        synchronized (ap.class) {
            if (EL == null) {
                EL = new ap();
            }
            apVar = EL;
        }
        return apVar;
    }

    public void a(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (str2 != null && str != null) {
            String bQ = bb.bQ(str);
            ay.my().copyFile(str2, bQ);
            if (z || z2 || z3) {
                synchronized (d.tg) {
                    int bP = ay.my().bP(bQ);
                    if (bP > 0) {
                        if (z) {
                            Bitmap bN = ay.my().bN(bQ);
                            com.baidu.tbadk.imageManager.e.si().cR(bP);
                            if (bN != null) {
                                a(str, bN, z2, ay.my().bO(bQ), z3, bQ);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(String str, String str2, boolean z, boolean z2, boolean z3) {
        new aq(this, str2, str2, z3, z3, z3).execute(new String[0]);
    }

    public Bitmap c(Bitmap bitmap) {
        return a(bitmap, true);
    }

    public Bitmap a(Bitmap bitmap, boolean z) {
        try {
            com.baidu.tbadk.core.util.a.a a = a(bitmap.getWidth(), bitmap.getHeight(), z);
            int i = a.width;
            int i2 = a.height;
            if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                Bitmap b = d.b(bitmap, i, i2);
                return b != null ? b : bitmap;
            }
            return bitmap;
        } catch (Exception e) {
            r rVar = new r();
            if (bitmap == null) {
                rVar.g("bitmap", "null");
            } else {
                rVar.g("bitW", Integer.valueOf(bitmap.getWidth()));
                rVar.g("bitH", Integer.valueOf(bitmap.getHeight()));
            }
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_RESIZE, "getResizedBitmap error: " + e.toString(), rVar.toString());
            return bitmap;
        }
    }

    private static void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.si().c(str, aVar);
    }

    public Bitmap a(Bitmap bitmap, boolean z, boolean z2, String str) {
        Bitmap bitmap2;
        Bitmap c = z2 ? c(bitmap) : bitmap;
        if (!z || c == null) {
            bitmap2 = c;
        } else {
            float f = 10.0f;
            bitmap2 = d.a(c, (c.getHeight() < 100 || c.getWidth() < 100) ? 5.0f : 5.0f, true);
        }
        if (!TextUtils.isEmpty(str)) {
            ay.my().f(str, d.b(bitmap2, 100));
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

    public com.baidu.tbadk.core.util.a.a a(int i, int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6 = 70;
        int lZ = LocalViewSize.lV().lZ();
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
            if (i4 <= i3 && i4 > lZ) {
                i3 = (int) (i3 / (i4 / lZ));
            } else if (i3 > i4 || i3 <= lZ) {
                lZ = i4;
            } else {
                lZ = (int) (i4 / (i3 / lZ));
                i3 = lZ;
            }
            if (z2 && i <= lZ && i2 <= i3) {
                lZ = (int) (lZ * 0.9d);
                i3 = (int) (i3 * 0.9d);
            }
            if (lZ < 70 || i3 >= 70) {
                i6 = i3;
                i5 = lZ;
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
        lZ = i4;
        if (z2) {
            lZ = (int) (lZ * 0.9d);
            i3 = (int) (i3 * 0.9d);
        }
        if (lZ < 70) {
        }
        i6 = i3;
        i5 = lZ;
        return new com.baidu.tbadk.core.util.a.a(i5, i6, z2);
    }
}
