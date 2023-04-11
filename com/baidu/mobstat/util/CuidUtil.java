package com.baidu.mobstat.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.bu;
import com.baidu.tieba.v10;
import com.baidu.tieba.x10;
/* loaded from: classes2.dex */
public class CuidUtil {
    public static String getCuid3(Context context) {
        String str;
        if (!bu.a().a(false)) {
            return "";
        }
        try {
            str = v10.f(context).c();
            try {
                if (TextUtils.isEmpty(str)) {
                    v10.f(context).j(new x10<String>() { // from class: com.baidu.mobstat.util.CuidUtil.2
                        @Override // com.baidu.tieba.x10
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.x10
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
                    v10.f(context).m(new x10<String>() { // from class: com.baidu.mobstat.util.CuidUtil.3
                        @Override // com.baidu.tieba.x10
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.x10
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
            str = v10.f(context).e();
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
            str = v10.f(context).g();
            try {
                if (TextUtils.isEmpty(str)) {
                    v10.f(context).o(new x10<String>() { // from class: com.baidu.mobstat.util.CuidUtil.1
                        @Override // com.baidu.tieba.x10
                        public void onError(int i, Throwable th, Bundle bundle) {
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.x10
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
            str = v10.f(context).h();
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
