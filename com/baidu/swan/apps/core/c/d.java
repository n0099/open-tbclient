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
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.games.c.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bUs;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bUs = false;
        this.mContext = context;
        XJ();
    }

    protected void XJ() {
        Th().setVisibility(8);
        Th().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.azc().azf(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            dv(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.azp();
        dv(true);
    }

    private void dv(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.bUs || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.azo(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File XK() {
                    return com.baidu.swan.games.c.d.azc().azf();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void jg(@NonNull String str) {
                    f.rw(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void dw(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.bUs = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xk() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ac(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aN(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.w.f.ahV().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void SY() {
        com.baidu.swan.apps.console.c.dr(false);
        ViewParent parent = Th().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(Th());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void r(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, Th());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void dg(boolean z) {
        Th().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void SX() {
        dg(Th().getVisibility() != 0);
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
    public String Tj() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Tk() {
        super.Tk();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        Td();
        super.destroy();
    }

    private void Td() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            u.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
