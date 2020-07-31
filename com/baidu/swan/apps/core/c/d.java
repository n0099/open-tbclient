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
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.games.c.f;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class d extends SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.a<NgWebView> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cax;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.cax = false;
        this.mContext = context;
        ZH();
    }

    protected void ZH() {
        UP().setVisibility(8);
        UP().setBackgroundColor(0);
        File file = new File(com.baidu.swan.games.c.d.aDN().aDQ(), "index.html");
        if (file.exists() && file.isFile()) {
            loadUrl(Uri.fromFile(file).toString());
            dD(false);
            return;
        }
        loadUrl("file:///android_asset/aiapps/sConsole.html");
        f.aEa();
        dD(true);
    }

    private void dD(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
        }
        if (!this.cax || z) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.d("sconsole-core", f.aDZ(), 2), new com.baidu.swan.games.c.a.a(new com.baidu.swan.games.c.b.a() { // from class: com.baidu.swan.apps.core.c.d.1
                @Override // com.baidu.swan.games.c.b.a
                @NonNull
                public File ZI() {
                    return com.baidu.swan.games.c.d.aDN().aDQ();
                }

                @Override // com.baidu.swan.games.c.b.a
                public void jD(@NonNull String str) {
                    f.sD(str);
                }
            }, new com.baidu.swan.games.c.b() { // from class: com.baidu.swan.apps.core.c.d.2
                @Override // com.baidu.swan.games.c.b
                public void dE(boolean z2) {
                    if (d.DEBUG) {
                        Log.d("SwanAppConsoleManager", "download sConsole result: " + z2);
                    }
                }
            }));
            this.cax = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zg() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void af(View view) {
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void aQ(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        com.baidu.swan.apps.v.f.akr().a("console", new com.baidu.swan.apps.event.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void UF() {
        com.baidu.swan.apps.console.c.dz(false);
        ViewParent parent = UP().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(UP());
        }
        destroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void u(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, UP());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    /* renamed from: do */
    public void mo25do(boolean z) {
        UP().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.adaptation.b.a
    public void UE() {
        mo25do(UP().getVisibility() != 0);
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
    public String UR() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void US() {
        super.US();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        UK();
        super.destroy();
    }

    private void UK() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            w.forceHiddenSoftInput(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
