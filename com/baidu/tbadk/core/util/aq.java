package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class aq {
    public static final Map<Long, Pair<String, String>> mMap = new HashMap();
    private static com.baidu.adp.lib.e.b eME = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.util.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bAt().addBitmap(str, aVar.getRawBitmap());
            }
        }
    };

    public static void e(Long l) {
        if (l.longValue() > 0) {
            mMap.remove(l);
        }
    }

    public static void b(Long l, String str, String str2) {
        if (l != null && l.intValue() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dQ(str, str2);
            mMap.put(l, new Pair<>(str, str2));
        }
    }

    public static void a(long j, bx bxVar) {
        Pair<String, String> pair = mMap.get(Long.valueOf(j));
        if (pair != null) {
            bxVar.setFid(j);
            bxVar.dE((String) pair.first, (String) pair.second);
        }
    }

    public static void a(bx bxVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a an;
        com.baidu.adp.widget.ImageView.a an2;
        BitmapDrawable bitmapDrawable;
        if (bxVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String bmu = bxVar.bmu();
            String bmv = bxVar.bmv();
            if (!StringUtils.isNull(bmu) && !StringUtils.isNull(bmv)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bAt().getBitmap(bmu);
                if ((bitmap == null || !com.baidu.tbadk.core.util.c.x.am(bmu, 10)) && (an = com.baidu.tbadk.core.util.c.x.an(bmu, 10)) != null) {
                    bitmap = an.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bAt().addBitmap(bmu, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bAt().getBitmap(bmv);
                if ((bitmap2 == null || !com.baidu.tbadk.core.util.c.x.am(bmv, 10)) && (an2 = com.baidu.tbadk.core.util.c.x.an(bmv, 10)) != null) {
                    bitmap2 = an2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bAt().addBitmap(bmv, bitmap2);
                }
                Bitmap bitmap3 = bitmap2;
                if (bitmap != null && !bitmap.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < str.length(); i3++) {
                        if (str.charAt(i3) == '#') {
                            if (i2 % 2 == 0) {
                                bitmapDrawable = new BitmapDrawable(bitmap);
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            } else {
                                bitmapDrawable = new BitmapDrawable(bitmap3);
                                bitmapDrawable.setBounds(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
                            }
                            com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                            kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), bxVar.eCJ));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                dQ(bmu, bmv);
            }
        }
    }

    public static void dQ(final String str, final String str2) {
        Bitmap bitmap = com.baidu.tbadk.imageManager.c.bAt().getBitmap(str);
        Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bAt().getBitmap(str2);
        if (bitmap == null || bitmap2 == null) {
            if (!com.baidu.adp.lib.util.l.isMainThread()) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tbadk.core.util.aq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.adp.lib.e.c.mS().a(str, 10, aq.eME, null);
                        com.baidu.adp.lib.e.c.mS().a(str2, 10, aq.eME, null);
                    }
                });
                return;
            }
            com.baidu.adp.lib.e.c.mS().a(str, 10, eME, null);
            com.baidu.adp.lib.e.c.mS().a(str2, 10, eME, null);
        }
    }
}
