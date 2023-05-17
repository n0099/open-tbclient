package com.baidu.cyberplayer.sdk.config;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.baidu.cyberplayer.sdk.config.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0091a {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* loaded from: classes3.dex */
    public static class b {
        public int e;
        public boolean c = false;
        public boolean d = false;
        public String[] a = null;
        public boolean b = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.d = true;
                this.c = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.c = true;
                this.d = false;
            } else if (!str.contains(str2)) {
                this.a = a(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = WebChromeClient.PARAM_SEPARATOR;
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.a = a(split[0], str3);
                    this.b = c(split[1]);
                } else if (split.length == 1) {
                    this.a = a(split[0], str3);
                }
            }
        }

        private String[] a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.contains(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return new String[]{str};
            }
            String[] split = str.split(str2);
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (TextUtils.isEmpty(split[i]) || split[i].equals(".")) {
                    split[i] = null;
                }
            }
            return split;
        }

        private boolean c(String str) {
            return TextUtils.isEmpty(str) || !str.toLowerCase().equals("or");
        }

        public void a(int i) {
            this.e = i;
        }

        public boolean a(String str) {
            String[] strArr;
            if (this.c) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && (strArr = this.a) != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (!str.equals(this.a[i]) && (this.e != 0 || !a(str, this.a[i], "\\.", "*"))) {
                        if (this.e == 1) {
                            if (str.contains("." + this.a[i])) {
                            }
                        }
                    }
                    return true;
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

        public EnumC0091a b(String str) {
            if (this.d) {
                return EnumC0091a.FAILED;
            }
            boolean a = a(str);
            return this.b ? a ? EnumC0091a.AND_NEED_CHECK_NEXT : EnumC0091a.FAILED : a ? EnumC0091a.SUCCESS : EnumC0091a.OR_NEED_CHECK_NEXT;
        }
    }

    public static Boolean a(String str, String str2) {
        b bVar = new b();
        boolean z = false;
        bVar.a(0);
        bVar.a(str, "|", ParamableElem.DIVIDE_PARAM);
        EnumC0091a b2 = bVar.b(str2);
        return Boolean.valueOf((b2 == EnumC0091a.SUCCESS || b2 == EnumC0091a.AND_NEED_CHECK_NEXT) ? true : true);
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

    public static boolean b(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (str.equalsIgnoreCase(arrayList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
