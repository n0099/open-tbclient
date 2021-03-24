package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.b.j.d.a;
import d.b.h0.r.f0.k;
import d.b.h0.r.q.a2;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class SpecHotTopicHelper {
    public static final Map<Long, Pair<String, String>> mMap = new HashMap();
    public static c mResourceCallback = new c<a>() { // from class: com.baidu.tbadk.core.util.SpecHotTopicHelper.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(a aVar, String str, int i) {
            super.onLoaded((AnonymousClass2) aVar, str, i);
            if (aVar != null) {
                d.b.h0.a0.c.j().a(str, aVar.p());
            }
        }
    };

    public static void addSpecTopic(a2 a2Var, SpannableString spannableString, String str, int i) {
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
        Bitmap i2 = d.b.h0.a0.c.j().i(D0);
        if ((i2 == null || !AbstractImageLoaderProc.isImageFileExist(D0, 10)) && (loadBdImageFromLocal = AbstractImageLoaderProc.loadBdImageFromLocal(D0, 10)) != null) {
            i2 = loadBdImageFromLocal.p();
            d.b.h0.a0.c.j().a(D0, i2);
        }
        Bitmap i3 = d.b.h0.a0.c.j().i(c1);
        if ((i3 == null || !AbstractImageLoaderProc.isImageFileExist(c1, 10)) && (loadBdImageFromLocal2 = AbstractImageLoaderProc.loadBdImageFromLocal(c1, 10)) != null) {
            i3 = loadBdImageFromLocal2.p();
            d.b.h0.a0.c.j().a(c1, i3);
        }
        if (i2 != null && !i2.isRecycled() && i3 != null && !i3.isRecycled()) {
            int i4 = 0;
            for (int i5 = 0; i5 < str.length(); i5++) {
                if (str.charAt(i5) == '#') {
                    if (i4 % 2 == 0) {
                        bitmapDrawable = new BitmapDrawable(i2);
                        bitmapDrawable.setBounds(0, 0, i2.getWidth(), i2.getHeight());
                    } else {
                        bitmapDrawable = new BitmapDrawable(i3);
                        bitmapDrawable.setBounds(0, 0, i3.getWidth(), i3.getHeight());
                    }
                    k kVar = new k(bitmapDrawable);
                    kVar.b(l.e(TbadkCoreApplication.getInst(), a2Var.p));
                    int i6 = i + i5;
                    spannableString.setSpan(kVar, i6, i6 + 1, 33);
                    i4++;
                }
            }
            return;
        }
        loadSpecTopicIconIfNeed(D0, c1);
    }

    public static void loadSpecTopicIconIfNeed(final String str, final String str2) {
        Bitmap i = d.b.h0.a0.c.j().i(str);
        Bitmap i2 = d.b.h0.a0.c.j().i(str2);
        if (i == null || i2 == null) {
            if (!l.B()) {
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
            a2Var.t3(j);
            a2Var.h4((String) pair.first, (String) pair.second);
        }
    }
}
