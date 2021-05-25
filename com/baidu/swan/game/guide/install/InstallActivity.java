package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.v2.w;
import d.a.l0.f.j.n.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallActivity extends Activity {
    public static final String TAG = "InstallActivity";
    public static ExecutorService sExecutorService = Executors.newSingleThreadExecutor();
    public String downloadPackageName;
    public String downloadUrl;
    public String mDownloadParams;
    public JSONObject mUbcParams;
    public int mResumeCount = 0;
    public boolean mFallbackFinish = true;

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f11600e;

        /* renamed from: f  reason: collision with root package name */
        public String f11601f;

        /* renamed from: g  reason: collision with root package name */
        public String f11602g;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference<Activity> f11603h;

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f11600e) || TextUtils.isEmpty(this.f11601f)) {
                return;
            }
            boolean handleInstallApp = InstallActivity.handleInstallApp(this.f11603h, this.f11600e, this.f11601f, this.f11602g);
            Activity activity = this.f11603h.get();
            if (handleInstallApp || activity == null || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            activity.finish();
        }

        public b(Activity activity, String str, String str2, String str3) {
            this.f11600e = str;
            this.f11601f = str2;
            this.f11602g = str3;
            this.f11603h = new WeakReference<>(activity);
        }
    }

    public static boolean handleInstallApp(WeakReference<Activity> weakReference, String str, String str2, String str3) {
        return e.s().t(weakReference.get(), str, str2, str3);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1345431) {
            if (i3 != -1 || TextUtils.isEmpty(this.downloadPackageName)) {
                if (i3 == 0) {
                    d.a.l0.f.j.r.b.n().h("installCancel", new d.a.l0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                } else if (i3 == 1 && intent != null) {
                    d.a.l0.f.j.r.b.n().g("installFailed", new d.a.l0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022), this.downloadUrl);
                }
            } else if (d.a.l0.f.j.o.a.g(AppRuntime.getAppContext(), this.downloadPackageName) && d.a.l0.f.j.o.a.k(AppRuntime.getAppContext(), this.downloadPackageName)) {
                d.a.l0.f.j.r.b.n().h("openAtOnce", new d.a.l0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.downloadUrl = extras.getString("key_download_url");
            this.downloadPackageName = extras.getString("key_download_package_name");
            this.mUbcParams = w.d(extras.getString("ubc_params", ""));
            this.mDownloadParams = extras.getString("download_params");
        }
        sExecutorService.execute(new b(this, this.downloadUrl, this.downloadPackageName, this.mDownloadParams));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mFallbackFinish) {
            int i2 = this.mResumeCount + 1;
            this.mResumeCount = i2;
            if (i2 > 1) {
                if (!d.a.l0.f.j.o.a.g(AppRuntime.getAppContext(), this.downloadPackageName)) {
                    d.a.l0.f.j.r.b.n().h("installCancel", new d.a.l0.f.j.r.a(this.mUbcParams), this.downloadPackageName, this.mDownloadParams, this.downloadUrl);
                }
                finish();
            }
        }
    }
}
