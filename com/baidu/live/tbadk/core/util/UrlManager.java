package com.baidu.live.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class UrlManager {
    public static final String DEFAULT_PARAM = "default_param";
    public static final int MATCH = 0;
    public static final int MATCH_AND_FINISH_WEBVIEW = 1;
    public static final int NOT_MATCH = 3;
    private final ConcurrentHashMap<String, UrlSchemaHandler> mHandlers;
    private final List<UrlDealListener> mListeners;
    private UrlWebDealListener mWebListener;
    private static UrlManager mInstance = new UrlManager() { // from class: com.baidu.live.tbadk.core.util.UrlManager.1
    };
    private static final String patternText = "(http://|ftp://|https://|www){1,1}[^一-龥\\s]*";
    private static final Pattern pattern = Pattern.compile(patternText, 2);

    /* loaded from: classes10.dex */
    public interface UrlDealListener {
        int deal(TbPageContext<?> tbPageContext, String[] strArr);
    }

    /* loaded from: classes10.dex */
    public interface UrlSchemaHandler {
        void deal(TbPageContext<?> tbPageContext, Map<String, String> map);
    }

    /* loaded from: classes10.dex */
    public interface UrlWebDealListener {
        void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2);
    }

    /* loaded from: classes10.dex */
    public interface UrlWebDialogCancelListener {
        void onCancel();
    }

    private UrlManager() {
        this.mListeners = new LinkedList();
        this.mHandlers = new ConcurrentHashMap<>();
        this.mWebListener = null;
    }

    public static UrlManager getInstance() {
        return mInstance;
    }

    public void addListener(final UrlDealListener urlDealListener) {
        if (BdUtilHelper.isMainThread()) {
            addListenerInner(urlDealListener);
        } else {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.tbadk.core.util.UrlManager.2
                @Override // java.lang.Runnable
                public void run() {
                    UrlManager.this.addListenerInner(urlDealListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addListenerInner(UrlDealListener urlDealListener) {
        if (!this.mListeners.contains(urlDealListener)) {
            this.mListeners.add(urlDealListener);
        }
    }

    public void setWebListener(UrlWebDealListener urlWebDealListener) {
        this.mWebListener = urlWebDealListener;
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        return dealOneLinkWithDialog(tbPageContext, "", strArr, z, urlWebDialogCancelListener, z2);
    }

    public int dealOneLinkWithOutJumpWebView(TbPageContext<?> tbPageContext, String[] strArr) {
        int deal;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
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
        return 3;
    }

    public void dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener) {
        dealOneLinkWithDialog(tbPageContext, strArr, z, urlWebDialogCancelListener, false);
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        boolean z3;
        boolean z4;
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return false;
        }
        String str2 = strArr[0];
        UrlSchemaHandler urlSchemaHandler = this.mHandlers.get(getSchemaKey(str2));
        if (urlSchemaHandler != null) {
            urlSchemaHandler.deal(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str2)));
            return true;
        }
        Iterator<UrlDealListener> it = this.mListeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            UrlDealListener next = it.next();
            if (next != null && next.deal(tbPageContext, strArr) != 3) {
                z3 = true;
                break;
            }
        }
        if (!z3 && this.mWebListener != null) {
            if (str2.contains("nohead:url") || str2.contains("booktown") || str2.contains("bookreader")) {
                z4 = true;
                return z4;
            }
            jumpToWeb(tbPageContext, str, strArr[0], z, urlWebDialogCancelListener, z2);
        }
        z4 = z3;
        return z4;
    }

    public void dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, z, urlWebDialogCancelListener, false);
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
            hashMap.put(DEFAULT_PARAM, str);
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

    public boolean dealOneLink(TbPageContext<?> tbPageContext, String[] strArr) {
        return dealOneLinkWithDialog(tbPageContext, strArr, false, (UrlWebDialogCancelListener) null, false);
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        dealOneLinkWithDialog(tbPageContext, strArr, false, (UrlWebDialogCancelListener) null, z);
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, false);
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z) {
        dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, z);
    }

    private void jumpToWeb(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        if (pattern.matcher(str2).find()) {
            this.mWebListener.deal(tbPageContext, str, str2, z, urlWebDialogCancelListener, z2);
        }
    }

    public void registerSchema(String str, UrlSchemaHandler urlSchemaHandler) {
        if (!StringUtils.isNull(str) && urlSchemaHandler != null) {
            String schemaKey = getSchemaKey(str);
            if (!StringUtils.isNull(schemaKey)) {
                this.mHandlers.put(schemaKey, urlSchemaHandler);
            }
        }
    }

    public boolean UrlValidated(String str) {
        return pattern.matcher(str).find();
    }
}
