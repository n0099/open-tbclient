package cn.jpush.android.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.a.i;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class f {
    private final WeakReference<Activity> a;
    private final cn.jpush.android.data.b b;

    public f(Context context, cn.jpush.android.data.b bVar) {
        this.a = new WeakReference<>((Activity) context);
        this.b = bVar;
    }

    @JavascriptInterface
    private void userClick(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            i = 1100;
        }
        cn.jpush.android.a.e.a(this.b.c, i, null, this.a.get());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void click(String str, String str2, String str3) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.a.get() != null) {
            userClick(str);
            try {
                z = Boolean.parseBoolean(str2);
                try {
                    z2 = z;
                    z3 = Boolean.parseBoolean(str3);
                } catch (Exception e) {
                    z2 = z;
                    z3 = false;
                    if (z3) {
                    }
                    if (z2) {
                    }
                }
            } catch (Exception e2) {
                z = false;
            }
            if (z3) {
                cn.jpush.android.api.c.a(this.a.get(), this.b, 0);
            }
            if (z2) {
                return;
            }
            this.a.get().finish();
        }
    }

    @JavascriptInterface
    public final void close() {
        if (this.a.get() != null) {
            this.a.get().finish();
        }
    }

    @JavascriptInterface
    public final void createShortcut(String str, String str2, String str3) {
        int i;
        try {
            i = Integer.parseInt(str3);
        } catch (Exception e) {
            i = 0;
        }
        if (this.a.get() == null) {
            return;
        }
        Activity activity = this.a.get();
        int a = cn.jpush.android.api.c.a(i);
        Uri parse = Uri.parse(str2);
        if (parse != null) {
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setFlags(335544320);
            try {
                Intent.ShortcutIconResource fromContext = Intent.ShortcutIconResource.fromContext(activity, a);
                Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                intent2.putExtra("duplicate", false);
                intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", fromContext);
                intent2.setPackage(activity.getPackageName());
                activity.sendBroadcast(intent2);
            } catch (Throwable th) {
                cn.jpush.android.d.f.c("AndroidUtil", "createShortCut error:" + th.getMessage());
            }
        }
    }

    @JavascriptInterface
    public final void download(String str) {
        if (this.a.get() == null) {
        }
    }

    @JavascriptInterface
    public final void download(String str, String str2) {
        if (this.a.get() == null) {
            return;
        }
        userClick(str);
        download(str2);
        cn.jpush.android.api.c.a(this.a.get(), this.b, 0);
        this.a.get().finish();
    }

    @JavascriptInterface
    public final void download(String str, String str2, String str3) {
        download(str, str2);
    }

    @JavascriptInterface
    public final void executeMsgMessage(String str) {
        if (!cn.jiguang.api.e.bv() || this.a.get() == null) {
            return;
        }
        i.a(this.a.get(), str);
    }

    @JavascriptInterface
    public final void showTitleBar() {
        if (this.a.get() == null || !(this.a.get() instanceof PushActivity)) {
            return;
        }
        ((PushActivity) this.a.get()).a();
    }

    @JavascriptInterface
    public final void showToast(String str) {
        if (this.a.get() != null) {
            Toast.makeText(this.a.get(), str, 0).show();
        }
    }

    @JavascriptInterface
    public final void startActivityByIntent(String str, String str2) {
        Activity activity = this.a.get();
        if (activity == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(activity.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception e) {
            cn.jpush.android.d.f.d("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public final void startActivityByName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.d.f.d("WebViewHelper", "The activity name is null or empty, Give up..");
        }
        Activity activity = this.a.get();
        if (activity == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Intent intent = new Intent(activity, cls);
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                activity.startActivity(intent);
            }
        } catch (Exception e) {
            cn.jpush.android.d.f.d("WebViewHelper", "The activity name is invalid, Give up..");
        }
    }

    @JavascriptInterface
    public final void startMainActivity(String str) {
        Activity activity = this.a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.d.a.b(activity);
        } catch (Exception e) {
            cn.jpush.android.d.f.d("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public final void startPushActivity(String str) {
        if (this.a.get() == null || !(this.a.get() instanceof PopWinActivity)) {
            return;
        }
        ((PopWinActivity) this.a.get()).a(str);
    }

    @JavascriptInterface
    public final void triggerNativeAction(String str) {
        Activity activity = this.a.get();
        if (activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (JPushInterface.EXTRA_EXTRA != 0) {
            bundle.putString(JPushInterface.EXTRA_EXTRA, str);
        }
        cn.jpush.android.d.a.a(activity, JPushInterface.ACTION_RICHPUSH_CALLBACK, bundle);
    }
}
