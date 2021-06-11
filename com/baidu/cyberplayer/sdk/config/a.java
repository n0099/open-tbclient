package com.baidu.cyberplayer.sdk.config;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.webkit.sdk.VideoCloudSetting;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.cyberplayer.sdk.config.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0071a {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: e  reason: collision with root package name */
        public int f4809e;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4807c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4808d = false;

        /* renamed from: a  reason: collision with root package name */
        public String[] f4805a = null;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4806b = true;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.f4808d = true;
                this.f4807c = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.f4807c = true;
                this.f4808d = false;
            } else if (!str.contains(str2)) {
                this.f4805a = a(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = "\\|";
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.f4805a = a(split[0], str3);
                    this.f4806b = c(split[1]);
                } else if (split.length == 1) {
                    this.f4805a = a(split[0], str3);
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
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.isEmpty(split[i2]) || split[i2].equals(".")) {
                    split[i2] = null;
                }
            }
            return split;
        }

        private boolean c(String str) {
            return TextUtils.isEmpty(str) || !str.toLowerCase().equals("or");
        }

        public void a(int i2) {
            this.f4809e = i2;
        }

        public boolean a(String str) {
            String[] strArr;
            if (this.f4807c) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && (strArr = this.f4805a) != null) {
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!str.equals(this.f4805a[i2]) && (this.f4809e != 0 || !a(str, this.f4805a[i2], EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "*"))) {
                        if (this.f4809e == 1) {
                            if (str.contains("." + this.f4805a[i2])) {
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
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.isEmpty(split[i2]) || TextUtils.isEmpty(split2[i2])) {
                    if (!TextUtils.isEmpty(split2[i2]) || !TextUtils.isEmpty(split[i2])) {
                        return false;
                    }
                } else if (!split2[i2].equals(str4) && !split2[i2].equals(split[i2])) {
                    return false;
                }
            }
            return true;
        }

        public EnumC0071a b(String str) {
            if (this.f4808d) {
                return EnumC0071a.FAILED;
            }
            boolean a2 = a(str);
            return this.f4806b ? a2 ? EnumC0071a.AND_NEED_CHECK_NEXT : EnumC0071a.FAILED : a2 ? EnumC0071a.SUCCESS : EnumC0071a.OR_NEED_CHECK_NEXT;
        }
    }

    public static Boolean a(String str, String str2) {
        b bVar = new b();
        boolean z = false;
        bVar.a(0);
        bVar.a(str, "|", ";");
        EnumC0071a b2 = bVar.b(str2);
        return Boolean.valueOf((b2 == EnumC0071a.SUCCESS || b2 == EnumC0071a.AND_NEED_CHECK_NEXT) ? true : true);
    }

    public static boolean a(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.indexOf(arrayList.get(i2)) > -1) {
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
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (str.equalsIgnoreCase(arrayList.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
