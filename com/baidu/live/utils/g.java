package com.baidu.live.utils;

import android.text.Html;
import android.text.ParcelableSpan;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    public static SpannableStringBuilder E(String str, int i) {
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
                c cVar = new c((ForegroundColorSpan) parcelableSpanArr[i2 - 1]);
                cVar.a((URLSpan) parcelableSpanArr[i2]);
                cVar.bxk = valueOf.getSpanStart(parcelableSpanArr[i2]);
                cVar.bxl = valueOf.getSpanEnd(parcelableSpanArr[i2]);
                arrayList.add(cVar);
            } else if ((parcelableSpanArr[i2] instanceof ForegroundColorSpan) && ((i2 + 1 < parcelableSpanArr.length && !(parcelableSpanArr[i2 + 1] instanceof URLSpan)) || i2 == parcelableSpanArr.length - 1)) {
                c cVar2 = new c((ForegroundColorSpan) parcelableSpanArr[i2]);
                cVar2.bxk = valueOf.getSpanStart(parcelableSpanArr[i2]);
                cVar2.bxl = valueOf.getSpanEnd(parcelableSpanArr[i2]);
                arrayList.add(cVar2);
            }
        }
        valueOf2.setSpan(new ForegroundColorSpan(i), 0, valueOf.length(), 33);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            c cVar3 = (c) arrayList.get(i3);
            if (cVar3 != null) {
                if (cVar3.bxn) {
                    valueOf2.setSpan(new a(cVar3.mUrl, cVar3.bxm), cVar3.bxk, cVar3.bxl, 33);
                } else {
                    valueOf2.setSpan(new ForegroundColorSpan(cVar3.bxm), cVar3.bxk, cVar3.bxl, 33);
                }
            }
        }
        return valueOf2;
    }
}
