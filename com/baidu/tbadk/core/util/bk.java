package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bk {
    private static bk VE = new bl();
    private static final Pattern VG = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private bn VF;
    private List<bm> mListeners;

    private bk() {
        this.mListeners = new LinkedList();
        this.VF = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bk(bk bkVar) {
        this();
    }

    public static SpannableString C(Context context, String str) {
        int start;
        Matcher matcher = VG.matcher(str);
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

    public static bk tl() {
        return VE;
    }

    public void a(bm bmVar) {
        if (!this.mListeners.contains(bmVar)) {
            this.mListeners.add(bmVar);
        }
    }

    public void a(bn bnVar) {
        this.VF = bnVar;
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, bo boVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.mListeners == null) {
                this.mListeners = new LinkedList();
            }
            Iterator<bm> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bm next = it.next();
                if (next != null && next.a(tbPageContext, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.VF != null && tbPageContext != null) {
                b(tbPageContext, "", strArr[0], z, boVar);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, bo boVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.mListeners == null) {
                this.mListeners = new LinkedList();
            }
            Iterator<bm> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bm next = it.next();
                if (next != null && next.a(tbPageContext, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.VF != null) {
                b(tbPageContext, str, strArr[0], z, boVar);
            }
        }
    }

    public static Map<String, String> cQ(String str) {
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

    public static String cR(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    public void b(TbPageContext<?> tbPageContext, String[] strArr) {
        a(tbPageContext, strArr, false, null);
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        a(tbPageContext, str, strArr, false, null);
    }

    private void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, bo boVar) {
        if (VG.matcher(str2).find()) {
            this.VF.a(tbPageContext, str, str2, z, boVar);
        }
    }
}
