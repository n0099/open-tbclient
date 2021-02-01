package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class aq {
    public static final Map<Long, Pair<String, String>> mMap = new HashMap();
    private static com.baidu.adp.lib.e.c faT = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.util.aq.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar != null) {
                com.baidu.tbadk.imageManager.c.bCP().addBitmap(str, aVar.getRawBitmap());
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

    public static void a(long j, cb cbVar) {
        Pair<String, String> pair = mMap.get(Long.valueOf(j));
        if (pair != null) {
            cbVar.setFid(j);
            cbVar.dD((String) pair.first, (String) pair.second);
        }
    }

    public static void a(cb cbVar, SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a as;
        com.baidu.adp.widget.ImageView.a as2;
        BitmapDrawable bitmapDrawable;
        if (cbVar != null && spannableString != null && !StringUtils.isNull(str)) {
            String boH = cbVar.boH();
            String boI = cbVar.boI();
            if (!StringUtils.isNull(boH) && !StringUtils.isNull(boI)) {
                Bitmap bitmap = com.baidu.tbadk.imageManager.c.bCP().getBitmap(boH);
                if ((bitmap == null || !com.baidu.tbadk.core.util.d.s.ar(boH, 10)) && (as = com.baidu.tbadk.core.util.d.s.as(boH, 10)) != null) {
                    bitmap = as.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bCP().addBitmap(boH, bitmap);
                }
                Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bCP().getBitmap(boI);
                if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.s.ar(boI, 10)) && (as2 = com.baidu.tbadk.core.util.d.s.as(boI, 10)) != null) {
                    bitmap2 = as2.getRawBitmap();
                    com.baidu.tbadk.imageManager.c.bCP().addBitmap(boI, bitmap2);
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
                            kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst(), cbVar.eRg));
                            spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                            i2++;
                        }
                    }
                    return;
                }
                dQ(boH, boI);
            }
        }
    }

    public static void dQ(final String str, final String str2) {
        Bitmap bitmap = com.baidu.tbadk.imageManager.c.bCP().getBitmap(str);
        Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.bCP().getBitmap(str2);
        if (bitmap == null || bitmap2 == null) {
            if (!com.baidu.adp.lib.util.l.isMainThread()) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tbadk.core.util.aq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.adp.lib.e.d.mw().a(str, 10, aq.faT, null);
                        com.baidu.adp.lib.e.d.mw().a(str2, 10, aq.faT, null);
                    }
                });
                return;
            }
            com.baidu.adp.lib.e.d.mw().a(str, 10, faT, null);
            com.baidu.adp.lib.e.d.mw().a(str2, 10, faT, null);
        }
    }
}
