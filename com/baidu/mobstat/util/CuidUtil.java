package com.baidu.mobstat.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.bu;
import com.baidu.tieba.m30;
import com.baidu.tieba.o30;
/* loaded from: classes3.dex */
public class CuidUtil {
    public static String getCuid3(Context context) {
        String str;
        if (!bu.a().a(false)) {
            return "";
        }
        try {
            str = m30.f(context).c();
            try {
                if (TextUtils.isEmpty(str)) {
                    m30.f(context).j(new o30<String>() { // from class: com.baidu.mobstat.util.CuidUtil.2
                        @Override // com.baidu.tieba.o30
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.o30
                        public void onResult(String str2, Bundle bundle) {
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getGaid(Context context) {
        String str;
        try {
            str = bu.a().b();
            try {
                if (TextUtils.isEmpty(str)) {
                    m30.f(context).m(new o30<String>() { // from class: com.baidu.mobstat.util.CuidUtil.3
                        @Override // com.baidu.tieba.o30
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.o30
                        public void onResult(String str2, Bundle bundle) {
                            if (!TextUtils.isEmpty(str2)) {
                                bu.a().a(str2);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getIid(Context context) {
        String str;
        try {
            str = m30.f(context).e();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getOaid(Context context) {
        String str;
        try {
            str = m30.f(context).g();
            try {
                if (TextUtils.isEmpty(str)) {
                    m30.f(context).o(new o30<String>() { // from class: com.baidu.mobstat.util.CuidUtil.1
                        @Override // com.baidu.tieba.o30
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.o30
                        public void onResult(String str2, Bundle bundle) {
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getSsaid(Context context) {
        String str;
        try {
            str = m30.f(context).h();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
