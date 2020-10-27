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
    private boolean cDl;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.cDl = false;
        this.mContext = context;
        alf();
    }

    protected void alf() {
        agh().setVisibility(8);
        agh().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.aRQ().aRT(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            ev(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.aSd();
        ev(true);
    }

    private void ev(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.cDl || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.aSc(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File alg() {
                    return com.baidu.swan.games.c.d.aRQ().aRT();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void mB(@NonNull String str) {
                    f.wt(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void ew(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.cDl = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akE() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void al(View view) {
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
        com.baidu.swan.apps.v.f.axo().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void afX() {
        com.baidu.swan.apps.console.c.eq(false);
        ViewParent parent = agh().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(agh());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void B(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, agh());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void ee(boolean z) {
        agh().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void afW() {
        ee(agh().getVisibility() != 0);
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
    public String agj() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void agk() {
        super.agk();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        agc();
        super.destroy();
    }

    private void agc() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            w.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
