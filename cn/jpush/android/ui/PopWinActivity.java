package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.d.j;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import java.io.File;
/* loaded from: classes3.dex */
public class PopWinActivity extends Activity {
    public static cn.jpush.android.e.a.f a = null;
    private String b;
    private WebView c;
    private cn.jpush.android.data.b d = null;

    private void a() {
        try {
            j.a(this.c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{a, "JPushWeb"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str) {
        if (this.d == null || this.c == null || !(this.d instanceof cn.jpush.android.data.g)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            ((cn.jpush.android.data.g) this.d).a = str;
            Intent intent = new Intent(this, PushActivity.class);
            intent.putExtra("body", this.d);
            intent.putExtra("from_way", true);
            intent.setFlags(335544320);
            startActivity(intent);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        cn.jpush.android.a.e.a(this.b, PointerIconCompat.TYPE_CELL, null, this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            cn.jpush.android.d.f.c("PopWinActivity", "PopWinActivity get NULL intent!");
            finish();
            return;
        }
        try {
            if (getIntent().getBooleanExtra("isNotification", false)) {
                cn.jpush.android.service.d.a();
                cn.jpush.android.service.d.a(getApplicationContext(), getIntent());
                finish();
                return;
            }
            Intent intent = getIntent();
            cn.jpush.android.data.b bVar = (cn.jpush.android.data.b) intent.getSerializableExtra("body");
            if (bVar == null) {
                cn.jpush.android.d.f.a("PopWinActivity", "parse entity form plugin plateform");
                String uri = intent.getData() != null ? intent.getData().toString() : null;
                if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
                    uri = intent.getExtras().getString("JMessageExtra");
                }
                bVar = cn.jpush.android.c.c.a(this, uri, "");
            }
            this.d = bVar;
            if (this.d == null) {
                cn.jpush.android.d.f.c("PopWinActivity", "Warning，null message entity! Close PopWinActivity!");
                finish();
                return;
            }
            this.b = this.d.c;
            int identifier = getResources().getIdentifier("jpush_popwin_layout", "layout", getPackageName());
            if (identifier == 0) {
                cn.jpush.android.d.f.d("PopWinActivity", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
                finish();
            } else {
                setContentView(identifier);
                int identifier2 = getResources().getIdentifier("wvPopwin", "id", getPackageName());
                if (identifier2 == 0) {
                    cn.jpush.android.d.f.d("PopWinActivity", "Please use default code in jpush_popwin_layout.xml!");
                    finish();
                } else {
                    this.c = (WebView) findViewById(identifier2);
                    if (this.c == null) {
                        cn.jpush.android.d.f.d("PopWinActivity", "Can not get webView in layout file!");
                        finish();
                    } else {
                        this.c.setScrollbarFadingEnabled(true);
                        this.c.setScrollBarStyle(33554432);
                        WebSettings settings = this.c.getSettings();
                        settings.setDomStorageEnabled(true);
                        cn.jpush.android.d.a.a(settings);
                        cn.jpush.android.d.a.a(this.c);
                        settings.setSavePassword(false);
                        this.c.setBackgroundColor(0);
                        a = new cn.jpush.android.e.a.f(this, this.d);
                        if (Build.VERSION.SDK_INT >= 17) {
                            cn.jpush.android.d.f.a("PopWinActivity", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                            a();
                        }
                        this.c.setWebChromeClient(new cn.jpush.android.e.a.a("JPushWeb", cn.jpush.android.e.a.b.class, null, null));
                        this.c.setWebViewClient(new c(this.d, this));
                        cn.jpush.android.e.a.b.setWebViewHelper(a);
                    }
                }
            }
            cn.jpush.android.data.g gVar = (cn.jpush.android.data.g) this.d;
            String str = gVar.Q;
            String str2 = gVar.a;
            if (TextUtils.isEmpty(str) || !new File(str.replace(SkiaImageDecoder.FILE_PREFIX, "")).exists()) {
                this.c.loadUrl(str2);
            } else {
                this.c.loadUrl(str);
            }
            cn.jpush.android.a.e.a(this.b, 1000, null, this);
        } catch (Exception e) {
            cn.jpush.android.d.f.d("PopWinActivity", "Extra data is not serializable!");
            e.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.c != null) {
            this.c.removeAllViews();
            this.c.destroy();
            this.c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.c == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.c.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.c != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.c.onResume();
            }
            cn.jpush.android.e.a.b.setWebViewHelper(a);
        }
    }
}
