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
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.games.c.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cgq;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.cgq = false;
        this.mContext = context;
        afQ();
    }

    protected void afQ() {
        aaS().setVisibility(8);
        aaS().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.aMC().aMF(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            dN(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.aMP();
        dN(true);
    }

    private void dN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.cgq || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.aMO(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File afR() {
                    return com.baidu.swan.games.c.d.aMC().aMF();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void lc(@NonNull String str) {
                    f.uU(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void dO(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.cgq = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ag(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aU(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.v.f.arY().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aaI() {
        com.baidu.swan.apps.console.c.dI(false);
        ViewParent parent = aaS().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(aaS());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void v(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, aaS());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void dw(boolean z) {
        aaS().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aaH() {
        dw(aaS().getVisibility() != 0);
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
    public String aaU() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aaV() {
        super.aaV();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        aaN();
        super.destroy();
    }

    private void aaN() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            w.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
