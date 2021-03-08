package com.baidu.swan.apps.core.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.games.c.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cSk;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.cSk = false;
        this.mContext = context;
        anY();
    }

    protected void anY() {
        aiZ().setVisibility(8);
        aiZ().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.aVD().aVG(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            fd(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.aVQ();
        fd(true);
    }

    private void fd(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.cSk || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.aVP(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File anZ() {
                    return com.baidu.swan.games.c.d.aVD().aVG();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void my(@NonNull String str) {
                    f.wx(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void fe(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.cSk = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anx() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ao(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void be(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.v.f.aAo().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aiP() {
        com.baidu.swan.apps.console.c.eY(false);
        ViewParent parent = aiZ().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(aiZ());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void A(ViewGroup viewGroup) {
        if (viewGroup != null) {
            b(viewGroup, aiZ());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void eM(boolean z) {
        aiZ().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aiO() {
        eM(aiZ().getVisibility() != 0);
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
    public String ajb() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void ajc() {
        super.ajc();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        aiU();
        super.destroy();
    }

    private void aiU() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            w.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
