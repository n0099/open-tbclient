package com.baidu.tbadk.core.util;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import d.b.c.e.m.e;
import d.b.c.e.p.l;
import d.b.h0.b1.m.f;
import d.b.i0.d3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class UrlManager {
    public static final String DEFAULT_PARAM = "default_param";
    public static final int MATCH = 0;
    public static final int MATCH_AND_FINISH_WEBVIEW = 1;
    public static final int MATCH_REDIRECT_BACK = 2;
    public static final int NOT_MATCH = 3;
    public static final String YUN_PUSH_TAG = "yun_push_tag";
    public final ConcurrentHashMap<String, UrlSchemaHandler> mHandlers;
    public final List<UrlDealListener> mListeners;
    public UrlWebDealListener mWebListener;
    public static UrlManager mInstance = new UrlManager() { // from class: com.baidu.tbadk.core.util.UrlManager.1
    };
    public static final String patternText = "(http://|ftp://|https://|www){1,1}[^一-龥\\s]*";
    public static final Pattern pattern = Pattern.compile(patternText, 2);

    /* loaded from: classes3.dex */
    public interface UrlDealListener {
        int deal(TbPageContext<?> tbPageContext, String[] strArr);
    }

    /* loaded from: classes3.dex */
    public interface UrlSchemaHandler {
        void deal(TbPageContext<?> tbPageContext, Map<String, String> map);
    }

    /* loaded from: classes3.dex */
    public interface UrlWebDealListener {
        void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2);
    }

    /* loaded from: classes3.dex */
    public interface UrlWebDialogCancelListener {
        void onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addListenerInner(UrlDealListener urlDealListener) {
        if (this.mListeners.contains(urlDealListener)) {
            return;
        }
        this.mListeners.add(urlDealListener);
    }

    public static SpannableString findAllWebUrl(Context context, String str) {
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
            spannableString.setSpan(new f(2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
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
            } else {
                hashMap.put(DEFAULT_PARAM, str);
            }
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

    public static UrlManager getInstance() {
        return mInstance;
    }

    public static Map<String, String> getParamPair(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("[&]");
        if (split == null) {
            return null;
        }
        for (String str2 : split) {
            String[] split2 = str2.split("[=]");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public static String getParamStr(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
            return null;
        }
        return split[1];
    }

    public static String getParamStrBehindScheme(String str) {
        int i;
        if (StringUtils.isNull(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("://");
        if (lastIndexOf < 0) {
            int lastIndexOf2 = str.lastIndexOf(":");
            if (lastIndexOf2 >= 0 && (i = lastIndexOf2 + 1) <= str.length()) {
                return str.substring(i);
            }
            return null;
        }
        int i2 = lastIndexOf + 3;
        if (i2 <= str.length()) {
            return str.substring(i2);
        }
        return null;
    }

    private String getSchemaKey(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (str.contains("://")) {
            return str.substring(0, str.lastIndexOf("://") + 2);
        }
        return str.contains(":") ? str.substring(0, str.lastIndexOf(":")) : str;
    }

    private void jumpToWeb(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        if (pattern.matcher(str2).find()) {
            this.mWebListener.deal(tbPageContext, str, str2, z, urlWebDialogCancelListener, z2);
        }
    }

    public boolean UrlValidated(String str) {
        return pattern.matcher(str).find();
    }

    public void addListener(final UrlDealListener urlDealListener) {
        if (l.B()) {
            addListenerInner(urlDealListener);
        } else {
            e.a().post(new Runnable() { // from class: com.baidu.tbadk.core.util.UrlManager.2
                @Override // java.lang.Runnable
                public void run() {
                    UrlManager.this.addListenerInner(urlDealListener);
                }
            });
        }
    }

    public boolean dealOneLink(TbPageContext<?> tbPageContext, String[] strArr) {
        return dealOneLinkWithDialog(tbPageContext, strArr, false, (UrlWebDialogCancelListener) null, false);
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        return dealOneLinkWithDialog(tbPageContext, "", strArr, z, urlWebDialogCancelListener, z2);
    }

    public int dealOneLinkWithOutJumpWebView(TbPageContext<?> tbPageContext, String[] strArr) {
        int deal;
        if (strArr != null && strArr.length != 0) {
            String str = strArr[0];
            UrlSchemaHandler urlSchemaHandler = this.mHandlers.get(getSchemaKey(str));
            if (urlSchemaHandler != null) {
                urlSchemaHandler.deal(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str)));
                return 0;
            }
            for (UrlDealListener urlDealListener : this.mListeners) {
                if (urlDealListener != null && (deal = urlDealListener.deal(tbPageContext, strArr)) != 3) {
                    return deal;
                }
            }
        }
        return 3;
    }

    public String getTidFromPbUrl(String str) {
        if (isPbUrl(str)) {
            String[] split = str.split("\\?");
            if (split != null && split[0] != null) {
                str = split[0];
            }
            String[] split2 = str.split("/");
            return split2[split2.length - 1];
        }
        return null;
    }

    public boolean isFindUrlEndWithBlank(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(charSequence).find();
    }

    public boolean isPbUrl(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return TbPatternsCompat.PB_URL.matcher(charSequence).find();
    }

    public boolean isUrlValid(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return TbPatternsCompat.WEB_URL.matcher(charSequence).matches();
    }

    public void registerSchema(String str, UrlSchemaHandler urlSchemaHandler) {
        if (StringUtils.isNull(str) || urlSchemaHandler == null) {
            return;
        }
        String schemaKey = getSchemaKey(str);
        if (StringUtils.isNull(schemaKey)) {
            return;
        }
        this.mHandlers.put(schemaKey, urlSchemaHandler);
    }

    public void setWebListener(UrlWebDealListener urlWebDealListener) {
        this.mWebListener = urlWebDealListener;
    }

    public UrlManager() {
        this.mListeners = new LinkedList();
        this.mHandlers = new ConcurrentHashMap<>();
        this.mWebListener = null;
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        dealOneLinkWithDialog(tbPageContext, strArr, false, (UrlWebDialogCancelListener) null, z);
    }

    public void dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener) {
        dealOneLinkWithDialog(tbPageContext, strArr, z, urlWebDialogCancelListener, false);
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, false);
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        boolean z3;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        if (str2.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
            try {
                Uri parse = Uri.parse(str2);
                HashMap hashMap = new HashMap();
                String host = parse.getHost();
                for (String str3 : parse.getQueryParameterNames()) {
                    hashMap.put(str3, parse.getQueryParameter(str3));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(tbPageContext.getPageActivity(), host, hashMap)));
                return false;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        UrlSchemaHandler urlSchemaHandler = this.mHandlers.get(getSchemaKey(str2));
        if (urlSchemaHandler != null) {
            urlSchemaHandler.deal(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str2)));
            return true;
        }
        if (CmdRouter.cmdMaps.getValues("3001000") != null) {
            for (String str4 : CmdRouter.cmdMaps.getValues("3001000")) {
                for (ArrayList<String> arrayList : CmdRouter.configMaps.getValues(str4)) {
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
        Iterator<UrlDealListener> it2 = this.mListeners.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z3 = false;
                break;
            }
            UrlDealListener next = it2.next();
            if (next != null && next.deal(tbPageContext, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.mWebListener != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                return true;
            }
            if (strArr.length > 1 && !StringUtils.isNull(strArr[1]) && YUN_PUSH_TAG.equals(strArr[1])) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(tbPageContext.getPageActivity());
                mainTabActivityConfig.setTargetScheme(strArr[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            } else {
                jumpToWeb(tbPageContext, str, strArr[0], z, urlWebDialogCancelListener, z2);
            }
        }
        return z3;
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, z);
    }

    public void dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, z, urlWebDialogCancelListener, false);
    }
}
