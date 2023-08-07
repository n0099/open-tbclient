package com.baidu.pass.biometrics.face.liveness.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tieba.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class YYProtocolActivity extends Activity implements NoProguard {
    public ImageView a;
    public WebView b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            YYProtocolActivity.this.finish();
        }
    }

    private void a() {
        this.a.setOnClickListener(new a());
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911f5);
        WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f0929dc);
        this.b = webView;
        webView.setWebChromeClient(new WebChromeClient());
        this.b.setWebViewClient(new WebViewClient());
        this.b.loadUrl(PassBioEnv.YY_PERSONAL_INFO_PROTOCOL);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.b;
        if (webView != null) {
            webView.destroy();
            this.b = null;
        }
    }

    public static boolean a(Activity activity, boolean z) {
        int i;
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (z) {
                i = i3 | i2;
            } else {
                i = (~i2) & i3;
            }
            declaredField2.setInt(attributes, i);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        int i;
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(8192);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            if (z) {
                i = i2;
            } else {
                i = 0;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window2, objArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void newLoginStatusBarTint(Activity activity) {
        if (!b(activity, true)) {
            a(activity, true);
        }
        setTranslucentStatus(activity);
        setRootViewFitsSystemWindows(activity, false);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        getWindow().addFlags(128);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0536);
        b();
        a();
        newLoginStatusBarTint(this);
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() > 0 && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
                viewGroup.setFitsSystemWindows(z);
            }
        }
    }

    public static void setTranslucentStatus(Activity activity) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 23) {
                i = 9472;
            } else {
                i = 1280;
            }
            decorView.setSystemUiVisibility(i);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i2 >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags |= 67108864;
            window2.setAttributes(attributes);
        }
    }
}
