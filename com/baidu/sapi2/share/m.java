package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import java.util.List;
/* loaded from: classes5.dex */
public class m {
    public static final String a = "extra_trace_id";
    public static final String b = "extra_session_id";
    public static final String c = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String d = "FACE_LOGIN_MODEL";
    public static final String e = "PKG";
    public static final String f = "SDK_VERSION";
    public static final int g = 20001;
    public static final int h = 190;
    public static final String i = "choice_share";
    public static final String j = "choice_share_v2";
    public static b k;

    /* loaded from: classes5.dex */
    public static abstract class a {
        public void onFailed(int i, String str) {
        }

        public abstract void onSuccess();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static final String a = "index";
        public static final String b = "account_tpl";
        public static final String c = "account_app";
        public int d;
        public String e;
        public String f;
    }

    public boolean a(Context context, String str) {
        return x.a(context, str);
    }

    public void a(boolean z) {
        ThreadPoolService.getInstance().run(new TPRunnable(new l(this, z)));
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list) {
        x.a(activity, str, str2, str3, str4, list);
    }

    public void a(a aVar, int i2, int i3, Intent intent, List<PassNameValuePair> list) {
        x.a(aVar, i2, i3, intent, this, list);
    }
}
