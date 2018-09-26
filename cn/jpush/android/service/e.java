package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.api.i;
import cn.jpush.android.a.g;
import cn.jpush.android.a.k;
import cn.jpush.android.a.n;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.data.JPushLocalNotification;
import com.baidu.tieba.ala.ALaKeepAliveService;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes3.dex */
public final class e {
    private static e b;
    private Context a;

    private e(Context context) {
        this.a = context;
    }

    public static e a(Context context) {
        if (b == null) {
            b = new e(context);
        }
        return b;
    }

    public static void a(Context context, Bundle bundle, String str) {
        bundle.putString(AuthActivity.ACTION_KEY, b(context) + "." + str);
    }

    private static String b(Context context) {
        String str = cn.jpush.android.a.c;
        if (TextUtils.isEmpty(str) && context != null) {
            str = context.getPackageName();
        }
        return str == null ? "" : str;
    }

    public final void a() {
        a.a(this.a).d(this.a);
    }

    public final void a(Bundle bundle, Handler handler) {
        String string;
        cn.jpush.android.d.f.a("PushServiceCore", "bundle:" + (bundle != null ? bundle.toString() : ""));
        if (bundle == null || (string = bundle.getString(AuthActivity.ACTION_KEY)) == null) {
            return;
        }
        cn.jpush.android.d.f.a("PushServiceCore", "Action - handleServiceAction - action:" + string);
        String str = b(this.a) + ".";
        if (string.startsWith(str)) {
            string = string.substring(str.length());
        }
        if ("intent.MULTI_PROCESS".equals(string)) {
            switch (bundle.getInt("multi_type")) {
                case 1:
                    cn.jpush.android.b.a(this.a, bundle.getString("notification_buidler_id"), bundle.getString("notification_buidler"), true);
                    return;
                case 2:
                    cn.jpush.android.b.a(this.a, bundle.getInt("notification_maxnum"), true);
                    return;
                case 3:
                    cn.jpush.android.b.b(this.a, bundle.getString("enable_push_time"), true);
                    return;
                case 4:
                    cn.jpush.android.b.a(this.a, bundle.getString("silence_push_time"), true);
                    return;
                case 5:
                default:
                    return;
                case 6:
                    a.a(this.a).a(this.a, (JPushLocalNotification) bundle.getSerializable("local_notification"), true);
                    return;
                case 7:
                    a.a(this.a).a(this.a, bundle.getLong("local_notification_id"));
                    return;
                case 8:
                    a.a(this.a).b(this.a);
                    return;
                case 9:
                    cn.jpush.android.api.c.a(this.a, bundle.getInt(ALaKeepAliveService.KEY_NOTIFICATION_ID), true);
                    return;
                case 10:
                    cn.jpush.android.api.c.a(this.a, true);
                    return;
            }
        } else if ("intent.STOPPUSH".equals(string)) {
            i.d(this.a, "service_stoped", 1);
        } else if (string.equals("intent.RESTOREPUSH")) {
            i.d(this.a, "service_stoped", 0);
        } else if ("intent.ALIAS_TAGS".equals(string)) {
            n.a(this.a, bundle);
        } else if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REQUEST_REGID.equals(string)) {
            cn.jpush.android.c.a.a().a(this.a, bundle);
        } else if (!JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_ON_MESSAGING.equals(string)) {
            if (JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW.equals(string)) {
                cn.jpush.android.c.d.a().a(this.a, bundle);
            } else if ("intent.MOBILE_NUMBER".equals(string)) {
                g.a().a(this.a, bundle);
            }
        } else {
            String string2 = bundle.getString("appId");
            String string3 = bundle.getString("senderId");
            String string4 = bundle.getString("JMessageExtra");
            byte b2 = bundle.getByte("platform");
            Log.d("PushServiceCore", "appId:" + String.valueOf(string2) + ",senderId:" + String.valueOf(string3) + ",JMessageExtra:" + String.valueOf(string4));
            if (TextUtils.isEmpty(string4)) {
                return;
            }
            if (TextUtils.isEmpty(string2)) {
                string2 = this.a.getPackageName();
            }
            if (TextUtils.isEmpty(string3)) {
                string3 = cn.jiguang.api.e.getAppKey();
            }
            k.a(this.a, string2, string3, string4, 0L, b2);
        }
    }
}
