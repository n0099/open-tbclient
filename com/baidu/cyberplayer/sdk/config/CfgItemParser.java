package com.baidu.cyberplayer.sdk.config;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class CfgItemParser {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum a {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* loaded from: classes6.dex */
    private static class b {
        public int e;
        public boolean c = false;
        public boolean d = false;

        /* renamed from: a  reason: collision with root package name */
        public String[] f1798a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1799b = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("close_all")) {
                this.d = true;
                this.c = false;
            } else if (str.equals("enable_all")) {
                this.c = true;
                this.d = false;
            } else if (!str.contains(str2)) {
                this.f1798a = a(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR;
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.f1798a = a(split[0], str3);
                    this.f1799b = c(split[1]);
                } else if (split.length == 1) {
                    this.f1798a = a(split[0], str3);
                }
            }
        }

        private String[] a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(str2)) {
                    String[] split = str.split(str2);
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        if (TextUtils.isEmpty(split[i]) || split[i].equals(".")) {
                            split[i] = null;
                        }
                    }
                    return split;
                } else if (!TextUtils.isEmpty(str)) {
                    return new String[]{str};
                }
            }
            return null;
        }

        private boolean c(String str) {
            return TextUtils.isEmpty(str) || !str.toLowerCase().equals("or");
        }

        public void a(int i) {
            this.e = i;
        }

        public boolean a(String str) {
            if (this.c) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && this.f1798a != null) {
                int length = this.f1798a.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(this.f1798a[i])) {
                        return true;
                    }
                    if (this.e == 0 && a(str, this.f1798a[i], "\\.", "*")) {
                        return true;
                    }
                    if (this.e == 1 && str.contains("." + this.f1798a[i])) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean a(String str, String str2, String str3, String str4) {
            String[] split = str.split(str3);
            String[] split2 = str2.split(str3);
            if (split.length != split2.length) {
                return false;
            }
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (TextUtils.isEmpty(split[i]) || TextUtils.isEmpty(split2[i])) {
                    if (!TextUtils.isEmpty(split2[i]) || !TextUtils.isEmpty(split[i])) {
                        return false;
                    }
                } else if (!split2[i].equals(str4) && !split2[i].equals(split[i])) {
                    return false;
                }
            }
            return true;
        }

        public a b(String str) {
            if (this.d) {
                return a.FAILED;
            }
            boolean a2 = a(str);
            return this.f1799b ? a2 ? a.AND_NEED_CHECK_NEXT : a.FAILED : a2 ? a.SUCCESS : a.OR_NEED_CHECK_NEXT;
        }
    }

    public static boolean a(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.indexOf(arrayList.get(i)) > -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        return b(Build.DEVICE, arrayList) || b(Build.MODEL, arrayList2);
    }

    private static boolean b(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.equalsIgnoreCase(arrayList.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public static Boolean versionMatchCheck(String str, String str2) {
        boolean z = false;
        b bVar = new b();
        bVar.a(0);
        bVar.a(str, "|", ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        a b2 = bVar.b(str2);
        return Boolean.valueOf((b2 == a.SUCCESS || b2 == a.AND_NEED_CHECK_NEXT) ? true : true);
    }
}
