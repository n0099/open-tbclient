package com.baidu.cyberplayer.sdk.config;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CfgItemParser {

    /* loaded from: classes2.dex */
    public enum a {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: e  reason: collision with root package name */
        public int f4900e;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4898c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4899d = false;

        /* renamed from: a  reason: collision with root package name */
        public String[] f4896a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4897b = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.f4899d = true;
                this.f4898c = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.f4898c = true;
                this.f4899d = false;
            } else if (!str.contains(str2)) {
                this.f4896a = a(str, str3);
            } else {
                if (str2.endsWith(FieldBuilder.SE)) {
                    str2 = "\\|";
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.f4896a = a(split[0], str3);
                    this.f4897b = c(split[1]);
                } else if (split.length == 1) {
                    this.f4896a = a(split[0], str3);
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
            this.f4900e = i;
        }

        public boolean a(String str) {
            String[] strArr;
            if (this.f4898c) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && (strArr = this.f4896a) != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (!str.equals(this.f4896a[i]) && (this.f4900e != 0 || !a(str, this.f4896a[i], EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "*"))) {
                        if (this.f4900e == 1) {
                            if (str.contains("." + this.f4896a[i])) {
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

        public a b(String str) {
            if (this.f4899d) {
                return a.FAILED;
            }
            boolean a2 = a(str);
            return this.f4897b ? a2 ? a.AND_NEED_CHECK_NEXT : a.FAILED : a2 ? a.SUCCESS : a.OR_NEED_CHECK_NEXT;
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

    @Keep
    public static Boolean versionMatchCheck(String str, String str2) {
        b bVar = new b();
        boolean z = false;
        bVar.a(0);
        bVar.a(str, FieldBuilder.SE, ";");
        a b2 = bVar.b(str2);
        return Boolean.valueOf((b2 == a.SUCCESS || b2 == a.AND_NEED_CHECK_NEXT) ? true : true);
    }
}
