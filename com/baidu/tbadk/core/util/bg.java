package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bg {
    private static bg Fq = new bh();
    private static final Pattern Ft = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*?\\.(com|net|cn|me|tw|fr|hk|gov|org|cc)[^一-龥\\s]*", 2);
    private List<bi> Fr;
    private bj Fs;

    private bg() {
        this.Fr = new LinkedList();
        this.Fs = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(bg bgVar) {
        this();
    }

    public static SpannableString n(Context context, String str) {
        int start;
        Matcher matcher = Ft.matcher(str);
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

    public static bg mR() {
        return Fq;
    }

    public void a(bi biVar) {
        if (!this.Fr.contains(biVar)) {
            this.Fr.add(biVar);
        }
    }

    public void a(bj bjVar) {
        this.Fs = bjVar;
    }

    public void a(Context context, String[] strArr, boolean z, bk bkVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.Fr == null) {
                this.Fr = new LinkedList();
            }
            Iterator<bi> it = this.Fr.iterator();
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
            if (!z2 && this.Fs != null) {
                b(context, "", strArr[0], z, bkVar);
            }
        }
    }

    public void a(Context context, String str, String[] strArr, boolean z, bk bkVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.Fr == null) {
                this.Fr = new LinkedList();
            }
            Iterator<bi> it = this.Fr.iterator();
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
            if (!z2 && this.Fs != null) {
                b(context, str, strArr[0], z, bkVar);
            }
        }
    }

    public static Map<String, String> bT(String str) {
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

    public static String bU(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    public void b(Context context, String[] strArr) {
        a(context, strArr, false, null);
    }

    public void a(Context context, String str, String[] strArr) {
        a(context, str, strArr, false, null);
    }

    private void b(Context context, String str, String str2, boolean z, bk bkVar) {
        if (Ft.matcher(str2).find()) {
            this.Fs.a(context, str, str2, z, bkVar);
        }
    }
}
