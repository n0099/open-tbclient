package cn.jpush.android.e.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.api.JPushInterface;
/* loaded from: classes3.dex */
public final class e {
    private Context a;
    private WindowManager b;
    private WebView c;
    private ImageButton d;

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.d.f.d("SystemAlertWebViewCallback", "The activity name is null or empty, Give up..");
        }
        if (this.a == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Intent intent = new Intent(this.a, cls);
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                this.a.startActivity(intent);
                cn.jpush.android.api.e.a(this.b, this.c, this.d);
            }
        } catch (Exception e) {
            cn.jpush.android.d.f.d("SystemAlertWebViewCallback", "The activity name is invalid, Give up..");
        }
    }
}
