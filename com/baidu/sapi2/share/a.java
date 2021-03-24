package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11342a = "extra_trace_id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11343b = "extra_session_id";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11344c = "login_type_share";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11345d = "call_type_share";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11346e = "V2_FACE_LOGIN_UIDS_TIMES";

    /* renamed from: f  reason: collision with root package name */
    public static final String f11347f = "PKG";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11348g = "SDK_VERSION";

    /* renamed from: h  reason: collision with root package name */
    public static final int f11349h = 20001;
    public static final int i = 190;
    public static final String j = "choice_share";
    public static final String k = "choice_share_v2";
    public static c l;

    /* renamed from: com.baidu.sapi2.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0144a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f11350a;

        public RunnableC0144a(int i) {
            this.f11350a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            new ShareStorage().set(this.f11350a);
            d.f();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void onFailed(int i, String str) {
        }

        public abstract void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: e  reason: collision with root package name */
        public static final String f11352e = "index";

        /* renamed from: f  reason: collision with root package name */
        public static final String f11353f = "account_tpl";

        /* renamed from: g  reason: collision with root package name */
        public static final String f11354g = "account_app";

        /* renamed from: h  reason: collision with root package name */
        public static final String f11355h = "share_version";
        public static final String i = "call_type";

        /* renamed from: a  reason: collision with root package name */
        public int f11356a;

        /* renamed from: b  reason: collision with root package name */
        public String f11357b;

        /* renamed from: c  reason: collision with root package name */
        public String f11358c;

        /* renamed from: d  reason: collision with root package name */
        public String f11359d;
    }

    public boolean a(Context context, String str) {
        return d.a(context, str);
    }

    public void a(int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new RunnableC0144a(i2)));
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        d.a(activity, str, str2, str3, str4, list, str5, str6);
    }

    public void a(b bVar, int i2, int i3, Intent intent, List<PassNameValuePair> list, String str) {
        d.a(bVar, i2, i3, intent, this, list, str);
    }
}
