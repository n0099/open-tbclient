package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import d.a.c.e.l.c;
import d.a.c.e.l.d;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import d.a.c.k.d.a;
import d.a.m0.r.f0.k;
import d.a.m0.r.q.a2;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SpecHotTopicHelper {
    public static final Map<Long, Pair<String, String>> mMap = new HashMap();
    public static c mResourceCallback = new c<a>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(a aVar, String str, int i2) {
            super.onLoaded((AnonymousClass2) aVar, str, i2);
            if (aVar != null) {
                d.a.m0.a0.c.k().a(str, aVar.p());
            }
        }
    };

    public static void addSpecTopic(a2 a2Var, SpannableString spannableString, String str, int i2) {
        a loadBdImageFromLocal;
        a loadBdImageFromLocal2;
        BitmapDrawable bitmapDrawable;
        if (a2Var == null || spannableString == null || StringUtils.isNull(str)) {
            return;
        }
        String E0 = a2Var.E0();
        String e1 = a2Var.e1();
        if (StringUtils.isNull(E0) || StringUtils.isNull(e1)) {
            return;
        }
        Bitmap j = d.a.m0.a0.c.k().j(E0);
        if ((j == null || !AbstractImageLoaderProc.isImageFileExist(E0, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(E0, 10)) != null) {
            j = loadBdImageFromLocal.p();
            d.a.m0.a0.c.k().a(E0, j);
        }
        Bitmap j2 = d.a.m0.a0.c.k().j(e1);
        if ((j2 == null || !AbstractImageLoaderProc.isImageFileExist(e1, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(e1, 10)) != null) {
            j2 = loadBdImageFromLocal2.p();
            d.a.m0.a0.c.k().a(e1, j2);
        }
        if (j != null && !j.isRecycled() && j2 != null && !j2.isRecycled()) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                if (str.charAt(i4) == '#') {
                    if (i3 % 2 == 0) {
                        bitmapDrawable = new BitmapDrawable(j);
                        bitmapDrawable.setBounds(0, 0, j.getWidth(), j.getHeight());
                    } else {
                        bitmapDrawable = new BitmapDrawable(j2);
                        bitmapDrawable.setBounds(0, 0, j2.getWidth(), j2.getHeight());
                    }
                    k kVar = new k(bitmapDrawable);
                    kVar.b(l.e(TbadkCoreApplication.getInst(), a2Var.p));
                    int i5 = i2 + i4;
                    spannableString.setSpan(kVar, i5, i5 + 1, 33);
                    i3++;
                }
            }
            return;
        }
        loadSpecTopicIconIfNeed(E0, e1);
    }

    public static void loadSpecTopicIconIfNeed(final String str, final String str2) {
        Bitmap j = d.a.m0.a0.c.k().j(str);
        Bitmap j2 = d.a.m0.a0.c.k().j(str2);
        if (j == null || j2 == null) {
            if (!l.C()) {
                e.a().post(new Runnable() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.h().m(str, 10, SpecHotTopicHelper.mResourceCallback, null);
                        d.h().m(str2, 10, SpecHotTopicHelper.mResourceCallback, null);
                    }
                });
                return;
            }
            d.h().m(str, 10, mResourceCallback, null);
            d.h().m(str2, 10, mResourceCallback, null);
        }
    }

    public static void putSpecialTopicIcon(Long l, String str, String str2) {
        if (l == null || l.intValue() <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        loadSpecTopicIconIfNeed(str, str2);
        mMap.put(l, new Pair<>(str, str2));
    }

    public static void removeSpecTopicIconForFrs(Long l) {
        if (l.longValue() > 0) {
            mMap.remove(l);
        }
    }

    public static void setSpecTopicIcon(long j, a2 a2Var) {
        Pair<String, String> pair = mMap.get(Long.valueOf(j));
        if (pair != null) {
            a2Var.y3(j);
            a2Var.m4((String) pair.first, (String) pair.second);
        }
    }
}
