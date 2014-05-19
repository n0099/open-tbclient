package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bi {
    private static bi a = new bj();
    private static final Pattern d = Pattern.compile("(((ht|f)tp(s{0,1}))://)?([\\w-]+\\.)+[a-zA-Z_-]{2,}(/[\\w-./?%&+=#]*)?", 2);
    private List<bk> b;
    private bl c;

    private bi() {
        this.b = new LinkedList();
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bi(bi biVar) {
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

    public static bi a() {
        return a;
    }

    public void a(bk bkVar) {
        if (!this.b.contains(bkVar)) {
            this.b.add(bkVar);
        }
    }

    public void a(bl blVar) {
        this.c = blVar;
    }

    public void a(Context context, String[] strArr, boolean z, bm bmVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            Iterator<bk> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bk next = it.next();
                if (next != null && next.a(context, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.c != null) {
                a(context, strArr[0], z, bmVar);
            }
        }
    }

    public void a(Context context, String[] strArr) {
        a(context, strArr, false, (bm) null);
    }

    private void a(Context context, String str, boolean z, bm bmVar) {
        String lowerCase = str.toLowerCase();
        if (d.matcher(lowerCase).find()) {
            this.c.a(context, lowerCase, z, bmVar);
        } else {
            BdLog.d("wrong url:" + lowerCase);
        }
    }
}
