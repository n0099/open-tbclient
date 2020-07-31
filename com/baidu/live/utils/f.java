package com.baidu.live.utils;

import android.text.Html;
import android.text.ParcelableSpan;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {
    public static SpannableStringBuilder D(String str, int i) {
        SpannableStringBuilder valueOf;
        try {
            valueOf = (SpannableStringBuilder) Html.fromHtml(str);
        } catch (Exception e) {
            valueOf = SpannableStringBuilder.valueOf(str);
        }
        SpannableStringBuilder valueOf2 = SpannableStringBuilder.valueOf(valueOf.toString());
        ParcelableSpan[] parcelableSpanArr = (ParcelableSpan[]) valueOf.getSpans(0, valueOf.length(), ParcelableSpan.class);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < parcelableSpanArr.length; i2++) {
            if ((parcelableSpanArr[i2] instanceof URLSpan) && i2 - 1 >= 0 && (parcelableSpanArr[i2 - 1] instanceof ForegroundColorSpan)) {
                b bVar = new b((ForegroundColorSpan) parcelableSpanArr[i2 - 1]);
                bVar.a((URLSpan) parcelableSpanArr[i2]);
                bVar.bkF = valueOf.getSpanStart(parcelableSpanArr[i2]);
                bVar.bkG = valueOf.getSpanEnd(parcelableSpanArr[i2]);
                arrayList.add(bVar);
            } else if ((parcelableSpanArr[i2] instanceof ForegroundColorSpan) && ((i2 + 1 < parcelableSpanArr.length && !(parcelableSpanArr[i2 + 1] instanceof URLSpan)) || i2 == parcelableSpanArr.length - 1)) {
                b bVar2 = new b((ForegroundColorSpan) parcelableSpanArr[i2]);
                bVar2.bkF = valueOf.getSpanStart(parcelableSpanArr[i2]);
                bVar2.bkG = valueOf.getSpanEnd(parcelableSpanArr[i2]);
                arrayList.add(bVar2);
            }
        }
        valueOf2.setSpan(new ForegroundColorSpan(i), 0, valueOf.length(), 33);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            b bVar3 = (b) arrayList.get(i3);
            if (bVar3 != null) {
                if (bVar3.bkI) {
                    valueOf2.setSpan(new a(bVar3.mUrl, bVar3.bkH), bVar3.bkF, bVar3.bkG, 33);
                } else {
                    valueOf2.setSpan(new ForegroundColorSpan(bVar3.bkH), bVar3.bkF, bVar3.bkG, 33);
                }
            }
        }
        return valueOf2;
    }
}
