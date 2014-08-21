package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bg {
    private static bg a = new bh();
    private static final Pattern d = Pattern.compile("(((ht|f)tp(s{0,1}))://)?([\\w-]+\\.)+[a-zA-Z_-]{2,}(/[\\w-./?%&+=#]*)?", 2);
    private List<bi> b;
    private bj c;

    private bg() {
        this.b = new LinkedList();
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(bg bgVar) {
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

    public static bg a() {
        return a;
    }

    public void a(bi biVar) {
        if (!this.b.contains(biVar)) {
            this.b.add(biVar);
        }
    }

    public void a(bj bjVar) {
        this.c = bjVar;
    }

    public void a(Context context, String[] strArr, boolean z, bk bkVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            Iterator<bi> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bi next = it.next();
                if (next != null && next.a(context, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.c != null) {
                a(context, strArr[0], z, bkVar);
            }
        }
    }

    public static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return null;
    }

    public static String b(String str) {
        String[] split = str.split("[?]");
        if (split == null || split.length <= 0 || split.length <= 1 || split[1] == null) {
            return null;
        }
        return split[1];
    }

    public void a(Context context, String[] strArr) {
        a(context, strArr, false, (bk) null);
    }

    private void a(Context context, String str, boolean z, bk bkVar) {
        if (d.matcher(str).find()) {
            this.c.a(context, str, z, bkVar);
        }
    }
}
