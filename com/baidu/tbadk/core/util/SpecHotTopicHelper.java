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
import d.a.c.j.d.a;
import d.a.i0.r.f0.k;
import d.a.i0.r.q.a2;
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
                d.a.i0.a0.c.k().a(str, aVar.p());
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
        String D0 = a2Var.D0();
        String c1 = a2Var.c1();
        if (StringUtils.isNull(D0) || StringUtils.isNull(c1)) {
            return;
        }
        Bitmap j = d.a.i0.a0.c.k().j(D0);
        if ((j == null || !AbstractImageLoaderProc.isImageFileExist(D0, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(D0, 10)) != null) {
            j = loadBdImageFromLocal.p();
            d.a.i0.a0.c.k().a(D0, j);
        }
        Bitmap j2 = d.a.i0.a0.c.k().j(c1);
        if ((j2 == null || !AbstractImageLoaderProc.isImageFileExist(c1, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(c1, 10)) != null) {
            j2 = loadBdImageFromLocal2.p();
            d.a.i0.a0.c.k().a(c1, j2);
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
        loadSpecTopicIconIfNeed(D0, c1);
    }

    public static void loadSpecTopicIconIfNeed(final String str, final String str2) {
        Bitmap j = d.a.i0.a0.c.k().j(str);
        Bitmap j2 = d.a.i0.a0.c.k().j(str2);
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
            a2Var.u3(j);
            a2Var.i4((String) pair.first, (String) pair.second);
        }
    }
}
