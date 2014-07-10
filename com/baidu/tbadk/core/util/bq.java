package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bq {
    private static bq a = new br();
    private static final Pattern d = Pattern.compile("(((ht|f)tp(s{0,1}))://)?([\\w-]+\\.)+[a-zA-Z_-]{2,}(/[\\w-./?%&+=#]*)?", 2);
    private List<bs> b;
    private bt c;

    private bq() {
        this.b = new LinkedList();
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bq(bq bqVar) {
        this();
    }

    public static SpannableString a(Context context, String str) {
        int start;
        Matcher matcher = d.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = String.valueOf(group2) + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.h(context, 2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static bq a() {
        return a;
    }

    public void a(bs bsVar) {
        if (!this.b.contains(bsVar)) {
            this.b.add(bsVar);
        }
    }

    public void a(bt btVar) {
        this.c = btVar;
    }

    public void a(Context context, String[] strArr, boolean z, bu buVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            Iterator<bs> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bs next = it.next();
                if (next != null && next.a(context, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.c != null) {
                a(context, strArr[0], z, buVar);
            }
        }
    }

    public void a(Context context, String[] strArr) {
        a(context, strArr, false, (bu) null);
    }

    private void a(Context context, String str, boolean z, bu buVar) {
        if (d.matcher(str).find()) {
            this.c.a(context, str, z, buVar);
        }
    }
}
