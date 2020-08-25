package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import java.util.List;
/* loaded from: classes12.dex */
public class b {
    public static final String a = "extra_trace_id";
    public static final String b = "extra_session_id";
    public static final String c = "login_type_share";
    public static final String d = "V2_FACE_LOGIN_UIDS_TIMES";
    public static final String e = "FACE_LOGIN_MODEL";
    public static final String f = "PKG";
    public static final String g = "SDK_VERSION";
    public static final int h = 20001;
    public static final int i = 190;
    public static final String j = "choice_share";
    public static final String k = "choice_share_v2";
    public static c l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            new ShareStorage().a(this.a);
            e.c();
            SapiAccountManager.getInstance().getAccountService().refreshOpenidToUid();
        }
    }

    /* renamed from: com.baidu.sapi2.share.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC0302b {
        public void onFailed(int i, String str) {
        }

        public abstract void onSuccess();
    }

    /* loaded from: classes12.dex */
    public static class c {
        public static final String e = "index";
        public static final String f = "account_tpl";
        public static final String g = "account_app";
        public static final String h = "share_version";
        public int a;
        public String b;
        public String c;
        public String d;
    }

    public boolean a(Context context, String str) {
        return e.a(context, str);
    }

    public void a(int i2) {
        ThreadPoolService.getInstance().run(new TPRunnable(new a(i2)));
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list) {
        a(activity, str, str2, str3, str4, list, SapiShareClient.SHARE_ACCOUNT_NEW_VERSION);
    }

    public void a(Activity activity, String str, String str2, String str3, String str4, List<PassNameValuePair> list, String str5) {
        e.a(activity, str, str2, str3, str4, list, str5);
    }

    public void a(AbstractC0302b abstractC0302b, int i2, int i3, Intent intent, List<PassNameValuePair> list) {
        e.a(abstractC0302b, i2, i3, intent, this, list);
    }
}
