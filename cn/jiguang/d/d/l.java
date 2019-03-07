package cn.jiguang.d.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.PushService;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public final class l {
    private static final Object c = new Object();
    private static volatile l mg;
    private boolean a;
    private Context b;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(Context context, String str) {
        return b(context) + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(l lVar, String str, Bundle bundle) {
        try {
            cn.jiguang.d.b.d.bN().a(lVar.b);
            String str2 = b(lVar.b) + ".";
            if (str.startsWith(str2)) {
                str = str.substring(str2.length());
            }
            if (str.equals("intent.INIT")) {
                if (cn.jiguang.d.b.g.a.get() == 0) {
                    cn.jiguang.d.b.d.bN().f();
                }
            } else if (str.equals("senddata.action")) {
                if (cn.jiguang.d.b.g.a.get() == 0) {
                    cn.jiguang.d.b.d.bN().f();
                    return;
                }
                byte[] byteArray = bundle.getByteArray(IntentConfig.DATAS);
                if (byteArray != null) {
                    byte[] a = cn.jiguang.d.e.a.a.b.a(cn.jiguang.d.a.d.a(), 0L, byteArray);
                    if (cn.jiguang.d.g.c.cf().cg().j(cn.jiguang.d.e.a.a.b.a(a, 1)) == 6026) {
                        int i = bundle.getInt(IntentConfig.CMD);
                        String string = bundle.getString("sdktype");
                        cn.jiguang.g.a.m(a);
                        e.bT().a(lVar.b, string, cn.jiguang.g.a.m(a), i, 6026);
                    }
                }
            } else if ("intent.RTC".equals(str)) {
                cn.jiguang.d.b.d.bN().b(bundle.getBoolean("force"), bundle.getLong("rtc_delay", 0L));
            } else if ("intent.CONNECTIVITY_CHANGE".equals(str)) {
                cn.jiguang.d.b.d.bN().a(bundle);
                if (bundle.getBoolean("connection-state", false)) {
                    aa.a(lVar.b);
                }
            } else if (str.equals("run.action")) {
                String string2 = bundle.getString("sdktype");
                e.bT();
                e.a(lVar.b, string2, cn.jiguang.d.b.g.a.get(), bundle, cn.jiguang.d.b.d.bN().bO());
            } else if (str.equals("intent.STOPPUSH")) {
                String string3 = bundle.getString("sdktype");
                cn.jiguang.d.b.d bN = cn.jiguang.d.b.d.bN();
                cn.jiguang.d.a.b(lVar.b);
                bN.b(string3, bundle);
            } else if (str.equals("intent.RESTOREPUSH")) {
                String string4 = bundle.getString("sdktype");
                cn.jiguang.d.b.d bN2 = cn.jiguang.d.b.d.bN();
                cn.jiguang.d.a.b(lVar.b);
                bN2.a(string4, bundle);
            } else if (str.equals("sendrequestdata.action")) {
                byte[] byteArray2 = bundle.getByteArray(IntentConfig.DATAS);
                int i2 = bundle.getInt("timeout");
                String string5 = bundle.getString("sdktype");
                cn.jiguang.d.b.d.bN();
                cn.jiguang.d.b.d.a(byteArray2, string5, i2);
            } else if (str.equals("intent.power.save")) {
                cn.jiguang.d.b.d.bN().a(bundle.getBoolean("key_power_save"));
            } else if (str.equals("cn.jpush.android.intent.check.notification.state")) {
                cn.jiguang.a.c.c.b(lVar.b, bundle.getInt("key_trigger_scene"));
            } else if (str.equals("report_history")) {
                aa.a(lVar.b);
            } else if (str.equals("intent.PERIOD_RESUME")) {
                o.bZ().b(lVar.b, bundle.getBoolean("force"));
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JServiceCommandHelper", "handleAction failed", th);
        }
    }

    private boolean a(Context context) {
        if (this.a) {
            return true;
        }
        if (context == null) {
            cn.jiguang.e.c.d("JServiceCommandHelper", "init failed");
            return false;
        }
        this.b = context.getApplicationContext();
        if (!cn.jiguang.g.a.q(cn.jiguang.d.a.d)) {
            cn.jiguang.d.b.a.a = 0;
        }
        this.e = cn.jiguang.d.b.a.b(this.b);
        this.a = true;
        return true;
    }

    private static String b(Context context) {
        String str = cn.jiguang.d.a.c;
        if (TextUtils.isEmpty(str) && context != null) {
            str = context.getPackageName();
        }
        return str == null ? "" : str;
    }

    public static l bY() {
        if (mg == null) {
            synchronized (c) {
                if (mg == null) {
                    mg = new l();
                }
            }
        }
        return mg;
    }

    private static boolean c(String str, Bundle bundle) {
        try {
            if (cn.jiguang.g.a.a.c()) {
                cn.jiguang.g.a.a.b().a(str, bundle);
                return true;
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JServiceCommandHelper", "throwable , remote call failed, error:" + th);
            return false;
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        try {
            Context X = cn.jiguang.d.a.X(context);
            if (a(X)) {
                cn.jiguang.api.e.a("ACTION", new n(this, X, str, bundle, 1), new int[0]);
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JServiceCommandHelper", "callAction failed", th);
        }
    }

    public final void d(Context context, String str, Bundle bundle) {
        try {
            Context X = cn.jiguang.d.a.X(context);
            if (a(X)) {
                cn.jiguang.api.e.a("SDK_MAIN", new m(this, X, str, bundle), new int[0]);
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JServiceCommandHelper", "onAction failed", th);
        }
    }

    public final boolean e(Context context, String str, Bundle bundle) {
        if (!c(str, bundle)) {
            try {
                Intent intent = new Intent(context, PushService.class);
                intent.setAction(str);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                context.startService(intent);
            } catch (Throwable th) {
                cn.jiguang.e.c.c("JServiceCommandHelper", "throwable ,cant start service" + th.getMessage() + ", will use aidl to do action");
                return false;
            }
        }
        return true;
    }
}
