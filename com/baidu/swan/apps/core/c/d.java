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
/* loaded from: classes10.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cJe;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.cJe = false;
        this.mContext = context;
        anF();
    }

    protected void anF() {
        aiH().setVisibility(8);
        aiH().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.aUq().aUt(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            eE(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.aUD();
        eE(true);
    }

    private void eE(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.cJe || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.aUC(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File anG() {
                    return com.baidu.swan.games.c.d.aUq().aUt();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mQ(@NonNull String str) {
                    f.wH(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void eF(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.cJe = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void ane() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ap(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void bg(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.v.f.azO().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aix() {
        com.baidu.swan.apps.console.c.ez(false);
        ViewParent parent = aiH().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(aiH());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void D(ViewGroup viewGroup) {
        if (viewGroup != null) {
            b(viewGroup, aiH());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void en(boolean z) {
        aiH().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aiw() {
        en(aiH().getVisibility() != 0);
    }

    private void b(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !c(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean c(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiJ() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiK() {
        super.aiK();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        aiC();
        super.destroy();
    }

    private void aiC() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            w.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
