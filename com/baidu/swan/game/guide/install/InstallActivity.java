package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.e04;
import com.baidu.tieba.h04;
import com.baidu.tieba.i04;
import com.baidu.tieba.mm3;
import com.baidu.tieba.yz3;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallActivity extends Activity {
    public static ExecutorService g = Executors.newSingleThreadExecutor();
    public int a = 0;
    public boolean b = true;
    public String c;
    public String d;
    public JSONObject e;
    public String f;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public String a;
        public String b;
        public String c;
        public WeakReference<Activity> d;

        public b(Activity activity, String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = new WeakReference<>(activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                boolean b = InstallActivity.b(this.d, this.a, this.b, this.c);
                Activity activity = this.d.get();
                if (!b && activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    }

    public static boolean b(WeakReference<Activity> weakReference, String str, String str2, String str3) {
        return yz3.t().u(weakReference.get(), str, str2, str3);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1345431) {
            if (i2 == -1 && !TextUtils.isEmpty(this.d)) {
                if (e04.g(AppRuntime.getAppContext(), this.d) && e04.k(AppRuntime.getAppContext(), this.d)) {
                    i04.n().h("openAtOnce", new h04(this.e), this.d, this.f, this.c);
                }
            } else if (i2 == 0) {
                i04.n().h("installCancel", new h04(this.e), this.d, this.f, this.c);
            } else if (i2 == 1 && intent != null) {
                i04.n().g("installFailed", new h04(this.e), this.d, this.f, intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022), this.c);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.c = extras.getString("key_download_url");
            this.d = extras.getString("key_download_package_name");
            this.e = mm3.d(extras.getString("ubc_params", ""));
            this.f = extras.getString("download_params");
        }
        g.execute(new b(this, this.c, this.d, this.f));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b) {
            int i = this.a + 1;
            this.a = i;
            if (i > 1) {
                if (!e04.g(AppRuntime.getAppContext(), this.d)) {
                    i04.n().h("installCancel", new h04(this.e), this.d, this.f, this.c);
                }
                finish();
            }
        }
    }
}
