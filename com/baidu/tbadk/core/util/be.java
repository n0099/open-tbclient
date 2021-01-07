package com.baidu.tbadk.core.util;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class be {
    private static be fdM = new be() { // from class: com.baidu.tbadk.core.util.be.1
    };
    private static final Pattern pattern = Pattern.compile("(http://|ftp://|https://|www){1,1}[^一-龥\\s]*", 2);
    private c fdN;
    private final ConcurrentHashMap<String, b> mHandlers;
    private final List<a> mListeners;

    /* loaded from: classes.dex */
    public interface a {
        int deal(TbPageContext<?> tbPageContext, String[] strArr);
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

    private be() {
        this.mListeners = new LinkedList();
        this.mHandlers = new ConcurrentHashMap<>();
        this.fdN = null;
    }

    public static SpannableString aC(Context context, String str) {
        int start;
        Matcher matcher = pattern.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = group2 + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.f(2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static be bwv() {
        return fdM;
    }

    public void a(final a aVar) {
        if (com.baidu.adp.lib.util.l.isMainThread()) {
            b(aVar);
        } else {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tbadk.core.util.be.2
                @Override // java.lang.Runnable
                public void run() {
                    be.this.b(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (!this.mListeners.contains(aVar)) {
            this.mListeners.add(aVar);
        }
    }

    public void a(c cVar) {
        this.fdN = cVar;
    }

    public boolean a(TbPageContext<?> tbPageContext, String[] strArr, boolean z, d dVar, boolean z2) {
        return a(tbPageContext, "", strArr, z, dVar, z2);
    }

    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        int deal;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        b bVar = this.mHandlers.get(getSchemaKey(str));
        if (bVar != null) {
            bVar.a(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str)));
            return 0;
        }
        for (a aVar : this.mListeners) {
            if (aVar != null && (deal = aVar.deal(tbPageContext, strArr)) != 3) {
                return deal;
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
        if (str2.startsWith("flt://")) {
            try {
                Uri parse = Uri.parse(str2);
                HashMap hashMap = new HashMap();
                String host = parse.getHost();
                for (String str3 : parse.getQueryParameterNames()) {
                    hashMap.put(str3, parse.getQueryParameter(str3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(tbPageContext.getPageActivity(), host, hashMap)));
                z3 = false;
            } catch (Exception e) {
                BdLog.e(e);
                z3 = false;
            }
        } else {
            b bVar = this.mHandlers.get(getSchemaKey(str2));
            if (bVar != null) {
                bVar.a(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str2)));
                return true;
            }
            if (com.baidu.adp.framework.a.b.Jx.q("3001000") != null) {
                for (String str4 : com.baidu.adp.framework.a.b.Jx.q("3001000")) {
                    for (ArrayList<String> arrayList : com.baidu.adp.framework.a.b.Jw.q(str4)) {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (str2.contains(it.next())) {
                                try {
                                    Class.forName(str4);
                                } catch (Throwable th) {
                                    BdLog.e(th);
                                }
                            }
                        }
                    }
                }
            }
            Iterator<a> it2 = this.mListeners.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z4 = false;
                    break;
                }
                a next = it2.next();
                if (next != null && next.deal(tbPageContext, strArr) != 3) {
                    z4 = true;
                    break;
                }
            }
            if (!z4 && this.fdN != null) {
                if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                    z3 = true;
                } else if (strArr.length > 1 && !StringUtils.isNull(strArr[1]) && "yun_push_tag".equals(strArr[1])) {
                    MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(tbPageContext.getPageActivity());
                    mainTabActivityConfig.setTargetScheme(strArr[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig));
                    z3 = z4;
                } else {
                    b(tbPageContext, str, strArr[0], z, dVar, z2);
                }
            }
            z3 = z4;
        }
        return z3;
    }

    public static Map<String, String> getParamPair(String str) {
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

    public static String getParamStr(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    public static String getParamStrBehindScheme(String str) {
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

    private Map<String, String> getInnerParamPair(String str) {
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
            hashMap.put(UrlManager.DEFAULT_PARAM, str);
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

    private String getSchemaKey(String str) {
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

    public boolean b(TbPageContext<?> tbPageContext, String[] strArr) {
        return a(tbPageContext, strArr, false, null, false);
    }

    public void a(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        a(tbPageContext, strArr, false, null, z);
    }

    public void a(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        a(tbPageContext, str, strArr, false, null, false);
    }

    private void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, d dVar, boolean z2) {
        if (pattern.matcher(str2).find()) {
            this.fdN.a(tbPageContext, str, str2, z, dVar, z2);
        }
    }

    public void a(String str, b bVar) {
        if (!StringUtils.isNull(str) && bVar != null) {
            String schemaKey = getSchemaKey(str);
            if (!StringUtils.isNull(schemaKey)) {
                this.mHandlers.put(schemaKey, bVar);
            }
        }
    }

    public boolean UrlValidated(String str) {
        return pattern.matcher(str).find();
    }

    public boolean l(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return aw.WEB_URL.matcher(charSequence).matches();
    }

    public boolean m(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return aw.fdI.matcher(charSequence).find();
    }

    public String Ce(String str) {
        if (!m(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split[0] != null) {
            str = split[0];
        }
        String[] split2 = str.split("/");
        return split2[split2.length - 1];
    }

    public boolean n(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return aw.fdH.matcher(charSequence).find();
    }
}
