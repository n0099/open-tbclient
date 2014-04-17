package com.baidu.tbadk.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.util.HashMap;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class TbWebViewActivity extends com.baidu.tbadk.a implements com.baidu.tbadk.coreExtra.view.f {
    private static HashMap<String, o> a = null;
    private boolean j;
    private com.baidu.tbadk.d.e k;
    private View l;
    private View m;
    private View n;
    private ImageView o;
    private ImageView p;
    private com.baidu.tbadk.core.view.i q;
    private NavigationBar t;
    private RelativeLayout u;
    private String b = null;
    private String c = null;
    private boolean d = false;
    private RelativeLayout e = null;
    private BaseWebView f = null;
    private ProgressBar g = null;
    private LinearLayout h = null;
    private TextView i = null;
    private final Handler r = new Handler();
    private final Runnable s = new g(this);

    static {
        TbadkApplication.j().a(as.class, TbWebViewActivity.class);
    }

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return TbadkApplication.j().az();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tbadk.k.tb_webview_activity);
        Intent intent = getIntent();
        this.b = intent.getStringExtra("tag_title");
        this.c = intent.getStringExtra("tag_url");
        this.d = intent.getBooleanExtra("tag_cookie", false);
        this.j = intent.getBooleanExtra("tag_enable_js", false);
        if (bc.c(this.c)) {
            com.baidu.adp.lib.util.i.a((Context) this, getResources().getString(com.baidu.tbadk.l.url_is_null));
            return;
        }
        this.e = (RelativeLayout) findViewById(com.baidu.tbadk.j.parent);
        this.t = (NavigationBar) findViewById(com.baidu.tbadk.j.view_navigation_bar);
        this.t.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.t.a(this.b);
        this.u = (RelativeLayout) findViewById(com.baidu.tbadk.j.webview_bottom_navigation_bar);
        View inflate = getLayoutInflater().inflate(com.baidu.tbadk.k.tb_webview_pop_more, (ViewGroup) null);
        this.q = new com.baidu.tbadk.core.view.i(this, inflate, this.t, getResources().getDrawable(com.baidu.tbadk.i.bg_pull_down_right_n), new h(this));
        this.l = inflate.findViewById(com.baidu.tbadk.j.webview_more_pop_item_share_friend_layout);
        this.l.setOnClickListener(this);
        this.n = inflate.findViewById(com.baidu.tbadk.j.webview_more_pop_item_open_browser_layout);
        this.n.setOnClickListener(this);
        this.m = inflate.findViewById(com.baidu.tbadk.j.webview_more_pop_item_copy_link_layout);
        this.m.setOnClickListener(this);
        this.t.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tbadk.k.widget_nb_item_more, new i(this));
        this.h = (LinearLayout) findViewById(com.baidu.tbadk.j.webview_container);
        this.i = (TextView) this.h.findViewById(com.baidu.tbadk.j.webview_crash_tip);
        this.g = (ProgressBar) findViewById(com.baidu.tbadk.j.webview_progress);
        if (d()) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.o = (ImageView) findViewById(com.baidu.tbadk.j.tb_webview_bottom_back_button);
        this.o.setEnabled(false);
        this.o.setOnClickListener(new j(this));
        this.p = (ImageView) findViewById(com.baidu.tbadk.j.tb_webview_bottom_refresh_button);
        this.p.setOnClickListener(new k(this));
        if (this.d) {
            a.a(this);
        }
        if (!bc.c(this.c)) {
            if (this.c.indexOf("_client_version") < 0) {
                if (bc.c(Uri.parse(this.c).getQuery())) {
                    this.c = String.valueOf(this.c) + "?_client_version=" + com.baidu.tbadk.core.data.n.c();
                } else {
                    this.c = String.valueOf(this.c) + "&_client_version=" + com.baidu.tbadk.core.data.n.c();
                }
            }
            if (this.c.indexOf("nohead=1") < 0) {
                this.c = String.valueOf(this.c) + "&nohead=1";
            }
        }
        this.r.postDelayed(this.s, 500L);
    }

    public final void a() {
        if (this.q != null) {
            this.q.b();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        this.q.dismiss();
        if (view == this.l) {
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.b = this.b;
            fVar.c = this.c;
            if (fVar != null) {
                TiebaStatic.a(this, "share", "click", 1, new Object[0]);
                com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
                dVar.a(fVar, true);
                SparseArray<String> sparseArray = new SparseArray<>(7);
                sparseArray.put(2, "pb_wx_timeline");
                sparseArray.put(3, "pb_wx_friend");
                sparseArray.put(4, "pb_qq_zone");
                sparseArray.put(5, "pb_tencent_weibo");
                sparseArray.put(6, "pb_sina_weibo");
                sparseArray.put(7, "pb_renren");
                dVar.a(sparseArray);
                dVar.a();
            }
        } else if (view == this.n) {
            a.c(this, this.c);
        } else if (view == this.m) {
            com.baidu.adp.lib.util.a.a(this.c);
            com.baidu.adp.lib.util.i.a(view.getContext(), view.getResources().getString(com.baidu.tbadk.l.copy_pb_url_success));
        }
    }

    private static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, o> hashMap) {
        if (UtilHelper.h(context)) {
            com.baidu.adp.lib.util.i.a(context, context.getString(com.baidu.tbadk.l.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_navigation_bar", true);
        intent.putExtra("tag_back", true);
        intent.putExtra("tag_refresh", z2);
        intent.putExtra("tag_cookie", z3);
        intent.putExtra("tag_enable_js", false);
        a = null;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, boolean z, HashMap<String, o> hashMap) {
        if (UtilHelper.h(context)) {
            com.baidu.adp.lib.util.i.a(context, context.getString(com.baidu.tbadk.l.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_url", str);
        intent.putExtra("tag_navigation_bar", false);
        intent.putExtra("tag_cookie", true);
        intent.putExtra("tag_enable_js", true);
        a = null;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, true, false, true, false, null);
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, true, false, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.e, i);
        if (this.f != null) {
            ba.a(this.f, i);
        }
        if (this.t != null && this.t.getVisibility() == 0) {
            this.t.b(i);
        }
        if (i == 1) {
            this.u.setBackgroundResource(com.baidu.tbadk.i.bg_bar_1);
            if (this.f.canGoBack()) {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_n_1));
            } else {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_dd));
            }
            this.o.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg_1);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_refresh_n_1));
            this.p.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg_1);
        } else {
            this.u.setBackgroundResource(com.baidu.tbadk.i.bg_bar);
            if (this.f.canGoBack()) {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_n));
            } else {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_dd));
            }
            this.o.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tbadk.i.icon_webview_refresh_n));
            this.p.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg);
        }
        this.q.a(this, i, getResources().getDrawable(com.baidu.tbadk.i.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tbadk.i.bg_pull_down_right_n_1));
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public final boolean a(String str) {
        if (bc.c(str)) {
            return false;
        }
        if (com.baidu.tbadk.d.d.a(this, str)) {
            return true;
        }
        this.c = str;
        b();
        return true;
    }

    @JavascriptInterface
    private void c() {
        if (a == null) {
            a = new HashMap<>();
        }
        if (!a.containsKey("TbJsBridge")) {
            a.put("TbJsBridge", new l(this));
        }
        for (String str : a.keySet()) {
            this.f.addJavascriptInterface(a.get(str).a(this), str);
        }
    }

    private boolean d() {
        if (this.f == null) {
            try {
                this.f = new BaseWebView(this);
                ba.a(this.f, TbadkApplication.j().l());
                this.f.getSettings().setJavaScriptEnabled(true);
                this.f.getSettings().setAllowFileAccess(true);
                this.f.getSettings().setDatabaseEnabled(true);
                this.f.getSettings().setDomStorageEnabled(true);
                this.f.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.f.setOnLoadUrlListener(this);
                this.f.setHorizontalScrollBarEnabled(false);
                this.f.setHorizontalScrollbarOverlay(false);
                this.f.setInitialScale(100);
                this.f.setScrollBarStyle(33554432);
                this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f.setWebViewClient(new m(this));
                this.f.setWebChromeClient(new n(this));
                this.h.addView(this.f);
                if (this.j) {
                    c();
                    return true;
                }
                return true;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "TbWebViewActivity.createWebView error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public final void b() {
        this.i.setVisibility(8);
        if (this.f != null && URLUtil.isNetworkUrl(this.c)) {
            this.g.setVisibility(0);
            this.f.loadUrl(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        if (this.f != null) {
            this.f.resumeTimers();
            b("onResume");
            String str3 = "";
            com.baidu.tbadk.core.a.n a2 = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
            if (a2 != null) {
                if (a2.a != null) {
                    str3 = a2.a;
                }
                if (a2.b != null) {
                    str = str3;
                    str2 = a2.b;
                    com.baidu.tbadk.d.e eVar = new com.baidu.tbadk.d.e(str, str2);
                    if (this.k == null && (this.k == null || !this.k.equals(eVar))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.k = eVar;
                    if (this.f == null && z) {
                        a.a(this);
                        this.r.postDelayed(this.s, 100L);
                        return;
                    }
                }
            }
            str = str3;
            str2 = "";
            com.baidu.tbadk.d.e eVar2 = new com.baidu.tbadk.d.e(str, str2);
            if (this.k == null) {
            }
            z = false;
            this.k = eVar2;
            if (this.f == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.pauseTimers();
            b("onPause");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.r != null) {
            this.r.removeCallbacks(this.s);
        }
        TbadkApplication.j().b(this);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    private void b(String str) {
        if (this.f != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.f, new Object[0]);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }
}
