package com.baidu.searchbox.schemedispatch.forbid;

import android.net.Uri;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0006\u0010$\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u001a\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007J\u0010\u0010(\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0010\u0010)\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0019J\u0006\u0010,\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/forbid/InvokeStatistic;", "", "()V", "ext", "Lorg/json/JSONObject;", "fengchaolist", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "from", "page", "pinzhuanlist", "source", "value", "addExtPackage", "pkg", "addPath", "path", "addSContent", "sContent", "addScheme", "scheme", "addSchemeHeader", "header", "isInWhiteList", "", "addUserName", TbEnum.SystemMessage.KEY_USER_NAME, "addurl", "contentUrl", "cancleAlert", "", "confirmAlert", "invokeFail", "invokeStatistic", "type", "invokeSuc", "setFrom", "refer", "containerType", "setPage", "setSource", "setValue", "noAlert", "showAlert", "lib-security-openapp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvokeStatistic {
    public String from;
    public String page;
    public String source;
    public JSONObject ext = new JSONObject();
    public String value = InvokeStatisticKt.TC_NOT_WHITELIST;
    public final ArrayList<String> fengchaolist = CollectionsKt__CollectionsKt.arrayListOf("https://m.baidu.com/baidu.php", "http://m.baidu.com/baidu.php");
    public final ArrayList<String> pinzhuanlist = CollectionsKt__CollectionsKt.arrayListOf("http://bzclk.baidu.com/adrc.php", "https://sp0.baidu.com/9q9JcDHa2gU2pMbgoY3K/adrc.php", "https://m.baidu.com/other.php", "https://www.baidu.com/other.php");

    public final void cancleAlert() {
        invokeStatistic(InvokeStatisticKt.SCHEME_INVOKE_CLICK_ALERT_CANCLE);
    }

    public final void confirmAlert() {
        invokeStatistic(InvokeStatisticKt.SCHEME_INVOKE_CLICK_ALERT_OPEN);
    }

    public final void invokeFail() {
        invokeStatistic("fail");
    }

    public final void invokeSuc() {
        invokeStatistic("success");
    }

    public final void showAlert() {
        invokeStatistic(InvokeStatisticKt.SCHEME_INVOKE_SHOW_ALERT);
    }

    public static /* synthetic */ InvokeStatistic addSchemeHeader$default(InvokeStatistic invokeStatistic, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return invokeStatistic.addSchemeHeader(str, z);
    }

    private final void invokeStatistic(String str) {
        boolean z;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            String str2 = this.from;
            String str3 = "other";
            if (str2 == null) {
                str2 = "other";
            }
            hashMap.put("from", str2);
            String str4 = this.page;
            if (str4 != null) {
                str3 = str4;
            }
            hashMap.put("page", str3);
            String str5 = this.value;
            boolean z2 = true;
            if (str5.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                hashMap.put("value", str5);
            }
            String str6 = this.source;
            if (str6 != null) {
                if (str6.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    hashMap.put("source", str6);
                }
            }
            String jSONObject = this.ext.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "ext.toString()");
            hashMap.put("ext", jSONObject);
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent(InvokeStatisticKt.SCHEME_INVOKE_FORBID_UBCID, hashMap);
            }
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "";
                }
                Log.d("InvokeStatistic", localizedMessage);
            }
        }
    }

    public final InvokeStatistic addExtPackage(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return this;
        }
        try {
            this.ext.put("package", str);
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "";
                }
                Log.d("InvokeStatistic", localizedMessage);
            }
        }
        return this;
    }

    public final InvokeStatistic addPath(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                this.ext.put("path", str);
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic addSContent(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                this.ext.put("source_content", str);
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic addScheme(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                this.ext.put("scheme", str);
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic addSchemeHeader(String str) {
        return addSchemeHeader(str, false);
    }

    public final InvokeStatistic addUserName(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                this.ext.put(TbEnum.SystemMessage.KEY_USER_NAME, str);
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic addurl(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                this.ext.put("content_url", str);
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic setFrom(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.from = str;
        }
        return this;
    }

    public final InvokeStatistic setPage(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z && !Intrinsics.areEqual(this.page, InvokeStatisticKt.SCHEME_INVOKE_PAGE_MAGNET) && !Intrinsics.areEqual(this.page, InvokeStatisticKt.SCHEME_INVOKE_PAGE_NONSTANDARD)) {
            this.page = str;
        }
        return this;
    }

    public final InvokeStatistic setSource(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.source = str;
        }
        return this;
    }

    public final InvokeStatistic setValue(boolean z) {
        String str;
        if (z) {
            str = InvokeStatisticKt.TC_NOT_WHITELIST;
        } else {
            str = "alert";
        }
        this.value = str;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a A[Catch: JSONException -> 0x0066, TryCatch #0 {JSONException -> 0x0066, blocks: (B:10:0x0012, B:12:0x0018, B:14:0x001e, B:20:0x002a, B:25:0x0038, B:30:0x0042, B:32:0x0050, B:34:0x0055, B:36:0x005b, B:38:0x0061, B:23:0x0032), top: B:48:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0042 A[Catch: JSONException -> 0x0066, TryCatch #0 {JSONException -> 0x0066, blocks: (B:10:0x0012, B:12:0x0018, B:14:0x001e, B:20:0x002a, B:25:0x0038, B:30:0x0042, B:32:0x0050, B:34:0x0055, B:36:0x005b, B:38:0x0061, B:23:0x0032), top: B:48:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InvokeStatistic addSchemeHeader(String str, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            try {
                Uri parse = Uri.parse(str);
                if (z) {
                    String scheme = parse.getScheme();
                    if (scheme != null && scheme.length() != 0) {
                        z3 = false;
                        if (!z3) {
                            str = parse.getScheme();
                            if (!((str != null || str.length() == 0) ? true : true)) {
                                return this;
                            }
                            this.ext.put("scheme_header", str);
                            if (Intrinsics.areEqual(str, InvokeStatisticKt.SCHEME_INVOKE_PAGE_MAGNET)) {
                                this.page = InvokeStatisticKt.SCHEME_INVOKE_PAGE_MAGNET;
                            } else if (!z && parse.getAuthority() == null && parse.getPath() == null) {
                                this.page = InvokeStatisticKt.SCHEME_INVOKE_PAGE_NONSTANDARD;
                            }
                        }
                    }
                    z3 = true;
                    if (!z3) {
                    }
                }
                if (!z) {
                    str = parse.getScheme();
                }
                if (!((str != null || str.length() == 0) ? true : true)) {
                }
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    String localizedMessage = e.getLocalizedMessage();
                    if (localizedMessage == null) {
                        localizedMessage = "";
                    }
                    Log.d("InvokeStatistic", localizedMessage);
                }
            }
        }
        return this;
    }

    public final InvokeStatistic setFrom(String str, String str2) {
        if (CollectionsKt___CollectionsKt.contains(this.fengchaolist, str)) {
            this.from = InvokeStatisticKt.SCHEME_INVOKE_FROM_FENGCHAO;
        } else if (CollectionsKt___CollectionsKt.contains(this.pinzhuanlist, str)) {
            this.from = InvokeStatisticKt.SCHEME_INVOKE_FROM_PINZHUAN;
        } else if (!Intrinsics.areEqual(str2, InvokeStatisticKt.SCHEME_INVOKE_FROM_SEARCH_H5LANDING) && !Intrinsics.areEqual(str2, "search")) {
            if (str2 != null) {
                this.from = "other";
                addSContent(str2);
            }
        } else {
            this.from = str2;
        }
        return this;
    }
}
