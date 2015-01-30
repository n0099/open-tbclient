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
public class bm {
    private static bm JT = new bn();
    private static final Pattern JV = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private bp JU;
    private List<bo> mListeners;

    private bm() {
        this.mListeners = new LinkedList();
        this.JU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bm(bm bmVar) {
        this();
    }

    public static SpannableString C(Context context, String str) {
        int start;
        Matcher matcher = JV.matcher(str);
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

    public static bm pV() {
        return JT;
    }

    public void a(bo boVar) {
        if (!this.mListeners.contains(boVar)) {
            this.mListeners.add(boVar);
        }
    }

    public void a(bp bpVar) {
        this.JU = bpVar;
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, bq bqVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.mListeners == null) {
                this.mListeners = new LinkedList();
            }
            Iterator<bo> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bo next = it.next();
                if (next != null && next.a(tbPageContext, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.JU != null && tbPageContext != null) {
                b(tbPageContext.getContext(), "", strArr[0], z, bqVar);
            }
        }
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, bq bqVar) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            if (this.mListeners == null) {
                this.mListeners = new LinkedList();
            }
            Iterator<bo> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                bo next = it.next();
                if (next != null && next.a(tbPageContext, strArr)) {
                    z2 = true;
                    break;
                }
            }
            if (!z2 && this.JU != null) {
                b(tbPageContext.getContext(), str, strArr[0], z, bqVar);
            }
        }
    }

    public static Map<String, String> cK(String str) {
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

    public static String cL(String str) {
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

    private void b(Context context, String str, String str2, boolean z, bq bqVar) {
        if (JV.matcher(str2).find()) {
            this.JU.a(context, str, str2, z, bqVar);
        }
    }
}
