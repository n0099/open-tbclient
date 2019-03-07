package com.baidu.swan.apps.core.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
import com.baidu.swan.apps.w.e;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.core.b implements com.baidu.swan.apps.b.c.a<SystemWebViewImpl> {
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        xR();
    }

    protected void xR() {
        wc().setVisibility(8);
        wc().setBackgroundColor(0);
        loadUrl("file:///android_asset/aiapps/sConsole.html");
    }

    @Override // com.baidu.swan.apps.b.c.a
    public void L(View view) {
    }

    @Override // com.baidu.swan.apps.b.c.a
    public void W(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            jSONArray.put(str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("logType", str);
        hashMap.put("logs", jSONArray.toString());
        e.Ec().a("console", new com.baidu.swan.apps.m.a.b("searchboxSConsole", hashMap));
    }

    @Override // com.baidu.swan.apps.b.c.a
    public void e(ViewGroup viewGroup) {
        if (viewGroup != null) {
            a(viewGroup, wc());
        }
    }

    @Override // com.baidu.swan.apps.b.c.a
    public void aM(boolean z) {
        wc().setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.b.c.a
    public void vU() {
        aM(wc().getVisibility() != 0);
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

    @Override // com.baidu.swan.apps.b.c.e
    public String we() {
        return "console";
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        vZ();
        super.destroy();
    }

    private void vZ() {
        if (this.mContext != null && (this.mContext instanceof Activity)) {
            o.a(this.mContext, ((Activity) this.mContext).getWindow().getDecorView().getWindowToken());
        }
    }
}
