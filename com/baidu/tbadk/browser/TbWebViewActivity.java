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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.util.Date;
import java.util.HashMap;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.g {
    private static HashMap<String, q> a = null;
    private boolean j;
    private com.baidu.tbadk.c.g k;
    private View l;
    private View m;
    private View n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private com.baidu.tbadk.core.view.i r;
    private NavigationBar u;
    private RelativeLayout v;
    private com.baidu.adp.lib.guide.d w;
    private String b = null;
    private String c = null;
    private boolean d = false;
    private RelativeLayout e = null;
    private BaseWebView f = null;
    private ProgressBar g = null;
    private LinearLayout h = null;
    private TextView i = null;
    private final Handler s = new Handler();
    private final Runnable t = new f(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bf.class, TbWebViewActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.tb_webview_activity);
        Intent intent = getIntent();
        this.b = intent.getStringExtra("tag_title");
        this.c = intent.getStringExtra("tag_url");
        if (this.c != null && !this.c.startsWith("http://") && !this.c.startsWith("https://")) {
            this.c = "http://".concat(this.c);
        }
        this.d = intent.getBooleanExtra("tag_cookie", false);
        this.j = intent.getBooleanExtra("tag_enable_js", false);
        if (be.c(this.c)) {
            com.baidu.adp.lib.util.k.a((Context) this, getResources().getString(com.baidu.tieba.y.url_is_null));
            return;
        }
        c();
        if (this.d) {
            a.a(this);
        }
        d();
        if (this.c != null) {
            int indexOf = this.c.indexOf(47, 8);
            if (indexOf > 8) {
                str = this.c.substring(0, indexOf);
            } else {
                str = this.c;
            }
            if (!str.contains("lecai.com") && !str.contains("baidu.com")) {
                i();
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.c = intent.getStringExtra("tag_url");
        b();
    }

    private void c() {
        this.e = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.u = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.u.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.u.a(this.b);
        this.v = (RelativeLayout) findViewById(com.baidu.tieba.v.webview_bottom_navigation_bar);
        View inflate = getLayoutInflater().inflate(com.baidu.tieba.w.tb_webview_pop_more, (ViewGroup) null);
        this.r = new com.baidu.tbadk.core.view.i(this, inflate, this.u, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new g(this));
        this.l = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_share_friend_layout);
        this.l.setOnClickListener(this);
        this.n = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_open_browser_layout);
        this.n.setOnClickListener(this);
        this.m = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_copy_link_layout);
        this.m.setOnClickListener(this);
        this.u.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_more, new h(this));
        this.h = (LinearLayout) findViewById(com.baidu.tieba.v.webview_container);
        this.i = (TextView) this.h.findViewById(com.baidu.tieba.v.webview_crash_tip);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.v.webview_progress);
        if (f()) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.o = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_back_button);
        this.o.setEnabled(false);
        this.o.setOnClickListener(new i(this));
        this.p = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_refresh_button);
        this.p.setOnClickListener(new j(this));
        this.q = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_install_button);
        this.q.setOnClickListener(this);
    }

    public void a() {
        if (this.r != null) {
            this.r.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        this.r.dismiss();
        if (view == this.l) {
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.b = this.b;
            fVar.c = this.c;
            if (fVar != null) {
                a(fVar);
            }
        } else if (view == this.n) {
            a.c(this, this.c);
        } else if (view == this.m) {
            com.baidu.adp.lib.util.a.a(this.c);
            com.baidu.adp.lib.util.k.a(view.getContext(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
        } else if (view == this.q && !this.q.isSelected()) {
            this.q.setSelected(true);
            if (this.q.isSelected()) {
                h();
            }
        }
    }

    private void d() {
        if (!be.c(this.c)) {
            if (this.c.indexOf("_client_version") < 0) {
                if (be.c(Uri.parse(this.c).getQuery())) {
                    this.c = String.valueOf(this.c) + "?_client_version=" + TbConfig.getVersion();
                } else {
                    this.c = String.valueOf(this.c) + "&_client_version=" + TbConfig.getVersion();
                }
            }
            if (this.c.indexOf("nohead=1") < 0) {
                this.c = String.valueOf(this.c) + "&nohead=1";
            }
        }
        this.s.postDelayed(this.t, 500L);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, q> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.k.a(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_navigation_bar", true);
        intent.putExtra("tag_back", z);
        intent.putExtra("tag_refresh", z2);
        intent.putExtra("tag_cookie", z3);
        intent.putExtra("tag_enable_js", z4);
        a = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, boolean z, HashMap<String, q> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.k.a(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_url", str);
        intent.putExtra("tag_navigation_bar", false);
        intent.putExtra("tag_cookie", z);
        intent.putExtra("tag_enable_js", true);
        a = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        a(context, str, str2, true, z, true, false, null);
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, true, false, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.a(this.e, i);
        if (this.f != null) {
            bc.a(this.f, i);
        }
        if (this.u != null && this.u.getVisibility() == 0) {
            this.u.c(i);
        }
        if (i == 1) {
            this.v.setBackgroundResource(com.baidu.tieba.u.bg_bar_1);
            if (this.f != null && this.f.canGoBack()) {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_n_1));
            } else {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
            }
            this.o.setBackgroundResource(com.baidu.tieba.u.title_icon_bg_1);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_refresh_n_1));
            this.p.setBackgroundResource(com.baidu.tieba.u.title_icon_bg_1);
        } else {
            this.v.setBackgroundResource(com.baidu.tieba.u.bg_bar);
            if (this.f != null && this.f.canGoBack()) {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_n));
            } else {
                this.o.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
            }
            this.o.setBackgroundResource(com.baidu.tieba.u.title_icon_bg);
            this.p.setImageDrawable(getResources().getDrawable(com.baidu.tieba.u.icon_webview_refresh_n));
            this.p.setBackgroundResource(com.baidu.tieba.u.title_icon_bg);
        }
        this.r.a(this, i, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n_1));
    }

    @Override // com.baidu.tbadk.coreExtra.view.g
    public boolean a(WebView webView, String str) {
        if (be.c(str)) {
            return false;
        }
        if (com.baidu.tbadk.c.f.a(this, str)) {
            return true;
        }
        this.c = str;
        b();
        return true;
    }

    @JavascriptInterface
    private void e() {
        if (a == null) {
            a = new HashMap<>();
        }
        if (!a.containsKey("TbJsBridge")) {
            a.put("TbJsBridge", new k(this));
        }
        for (String str : a.keySet()) {
            this.f.addJavascriptInterface(a.get(str).a(this), str);
        }
    }

    private boolean f() {
        if (this.f == null) {
            try {
                this.f = new BaseWebView(this);
                bc.a(this.f, TbadkApplication.m252getInst().getSkinType());
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
                this.f.setWebViewClient(new l(this));
                this.f.setWebChromeClient(new m(this));
                this.h.addView(this.f);
                if (this.j) {
                    e();
                    return true;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "", "TbWebViewActivity.createWebView error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void b() {
        this.i.setVisibility(8);
        if (this.f != null && URLUtil.isNetworkUrl(this.c)) {
            this.g.setVisibility(0);
            this.f.loadUrl(this.c);
        }
    }

    private void a(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(this, TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(fVar, true);
            dVar.a(g());
            dVar.a();
        }
    }

    private SparseArray<String> g() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(7);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        if (this.f != null) {
            a("onResume");
            String str3 = "";
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            if (parseBDUSS != null) {
                if (parseBDUSS.mBduss != null) {
                    str3 = parseBDUSS.mBduss;
                }
                if (parseBDUSS.mPtoken != null) {
                    str = str3;
                    str2 = parseBDUSS.mPtoken;
                    com.baidu.tbadk.c.g gVar = new com.baidu.tbadk.c.g(str, str2);
                    if (this.k == null && (this.k == null || !this.k.equals(gVar))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.k = gVar;
                    if (this.f == null && z) {
                        a.a(this);
                        this.s.postDelayed(this.t, 100L);
                        return;
                    }
                }
            }
            str = str3;
            str2 = "";
            com.baidu.tbadk.c.g gVar2 = new com.baidu.tbadk.c.g(str, str2);
            if (this.k == null) {
            }
            z = false;
            this.k = gVar2;
            if (this.f == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            a("onPause");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.s != null) {
            this.s.removeCallbacks(this.t);
        }
        if (this.f != null) {
            this.f.destroy();
            this.f = null;
        }
        TbadkApplication.m252getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    private void a(String str) {
        if (this.f != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.f, new Object[0]);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }

    private void h() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(0).a(false).b(com.baidu.tieba.v.webview_bottom_navigation_bar).c(true);
        gVar.a(new n(this));
        this.w = gVar.a();
        this.w.a(this);
        this.q.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!com.baidu.tbadk.tbplugin.m.a().b("browser")) {
            this.q.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.a().a("install_plugin_dialog_closed", false)) {
                h();
                return;
            }
            if (new Date().getTime() - com.baidu.tbadk.core.sharedPref.b.a().a("install_plugin_dialog_shown_time", new Date().getTime()) > 259200000) {
                h();
                return;
            }
            return;
        }
        this.q.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.w != null) {
                this.w.a();
                this.q.setSelected(false);
            }
            if (i2 == -1) {
                this.q.setVisibility(8);
            }
        }
    }
}
