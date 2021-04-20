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
    public static final String f10927a = "extra_trace_id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f10928b = "extra_session_id";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10929c = "login_type_share";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10930d = "call_type_share";

    /* renamed from: e  reason: collision with root package name */
    public static final String f10931e = "V2_FACE_LOGIN_UIDS_TIMES";

    /* renamed from: f  reason: collision with root package name */
    public static final String f10932f = "PKG";

    /* renamed from: g  reason: collision with root package name */
    public static final String f10933g = "SDK_VERSION";

    /* renamed from: h  reason: collision with root package name */
    public static final int f10934h = 20001;
    public static final int i = 190;
    public static final String j = "choice_share";
    public static final String k = "choice_share_v2";
    public static c l;

    /* renamed from: com.baidu.sapi2.share.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0145a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f10935a;

        public RunnableC0145a(int i) {
            this.f10935a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            new ShareStorage().set(this.f10935a);
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
        public static final String f10937e = "index";

        /* renamed from: f  reason: collision with root package name */
        public static final String f10938f = "account_tpl";

        /* renamed from: g  reason: collision with root package name */
        public static final String f10939g = "account_app";

        /* renamed from: h  reason: collision with root package name */
        public static final String f10940h = "share_version";
        public static final String i = "call_type";

        /* renamed from: a  reason: collision with root package name */
        public int f10941a;

        /* renamed from: b  reason: collision with root package name */
        public String f10942b;

        /* renamed from: c  reason: collision with root package name */
        public String f10943c;

        /* renamed from: d  reason: collision with root package name */
        public String f10944d;
    }

    public boolean a(Context context, String str) {
        return d.a(context, str);
    }

    public void a(int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new RunnableC0145a(i2)));
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5, String str6) {
        d.a(activity, str, str2, str3, str4, list, str5, str6);
    }

    public void a(b bVar, int i2, int i3, Intent intent, List<PassNameValuePair> list, String str) {
        d.a(bVar, i2, i3, intent, this, list, str);
    }
}
