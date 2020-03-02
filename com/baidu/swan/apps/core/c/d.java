package com.baidu.swan.apps.core.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.swan.apps.as.t;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.games.b.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bmV;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bmV = false;
        this.mContext = context;
        No();
    }

    protected void No() {
        IP().setVisibility(8);
        IP().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.b.d.amX().ana(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            cl(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.ank();
        cl(true);
    }

    private void cl(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.bmV || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.anj(), 2), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File Np() {
                    return com.baidu.swan.games.b.d.amX().ana();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gS(@NonNull String str) {
                    f.oI(str);
                }
            }, new com.baidu.swan.games.b.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.b.b
                public void cm(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.bmV = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MP() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aq(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.y.f.WS().a("console", new com.baidu.swan.apps.n.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void IG() {
        com.baidu.swan.apps.console.c.ch(false);
        ViewParent parent = IP().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(IP());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void m(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, IP());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void bW(boolean z) {
        IP().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void IF() {
        bW(IP().getVisibility() != 0);
    }

    private void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !b(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean b(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IR() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IS() {
        super.IS();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        IL();
        super.destroy();
    }

    private void IL() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            t.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
