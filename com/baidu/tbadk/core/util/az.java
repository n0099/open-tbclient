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
public class az {
    private static az abA = new ba();
    private static final Pattern abD = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private List<a> abB;
    private b abC;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(TbPageContext<?> tbPageContext, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, c cVar, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    private az() {
        this.abB = new LinkedList();
        this.abC = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(az azVar) {
        this();
    }

    public static SpannableString E(Context context, String str) {
        int start;
        Matcher matcher = abD.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = String.valueOf(group2) + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.g(2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static az uX() {
        return abA;
    }

    public void a(a aVar) {
        if (!this.abB.contains(aVar)) {
            this.abB.add(aVar);
        }
    }

    public void a(b bVar) {
        this.abC = bVar;
    }

    public boolean a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, c cVar, boolean z2) {
        boolean z3;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        if (this.abB == null) {
            this.abB = new LinkedList();
        }
        Iterator<a> it = this.abB.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            a next = it.next();
            if (next != null && next.a(tbPageContext, strArr)) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.abC != null) {
            if (tbPageContext == null) {
                return false;
            }
            b(tbPageContext, "", strArr[0], z, cVar, z2);
        }
        return z3;
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, c cVar) {
        a(tbPageContext, strArr, z, cVar, false);
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, c cVar, boolean z2) {
        boolean z3;
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            if (this.abB == null) {
                this.abB = new LinkedList();
            }
            Iterator<a> it = this.abB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                a next = it.next();
                if (next != null && next.a(tbPageContext, strArr)) {
                    z3 = true;
                    break;
                }
            }
            if (!z3 && this.abC != null) {
                b(tbPageContext, str, strArr[0], z, cVar, z2);
            }
        }
    }

    public static Map<String, String> dr(String str) {
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

    public static String ds(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    public boolean b(TbPageContext<?> tbPageContext, String[] strArr) {
        return a(tbPageContext, strArr, false, null, false);
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        a(tbPageContext, strArr, false, null, z);
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        a(tbPageContext, str, strArr, false, null, false);
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z) {
        a(tbPageContext, str, strArr, false, null, z);
    }

    private void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, c cVar, boolean z2) {
        if (abD.matcher(str2).find()) {
            this.abC.a(tbPageContext, str, str2, z, cVar, z2);
        }
    }
}
