package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a.i;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
/* loaded from: classes3.dex */
public class PushActivity extends Activity {
    private String c;
    private Handler e;
    private int a = 0;
    private boolean b = false;
    private FullScreenView d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PushActivity pushActivity, cn.jpush.android.data.b bVar) {
        if (bVar == null) {
            cn.jpush.android.d.f.c("PushActivity", "Null message entity! Close PushActivity!");
            pushActivity.finish();
            return;
        }
        cn.jpush.android.data.g gVar = (cn.jpush.android.data.g) bVar;
        if (gVar.M == 0) {
            pushActivity.a = gVar.K;
            int identifier = pushActivity.getResources().getIdentifier("jpush_webview_layout", "layout", pushActivity.getPackageName());
            if (identifier == 0) {
                cn.jpush.android.d.f.d("PushActivity", "Please add layout resource jpush_webview_layout.xml to res/layout !");
                pushActivity.finish();
                return;
            }
            pushActivity.setContentView(identifier);
            String str = gVar.a;
            if (!i.a(str)) {
                cn.jpush.android.api.c.a(pushActivity, bVar, 0);
                pushActivity.finish();
                return;
            }
            String str2 = gVar.Q;
            if (gVar.r) {
                int identifier2 = pushActivity.getResources().getIdentifier("actionbarLayoutId", "id", pushActivity.getPackageName());
                if (identifier2 == 0) {
                    cn.jpush.android.d.f.d("PushActivity", "Please use default code in jpush_webview_layout.xml!");
                    pushActivity.finish();
                    return;
                }
                pushActivity.d = (FullScreenView) pushActivity.findViewById(identifier2);
                pushActivity.d.initModule(pushActivity, bVar);
                if (TextUtils.isEmpty(str2) || !new File(str2.replace(SkiaImageDecoder.FILE_PREFIX, "")).exists() || pushActivity.b) {
                    pushActivity.d.loadUrl(str);
                } else {
                    pushActivity.d.loadUrl(str2);
                }
            }
            if (pushActivity.b) {
                return;
            }
            cn.jpush.android.a.e.a(pushActivity.c, 1000, null, pushActivity);
        }
    }

    private void c() {
        if (getIntent() == null) {
            cn.jpush.android.d.f.c("PushActivity", "PushActivity get NULL intent!");
            finish();
            return;
        }
        try {
            this.b = getIntent().getBooleanExtra("from_way", false);
            Intent intent = getIntent();
            cn.jpush.android.data.b bVar = (cn.jpush.android.data.b) intent.getSerializableExtra("body");
            if (bVar == null) {
                cn.jpush.android.d.f.a("PushActivity", "parse entity form plugin plateform");
                String uri = intent.getData() != null ? intent.getData().toString() : null;
                if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
                    uri = intent.getExtras().getString("JMessageExtra");
                }
                bVar = cn.jpush.android.c.c.a(this, uri, "");
            }
            if (bVar == null) {
                cn.jpush.android.d.f.c("PushActivity", "Warning，null message entity! Close PushActivity!");
                finish();
                return;
            }
            this.c = bVar.c;
            if (bVar == null) {
                cn.jpush.android.d.f.c("PushActivity", "Null message entity! Close PushActivity!");
                finish();
                return;
            }
            switch (bVar.q) {
                case 0:
                    Message message = new Message();
                    message.what = 1;
                    message.obj = bVar;
                    this.e.sendMessageDelayed(message, 500L);
                    return;
                default:
                    cn.jpush.android.api.c.a(this, bVar, 0);
                    finish();
                    return;
            }
        } catch (Exception e) {
            cn.jpush.android.d.f.d("PushActivity", "Extra data is not serializable!");
            e.printStackTrace();
            finish();
        }
    }

    public final void a() {
        runOnUiThread(new f(this));
    }

    public final void b() {
        finish();
        if (1 == this.a) {
            try {
                ActivityManager activityManager = (ActivityManager) getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                ComponentName componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                ComponentName componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                if (componentName == null || componentName2 == null || !componentName2.toString().equals(componentName.toString())) {
                    return;
                }
                cn.jpush.android.d.a.b(this);
            } catch (Exception e) {
                cn.jpush.android.d.f.c("PushActivity", "Get running tasks failed.");
                cn.jpush.android.d.a.b(this);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.d != null && this.d.webviewCanGoBack()) {
            this.d.webviewGoBack();
            return;
        }
        cn.jpush.android.a.e.a(this.c, PointerIconCompat.TYPE_CELL, null, this);
        b();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new g(this);
        c();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.d != null) {
            this.d.destory();
        }
        if (this.e.hasMessages(2)) {
            this.e.removeMessages(2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        c();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.d != null) {
            this.d.pause();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.resume();
        }
    }
}
