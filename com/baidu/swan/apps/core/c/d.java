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
/* loaded from: classes9.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bhS;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.bhS = false;
        this.mContext = context;
        KB();
    }

    protected void KB() {
        Gc().setVisibility(8);
        Gc().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.b.d.ako().akr(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            bZ(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.akB();
        bZ(true);
    }

    private void bZ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.bhS || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.akA(), 2), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File KC() {
                    return com.baidu.swan.games.b.d.ako().akr();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gA(@NonNull String str) {
                    f.oq(str);
                }
            }, new com.baidu.swan.games.b.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.b.b
                public void ca(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.bhS = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kc() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void Z(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void af(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.y.f.Uf().a("console", new com.baidu.swan.apps.n.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void FT() {
        com.baidu.swan.apps.console.c.bU(false);
        ViewParent parent = Gc().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(Gc());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void i(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, Gc());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void bJ(boolean z) {
        Gc().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void FS() {
        bJ(Gc().getVisibility() != 0);
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
    public String Ge() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Gf() {
        super.Gf();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        FY();
        super.destroy();
    }

    private void FY() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            t.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
