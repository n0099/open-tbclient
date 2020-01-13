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
/* loaded from: classes10.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean biK;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.biK = false;
        this.mContext = context;
        KX();
    }

    protected void KX() {
        Gy().setVisibility(8);
        Gy().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.b.d.akH().akK(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            ce(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.akU();
        ce(true);
    }

    private void ce(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.biK || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.akT(), 2), new com.baidu.swan.games.b.a.a(new com.baidu.swan.games.b.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.b.b.a
                @NonNull
                public File KY() {
                    return com.baidu.swan.games.b.d.akH().akK();
                }

                @Override // com.baidu.swan.games.b.b.a
                public void gD(@NonNull String str) {
                    f.ot(str);
                }
            }, new com.baidu.swan.games.b.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.b.b
                public void cf(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.biK = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Ky() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ag(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.y.f.UC().a("console", new com.baidu.swan.apps.n.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void Gp() {
        com.baidu.swan.apps.console.c.bZ(false);
        ViewParent parent = Gy().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(Gy());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void l(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, Gy());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void bO(boolean z) {
        Gy().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void Go() {
        bO(Gy().getVisibility() != 0);
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
    public String GA() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void GB() {
        super.GB();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        Gu();
        super.destroy();
    }

    private void Gu() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            t.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
