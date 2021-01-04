package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ap {
    public static final Map<Long, Pair<String, String>> mMap = new HashMap();
    private static com.baidu.adp.lib.e.c fdn = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.util.ap.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bGp().addBitmap(str, aVar.getRawBitmap());
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
            dW(str, str2);
            mMap.put(l, new Pair<>(str, str2));
        }
    }

    public static void a(long j, bz bzVar) {
        Pair<String, String> pair = mMap.get(Long.valueOf(j));
        if (pair != null) {
            bzVar.setFid(j);
            bzVar.dK((String) pair.first, (String) pair.second);
        }
    }

    public static void a(bz bzVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a aq;
        com.baidu.adp.widget.ImageView.a aq2;
        BitmapDrawable bitmapDrawable;
        if (bzVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String bsi = bzVar.bsi();
            String bsj = bzVar.bsj();
            if (!StringUtils.isNull(bsi) && !StringUtils.isNull(bsj)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bGp().getBitmap(bsi);
                if ((bitmap == null || !com.baidu.tbadk.core.util.d.s.ap(bsi, 10)) && (aq = com.baidu.tbadk.core.util.d.s.aq(bsi, 10)) != null) {
                    bitmap = aq.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bGp().addBitmap(bsi, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bGp().getBitmap(bsj);
                if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.s.ap(bsj, 10)) && (aq2 = com.baidu.tbadk.core.util.d.s.aq(bsj, 10)) != null) {
                    bitmap2 = aq2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bGp().addBitmap(bsj, bitmap2);
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
                            kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), bzVar.eTF));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                dW(bsi, bsj);
            }
        }
    }

    public static void dW(final String str, final String str2) {
        Bitmap bitmap = com.baidu.tbadk.imageManager.c.bGp().getBitmap(str);
        Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bGp().getBitmap(str2);
        if (bitmap == null || bitmap2 == null) {
            if (!com.baidu.adp.lib.util.l.isMainThread()) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tbadk.core.util.ap.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.adp.lib.e.d.mx().a(str, 10, ap.fdn, null);
                        com.baidu.adp.lib.e.d.mx().a(str2, 10, ap.fdn, null);
                    }
                });
                return;
            }
            com.baidu.adp.lib.e.d.mx().a(str, 10, fdn, null);
            com.baidu.adp.lib.e.d.mx().a(str2, 10, fdn, null);
        }
    }
}
