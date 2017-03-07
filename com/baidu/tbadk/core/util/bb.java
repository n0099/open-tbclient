package com.baidu.tbadk.core.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
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
public class bb {
    private static bb agA = new bc();
    private static final Pattern agE = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private final List<a> agB;
    private final ConcurrentHashMap<String, b> agC;
    private c agD;

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

    private bb() {
        this.agB = new LinkedList();
        this.agC = new ConcurrentHashMap<>();
        this.agD = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(bb bbVar) {
        this();
    }

    public static SpannableString R(Context context, String str) {
        int start;
        Matcher matcher = agE.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = String.valueOf(group2) + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.b(2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static bb vQ() {
        return agA;
    }

    public void a(a aVar) {
        if (com.baidu.adp.lib.util.k.hu()) {
            b(aVar);
        } else {
            com.baidu.adp.lib.g.h.fM().post(new bd(this, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (!this.agB.contains(aVar)) {
            this.agB.add(aVar);
        }
    }

    public void a(c cVar) {
        this.agD = cVar;
    }

    public boolean a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, d dVar, boolean z2) {
        return a(tbPageContext, "", strArr, z, dVar, z2);
    }

    public int b(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        b bVar = this.agC.get(dE(str));
        if (bVar != null) {
            bVar.a(tbPageContext, dD(dC(str)));
            return 0;
        }
        for (a aVar : this.agB) {
            if (aVar != null) {
                Log.e("+-->", "--listener---" + aVar);
                int a2 = aVar.a(tbPageContext, strArr);
                if (a2 != 3) {
                    return a2;
                }
            }
        }
        return 3;
    }

    public boolean a(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, d dVar, boolean z2) {
        boolean z3;
        boolean z4;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        b bVar = this.agC.get(dE(str2));
        if (bVar != null) {
            bVar.a(tbPageContext, dD(dC(str2)));
            return true;
        }
        Iterator<a> it = this.agB.iterator();
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
        if (!z3 && this.agD != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                z4 = true;
                return z4;
            }
            b(tbPageContext, str, strArr[0], z, dVar, z2);
        }
        z4 = z3;
        return z4;
    }

    public static Map<String, String> dA(String str) {
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

    public static String dB(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    private String dC(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("://");
        if (lastIndexOf < 0) {
            int lastIndexOf2 = str.lastIndexOf(":");
            if (lastIndexOf2 < 0 || lastIndexOf2 + 1 > str.length()) {
                return null;
            }
            return str.substring(lastIndexOf2 + 1);
        } else if (lastIndexOf + 3 <= str.length()) {
            return str.substring(lastIndexOf + 3);
        } else {
            return null;
        }
    }

    private Map<String, String> dD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split == null) {
            String[] split2 = str.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
                return hashMap;
            }
            hashMap.put("default_param", str);
            return hashMap;
        }
        for (String str2 : split) {
            String[] split3 = str2.split("[=]");
            if (split3.length > 1) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        return hashMap;
    }

    private String dE(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.contains("://")) {
            return str.substring(0, str.lastIndexOf("://") + 2);
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
        if (agE.matcher(str2).find()) {
            this.agD.a(tbPageContext, str, str2, z, dVar, z2);
        }
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str) && bVar != null) {
            String dE = dE(str);
            if (!StringUtils.isNull(dE)) {
                this.agC.put(dE, bVar);
            }
        }
    }

    public boolean dF(String str) {
        return agE.matcher(str).find();
    }
}
