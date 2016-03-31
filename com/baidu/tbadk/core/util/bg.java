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
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bg {
    private static bg acG = new bh();
    private static final Pattern acK = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private final List<a> acH;
    private final ConcurrentHashMap<String, b> acI;
    private c acJ;

    /* loaded from: classes.dex */
    public interface a {
        int a(TbPageContext<?> tbPageContext, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(TbPageContext<?> tbPageContext, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, d dVar, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    private bg() {
        this.acH = new LinkedList();
        this.acI = new ConcurrentHashMap<>();
        this.acJ = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bg(bg bgVar) {
        this();
    }

    public static SpannableString v(Context context, String str) {
        int start;
        Matcher matcher = acK.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = String.valueOf(group2) + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.h(2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static bg wM() {
        return acG;
    }

    public void a(a aVar) {
        if (com.baidu.adp.lib.util.k.jv()) {
            b(aVar);
        } else {
            com.baidu.adp.lib.h.h.hx().post(new bi(this, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (!this.acH.contains(aVar)) {
            this.acH.add(aVar);
        }
    }

    public void a(c cVar) {
        this.acJ = cVar;
    }

    public boolean a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, d dVar, boolean z2) {
        return a(tbPageContext, "", strArr, z, dVar, z2);
    }

    public int b(TbPageContext<?> tbPageContext, String[] strArr) {
        int a2;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        for (a aVar : this.acH) {
            if (aVar != null && (a2 = aVar.a(tbPageContext, strArr)) != 3) {
                return a2;
            }
        }
        return 3;
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, d dVar) {
        a(tbPageContext, strArr, z, dVar, false);
    }

    public boolean a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, d dVar, boolean z2) {
        boolean z3;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        b bVar = this.acI.get(dI(str2));
        if (bVar != null) {
            bVar.a(tbPageContext, dH(dG(str2)));
            return true;
        }
        Iterator<a> it = this.acH.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            a next = it.next();
            if (next != null && next.a(tbPageContext, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.acJ != null) {
            b(tbPageContext, str, strArr[0], z, dVar, z2);
        }
        return z3;
    }

    public static Map<String, String> dE(String str) {
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

    public static String dF(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    private String dG(String str) {
        int lastIndexOf;
        if (!StringUtils.isNull(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    private Map<String, String> dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split == null) {
            hashMap.put("default_param", str);
            return hashMap;
        }
        for (String str2 : split) {
            String[] split2 = str2.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    private String dI(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.contains(":")) {
            return str.substring(0, str.lastIndexOf(":"));
        }
        return str;
    }

    public boolean c(TbPageContext<?> tbPageContext, String[] strArr) {
        return a(tbPageContext, strArr, false, null, false);
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        a(tbPageContext, strArr, false, null, z);
    }

    private void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, d dVar, boolean z2) {
        if (acK.matcher(str2).find()) {
            this.acJ.a(tbPageContext, str, str2, z, dVar, z2);
        }
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str) && bVar != null) {
            String dI = dI(str);
            if (!StringUtils.isNull(dI)) {
                this.acI.put(dI, bVar);
            }
        }
    }

    public boolean dJ(String str) {
        return acK.matcher(str).find();
    }
}
